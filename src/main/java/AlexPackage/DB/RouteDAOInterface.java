package AlexPackage.DB;

import AlexPackage.DB.Domain.Route;
import AlexPackage.DB.Helper.Country;
import AlexPackage.DB.Helper.Tags;
import lv.javaguru.java2.database.DBException;

import java.util.List;

/**
 * Created by Aborigens on 07-Nov-15.
 */
public interface RouteDAOInterface {

    List<Country> getCountryList() throws DBException;
    List<Tags> getTagsList() throws DBException;

    boolean saveRoute(Route route) throws DBException;

}
