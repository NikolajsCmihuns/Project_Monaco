package janis.monaco.app;


import janis.monaco.domain.entities.Place;
import janis.monaco.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by janis on 11/2/15.
 */
public class App {
    public static void main(String[] args){
//Create session factory object
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        //getting session object from session factory
        Session session = sessionFactory.openSession();
        //getting transaction object from session object
        session.beginTransaction();
        Query query = session.createQuery("from Place");
        query.toString();
        List<Place> places = query.list();


        session.getTransaction().commit();
        sessionFactory.close();

        for(Place place : places)
        {
            System.out.println("id: " + place.getPlaceId() + ", Name: " + place.getPlaceName() + ", Address: " + place.getPlaceAddress());

        }


    }
}

