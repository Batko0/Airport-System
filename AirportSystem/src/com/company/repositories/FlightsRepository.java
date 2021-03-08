package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Flights;
import com.company.entities.User;
import com.company.repositories.interfaces.IFlightsRepository;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class FlightsRepository implements IFlightsRepository {
    // creating obj of IDB in order to get connection
    private final IDB db;

    public FlightsRepository(IDB db) {
        this.db = db;
    }
    // method to get one needed flight by it's ID
    @Override
    public Flights getFlight(int flight_id) {
        Connection con = null; // con is null, in order to empty it from previous con
        try {
            con = db.getConnection(); // get connection with DB
            // SQL query
            String sql = "SELECT * FROM flights WHERE flight_id = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, flight_id); // setting flight id in symbol ?

            ResultSet rs = st.executeQuery(); // execution of query
            if (rs.next()) {
                Flights flight = new Flights(rs.getInt("flight_id"),
                        rs.getString("aircraft_id"),
                        rs.getInt("cap_id"),
                        rs.getString("departure_arrival"),
                        rs.getString("flight_time"),
                        rs.getBoolean("availability"));
                return flight; // returning result into controller obj
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    // method to get all flights. Everything below works similarly as before
    @Override
    public List<Flights> getAllFlights() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM flights";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Flights> flights = new LinkedList<>();
            while (rs.next()) {
                Flights flight = new Flights(rs.getInt("flight_id"),
                        rs.getString("aircraft_id"),
                        rs.getInt("cap_id"),
                        rs.getString("departure_arrival"),
                        rs.getString("flight_time"),
                        rs.getBoolean("availability"));


                flights.add(flight);
            }
            return flights;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
    // method to get Departure-Arrival from table flights. Everything below works similarly as before
    @Override
    public List<Flights> getFlightsbyArrDep(String dep_arr) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM flights where departure_arrival = '" + dep_arr + "'";
            Statement st = con.createStatement();
            PreparedStatement stt = con.prepareStatement(sql);

            ResultSet rs = st.executeQuery(sql);
            List<Flights> flights = new LinkedList<>();
            while (rs.next()) {
                Flights flight = new Flights(rs.getInt("flight_id"),
                        rs.getString("aircraft_id"),
                        rs.getInt("cap_id"),
                        rs.getString("departure_arrival"),
                        rs.getString("flight_time"),
                        rs.getBoolean("availability"));


                flights.add(flight);
            }
            return flights;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
}
