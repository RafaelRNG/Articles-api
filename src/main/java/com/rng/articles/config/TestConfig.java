package com.rng.articles.config;

import com.rng.articles.services.database.StartedDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private StartedDatabase startedDatabase;

    @Bean
    public boolean InsetData(){

        startedDatabase.insertDados();
        return true;
    }
}