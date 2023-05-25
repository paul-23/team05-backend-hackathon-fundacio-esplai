package com.fundacio.esplai.hacktahon.model.domain;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "countries")
public class Country {
    @Id
    private String id;
    private String name;
    private String region;
    private double population;
    private double hdi;
    private double gdp;
    private double croplandFootprint;
    private double grazingFootprint;
    private double forestFootprint;
    private double carbonFootprint;
    private double fishFootprint;
    private double totalEcologicalFootprint;
    private double cropland;
    private double grazingLand;
    private double forestLand;
    private double fishingWater;
    private double urbanLand;
    private double totalBiocapacity;
    private double biocapacityDeficitOrReserve;
    private double earthRequired;
    private int countriesRequired;
    private String dataQuality;


}
