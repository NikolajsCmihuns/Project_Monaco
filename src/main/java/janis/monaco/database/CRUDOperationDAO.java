package janis.monaco.database;

import java.util.List;

public interface CRUDOperationDAO<E> {

    void create(E entity);

    E getById(int id);

    E getRequired(int id);

    void update(E entity);

    void delete(E entity);

    List<E> getAll();

}