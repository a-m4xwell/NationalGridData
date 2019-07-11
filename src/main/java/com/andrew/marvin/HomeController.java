package com.andrew.marvin;

import com.andrew.marvin.CarbonIntensityDomain.Intensity;
import com.andrew.marvin.CarbonIntensityDomain.IntensityData;
import com.andrew.marvin.CarbonIntensityDomain.IntensityFactorsData;
import com.andrew.marvin.DataVisualization.DataVisualisationBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final IntensityCache intensityCache;
    private final DataVisualisationBuilder dataVisualisationBuilder = new DataVisualisationBuilder();

    /*@ModelAttribute(name = "formObject")
    public HomeForm getFormObject(){
        return new HomeForm();
    }*/

    @GetMapping("/home")
    public String getHome(Model model) {
        model.addAttribute("formObject", new HomeForm());

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
        model.addAttribute("factors", dataVisualisationBuilder.buildBarChartData(factors));

        return "home";
    }

    @PostMapping("/home")
    public String postHome(@ModelAttribute HomeForm formObject, Model model){
        System.out.println(formObject.getLocalPostcode());
        return "home";
    }

    @GetMapping("/about")
    public String getAbout(){
        return "about";
    }
}
