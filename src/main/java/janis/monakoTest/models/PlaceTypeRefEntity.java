package janis.monakoTest.models;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by janis on 10/31/15.
 */
@Entity
@Table(name = "PLACE_TYPE_REF", schema = "", catalog = "monaco_test")
public class PlaceTypeRefEntity {
    private int placeTypeId;
    private String placeType;
    private Collection<PlaceEntity> placesByPlaceTypeId;

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

        PlaceTypeRefEntity that = (PlaceTypeRefEntity) o;

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
    public Collection<PlaceEntity> getPlacesByPlaceTypeId() {
        return placesByPlaceTypeId;
    }

    public void setPlacesByPlaceTypeId(Collection<PlaceEntity> placesByPlaceTypeId) {
        this.placesByPlaceTypeId = placesByPlaceTypeId;
    }
}
