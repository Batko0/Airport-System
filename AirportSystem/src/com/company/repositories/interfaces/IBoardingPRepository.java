package com.company.repositories.interfaces;

import com.company.entities.BoardingPass;

public interface IBoardingPRepository {
    BoardingPass getBoardingPass(int passenger_id);
}
