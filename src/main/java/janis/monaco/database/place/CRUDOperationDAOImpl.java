package janis.monaco.database.place;


import janis.monaco.database.CRUDOperationDAO;
import janis.monaco.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

abstract class CRUDOperationDAOImpl<E, K extends Serializable> implements CRUDOperationDAO<E, K> {


    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private Session session = sessionFactory.openSession();

    protected Class daoType;


    public CRUDOperationDAOImpl() {
        daoType = (Class) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }




    @Override
    public void create(E entity) {
        session.saveOrUpdate(entity);
        session.getTransaction().commit();
        sessionFactory.close();
    }

    @Override
    public E getById(K key) {
        E entity = (E) session.get(daoType, key);
        session.getTransaction().commit();
        sessionFactory.close();
        return entity;
    }

    @Override
    public E getRequired(K key) {
        E entity = (E) session.get(daoType, key);
        session.getTransaction().commit();
        sessionFactory.close();
        if(entity == null) {
            throw new IllegalArgumentException("Entity with id = " + key + " not exist!");
        }
        return entity;
    }

    @Override
    public void update(E entity) {
        session.saveOrUpdate(entity);
    }

    @Override
    public void delete(E entity) {
        session.delete(entity);
    }

    @Override
    public List<E> getAll() {
        List list = session.createCriteria(daoType).list();
        session.getTransaction().commit();
        sessionFactory.close();
        return list;
    }

}