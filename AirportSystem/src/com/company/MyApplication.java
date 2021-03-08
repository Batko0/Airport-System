package com.company;

import com.company.controllers.BoardingPController;
import com.company.controllers.FlightsController;
import com.company.controllers.UserController;
import com.company.entities.Flights;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MyApplication {
    // These are initial ticket and seat values
    private static int ticket_id = 11;
    private static int seat_id = 251;
    // Colors
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String	ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String	ANSI_ITALIC	= "\u001B[3m";
    // Creating objects for controllers
    private final FlightsController controller;
    private final BoardingPController controller1;
    private final UserController controller2;

    private final Scanner scanner;
    // Constructor to get controllers
    public MyApplication(FlightsController controller, BoardingPController controller1,UserController controller2) {
        this.controller = controller;
        this.controller1 = controller1;
        this.controller2 = controller2;
        scanner = new Scanner(System.in);
    }
    // Here application starts
    public void start() {
        // Main menu of app
        while (true) {
            System.out.println();
            System.out.println("Welcome to Airport System Application");
            System.out.println("Select option:");
            System.out.println("1. Get all flights");
            System.out.println("2. Get flight by Flight ID");
            System.out.println("3. Get your Boarding Pass by Passenger ID");
            System.out.println("4. Book ticket");
            System.out.println("5. Return ticket");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-5): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getAllFlights();
                } else if (option == 2) {
                    getFlight();
                }else if ( option == 3){
                  getBoardingPass();
                }else if( option == 4){
                  regUser();
                }else if ( option == 5){
                    delUser();
                }else if (option > 5 || option < 1){
                    System.exit(0);
                }
            } catch (InputMismatchException e) {
                System.out.println(ANSI_RED + "Input must be integer" + ANSI_RESET);
                scanner.nextLine(); // to ignore incorrect input
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println(ANSI_GREEN + "*************************" + ANSI_RESET);
        }
    }
    // Method to get one Flight
    public void getFlight(){
        System.out.println(ANSI_ITALIC + "Please enter flight_id" + ANSI_RESET);

        int flight_no = scanner.nextInt();
        String response = controller.getFlight(flight_no);
        System.out.println(response);
    }

    // Method to get all Flights
    public void  getAllFlights(){
        String response = controller.getAllFlights();
        System.out.println(response);
    }
    // Method to get Boarding pass by Passenger ID
    public void getBoardingPass(){
        System.out.println(ANSI_ITALIC + "Please enter your Passenger ID" + ANSI_RESET);

        int passenger_id = scanner.nextInt();
        String response = controller1.getBoardingPass(passenger_id);
        System.out.println(response);
    }
    // Method to get automatically Boarding Pass
    public void getBoardingPass2(int passenger_id){
        String response = controller1.getBoardingPass(passenger_id);
        System.out.println(response);
    }
    // Method to get Departure - Arrival. User input from where to where he/she wants to fly.
    public void getFlightsbyArrDep(){
        System.out.println(ANSI_ITALIC + "Please enter where are you and where you want to fly." + ANSI_RESET);
        System.out.println(ANSI_ITALIC + "Example: Lisbon-Moscow" + ANSI_RESET);
        scanner.nextLine();
        String dep_arr = scanner.nextLine();//**
        String response = controller.getFlightsbyArrDep(dep_arr);

        if (response.equals("[]")) {
            System.out.println(ANSI_RED + "This flight does not exist !" + ANSI_RESET);
            start();
        }else{
            System.out.println(response);
        }
    }

    //int a;
    // Array List to save all passenger ID
    ArrayList<Integer> passg_id = new ArrayList<>();
    // Method to regUser. Booking ticket
    public void regUser() {
        // Calling method. We call this function so that the user can see the flights.
        getFlightsbyArrDep();
        // While is needed for validators. In this code we have validator: Is input integer ? Is input YES or NO
        // If user input invalid type, process repeats, because there while(true)
        while (true) {
            System.out.println("DO you want to buy ticket ? YES/NO");
            String ans = scanner.next();
            ans = ans.toUpperCase();
            if(ans.equals("YES")) {
                while (true) {
                    System.out.println("Please enter your flight id (You have only one attempt !):");
                    int flight_id;
                    if (scanner.hasNextInt()) { //Checks if next input is Integers
                        flight_id = scanner.nextInt();
                        while (true) {
                            // Random ID generator. ID is Талон
                            int x = (int) (Math.random() * ((999999 - 100000) + 1)) + 100000;
                            System.out.println("It is your id: " + x);
                            System.out.println("Please enter your id:");
                            int passenger_id;
                            if (scanner.hasNextInt()) {
                                passenger_id = scanner.nextInt();
                                scanner.nextLine();
                                while (true) {
                                    System.out.println("Please enter your name:");
                                    String name = scanner.nextLine();
                                    if (true){
                                        while (true){
                                            System.out.println("Please enter your surname:");
                                            String surname = scanner.nextLine();
                                            if (true){
                                                while (true){
                                                    System.out.println("Please enter your phone number:");
                                                    long phone_number;
                                                    if (scanner.hasNextLong()) {
                                                        phone_number = scanner.nextLong();
                                                        scanner.nextLine();
                                                        while (true) {
                                                            System.out.println("PLease enter your age:");
                                                            int age;
                                                            if (scanner.hasNextInt()) {
                                                                age = scanner.nextInt();
                                                                if (age < 18){
                                                                    System.out.println(ANSI_RED + "You are under 18. You are not allowed to buy a ticket !!!" + ANSI_RESET);
                                                                    start();
                                                                }

                                                                scanner.nextLine();
                                                                System.out.println("Please enter your nationality:");
                                                                String nation = scanner.next();
                                                                scanner.nextLine();

                                                                int chitalka = 1;
                                                                for (Integer PID: passg_id) {
                                                                    if (PID == passenger_id) {//когда пользователь вводит существующиеся айди, айди билета не меняется тем самым
                                                                        //данные не сохранятся в таблицу ticket так как тикет айди primary key
                                                                        ticket_id = ticket_id;
                                                                        chitalka = 2;
                                                                    }
                                                                    if (chitalka == 2)
                                                                        break;
                                                                }

                                                                if (chitalka != 2){
                                                                    ++ticket_id;
                                                                    ++seat_id;
                                                                }

                                                                String response = controller2.regUser(flight_id, passenger_id, name, surname, phone_number, seat_id, ticket_id, age, nation);
                                                                System.out.println(response);
                                                                // If booking made successfully it immediately outputs boarding pass
                                                                if (response != ANSI_RED + "Booking was failed!" + ANSI_RESET) {
                                                                    getBoardingPass2(passenger_id);
                                                                }
                                                                // Here Array List is filling
                                                                passg_id.add(passenger_id);
                                                                // Going back to main menu
                                                                start();
                                                            } else {
                                                                System.out.println("Please input an integer !");
                                                                scanner.next(); // This scanner is needed to
                                                            }
                                                        }
                                                    } else {
                                                        System.out.println("Please input an integer !");
                                                        scanner.next();
                                                        //a++;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            } else {
                                System.out.println("Please input an integer !");
                                scanner.next();
                            }
                        }
                    } else {
                        System.out.println("Please input an integer !");
                        scanner.next();
                    }
                }
            }
            else if (ans.equals("NO")) {
                    // Going back to main menu
                    start();
            } else {
                System.out.println("Please input YES | NO !");
                scanner.nextLine();
            }
        }
    }
    // Method to cancel booking. In this there are also some validators
    public void delUser() {
        while (true) {
            System.out.println(ANSI_ITALIC + "Please enter your Ticket ID" + ANSI_RESET);
            int ticket_id;
            if (scanner.hasNextInt()) {
                ticket_id = scanner.nextInt();
                while (true) {
                    System.out.println(ANSI_ITALIC + "Please enter your Passenger ID" + ANSI_RESET);
                    int passenger_id;
                    if (scanner.hasNextInt()) {
                        passenger_id = scanner.nextInt();
                        String response = controller2.delUser(ticket_id, passenger_id);
                        System.out.println(response);
                        start(); // When this method ends it goes to main menu
                    } else {
                        System.out.println("Please input an integer !");
                        scanner.next();
                    }
                }
            } else{
                    System.out.println("Please input an integer !");
                    scanner.next();
            }
        }
    }
}
