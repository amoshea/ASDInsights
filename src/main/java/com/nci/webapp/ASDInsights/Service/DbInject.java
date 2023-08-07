package com.nci.webapp.ASDInsights.Service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nci.webapp.ASDInsights.Model.UserDtls;
import com.nci.webapp.ASDInsights.Repository.UserRepository;

@Service
public class DbInject {

    @Autowired
    private UserRepository userRepository;

    public void instanceDB(){
        UserDtls newTeacher = new UserDtls(0, "Mary", "May", "Souza", "teacher_assistant", "teacher01@gmail.com", "333");
        UserDtls newDoctor = new UserDtls(0, "James", "Rodrigues", "Souza", "healthcare_professional", "doctor01@gmail.com", "333");
        userRepository.saveAll(Arrays.asList(newTeacher, newDoctor));
    }

    
}
