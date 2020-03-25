package com.turowska.covidrecoverygeolocalization;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class Covid19DataParser {

    private static final String url="https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_19-covid-Recovered.csv";

    public List<Point> getCovid19Data () throws IOException {
        List<Point> points= new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        String values= restTemplate.getForObject(url, String.class);

        assert values != null;
        StringReader stringReader = new StringReader(values);
        CSVParser parsedValues = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(stringReader);

        for (CSVRecord strings : parsedValues) {
           double latitude= Double.parseDouble(strings.get("Lat"));
           double longitude= Double.parseDouble(strings.get("Long"));
           String text= strings.get("3/15/20");
           points.add(new Point(latitude,longitude,text));
        }
        return points;
    }

}
