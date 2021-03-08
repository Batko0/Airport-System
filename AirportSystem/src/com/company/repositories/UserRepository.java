package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.User;
import com.company.repositories.interfaces.IUserRepository;

import javax.swing.text.html.HTMLDocument;
import java.sql.*;

public class UserRepository implements IUserRepository {
    // creating obj of IDB in order to get connection
    private final IDB db;

    public UserRepository(IDB db) {
        this.db = db;
    }
    // method to book ticket and register user. Everything below works similarly as before
    @Override
    public boolean regUser(User user) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO ticket(ticket_id,flight_id,type) VALUES (?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, user.getTicket_id());
            st.setInt(2, user.getFlight_id());
            String type="Adult";
            st.setString(3, type);


            String sql2 = "INSERT INTO passenger(passenger_id,name,surname,age,nationality,phone_number,ticket_id,seat_id) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement st2 = con.prepareStatement(sql2);

            st2.setInt(1,user.getPassenger_id());
            st2.setString(2, user.getName());
            st2.setString(3,user.getSurname());
            st2.setInt(4,user.getAge());
            st2.setString(5,user.getNation());
            st2.setLong(6,user.getPhone_number());
            st2.setInt(7,user.getTicket_id());
            st2.setInt(8,user.getSeat_id());

            st.execute();
            st2.execute();
            return true;
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
        return false;
    }
    // method to return ticket. Everything below works similarly as before
    @Override
    public boolean delUser(int ticket_id, int passenger_id) {
        Connection con = null;

        try {
            con = db.getConnection();

            String sql2 = "delete from passenger where passenger_id = ?";

            PreparedStatement st2 = con.prepareStatement(sql2);

            st2.setInt(1,passenger_id);

            st2.execute();

            String sql = "delete from ticket where ticket_id = ?";

            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1,ticket_id);

            st.execute();
            return true;
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
        return false;
    }
    }

