package Model;

import java.util.ArrayList;

public interface DAOInterface<T> {
    T selectByID(int id);
    ArrayList<T> selectAll();
    void add(T t);
    void update(T t);
    void delete(T t);
}