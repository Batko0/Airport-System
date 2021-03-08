package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.BoardingPass;
import com.company.entities.Flights;
import com.company.repositories.interfaces.IBoardingPRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardingPRepository implements IBoardingPRepository {
    // creating obj of IDB in order to get connection
    private final IDB db;

    public BoardingPRepository(IDB db) {
        this.db = db;
    }
    // method to get boarding pass of passenger by his/her ID
    @Override
    public BoardingPass getBoardingPass(int passenger_id) {
        Connection con = null; // con is null, in order to empty it from previous con
        try {
            con = db.getConnection(); // get connection with DB
            // SQL query
            String sql = "SELECT flights.flight_id,\n" +
                    "departure.departure_from,departure.date,departure.departure_time,\n" +
                    "arrival.arrival_to,arrival.date,arrival.arrival_time,\n" +
                    "passenger.name,passenger.surname,passenger.ticket_id,passenger.seat_id\n" +
                    "from Flights,Departure,Arrival,Ticket,Passenger\n" +
                    "where flights.flight_id = ticket.flight_id and flights.flight_id = departure.flight_id and flights.flight_id = arrival.flight_id\n" +
                    "and ticket.ticket_id = passenger.ticket_id and passenger.passenger_id = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, passenger_id); // setting passenger id in symbol ?

            ResultSet rs = st.executeQuery(); // execution of query
            if (rs.next()) {
                BoardingPass boardingPass = new BoardingPass(rs.getInt("flight_id"),
                        rs.getString("departure_from"),rs.getDate("Date"),
                        rs.getTime("departure_time"),rs.getString("arrival_to"),
                        rs.getDate("Date"),rs.getTime("arrival_time"),
                        rs.getString("name"),rs.getString("surname"),
                        rs.getInt("ticket_id"),rs.getInt("seat_id"));

                return boardingPass; // returning result into controller obj
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
}
