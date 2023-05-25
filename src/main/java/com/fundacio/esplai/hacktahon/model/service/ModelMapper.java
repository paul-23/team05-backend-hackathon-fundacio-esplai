package com.fundacio.esplai.hacktahon.model.service;

import com.fundacio.esplai.hacktahon.model.domain.Country;
import com.fundacio.esplai.hacktahon.model.dto.CountryDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ModelMapper {
    private final org.modelmapper.ModelMapper mapper = new org.modelmapper.ModelMapper();

    private static ModelMapper instance;

    private ModelMapper() {}

    public static ModelMapper singleInstance() {
        if (instance == null) {
            instance = new ModelMapper();
        }
        return instance;
    }

    public CountryDTO toCountryDTO(Country country) {
        return mapper.map(country, CountryDTO.class);
    }

    public Country toCountry(CountryDTO countryDTO) {
        return mapper.map(countryDTO, Country.class);
    }

    public List<CountryDTO> toCountryDTOList(List<Country> countryList) {
        return countryList.stream().map(this::toCountryDTO).collect(Collectors.toList());
    }

    public List<Country> toCountryList(List<CountryDTO> countryDTOList) {
        return countryDTOList.stream().map(this::toCountry).collect(Collectors.toList());
    }

}
