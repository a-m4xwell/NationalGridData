package com.andrew.marvin.CarbonIntensityDomain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class IntensityFactors implements Serializable {
    private String Units = "gCO2/kWh";

    @JsonProperty("Biomass")
    private Integer biomass;
    @JsonProperty("Coal")
    private Integer coal;
    @JsonProperty("Dutch Imports")
    private Integer DutchImports;
    @JsonProperty("French Imports")
    private Integer frenchImports;
    @JsonProperty("Gas (Combined Cycle)")
    private Integer gasCombinedCycle;
    @JsonProperty("Gas (Open Cycle)")
    private Integer gasOpenCycle;
    @JsonProperty("Hydro")
    private Integer hydro;
    @JsonProperty("Irish Imports")
    private Integer irishImports;
    @JsonProperty("Nuclear")
    private Integer nuclear;
    @JsonProperty("Oil")
    private Integer oil;
    @JsonProperty("Other")
    private Integer Other;
    @JsonProperty("Pumped Storage")
    private Integer pumpedStorage;
    @JsonProperty("Solar")
    private Integer solar;
    @JsonProperty("Wind")
    private Integer wind;

}
