package com.andrew.marvin;

import com.andrew.marvin.CarbonIntensityDomain.GenerationMixData;
import com.andrew.marvin.CarbonIntensityDomain.IntensityData;
import com.andrew.marvin.CarbonIntensityDomain.IntensityFactorsData;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

public class IntensityCache {
    private ApplicationProperties applicationProperties = new ApplicationProperties();

    @Autowired
    private RestTemplate restTemplate;

    @Getter
    private IntensityData currentIntensityData = new IntensityData();
    @Getter
    private IntensityData todaysIntensityData = new IntensityData();
    @Getter
    private IntensityFactorsData factors = new IntensityFactorsData();
    @Getter
    private GenerationMixData generationMixData = new GenerationMixData();

    String test;

    @Scheduled(fixedRate = 30000)
    public void update() {
        currentIntensityData = restTemplate.getForObject(
                applicationProperties.getCarbonIntensityBaseUrl() + "/intensity", IntensityData.class);
        todaysIntensityData = restTemplate.getForObject(
                applicationProperties.getCarbonIntensityBaseUrl() + "/intensity/date", IntensityData.class);
        factors = restTemplate.getForObject(
                applicationProperties.getCarbonIntensityBaseUrl() + "/intensity/factors", IntensityFactorsData.class);
        generationMixData = restTemplate.getForObject(
                applicationProperties.getCarbonIntensityBaseUrl() + "/generation", GenerationMixData.class);

    }
}
