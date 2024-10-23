package project.Interfaces;

import java.util.List;

public interface CRUD <T> {
    boolean add(T object);
    boolean update(T object);
    boolean delete(int id);
    List<T> showAll();
    T findById(int id);
}
