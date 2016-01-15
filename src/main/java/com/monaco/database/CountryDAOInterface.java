package com.monaco.database;

import com.monaco.Entities.Country;
import lv.javaguru.java2.database.DBException;

import java.util.List;

/**
 * Created by maksimspuskels on 01/11/15.
 */

public interface CountryDAOInterface {
    Country getCountryByID(Integer id) throws DBException;

    Integer getIDByCountryName(String countryName) throws DBException;

    List<Country> getAllCountries() throws DBException;
}
