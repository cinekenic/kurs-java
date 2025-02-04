package com.kodilla.exception.test;

public class Main {
    public static void main(String[] args) {
        Flight flight1 = new Flight("JFK", "LHR");
        Flight flight2 = new Flight("WAW", "CDG");
        Flight flight3 = new Flight("BER", "XYZ");

        FlightSearcher flightSearcher = new FlightSearcher();

        try {
            flightSearcher.findFlight(flight1);
        }catch (RouteNotFoundException e){
            System.out.println("Błąd: " + e.getMessage());
        }

        try {
            flightSearcher.findFlight(flight2);
        }catch (RouteNotFoundException e){
            System.out.println("Błąd: " + e.getMessage());
        }

        try {
            flightSearcher.findFlight(flight3);
        }catch (RouteNotFoundException e){
            System.out.println("Błąd: " + e.getMessage());
        }
    }
}
