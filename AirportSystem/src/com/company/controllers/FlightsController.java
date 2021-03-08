package com.company.controllers;

import com.company.entities.Flights;
import com.company.repositories.interfaces.IFlightsRepository;
import com.company.repositories.interfaces.IUserRepository;

import java.util.List;

public class FlightsController {
    private final IFlightsRepository repo;
    // obj of Repository. It needed to use its functions (queries)
    public FlightsController(IFlightsRepository repo) {
        this.repo = repo;
    }
    // method to get one needed flight by it's ID
    public String getFlight(int flight_id){
        // creating obj of Flights class, then calling method in repo
        Flights flight = repo.getFlight(flight_id);
        // returning results, if it is null it outputs first
        return (flight == null ? "Flight was not found!" : flight.toString());
    }
    // method to get Departure-Arrival from table flights
    public String getFlightsbyArrDep(String dep_arr){
        // List because there can be more than one flight
        List<Flights> flights = repo.getFlightsbyArrDep(dep_arr);

        return flights.toString();
    }
    // method to get all flights
    public String getAllFlights(){
        // List is used, because there are a lot flights.
        List<Flights> flights = repo.getAllFlights();

        return flights.toString();
    }
}
