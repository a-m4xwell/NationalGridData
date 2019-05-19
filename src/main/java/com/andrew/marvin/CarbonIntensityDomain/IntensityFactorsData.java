package com.andrew.marvin.CarbonIntensityDomain;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;

@Data
public class IntensityFactorsData implements Serializable {
    ArrayList<IntensityFactors> data = new ArrayList<>();
}
