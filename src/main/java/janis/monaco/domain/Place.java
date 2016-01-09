package janis.monaco.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by janis on 1/8/16.
 */
@Entity
@Table(name = "PLACE", schema = "", catalog = "monaco")
public class Place {
    @Id
    @Column(name = "placeID")
    private int placeId;
    @Basic
    @Column(name = "latitude")
    private double latitude;
    @Basic
    @Column(name = "longitude")
    private double longitude;
    @Basic
    @Column(name = "imageURL")
    private String imageUrl;
    @Basic
    @Column(name = "placeName")
    private String placeName;
    @Basic
    @Column(name = "placeAddress")
    private String placeAddress;
    @Basic
    @Column(name = "placeTypeID")
    private Integer placeTypeId;
    @OneToMany(mappedBy = "placeByPlaceId")
	private Collection<Events> eventsesByPlaceId;
    @ManyToOne
    @JoinColumn(name = "placeTypeID", referencedColumnName = "PLACE_TYPE_ID", insertable=false, updatable=false)
    private PlaceTypeRef placeTypeRefByPlaceTypeId;
    @OneToMany(mappedBy = "placeByPlaceId")
    private Collection<PlacesInRoute> placesInRoutesByPlaceId;
    @OneToMany(mappedBy = "placeByPlaceId")
    private Collection<Review> reviewsByPlaceId;


    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }


    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }


    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }


    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }


    public String getPlaceAddress() {
        return placeAddress;
    }

    public void setPlaceAddress(String placeAddress) {
        this.placeAddress = placeAddress;
    }


    public Integer getPlaceTypeId() {
        return placeTypeId;
    }

    public void setPlaceTypeId(Integer placeTypeId) {
        this.placeTypeId = placeTypeId;
    }




    public Collection<Events> getEventsesByPlaceId() {
        return eventsesByPlaceId;
    }

    public void setEventsesByPlaceId(Collection<Events> eventsesByPlaceId) {
        this.eventsesByPlaceId = eventsesByPlaceId;
    }

   
    public PlaceTypeRef getPlaceTypeRefByPlaceTypeId() {
        return placeTypeRefByPlaceTypeId;
    }

    public void setPlaceTypeRefByPlaceTypeId(PlaceTypeRef placeTypeRefByPlaceTypeId) {
        this.placeTypeRefByPlaceTypeId = placeTypeRefByPlaceTypeId;
    }


    public Collection<PlacesInRoute> getPlacesInRoutesByPlaceId() {
        return placesInRoutesByPlaceId;
    }

    public void setPlacesInRoutesByPlaceId(Collection<PlacesInRoute> placesInRoutesByPlaceId) {
        this.placesInRoutesByPlaceId = placesInRoutesByPlaceId;
    }


    public Collection<Review> getReviewsByPlaceId() {
        return reviewsByPlaceId;
    }

    public void setReviewsByPlaceId(Collection<Review> reviewsByPlaceId) {
        this.reviewsByPlaceId = reviewsByPlaceId;
    }

}
