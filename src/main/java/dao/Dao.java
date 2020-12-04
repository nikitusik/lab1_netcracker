package dao;

import java.util.List;

public interface Dao<T> {
    void create(T t);
    void delete(T t);
    void edit(T t);
    T getById(int id);
    List<T> getAll();
}
