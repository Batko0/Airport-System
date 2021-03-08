package com.company.entities;

import java.sql.Date;
import java.sql.Time;

public class BoardingPass {
    // needed fields
    private int flight_id;
    private String departure_from;
    private Date departure_date;
    private Time departure_time;
    private String arrival_to;
    private Date arrival_date;
    private Time arrival_time;
    private String name;
    private String surname;
    private int ticket_id;
    private int seat_id;
    // some colors
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    // constructors to save data that is from DB
    public BoardingPass() {}

    public BoardingPass(String departure_from, Date departure_date, Time departure_time, String arrival_to,
                        Date arrival_date, Time arrival_time, String name, String surname, int ticket_id, int seat_id) {
        setDeparture_from(departure_from);
        setDeparture_date(departure_date);
        setDeparture_time(departure_time);
        setArrival_to(arrival_to);
        setArrival_date(arrival_date);
        setArrival_time(arrival_time);
        setName(name);
        setSurname(surname);
        setTicket_id(ticket_id);
        setSeat_id(seat_id);
    }

    public BoardingPass(int flight_id, String departure_from, Date departure_date, Time departure_time, String arrival_to,
                        Date arrival_date, Time arrival_time, String name, String surname, int ticket_id, int seat_id) {
        setFlight_id(flight_id);
        setDeparture_from(departure_from);
        setDeparture_date(departure_date);
        setDeparture_time(departure_time);
        setArrival_to(arrival_to);
        setArrival_date(arrival_date);
        setArrival_time(arrival_time);
        setName(name);
        setSurname(surname);
        setTicket_id(ticket_id);
        setSeat_id(seat_id);
    }

    //Getters
    public int getFlight_id() {
        return flight_id;
    }

    public String getDeparture_from() {
        return departure_from;
    }

    public Date getDeparture_date() {
        return departure_date;
    }

    public Time getDeparture_time() {
        return departure_time;
    }

    public String getArrival_to() {
        return arrival_to;
    }

    public Date getArrival_date() {
        return arrival_date;
    }

    public Time getArrival_time() {
        return arrival_time;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getTicket_id() {
        return ticket_id;
    }

    public int getSeat_id() {
        return seat_id;
    }

    //Setters

    public void setFlight_id(int flight_id) {
        this.flight_id = flight_id;
    }

    public void setDeparture_from(String departure_from) {
        this.departure_from = departure_from;
    }

    public void setDeparture_date(Date departure_date) {
        this.departure_date = departure_date;
    }

    public void setDeparture_time(Time departure_time) {
        this.departure_time = departure_time;
    }

    public void setArrival_to(String arrival_to) {
        this.arrival_to = arrival_to;
    }

    public void setArrival_date(Date arrival_date) {
        this.arrival_date = arrival_date;
    }

    public void setArrival_time(Time arrival_time) {
        this.arrival_time = arrival_time;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setTicket_id(int ticket_id) {
        this.ticket_id = ticket_id;
    }

    public void setSeat_id(int seat_id) {
        this.seat_id = seat_id;
    }

    @Override
    public String toString() {
        return "BoardingPass{" +
                      ANSI_BLUE + "flight_id=" + ANSI_RESET + flight_id +
                "," + ANSI_BLUE + "departure_from=" + ANSI_RESET + "'" + departure_from + '\'' +
                "," + ANSI_BLUE + "departure_date=" + ANSI_RESET + departure_date +
                "," + ANSI_BLUE + "departure_time=" + ANSI_RESET + departure_time +
                "," + ANSI_BLUE + "arrival_to=" + ANSI_RESET + "'" + arrival_to + '\'' +
                "," + ANSI_BLUE + "arrival_date=" + ANSI_RESET + arrival_date +
                "," + ANSI_BLUE + "arrival_time=" + ANSI_RESET + arrival_time +
                "," + ANSI_BLUE + "name=" + ANSI_RESET + "'" + name + '\'' +
                "," + ANSI_BLUE + "surname=" + ANSI_RESET + "'" + surname + '\'' +
                "," + ANSI_BLUE + "ticket_id=" + ANSI_RESET + ticket_id +
                "," + ANSI_BLUE + "seat_id=" + ANSI_RESET + seat_id +
                '}' + "\n";
    }
}
