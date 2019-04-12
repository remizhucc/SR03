package Model;

public interface DAOInterface<T> {
    T selectByID(int id);
    T select(T t);
    void add(T t);
    void update(T t);
    void delete(T t);
}