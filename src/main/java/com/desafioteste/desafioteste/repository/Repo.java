package com.desafioteste.desafioteste.repository;

import java.util.List;

public interface Repo<T> {

    public T save(Object obj);
    public List<T> findAll();
    public T findById(long id);
    public List<T> findByName(String name);
    public boolean delete(long id);
    public boolean exists(Object obj);

}
