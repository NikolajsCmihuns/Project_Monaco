package com.monaco.Database;

import com.monaco.Entities.Tag;
import com.monaco.Entities.User;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.jdbc.DAOImpl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created by maksimspuskels on 23/10/15.
 */

@Component
@Transactional
public class UserDAOImplementation extends DAOImpl implements UserDAOInterface {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void createUser(User user) throws DBException {
        sessionFactory.getCurrentSession().save(user);
    }

    public Optional<User> getUserByID(Integer id) throws DBException {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("userID", id));
        User user = (User) criteria.uniqueResult();
        if (user != null) {
            return Optional.of(user);
        }
        else {
            return Optional.empty();
        }
    }

    public Optional<User> getUserByNickname(String nickname) throws DBException {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("nickname", nickname));
        User user = (User) criteria.uniqueResult();
        if (user != null) {
            return Optional.of(user);
        }
        else {
            return Optional.empty();
        }
    }
}
