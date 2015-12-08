package janis.monaco.database.place;


import janis.monaco.database.PlaceDAO;
import janis.monaco.domain.Place;
import org.springframework.stereotype.Component;

@Component
public class PlaceDAOImpl extends CRUDOperationDAOImpl<Place> implements PlaceDAO {

}
