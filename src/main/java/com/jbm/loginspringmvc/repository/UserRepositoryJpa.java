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
 * 
 * Did not manage to make it working in GlassFish container
 */
//@Repository("JpaRepository")
//@Transactional(propagation = Propagation.MANDATORY)
public class UserRepositoryJpa implements UserRepository{
    
    //@PersistenceContext
    //private EntityManager entityManager;

    @Override
    public User getUser(String username, String password) {
        String sql = "SELECT u FROM User u WHERE u.username LIKE :username AND u.password LIKE :password";
               
        //return (User) entityManager.createQuery(sql)
        //        .setParameter("username", username)
        //        .setParameter("password", password)
        //        .getSingleResult();
        
        return null;
    }
    
}
