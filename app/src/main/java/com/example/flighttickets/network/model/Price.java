package com.example.flighttickets.network.model;

import com.google.gson.annotations.SerializedName;

public class Price {
    private float price;
    private String seats;
    private String currency;

    @SerializedName("flight_number")
    private String flightNumber;

    private String from;
    private String to;

    public float getPrice() {
        return price;
    }

    public String getSeats() {
        return seats;
    }

    public String getCurrency() {
        return currency;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }
}
