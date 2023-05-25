package com.fundacio.esplai.hacktahon.model.service;

import com.fundacio.esplai.hacktahon.model.domain.Country;
import com.fundacio.esplai.hacktahon.model.domain.GreenhouseGasEmission;
import com.fundacio.esplai.hacktahon.model.dto.CountryDTO;

import java.util.List;

public interface ICountryService {

    CountryDTO findCountryByName(String name);
    List<CountryDTO> getAllCountries();
    List<GreenhouseGasEmission> getAllGasesByCountry(String countryId);

}
