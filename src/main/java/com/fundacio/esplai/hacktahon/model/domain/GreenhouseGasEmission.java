package com.fundacio.esplai.hacktahon.model.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "environmentalData")
public class GreenhouseGasEmission {
    private String year;
    private String gasType; // Tipo de gas (CO2, CH4, N2O, etc.)
    private double emissionAmount; // Cantidad de emisiones del gas en toneladas

}
