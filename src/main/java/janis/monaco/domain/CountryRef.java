package janis.monaco.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by janis on 11/3/15.
 */
@Entity
@Table(name = "COUNTRY_REF", schema = "", catalog = "monaco")
public class CountryRef {
    private int countryNameId;
    private String countryName;
    private Collection<CityRef> cityRefsByCountryNameId;
    private Collection<User> usersByCountryNameId;

    @Id
    @Column(name = "COUNTRY_NAME_ID")
    public int getCountryNameId() {
        return countryNameId;
    }

    public void setCountryNameId(int countryNameId) {
        this.countryNameId = countryNameId;
    }

    @Basic
    @Column(name = "COUNTRY_NAME")
    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CountryRef that = (CountryRef) o;

        if (countryNameId != that.countryNameId) return false;
        if (countryName != null ? !countryName.equals(that.countryName) : that.countryName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = countryNameId;
        result = 31 * result + (countryName != null ? countryName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "countryRefByCityCountryId")
    public Collection<CityRef> getCityRefsByCountryNameId() {
        return cityRefsByCountryNameId;
    }

    public void setCityRefsByCountryNameId(Collection<CityRef> cityRefsByCountryNameId) {
        this.cityRefsByCountryNameId = cityRefsByCountryNameId;
    }

    @OneToMany(mappedBy = "countryRefByCountryId")
    public Collection<User> getUsersByCountryNameId() {
        return usersByCountryNameId;
    }

    public void setUsersByCountryNameId(Collection<User> usersByCountryNameId) {
        this.usersByCountryNameId = usersByCountryNameId;
    }
}
