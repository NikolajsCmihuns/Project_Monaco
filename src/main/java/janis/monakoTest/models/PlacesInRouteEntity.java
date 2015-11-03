package janis.monakoTest.models;

import javax.persistence.*;

/**
 * Created by janis on 10/31/15.
 */
@Entity
@Table(name = "PLACES_IN_ROUTE", schema = "", catalog = "monaco_test")
@IdClass(PlacesInRouteEntityPK.class)
public class PlacesInRouteEntity {
    private int routeId;
    private int seqnr;
    private int placeId;
    private PlaceEntity placeByPlaceId;
    private RouteEntity routeByRouteId;

    @Id
    @Column(name = "routeID")
    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    @Id
    @Column(name = "SEQNR")
    public int getSeqnr() {
        return seqnr;
    }

    public void setSeqnr(int seqnr) {
        this.seqnr = seqnr;
    }

    @Basic
    @Column(name = "placeID")
    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlacesInRouteEntity that = (PlacesInRouteEntity) o;

        if (routeId != that.routeId) return false;
        if (seqnr != that.seqnr) return false;
        if (placeId != that.placeId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = routeId;
        result = 31 * result + seqnr;
        result = 31 * result + placeId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "placeID", referencedColumnName = "placeID", nullable = false)
    public PlaceEntity getPlaceByPlaceId() {
        return placeByPlaceId;
    }

    public void setPlaceByPlaceId(PlaceEntity placeByPlaceId) {
        this.placeByPlaceId = placeByPlaceId;
    }

    @ManyToOne
    @JoinColumn(name = "routeID", referencedColumnName = "routeID", nullable = false)
    public RouteEntity getRouteByRouteId() {
        return routeByRouteId;
    }

    public void setRouteByRouteId(RouteEntity routeByRouteId) {
        this.routeByRouteId = routeByRouteId;
    }
}
