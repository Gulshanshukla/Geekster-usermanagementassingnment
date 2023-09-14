package com.geekster.UserManagenetSystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration

public class BeanBag {
    @Bean
    public List<User> getDataSource()
    {
        return new ArrayList<>();
    }
}
