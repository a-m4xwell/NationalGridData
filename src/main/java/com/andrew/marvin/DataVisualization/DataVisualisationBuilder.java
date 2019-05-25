package com.andrew.marvin.DataVisualization;

import com.andrew.marvin.CarbonIntensityDomain.*;

import java.util.*;

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

    public List<BarChartData> buildBarChartData(IntensityFactorsData data){
        ArrayList<IntensityFactors> intensityFactors = data.getData();
        if(intensityFactors.size() == 1){
            IntensityFactors intensity = intensityFactors.get(0);
            List<BarChartData> barChartData = addFactorsToList(intensity);
            Collections.sort(barChartData, ((barChartData1, t1) ->
                    Integer.compare(t1.getValue(), barChartData1.getValue())
            ));
            return barChartData;
        }
        return new ArrayList<>();
    }

    private List<BarChartData> addFactorsToList(IntensityFactors intensity) {
        ArrayList<BarChartData> list = new ArrayList<>();

        list.add(new BarChartData("Biomass", intensity.getBiomass()));
        list.add(new BarChartData("Coal", intensity.getCoal()));
        list.add(new BarChartData("Dutch Imports", intensity.getDutchImports()));
        list.add(new BarChartData("French Imports", intensity.getFrenchImports()));
        list.add(new BarChartData("Irish Imports", intensity.getIrishImports()));
        list.add(new BarChartData("Gas (Combined Cycle)", intensity.getGasCombinedCycle()));
        list.add(new BarChartData("Gas (Open Cycle)", intensity.getGasOpenCycle()));
        list.add(new BarChartData("Hydro", intensity.getHydro()));
        list.add(new BarChartData("Nuclear", intensity.getNuclear()));
        list.add(new BarChartData("Oil", intensity.getOil()));
        list.add(new BarChartData("Other", intensity.getOther()));
        list.add(new BarChartData("Pumped Storage", intensity.getPumpedStorage()));
        list.add(new BarChartData("Solar", intensity.getSolar()));
        list.add(new BarChartData("Wind", intensity.getWind()));

        return list;
    }
}
