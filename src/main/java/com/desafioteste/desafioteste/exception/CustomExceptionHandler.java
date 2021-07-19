package com.desafioteste.desafioteste.exception;

import com.desafioteste.desafioteste.dto.ExceptionDto;
import com.desafioteste.desafioteste.exception.disctrict.DistrictAlreadyExistsException;
import com.desafioteste.desafioteste.exception.disctrict.DistrictNotFoundException;
import com.desafioteste.desafioteste.exception.property.PropertyAlreadyExistsException;
import com.desafioteste.desafioteste.exception.property.PropertyCreateException;
import com.desafioteste.desafioteste.exception.property.PropertyNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(DistrictNotFoundException.class)
    public ResponseEntity<ExceptionDto> defaultHandler(DistrictNotFoundException e){
        ExceptionDto ex = new ExceptionDto(e.getMessage());
        return ResponseEntity.badRequest().body(ex);
    }

    @ExceptionHandler(DistrictAlreadyExistsException.class)
    public ResponseEntity<ExceptionDto> defaultHandler(DistrictAlreadyExistsException e){
        ExceptionDto ex = new ExceptionDto(e.getMessage());
        return ResponseEntity.badRequest().body(ex);
    }

    @ExceptionHandler(PropertyNotFoundException.class)
    public ResponseEntity<ExceptionDto> defaultHandler(PropertyNotFoundException e){
        ExceptionDto ex = new ExceptionDto(e.getMessage());
        return ResponseEntity.badRequest().body(ex);
    }

    @ExceptionHandler(PropertyAlreadyExistsException.class)
    public ResponseEntity<ExceptionDto> defaultHandler(PropertyAlreadyExistsException e){
        ExceptionDto ex = new ExceptionDto(e.getMessage());
        return ResponseEntity.badRequest().body(ex);
    }

    @ExceptionHandler(PropertyCreateException.class)
    public ResponseEntity<ExceptionDto> defaultHandler(PropertyCreateException e){
        ExceptionDto ex = new ExceptionDto(e.getMessage());
        return ResponseEntity.badRequest().body(ex);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ExceptionDto>> defaultHandler(MethodArgumentNotValidException e){
        BindingResult result = e.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        List<ExceptionDto> processFieldErrors = processFieldErrors(fieldErrors);
        return ResponseEntity.badRequest().body(processFieldErrors);
    }

    private List<ExceptionDto> processFieldErrors(List<FieldError> fieldErrors) {
        List<ExceptionDto> listaDtos = new ArrayList<>();
        for (FieldError fieldError: fieldErrors) {
            listaDtos.add(new ExceptionDto(fieldError.getField(), fieldError.getDefaultMessage()));
        }
        return listaDtos;
    }


}
