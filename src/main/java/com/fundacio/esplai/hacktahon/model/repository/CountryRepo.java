package com.fundacio.esplai.hacktahon.model.repository;

import com.fundacio.esplai.hacktahon.model.domain.Country;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepo extends MongoRepository<Country, String> {
    Country findByName(String name);
    List<Country> findByEmissionsGasType(String gasType);

}
