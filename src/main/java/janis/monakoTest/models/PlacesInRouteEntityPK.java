package janis.monakoTest.models;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by janis on 10/31/15.
 */
public class PlacesInRouteEntityPK implements Serializable {
    private int routeId;
    private int seqnr;

    @Column(name = "routeID")
    @Id
    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    @Column(name = "SEQNR")
    @Id
    public int getSeqnr() {
        return seqnr;
    }

    public void setSeqnr(int seqnr) {
        this.seqnr = seqnr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlacesInRouteEntityPK that = (PlacesInRouteEntityPK) o;

        if (routeId != that.routeId) return false;
        if (seqnr != that.seqnr) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = routeId;
        result = 31 * result + seqnr;
        return result;
    }
}
