package com.nci.webapp.ASDInsights.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nci.webapp.ASDInsights.Service.DbInject;

@Configuration
public class DbInjectConfig {

    @Autowired
    private DbInject dbInject;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String value;

     @Bean
    public boolean instanciaDB(){
        if(value.equals("update")){
            this.dbInject.instanceDB();
        }
        return false;   
    }
    
}
