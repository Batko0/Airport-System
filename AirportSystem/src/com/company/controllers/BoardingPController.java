package com.company.controllers;

import com.company.entities.BoardingPass;
import com.company.repositories.interfaces.IBoardingPRepository;
import com.company.repositories.interfaces.IFlightsRepository;

public class BoardingPController {
    // some colors
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String	ANSI_RED	= "\u001B[31m";
    // obj of Repository. It needed to use its functions (queries)
    private final IBoardingPRepository repo;

    public BoardingPController(IBoardingPRepository repo) {
        this.repo = repo;
    }

    public String getBoardingPass(int passenger_id){
        // calling method on repository and saving it into boardingPass
        BoardingPass boardingPass = repo.getBoardingPass(passenger_id);
        // returning results, if it is null it outputs first
        return (boardingPass == null ? ANSI_RED +"Boarding Pass was not found!" + ANSI_RESET : boardingPass.toString());
    }

}
