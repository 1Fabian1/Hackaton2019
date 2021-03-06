package dao;

import model.Notification;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO <T, PK extends Serializable> {

    //Basic CRUD
    T create (T newObject);
    T read (PK primaryKey);
    Notification update(T updateObject);
    boolean delete(PK primaryKey);
    List<T> GetAll();



}
