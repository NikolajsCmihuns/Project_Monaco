package com.monaco.Entities;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

/**
 * Created by maksimspuskels on 01/11/15.
 */

@Entity
@Table(name = "CITY_REF")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="CITY_NAME_ID")
    Integer cityNameID;

    @Column(name="CITY_NAME")
    String cityName;

    @Column(name="CITY_COUNTRY_ID")
    Integer countryID;

    @ManyToOne (fetch=EAGER)
    @JoinColumn(name="CITY_COUNTRY_ID", referencedColumnName="COUNTRY_NAME_ID", insertable=false, updatable=false)
    private Country country;

    public City(String cityName, int cityNameID, int countryID) {
        this.cityName = cityName;
        this.cityNameID = cityNameID;
        this.countryID = countryID;
    }

    public City() {

    }

    public String getCityName() {
        return cityName;
    }

    public int getCityNameID() {
        return cityNameID;
    }

    public int getCountryID() {
        return countryID;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "-== City ==-" + "\n" + cityName + "\n" + cityNameID + "\n" + countryID + "\n" + "-========-";
    }
}
