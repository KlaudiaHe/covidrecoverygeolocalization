package com.turowska.covidrecoverygeolocalization;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class MapController {

    private Covid19DataParser covid19DataParser;

    public MapController(Covid19DataParser covid19DataParser) {
        this.covid19DataParser = covid19DataParser;
    }

    @GetMapping
    public String getMap (Model model) throws IOException {
        model.addAttribute("points", covid19DataParser.getCovid19Data());
        return "map";
    }



}
