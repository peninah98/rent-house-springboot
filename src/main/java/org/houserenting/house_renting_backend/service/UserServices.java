package org.houserenting.house_renting_backend.service;

import org.houserenting.house_renting_backend.model.User;
import org.houserenting.house_renting_backend.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class UserServices {
    @Autowired
    UserRepo userRepo;

    public void createUser(User user) {
        user.setCreatedAt(Date.valueOf(LocalDate.now()));
         userRepo.save(user);
    }

    public void updateUser(User user) {
         userRepo.save(user);
    }

    public User getUserById(String userId) {
        return userRepo.findById(userId).orElse(null);
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
}
