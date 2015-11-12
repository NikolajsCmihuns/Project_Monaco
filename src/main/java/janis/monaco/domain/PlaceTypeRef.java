package janis.monaco.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by janis on 11/3/15.
 */
@Entity
@Table(name = "PLACE_TYPE_REF", schema = "", catalog = "monaco")
public class PlaceTypeRef {

    @Id
    @Column(name = "PLACE_TYPE_ID")
    private int placeTypeId;
    @Basic
    @Column(name = "PLACE_TYPE")
    private String placeType;
    @OneToMany(mappedBy = "placeTypeRefByPlaceTypeId")
    private Collection<Place> placesByPlaceTypeId;


    public int getPlaceTypeId() {
        return placeTypeId;
    }

    public void setPlaceTypeId(int placeTypeId) {
        this.placeTypeId = placeTypeId;
    }


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


    public Collection<Place> getPlacesByPlaceTypeId() {
        return placesByPlaceTypeId;
    }

    public void setPlacesByPlaceTypeId(Collection<Place> placesByPlaceTypeId) {
        this.placesByPlaceTypeId = placesByPlaceTypeId;
    }
}
