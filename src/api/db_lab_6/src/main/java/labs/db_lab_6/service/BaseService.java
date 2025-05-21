package labs.db_lab_6.service;

import java.util.List;

public interface BaseService<T, D> {

    List<T> findAll();
    T findById(Long id);
    T save(D dto);
    T updateById(D dto, Long id);
    boolean deleteById(Long id);
}
