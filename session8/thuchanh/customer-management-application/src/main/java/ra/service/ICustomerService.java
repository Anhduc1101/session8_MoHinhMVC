package ra.service;

import java.util.List;

public interface ICustomerService<T> {
    List<T> findAll();

    void save(T t);

    T findById(int id);

    int getNewId();
    List<T> findByName(String name);
    void deleteById(int id);
}
