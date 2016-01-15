package com.monaco.database;

import com.monaco.Entities.Tag;
import lv.javaguru.java2.database.DBException;

import java.util.List;

/**
 * Created by maksimspuskels on 01/11/15.
 */

public interface TagDAOInterface {
    Tag getTagByID(Integer id) throws DBException;
    Integer getIDByTagName(String TagName) throws DBException;
    List<Tag> getAllTags() throws DBException;
}
