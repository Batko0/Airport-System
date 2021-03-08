package com.company.entities;

public class Flights {
    // needed fields
    private int flight_id;
    private String aircraft_id;
    private int cap_id;
    private String departure_arrival;
    private String flight_time;
    private boolean availability;
    // some color
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";

    // constructors to save data that is from DB
    public Flights() {}

    public Flights(String aircraft_id, int cap_id, String departure_arrival, String flight_time, boolean availability) {
        setAircraft_id(aircraft_id);
        setCap_id(cap_id);
        setDeparture_arrival(departure_arrival);
        setFlight_time(flight_time);
        setAvailability(availability);
    }

    public Flights(int flight_id, String aircraft_id, int cap_id, String departure_arrival, String flight_time, boolean availability) {
        setFlight_id(flight_id);
        setAircraft_id(aircraft_id);
        setCap_id(cap_id);
        setDeparture_arrival(departure_arrival);
        setFlight_time(flight_time);
        setAvailability(availability);
    }

    //Getters
    public int getFlight_id() {
        return flight_id;
    }

    public String getAircraft_id() {
        return aircraft_id;
    }

    public int getCap_id() {
        return cap_id;
    }

    public String getDeparture_arrival() {
        return departure_arrival;
    }

    public String getFlight_time() {
        return flight_time;
    }

    public boolean isAvailability() {
        return availability;
    }

    //Setter
    public void setFlight_id(int flight_id) {
        this.flight_id = flight_id;
    }

    public void setAircraft_id(String aircraft_id) {
        this.aircraft_id = aircraft_id;
    }

    public void setCap_id(int cap_id) {
        this.cap_id = cap_id;
    }

    public void setDeparture_arrival(String departure_arrival) {
        this.departure_arrival = departure_arrival;
    }

    public void setFlight_time(String flight_time) {
        this.flight_time = flight_time;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Flights{" +
                      ANSI_BLUE + "flight_id=" + ANSI_RESET + flight_id  +
                "," + ANSI_BLUE + "aircraft_id=" + ANSI_RESET + "'" + aircraft_id + '\'' +
                "," + ANSI_BLUE + "cap_id=" + ANSI_RESET + cap_id +
                "," + ANSI_BLUE +  "departure_arrival=" + ANSI_RESET + "'" + departure_arrival + '\'' +
                "," + ANSI_BLUE + "flight_time=" + ANSI_RESET + "'" + flight_time + '\'' +
                "," + ANSI_BLUE +"availability=" + ANSI_RESET + availability +
                '}' + "\n";
    }
}
