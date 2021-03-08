package com.company.repositories.interfaces;

import com.company.entities.User;

import java.util.List;

public interface IUserRepository {
    boolean regUser(User user);
    boolean delUser(int ticket_id,int passenger_id);
}
