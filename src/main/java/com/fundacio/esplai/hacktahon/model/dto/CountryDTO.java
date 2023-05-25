package com.fundacio.esplai.hacktahon.model.dto;

import com.fundacio.esplai.hacktahon.model.domain.GreenhouseGasEmission;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CountryDTO {

    private String name;
    private List<GreenhouseGasEmission> emissions;
}
