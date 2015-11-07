package AlexPackage.DB;

import lv.javaguru.java2.database.DBException;

import java.util.List;

/**
 * Created by Aborigens on 07-Nov-15.
 */
public interface RouteDAOInterface {

    List<Country> getCountryList() throws DBException;
    List<Tags> getTagsList() throws DBException;

}
