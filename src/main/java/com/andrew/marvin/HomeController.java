package com.andrew.marvin;

import com.andrew.marvin.CarbonIntensityDomain.Intensity;
import com.andrew.marvin.CarbonIntensityDomain.IntensityData;
import com.andrew.marvin.CarbonIntensityDomain.IntensityFactorsData;
import com.andrew.marvin.DataVisualization.DataVisualisationBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final IntensityCache intensityCache;
    private final DataVisualisationBuilder dataVisualisationBuilder = new DataVisualisationBuilder();

    @GetMapping("/home")
    public String getHome(Model model) {
        IntensityData currentIntensityData = intensityCache.getCurrentIntensityData();
        IntensityData todaysIntensityData = intensityCache.getTodaysIntensityData();
        IntensityFactorsData factors = intensityCache.getFactors();

        if (currentIntensityData.getData().size() > 0) {
            Intensity currentIntensity = currentIntensityData.getData().get(0);
            model.addAttribute("currentIntensity", currentIntensity);
        }

        model.addAttribute("todaysIntensity", todaysIntensityData);
        model.addAttribute("pieChartData", dataVisualisationBuilder
                .buildPieChartData(intensityCache.getGenerationMixData()));
        model.addAttribute("lineChartData", dataVisualisationBuilder
                .buildLineChartData(todaysIntensityData.getData()));
        model.addAttribute("factors", factors);

        return "home";
    }
}
