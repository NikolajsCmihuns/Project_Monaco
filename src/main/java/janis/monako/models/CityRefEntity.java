package janis.monako.models;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by janis on 10/31/15.
 */
@Entity
@Table(name = "CITY_REF", schema = "", catalog = "monaco_test")
public class CityRefEntity {
    private int cityNameId;
    private String cityName;
    private Collection<PlaceEntity> placesByCityNameId;

    @Id
    @Column(name = "CITY_NAME_ID")
    public int getCityNameId() {
        return cityNameId;
    }

    public void setCityNameId(int cityNameId) {
        this.cityNameId = cityNameId;
    }

    @Basic
    @Column(name = "CITY_NAME")
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CityRefEntity that = (CityRefEntity) o;

        if (cityNameId != that.cityNameId) return false;
        if (cityName != null ? !cityName.equals(that.cityName) : that.cityName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cityNameId;
        result = 31 * result + (cityName != null ? cityName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "cityRefByCityId")
    public Collection<PlaceEntity> getPlacesByCityNameId() {
        return placesByCityNameId;
    }

    public void setPlacesByCityNameId(Collection<PlaceEntity> placesByCityNameId) {
        this.placesByCityNameId = placesByCityNameId;
    }
}
