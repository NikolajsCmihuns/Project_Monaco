package com.monaco.datasources;

import com.monaco.entities.City;
import com.monaco.entities.Country;
import com.monaco.database.CityDAOInterface;
import com.monaco.database.CountryDAOInterface;
import com.monaco.database.TagDAOInterface;
import com.monaco.entities.Tag;
import lv.javaguru.java2.database.DBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maksimspuskels on 26/11/15.
 */

@Component
public class RegistrationPageDS {

    @Autowired
    private TagDAOInterface tagDAO;

    @Autowired
    private CountryDAOInterface countryDAO;

    @Autowired
    private CityDAOInterface cityDAO;

    public RegistrationPageDS() {

    }

    public List<City> cities;
    public List<Tag> tags;
    public List<Country> countries;

    public void generateDatasource() {
        this.cities = getAllCities();
        this.countries = getAllCountries();
        this.tags = getAllTags();
    }

    public List<Country> getCountries() {
        return countries;
    }

    public List<City> getCities() {
        return cities;
    }

    public List<Tag> getTags() {
        return tags;
    }

    private List<City> getAllCities() {
        List<City> allCities = new ArrayList<>();

        try {
            Country country = countryDAO.getCountryByID(401);
            allCities = country.getCities();
        } catch (DBException e) {
            e.printStackTrace();
        }

        return allCities;
    }

    private List<Tag> getAllTags() {
        List<Tag> allTags = new ArrayList<>();

        try {
            allTags = tagDAO.getAllTags();
        } catch (DBException e) {
            e.printStackTrace();
        }

        return allTags;
    }

    private List<Country> getAllCountries() {
        List<Country> allCountries = new ArrayList<>();

        try {
            allCountries = countryDAO.getAllCountries();
        } catch (DBException e) {
            e.printStackTrace();
        }

        return allCountries;
    }

}
