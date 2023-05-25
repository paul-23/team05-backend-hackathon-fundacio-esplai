package com.fundacio.esplai.hacktahon.model.service;

import com.fundacio.esplai.hacktahon.model.domain.Country;
import com.fundacio.esplai.hacktahon.model.domain.GreenhouseGasEmission;
import com.fundacio.esplai.hacktahon.model.dto.CountryDTO;
import com.fundacio.esplai.hacktahon.model.repository.CountryRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements ICountryService {

    private final CountryRepo countryRepo;

    public CountryServiceImpl(CountryRepo countryRepository) {
        this.countryRepo = countryRepository;
    }

    @Override
    public CountryDTO findCountryByName(String name) {
        return ModelMapper.singleInstance().toCountryDTO(countryRepo.findByName(name));
    }

    @Override
    public List<CountryDTO> getAllCountries() {
        return ModelMapper.singleInstance().toCountryDTOList(countryRepo.findAll());
    }

    public List<GreenhouseGasEmission> getAllGasesByCountry(String countryId) {
        Country country = countryRepo.findById(countryId).orElse(null);
        if (country == null) {
            throw new IllegalArgumentException("Country not found");
        }
        return country.getEmissions();
    }

    /*public ComparisonResult compareGasEmissions(String gasType, String selectedCountryId, String otherCountryId) {
        Country country1 = countryRepo.findById(selectedCountryId).orElse(null);
        Country country2 = countryRepo.findById(otherCountryId).orElse(null);

        if (country1 == null || country2 == null) {
            throw new IllegalArgumentException("País(es) no encontrado(s)");
        }

        double emissionsCountry1 = getEmissionsByGasType(country1, gasType);
        double emissionsCountry2 = getEmissionsByGasType(country2, gasType);

        ComparisonResult comparisonResult = new ComparisonResult();
        comparisonResult.setSelectedCountryId(country1.getName());
        comparisonResult.setOtherCountryId(country2.getName());
        comparisonResult.setGasType(gasType);
        comparisonResult.setEmissionsSelectedCountry(emissionsCountry1);
        comparisonResult.setEmissionsOtherCountry(emissionsCountry2);

        return comparisonResult;
    }

    private double getEmissionsByGasType(Country country, String gasType) {
        List<GreenhouseGasEmission> emissions = country.getEmissions();
        for (GreenhouseGasEmission emission : emissions) {
            if (emission.getGasType().equalsIgnoreCase(gasType)) {
                return emission.getEmissionAmount();
            }
        }
        throw new IllegalArgumentException("Tipo de gas no encontrado para el país especificado");
    }*/

    /*
    @Autowired
    private HttpSession httpSession;

    @GetMapping("/current-country")
    public CarbonFootprintData getCurrentCountryCarbonFootprintData() {
        String currentCountry = (String) httpSession.getAttribute("country");
        return carbonFootprintRepository.findByCountry(currentCountry);
    }

    @GetMapping("/compare/{country}")
    public ComparisonResult compareCarbonFootprintData(@PathVariable String country) {
        String currentCountry = (String) httpSession.getAttribute("country");

        CarbonFootprintData data1 = carbonFootprintRepository.findByCountry(currentCountry);
        CarbonFootprintData data2 = carbonFootprintRepository.findByCountry(country);

        // Realizar la comparación de los datos de huella de carbono y devolver el resultado
        ComparisonResult result = new ComparisonResult(data1, data2);
        return result;
    }*/



}

