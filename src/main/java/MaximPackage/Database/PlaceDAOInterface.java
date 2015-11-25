package MaximPackage.Database;

import MaximPackage.Entities.Place;
import lv.javaguru.java2.database.DBException;

/**
 * Created by maksimspuskels on 25/10/15.
 */

public interface PlaceDAOInterface {

    void createPlace(Place place) throws DBException;

    Place getPlaceById(int id) throws DBException;
}
