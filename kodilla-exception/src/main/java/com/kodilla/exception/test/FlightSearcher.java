package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightSearcher {

    public void findFlight(Flight flight ) throws RouteNotFoundException {
        Map<String, Boolean> availableAirports = new HashMap<>();

        availableAirports.put("JFK", true);
        availableAirports.put("LHR", true);
        availableAirports.put("CDG", false);
        availableAirports.put("WAW", true);
        availableAirports.put("BER", true);

        String arrivalAirport = flight.getArrivalAirport();

        if(!availableAirports.containsKey(arrivalAirport)) {
            throw new RouteNotFoundException("Lotnisko docelowe " + arrivalAirport + " nie istnieje w systemie!");
        }

        if(!availableAirports.get(arrivalAirport)) {
            throw new RouteNotFoundException("Lotnisko " + arrivalAirport + " istnieje, ale loty do niego są niedostępne!");
        }

        System.out.println("Lot do " + arrivalAirport + " jest dostępny.");
    }
}
