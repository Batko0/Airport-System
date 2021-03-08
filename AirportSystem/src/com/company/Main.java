package com.company;

import com.company.controllers.BoardingPController;
import com.company.controllers.FlightsController;
import com.company.controllers.UserController;
import com.company.data.PostgresDB;
import com.company.data.interfaces.IDB;
import com.company.repositories.BoardingPRepository;
import com.company.repositories.FlightsRepository;
import com.company.repositories.UserRepository;
import com.company.repositories.interfaces.IBoardingPRepository;
import com.company.repositories.interfaces.IFlightsRepository;
import com.company.repositories.interfaces.IUserRepository;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        // Here you specify which DB and UserRepository to use
        IDB db = new PostgresDB();
        // Creating objects of Repositories and Controller
        IFlightsRepository repo = new FlightsRepository(db);
        FlightsController controller = new FlightsController(repo);

        IBoardingPRepository repo1 = new BoardingPRepository(db);
        BoardingPController controller1 = new BoardingPController(repo1);

        IUserRepository repo2 = new UserRepository(db);
        UserController controller2 = new UserController(repo2);

        // Starting application
        MyApplication app = new MyApplication(controller,controller1, controller2);
        app.start();
    }
}
