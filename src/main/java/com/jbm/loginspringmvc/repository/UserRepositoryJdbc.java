/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jbm.loginspringmvc.repository;

import com.jbm.loginspringmvc.entity.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


/**
 *
 * @author astan
 */
@Repository("JdbcTemplateRepository")
public class UserRepositoryJdbc implements UserRepository{
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User getUser(String username, String password){
        String sql = "SELECT username, password FROM dbo.users WHERE username = ? AND password = ?";
        
        List<User> users = jdbcTemplate.query(sql, new Object[]{username, password}, new RowMapper<User>(){
            @Override
            public User mapRow(ResultSet rs, int i) throws SQLException {
                User user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                return user;
            }
        });
        
        if(users.isEmpty()) return null;
        return users.get(0);
    }
    
}
