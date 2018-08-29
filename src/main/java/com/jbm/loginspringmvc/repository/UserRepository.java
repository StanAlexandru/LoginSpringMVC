/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jbm.loginspringmvc.repository;

import com.jbm.loginspringmvc.entity.User;

/**
 *
 * @author astan
 */
public interface UserRepository {
    public User getUser(String username, String password);
}
