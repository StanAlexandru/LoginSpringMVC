/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jbm.loginspringmvc.service;

import com.jbm.loginspringmvc.entity.User;
import com.jbm.loginspringmvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author astan
 */
@Service
public class LoginService {
    
    @Autowired
    @Qualifier("JdbcTemplateRepository")
    //@Qualifier("JpaRepository")
    UserRepository userRepository;
    public User login(User user){
        
        return userRepository.getUser(user.getUsername(), user.getPassword());

    }
    
}
