package janis.monaco.domain.entities;

import javax.persistence.*;

/**
 * Created by janis on 11/3/15.
 */
@Entity
@Table(name = "PLACES_IN_ROUTE", schema = "", catalog = "monaco")
public class PlacesInRoute {
    private int routeId;
    private int seqnr;
    private int placeId;
    private Place placeByPlaceId;
    private Route routeByRouteId;

    @Id
    @Column(name = "routeID")
    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    @Basic
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

        PlacesInRoute that = (PlacesInRoute) o;

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
    @JoinColumn(name = "placeID", referencedColumnName = "placeID", nullable = false, insertable=false, updatable=false)
    public Place getPlaceByPlaceId() {
        return placeByPlaceId;
    }

    public void setPlaceByPlaceId(Place placeByPlaceId) {
        this.placeByPlaceId = placeByPlaceId;
    }

    @ManyToOne
    @JoinColumn(name = "routeID", referencedColumnName = "routeID", nullable = false, insertable=false, updatable=false)
    public Route getRouteByRouteId() {
        return routeByRouteId;
    }

    public void setRouteByRouteId(Route routeByRouteId) {
        this.routeByRouteId = routeByRouteId;
    }
}
