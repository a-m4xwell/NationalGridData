package com.andrew.marvin.CarbonIntensityDomain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Intensity implements Serializable {
    private String from;
    private String to;
    private IntensityForecast intensity;
}
