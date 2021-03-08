package com.company.repositories.interfaces;

import com.company.entities.Flights;

import java.util.List;

public interface IFlightsRepository {
    Flights getFlight(int flight_id);
    List<Flights> getAllFlights();

    List<Flights> getFlightsbyArrDep(String dep_arr);
}
