package com.kodilla.good.patterns.challenges.flightCompany;

public class Application {
    public static void main(String[] args) {
        FlightRepository repository = new FlightRepository();

        repository.addFlight("GDAŃSK", "WROCŁAW");
        repository.addFlight("GDAŃSK", "KRAKÓW");
        repository.addFlight("KRAKÓW", "WROCŁAW");
        repository.addFlight("WARSZAWA", "GDAŃSK");

        System.out.println("Flights from GDAŃSK: " + repository.findFlightsFrom("GDAŃSK"));
        System.out.println("Flights to WROCŁAW: " + repository.findFlightsTo("WROCŁAW"));
        System.out.println("Flights from GDAŃSK through KRAKÓW to WROCŁAW: " + repository.findFlightsWithStopover("GDAŃSK", "KRAKÓW", "WROCŁAW"));
    }
}
