package com.company.controllers;

import com.company.entities.User;
import com.company.repositories.interfaces.IUserRepository;

import java.util.List;

public class UserController {
    // some colors
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String	ANSI_RED = "\u001B[31m";
    // obj of Repository. It needed to use its functions (queries)
    private final IUserRepository repo;

    public UserController(IUserRepository repo) {
        this.repo = repo;
    }
    // method to book ticket and reg user
    public String regUser( int flight_id, int passenger_id, String name, String surname,
             long phone_number, int seat_id, int ticket_id, int age, String nation) {

        User user = new User(flight_id, passenger_id, name, surname, phone_number, seat_id, ticket_id, age, nation);

        boolean created = repo.regUser(user);

        return (created ? ANSI_GREEN + "You have successfully book ticket" + ANSI_RESET : ANSI_RED + "Booking was failed!" + ANSI_RESET);
    }
    // method to return ticket
    public String delUser(int ticket_id, int passenger_id) {
        boolean deleted = repo.delUser(ticket_id,passenger_id);

        return (deleted? ANSI_GREEN + "You have successfully returned ticket" + ANSI_RESET : ANSI_RED + "Operation was failed!" + ANSI_RESET);
    }

}
