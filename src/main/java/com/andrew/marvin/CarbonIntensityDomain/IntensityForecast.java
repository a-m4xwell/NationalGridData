package com.andrew.marvin.CarbonIntensityDomain;

import lombok.Data;

import java.io.Serializable;

@Data
public class IntensityForecast implements Serializable {
    private Integer forecast;
    private Integer actual;
    private String index;
}
