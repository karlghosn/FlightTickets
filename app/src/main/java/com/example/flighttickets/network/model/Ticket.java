package com.example.flighttickets.network.model;

import com.google.gson.annotations.SerializedName;

public class Ticket {
    private String from;
    private String to;

    @SerializedName("flight_number")
    private String flightNumber;

    private String departure;
    private String arrival;
    private String duration;
    private String instructions;

    @SerializedName("stops")
    private int numberOfStops;

    private Airline airline;

    private Price price;

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDeparture() {
        return departure;
    }

    public String getArrival() {
        return arrival;
    }

    public String getDuration() {
        return duration;
    }

    public String getInstructions() {
        return instructions;
    }

    public int getNumberOfStops() {
        return numberOfStops;
    }

    public Airline getAirline() {
        return airline;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Ticket)) {
            return false;
        }

        return flightNumber.equalsIgnoreCase(((Ticket) obj).getFlightNumber());
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (this.flightNumber != null ? this.flightNumber.hashCode() : 0);
        return hash;
    }
}
