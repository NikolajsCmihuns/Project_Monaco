package janis.monaco.database.placetyperef;


import janis.monaco.database.CRUDOperationDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.lang.reflect.ParameterizedType;
import java.util.List;

@Component
abstract class CRUDOperationDAOImpl<E> implements CRUDOperationDAO<E> {


    @Autowired
    private SessionFactory sessionFactory;

    protected Class daoType;


    public CRUDOperationDAOImpl() {
        daoType = (Class) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }


    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }




    @Override
    public void create(E entity) {
        getSession().save(entity);

    }

    @Override
    public E getById(int id) {
        E entity = (E) getSession().get(daoType, id);

        return entity;
    }

    @Override
    public E getRequired(int id) {
        List list = this.getAll();


        if(list.size() < id ||0 > id ) {
            throw new IllegalArgumentException("Entity with id = " + id + " not exist!");
        }

        E entity =(E)list.get(id-1);




        return entity;
    }

    @Override
    public void update(E entity) {
        getSession().saveOrUpdate(entity);
    }

    @Override
    public void delete(E entity) {
        getSession().delete(entity);
    }

    @Override
    public List<E> getAll() {
        List list = getSession().createCriteria(daoType).list();

        return list;
    }

}