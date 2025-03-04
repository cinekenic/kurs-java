package com.kodilla.good.patterns.challenges.flightCompany;

import java.util.Objects;

public class Flight {
    private final String from;
    private final String to;

    public Flight(String from, String to) {
        this.from = from;
        this.to = to;
    }


    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(from, flight.from) && Objects.equals(to, flight.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }

    @Override
    public String toString() {
        return "Flight{" + "from='" + from + '\'' + ", to='" + to + '\'' + '}';
    }
}
