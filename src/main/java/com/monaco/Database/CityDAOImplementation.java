package com.monaco.Database;

import com.monaco.Entities.City;
import com.monaco.Entities.Country;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.jdbc.DAOImpl;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by maksimspuskels on 01/11/15.
 */

@Component
@Transactional
public class CityDAOImplementation extends DAOImpl implements CityDAOInterface {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public City getCityByID(Integer id) throws DBException {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(City.class);
        criteria.add(Restrictions.eq("cityNameID", id));
        City city = (City) criteria.uniqueResult();
        return city;
    }

    @Override
    public Integer getIDByCityName(String cityName) throws DBException {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(City.class);
        criteria.add(Restrictions.eq("cityName", cityName));
        City city = (City) criteria.uniqueResult();
        return city.getCityNameID();
    }
}
