package com.andrew.marvin.CarbonIntensityDomain;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;

@Data
public class IntensityData implements Serializable {
    private ArrayList<Intensity> data = new ArrayList<>();
}
