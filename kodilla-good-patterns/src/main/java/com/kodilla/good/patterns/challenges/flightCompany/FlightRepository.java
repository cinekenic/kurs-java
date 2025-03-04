package com.kodilla.good.patterns.challenges.flightCompany;

import java.util.*;
import java.util.stream.Collectors;

public class FlightRepository {
    private final Set<Flight> flights = new HashSet<>();

    public void addFlight(String from, String to) {
        flights.add(new Flight(from, to));
    }

    public Set<Flight> findFlightsFrom(String city){
        return flights.stream().filter(flight -> flight.getFrom().equalsIgnoreCase(city)).collect(Collectors.toSet());
    }

    public Set<Flight> findFlightsTo(String city) {
        return flights.stream()
                .filter(f -> f.getTo().equalsIgnoreCase(city))
                .collect(Collectors.toSet());
    }

    public Set<List<Flight>> findFlightsWithStopover(String from, String stopover, String to) {
        Set<Flight> firstLeg = findFlightsFrom(from).stream()
                .filter(f -> f.getTo().equalsIgnoreCase(stopover))
                .collect(Collectors.toSet());


        Set<Flight> connectingFlights = findFlightsFrom(stopover).stream()
                .filter(f -> f.getTo().equalsIgnoreCase(to))
                .collect(Collectors.toSet());

        return firstLeg.stream().flatMap(f1 -> connectingFlights.stream().map(f2 -> List.of(f1, f2))).collect(Collectors.toSet());
    }
}
