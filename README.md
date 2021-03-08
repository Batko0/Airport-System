# Airport-System
This is an application where you can view the flights of any airline that is connected to its database.
Also, this application provides the ability to book a ticket to anywhere in the world or otherwise return the ticket, etc.

--------------------------------------------------------------------------------------------------------------------------
Airport System (R)  Version 1.0  01/03/2021

GENERAL USAGE NOTES
-------------------

- This application allows to view all airport flights.That are saved in Database (PostgreSQL).
  - Used classes: FlightsRepository, FlightsController, Flights

- User can get needed flight by flight ID. Moreover user can get his or her boarding pass by ID in
  case he or she has lost his or her ticket.(All data are from Database, from some different tables)
  - Used classes: FlightsRepository, FlightsController, Flights. BoardingPRepository, BoardingPController, BoardingPass

- The app provides a ticket booking function. First, the app asks which flight the user is looking for.
  Then if the user's answer is YES the application continues to ask for the necessary information about the user
  in order to book a ticket. If user's answer is NO the application goes to main menu. (Data from user, are saved to Database).
  - Used classes: UserRepository, UserController, User

- Also, the application on the contrary provides cancellation of the booking. (Saved data in Database also deleted).
  - Used classes: UserRepository, UserController, User

- Class PostgresDB is used to connect to DATABASE.

- Class MyApplication. In this class interface of the application is written. Class calls other needed function.

- Class Main. Creates objects of DB connection, Repositories, Controllers and then starts application.
-------------------------------------------------------------------------------------------------------------------------------


AUTHORS: NIGMETOV.A , KUANDYKOV.A 
=================================
GROUP: SE-2012
=================================

Copyright (C) 2021 Nigmetov, Kuandykov, Inc. All rights reserved.
=================================================================
