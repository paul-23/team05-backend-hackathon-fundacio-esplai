package com.fundacio.esplai.hacktahon.controller;

import com.fundacio.esplai.hacktahon.model.dto.CountryDTO;
import com.fundacio.esplai.hacktahon.model.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    ICountryService countryService;

    @GetMapping
        public ResponseEntity<List<CountryDTO>> getAllContries() throws Exception {
        try {
            return ResponseEntity.ok(countryService.getAllCountries());
        } catch (Exception e) {
            throw new Exception("Error while getting all countries", e);
        }
    }



}
