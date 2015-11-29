package MaximPackage.Database;

import MaximPackage.Entities.Tag;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.jdbc.DAOImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * Created by maksimspuskels on 01/11/15.
 */

@Component
public class TagDAOImplementation extends DAOImpl implements TagDAOInterface{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Tag getTagByID(int id) throws DBException {
        Integer tagId = Integer.valueOf(id);
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Tag.class);
        criteria.add(Restrictions.eq("TAG_NAME_ID", tagId));
        Tag tag = (Tag) criteria.uniqueResult();
        return tag;
    }

    @Override
    public Integer getIDByTagName(String tagName) throws DBException {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Tag.class);
        criteria.add(Restrictions.eq("TAG_NAME", tagName));
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
