package com.nci.webapp.ASDInsights.Service;


import com.nci.webapp.ASDInsights.Model.UserDtls;
import com.nci.webapp.ASDInsights.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;
    @Override
    public UserDtls createUser(UserDtls user) {
        return userRepo.save(user);
    }

    @Override
    public boolean checkUsername(String username) {
        return userRepo.existsByUsername(username);
    }
}
