package com.andrew.marvin.DataVisualization;

import com.andrew.marvin.CarbonIntensityDomain.GenerationMixData;
import com.andrew.marvin.CarbonIntensityDomain.Generationmix;
import com.andrew.marvin.CarbonIntensityDomain.Intensity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DataVisualisationBuilder {

    public List<PieChartData> buildPieChartData(GenerationMixData generationMixData) {
        Optional<List<Generationmix>> optionalGenerationmixes = Optional.ofNullable(generationMixData.getData().getGenerationmix());
        if (optionalGenerationmixes.isPresent()) {
            List<Generationmix> generationmix = optionalGenerationmixes.get();
            ArrayList<PieChartData> data = new ArrayList<>();

            for (Generationmix fuel : generationmix) {
                PieChartData pieChartData = new PieChartData();
                pieChartData.setName(fuel.getFuel());
                pieChartData.setY(fuel.getPerc());
                data.add(pieChartData);
            }
            return data;
        }
        return new ArrayList<>();
    }

    public List<LineChartNode> buildLineChartData(List<Intensity> intensityData) {
        ArrayList<LineChartNode> nodes = new ArrayList<>();
        for (Intensity intensity : intensityData) {
            LineChartNode node = new LineChartNode();
            node.setValue(intensity.getIntensity().getForecast());
            if(intensity.getIntensity().getActual() != null){
                node.setActual(intensity.getIntensity().getActual());
            }
            node.setFrom(intensity.getFrom());
            node.setTo(intensity.getTo());
            nodes.add(node);
        }
        return nodes;
    }
}
