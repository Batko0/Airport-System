package com.company.entities;

public class User {
    // needed fields
    private int flight_id;
    private int passenger_id;
    private String name;
    private String surname;
    private long phone_number;
    private int seat_id;
    private int ticket_id;
    private int age;
    private String nation;
    // constructors to save data that is from DB
    public User() { }

    public User(int passenger_id, String name, String surname, long phone_number, int seat_id, int ticket_id, int age, String nation) {
        setPassenger_id(passenger_id);
        setName(name);
        setSurname(surname);
        setPhone_number(phone_number);
        setSeat_id(seat_id);
        setTicket_id(ticket_id);
        setAge(age);
        setNation(nation);
    }

    public User(int flight_id, int passenger_id, String name, String surname, long phone_number, int seat_id, int ticket_id, int age, String nation) {
        setFlight_id(flight_id);
        setPassenger_id(passenger_id);
        setName(name);
        setSurname(surname);
        setPhone_number(phone_number);
        setSeat_id(seat_id);
        setTicket_id(ticket_id);
        setAge(age);
        setNation(nation);
    }
    //Getters
    public int getFlight_id() {
        return flight_id;
    }

    public int getPassenger_id() {
        return passenger_id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public long getPhone_number() {
        return phone_number;
    }

    public int getSeat_id() {
        return seat_id;
    }

    public int getTicket_id() {
        return ticket_id;
    }

    public int getAge() {
        return age;
    }

    public String getNation() {
        return nation;
    }

    //Setters

    public void setFlight_id(int flight_id) {
        this.flight_id = flight_id;
    }

    public void setPassenger_id(int passenger_id) {
        this.passenger_id = passenger_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPhone_number(long phone_number) {
        this.phone_number = phone_number;
    }

    public void setSeat_id(int seat_id) {
        this.seat_id = seat_id;
    }

    public void setTicket_id(int ticket_id) {
        this.ticket_id = ticket_id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    @Override
    public String toString() {
        return "User{" +
                "flight_id=" + flight_id +
                ", passenger_id=" + passenger_id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone_number=" + phone_number +
                ", seat_id=" + seat_id +
                ", ticket_id=" + ticket_id +
                ", age=" + age +
                ", nation='" + nation + '\'' +
                '}' + "\n";
    }
}

