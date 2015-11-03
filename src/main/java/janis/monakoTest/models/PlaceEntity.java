package janis.monakoTest.models;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by janis on 10/31/15.
 */
@Entity
@Table(name = "PLACE", schema = "", catalog = "monaco_test")
public class PlaceEntity {
    private int placeId;
    private double latitude;
    private double longitute;
    private int cityId;
    private int countryId;
    private String imageUrl;
    private String placeName;
    private String placeAddress;
    private Integer placeTypeId;
    private Collection<CommentReviewOnPlaceEntity> commentReviewOnPlacesByPlaceId;
    private CityRefEntity cityRefByCityId;
    private PlaceTypeRefEntity placeTypeRefByPlaceTypeId;
    private Collection<PlacesInRouteEntity> placesInRoutesByPlaceId;
    private Collection<ReviewOnPlaceEntity> reviewOnPlacesByPlaceId;

    @Id
    @Column(name = "placeID")
    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }

    @Basic
    @Column(name = "latitude")
    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Basic
    @Column(name = "longitute")
    public double getLongitute() {
        return longitute;
    }

    public void setLongitute(double longitute) {
        this.longitute = longitute;
    }

    @Basic
    @Column(name = "cityID")
    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    @Basic
    @Column(name = "countryID")
    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    @Basic
    @Column(name = "imageURL")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Basic
    @Column(name = "placeName")
    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    @Basic
    @Column(name = "placeAddress")
    public String getPlaceAddress() {
        return placeAddress;
    }

    public void setPlaceAddress(String placeAddress) {
        this.placeAddress = placeAddress;
    }

    @Basic
    @Column(name = "placeTypeID")
    public Integer getPlaceTypeId() {
        return placeTypeId;
    }

    public void setPlaceTypeId(Integer placeTypeId) {
        this.placeTypeId = placeTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlaceEntity that = (PlaceEntity) o;

        if (placeId != that.placeId) return false;
        if (Double.compare(that.latitude, latitude) != 0) return false;
        if (Double.compare(that.longitute, longitute) != 0) return false;
        if (cityId != that.cityId) return false;
        if (countryId != that.countryId) return false;
        if (imageUrl != null ? !imageUrl.equals(that.imageUrl) : that.imageUrl != null) return false;
        if (placeName != null ? !placeName.equals(that.placeName) : that.placeName != null) return false;
        if (placeAddress != null ? !placeAddress.equals(that.placeAddress) : that.placeAddress != null) return false;
        if (placeTypeId != null ? !placeTypeId.equals(that.placeTypeId) : that.placeTypeId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = placeId;
        temp = Double.doubleToLongBits(latitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(longitute);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + cityId;
        result = 31 * result + countryId;
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        result = 31 * result + (placeName != null ? placeName.hashCode() : 0);
        result = 31 * result + (placeAddress != null ? placeAddress.hashCode() : 0);
        result = 31 * result + (placeTypeId != null ? placeTypeId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "placeByPlaceId")
    public Collection<CommentReviewOnPlaceEntity> getCommentReviewOnPlacesByPlaceId() {
        return commentReviewOnPlacesByPlaceId;
    }

    public void setCommentReviewOnPlacesByPlaceId(Collection<CommentReviewOnPlaceEntity> commentReviewOnPlacesByPlaceId) {
        this.commentReviewOnPlacesByPlaceId = commentReviewOnPlacesByPlaceId;
    }

    @ManyToOne
    @JoinColumn(name = "cityID", referencedColumnName = "CITY_NAME_ID", nullable = false)
    public CityRefEntity getCityRefByCityId() {
        return cityRefByCityId;
    }

    public void setCityRefByCityId(CityRefEntity cityRefByCityId) {
        this.cityRefByCityId = cityRefByCityId;
    }

    @ManyToOne
    @JoinColumn(name = "placeTypeID", referencedColumnName = "PLACE_TYPE_ID")
    public PlaceTypeRefEntity getPlaceTypeRefByPlaceTypeId() {
        return placeTypeRefByPlaceTypeId;
    }

    public void setPlaceTypeRefByPlaceTypeId(PlaceTypeRefEntity placeTypeRefByPlaceTypeId) {
        this.placeTypeRefByPlaceTypeId = placeTypeRefByPlaceTypeId;
    }

    @OneToMany(mappedBy = "placeByPlaceId")
    public Collection<PlacesInRouteEntity> getPlacesInRoutesByPlaceId() {
        return placesInRoutesByPlaceId;
    }

    public void setPlacesInRoutesByPlaceId(Collection<PlacesInRouteEntity> placesInRoutesByPlaceId) {
        this.placesInRoutesByPlaceId = placesInRoutesByPlaceId;
    }

    @OneToMany(mappedBy = "placeByPlaceId")
    public Collection<ReviewOnPlaceEntity> getReviewOnPlacesByPlaceId() {
        return reviewOnPlacesByPlaceId;
    }

    public void setReviewOnPlacesByPlaceId(Collection<ReviewOnPlaceEntity> reviewOnPlacesByPlaceId) {
        this.reviewOnPlacesByPlaceId = reviewOnPlacesByPlaceId;
    }
}
