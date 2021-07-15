package com.desafioteste.desafioteste.repository;

public interface Repo<T> {

    public T save(Object obj);
    public T findById(long id);
    public T findByName(String name);

}
