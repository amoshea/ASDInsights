package com.nci.webapp.ASDInsights.Service;


import com.nci.webapp.ASDInsights.Model.UserDtls;


public interface UserService {

    public UserDtls createUser(UserDtls user);

    public boolean checkUsername(String username);
}
