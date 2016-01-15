package com.monaco.entities;

import javax.persistence.*;

import java.util.List;

/**
 * Created by maksimspuskels on 01/11/15.
 */

@Entity
@Table(name = "COUNTRY_REF")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COUNTRY_NAME_ID")
    Integer countryNameID;

    @Column(name = "COUNTRY_NAME")
    String countryName;

    @Column(name = "COUNTRY_SHORT_NAME")
    String countryShortName;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    private List<City> cities;

    public Country(String countryName, Integer countryNameID, String countryShortName) {
        this.countryName = countryName;
        this.countryNameID = countryNameID;
        this.countryShortName = countryShortName;
    }

    public Country() {

    }

    public String getCountryShortName() {
        return countryShortName;
    }

    public void setCountryShortName(String countryShortName) {
        this.countryShortName = countryShortName;
    }

    public Integer getCountryNameID() {
        return countryNameID;
    }

    public void setCountryNameID(Integer countryNameID) {
        this.countryNameID = countryNameID;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public List<City> getCities() { return cities; }

    public void setCities(List<City> accessories) { this.cities = accessories; }

    @Override
    public String toString() {
        return "-== Country ==-" + "\n" + countryName + "\n" + countryNameID + "\n" + "-========-";
    }
}