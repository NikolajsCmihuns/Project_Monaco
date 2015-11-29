package janis.monaco.entities;

import janis.monaco.domain.CountryRef;
import janis.monaco.domain.User;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by janis on 11/3/15.
 */
@Entity
@Table(name = "CITY_REF", schema = "", catalog = "monaco")
public class CityRef {
    private int cityNameId;
    private String cityName;
    private int cityCountryId;
    private CountryRef countryRefByCityCountryId;
    private Collection<User> usersByCityNameId;

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

    @Basic
    @Column(name = "CITY_COUNTRY_ID")
    public int getCityCountryId() {
        return cityCountryId;
    }

    public void setCityCountryId(int cityCountryId) {
        this.cityCountryId = cityCountryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CityRef cityRef = (CityRef) o;

        if (cityNameId != cityRef.cityNameId) return false;
        if (cityCountryId != cityRef.cityCountryId) return false;
        if (cityName != null ? !cityName.equals(cityRef.cityName) : cityRef.cityName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cityNameId;
        result = 31 * result + (cityName != null ? cityName.hashCode() : 0);
        result = 31 * result + cityCountryId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "CITY_COUNTRY_ID", referencedColumnName = "COUNTRY_NAME_ID", nullable = false,insertable=false, updatable=false)
    public CountryRef getCountryRefByCityCountryId() {
        return countryRefByCityCountryId;
    }

    public void setCountryRefByCityCountryId(CountryRef countryRefByCityCountryId) {
        this.countryRefByCityCountryId = countryRefByCityCountryId;
    }

    @OneToMany(mappedBy = "cityRefByCityId")
    public Collection<User> getUsersByCityNameId() {
        return usersByCityNameId;
    }

    public void setUsersByCityNameId(Collection<User> usersByCityNameId) {
        this.usersByCityNameId = usersByCityNameId;
    }
}
