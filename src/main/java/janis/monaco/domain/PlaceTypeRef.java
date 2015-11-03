package janis.monaco.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by janis on 11/3/15.
 */
@Entity
@Table(name = "PLACE_TYPE_REF", schema = "", catalog = "monaco")
public class PlaceTypeRef {
    private int placeTypeId;
    private String placeType;
    private Collection<Place> placesByPlaceTypeId;

    @Id
    @Column(name = "PLACE_TYPE_ID")
    public int getPlaceTypeId() {
        return placeTypeId;
    }

    public void setPlaceTypeId(int placeTypeId) {
        this.placeTypeId = placeTypeId;
    }

    @Basic
    @Column(name = "PLACE_TYPE")
    public String getPlaceType() {
        return placeType;
    }

    public void setPlaceType(String placeType) {
        this.placeType = placeType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlaceTypeRef that = (PlaceTypeRef) o;

        if (placeTypeId != that.placeTypeId) return false;
        if (placeType != null ? !placeType.equals(that.placeType) : that.placeType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = placeTypeId;
        result = 31 * result + (placeType != null ? placeType.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "placeTypeRefByPlaceTypeId")
    public Collection<Place> getPlacesByPlaceTypeId() {
        return placesByPlaceTypeId;
    }

    public void setPlacesByPlaceTypeId(Collection<Place> placesByPlaceTypeId) {
        this.placesByPlaceTypeId = placesByPlaceTypeId;
    }
}
