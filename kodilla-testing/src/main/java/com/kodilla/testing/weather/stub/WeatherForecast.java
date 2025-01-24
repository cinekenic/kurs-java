package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {

            // adding 1 celsius degree to current value
            // as a temporary weather forecast
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }
        return resultMap;
    }

        public double calculateAverageTemperature() {
            Map<String, Double> temperatureMap = temperatures.getTemperatures();
            double sum = 0;
            for(double temp : temperatureMap.values()) {
                sum += temp;
            }
            return sum / temperatureMap.size();
        }

        public double calculateMedianTemperature() {
        Map<String, Double> temperatureMap = temperatures.getTemperatures();
            List<Double> temperatureList = new ArrayList<>(temperatureMap.values());
            Collections.sort(temperatureList);

            int size = temperatureList.size();
            if(size % 2 == 0) {
               return  (temperatureList.get(size / 2 - 1) + temperatureList.get(size / 2)) / 2.0;
            } else {
                return temperatureList.get(size / 2);
            }
        }

}