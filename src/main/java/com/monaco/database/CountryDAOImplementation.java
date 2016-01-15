package com.monaco.database;

import com.monaco.Entities.Country;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.jdbc.DAOImpl;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by maksimspuskels on 01/11/15.
 */

@Component
@Transactional
public class CountryDAOImplementation extends DAOImpl implements CountryDAOInterface {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Country getCountryByID(Integer id) throws DBException {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Country.class);
        criteria.add(Restrictions.eq("countryNameID", id));
        Country country = (Country) criteria.uniqueResult();
        return country;
    }

    @Override
    public Integer getIDByCountryName(String countryName) throws DBException {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Country.class);
        criteria.add(Restrictions.eq("countryName", countryName));
        Country country = (Country) criteria.uniqueResult();
        return country.getCountryNameID();
    }

    @Override
    public List<Country> getAllCountries() throws DBException {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Country.class);
        List<Country> allTags = (List<Country>) criteria.list();
        return allTags;
    }
}
