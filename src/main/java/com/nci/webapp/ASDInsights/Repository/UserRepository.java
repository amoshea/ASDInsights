package com.nci.webapp.ASDInsights.Repository;


import com.nci.webapp.ASDInsights.Model.UserDtls;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <UserDtls, Integer> {
    public boolean existsByUsername(String email);
}
