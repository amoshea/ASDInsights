package com.nci.webapp.ASDInsights.Repository;


import com.nci.webapp.ASDInsights.Model.UserDtls;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository <UserDtls, Integer> {

    public boolean existsByUsername(String email);

    @Query("SELECT b FROM UserDtls b WHERE b.email = :email AND b.password = :password")
    public UserDtls buscarLogin(@Param("email") String email, @Param("password") String password);
}
