package janis.monaco.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * Created by janis on 1/8/16.
 */
public class PlaceTest {

    Place place = new Place();



    @Test
    public void testSetGetPlaceId() throws Exception {
        place.setPlaceId(1);
        assertEquals(1,place.getPlaceId());
    }

    @Test
    public void testSetGetLatitude() throws Exception {
        place.setLatitude(1.11);
        assertEquals(1.11, place.getLatitude(), 0.000000001);
    }

    @Test
    public void tesSetGetLongitude() throws Exception {
        place.setLongitude(1.12);
       assertEquals(1.12,place.getLongitude(), 0.000000001);
    }

    @Test
    public void testSetGetImageUrl() throws Exception {
        place.setImageUrl("ImageUrl");
        assertEquals("ImageUrl", place.getImageUrl());
    }

    @Test
    public void testSetGetPlaceName() throws Exception {
        place.setPlaceName("Name");
        assertEquals("Name", place.getPlaceName());
    }

    @Test
    public void testSetGetPlaceAddress() throws Exception {
        place.setPlaceAddress("Address");
        assertEquals("Address", place.getPlaceAddress());
    }

    @Test
    public void testSetGetPlaceTypeId() throws Exception {
        Integer a=2;
        place.setPlaceTypeId(a);
        assertEquals(a, place.getPlaceTypeId());
    }

    @Test
    public void testSetGetEventsesByPlaceId() throws Exception {
        Events events1 = new Events();
        events1.setEventId(1);
        Events events2 = new Events();
        events2.setEventId(2);
        Events events3 = new Events();
        events3.setEventId(3);
        Collection<Events> eventsCollection = new ArrayList();
            eventsCollection.add(events1);
            eventsCollection.add(events2);
            eventsCollection.add(events3);
        place.setEventsesByPlaceId(eventsCollection);
        assertEquals(eventsCollection, place.getEventsesByPlaceId());
        Collection<Events> collection = place.getEventsesByPlaceId();
        int n = 1;
        for (Iterator i=collection.iterator(); i.hasNext();) {
            events1 =(Events) i.next();
            assertEquals(n, events1.getEventId());
            n++;
        }
    }

    @Test
    public void testSetGetPlaceTypeRefByPlaceTypeId() throws Exception {
        PlaceTypeRef placeTypeRef = new PlaceTypeRef();
        place.setPlaceTypeRefByPlaceTypeId(placeTypeRef);
        assertEquals(placeTypeRef, place.getPlaceTypeRefByPlaceTypeId());
    }

    @Test
    public void testSetGetPlacesInRoutesByPlaceId() throws Exception {

    }

    @Test
    public void testEquals() throws Exception {

    }

    @Test
    public void testHashCode() throws Exception {

    }


    @Test
    public void testGetReviewsByPlaceId() throws Exception {

    }

    @Test
    public void testSetReviewsByPlaceId() throws Exception {

    }
}