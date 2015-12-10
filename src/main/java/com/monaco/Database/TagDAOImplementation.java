package com.monaco.Database;

import com.monaco.Entities.Tag;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.jdbc.DAOImpl;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by maksimspuskels on 01/11/15.
 */

@Component
@Transactional
public class TagDAOImplementation extends DAOImpl implements TagDAOInterface {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Tag getTagByID(Integer id) throws DBException {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Tag.class);
        criteria.add(Restrictions.eq("tagNameID", id));
        Tag tag = (Tag) criteria.uniqueResult();
        return tag;
    }

    @Override
    public Integer getIDByTagName(String tagName) throws DBException {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Tag.class);
        criteria.add(Restrictions.eq("tagName", tagName));
        Tag tag = (Tag) criteria.uniqueResult();
        return tag.getTagNameID();
    }

    @Override
    public List<Tag> getAllTags() throws DBException {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Tag.class);
        List<Tag> allTags = (List<Tag>) criteria.list();
        return allTags;
    }
}
