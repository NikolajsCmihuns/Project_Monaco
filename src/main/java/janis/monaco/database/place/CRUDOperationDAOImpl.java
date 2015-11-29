package janis.monaco.database.place;


import janis.monaco.database.CRUDOperationDAO;
import janis.monaco.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;


import java.lang.reflect.ParameterizedType;
import java.util.List;

@Component
abstract class CRUDOperationDAOImpl<E> implements CRUDOperationDAO<E> {


    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private Session session = sessionFactory.openSession();

    protected Class daoType;


    public CRUDOperationDAOImpl() {
        daoType = (Class) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }




    @Override
    public void create(E entity) {
        session.save(entity);

    }

    @Override
    public E getById(int id) {
        E entity = (E) session.get(daoType, id);

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
        session.saveOrUpdate(entity);
    }

    @Override
    public void delete(E entity) {
        session.delete(entity);
    }

    @Override
    public List<E> getAll() {
        List list = session.createCriteria(daoType).list();

        return list;
    }

}