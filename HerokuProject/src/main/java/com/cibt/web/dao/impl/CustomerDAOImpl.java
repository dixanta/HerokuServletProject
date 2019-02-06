/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.web.dao.impl;

import com.cibt.jdbc.core.JdbcTemplate;
import com.cibt.jdbc.core.RowMapper;
import com.cibt.web.dao.CustomerDAO;
import com.cibt.web.entity.Customer;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author USER
 */
public class CustomerDAOImpl implements CustomerDAO {

    private JdbcTemplate<Customer> template=
            new JdbcTemplate<>();
    @Override
    public int insert(Customer model) throws Exception {
        String sql="insert into customers(first_name,last_name,"
                + "email,status) values(?,?,?,?)";
        return template.update(sql,new Object[]{
            model.getFirstName(),model.getLastName(),
            model.getEmail(),model.isStatus()
        });
    }

    @Override
    public List<Customer> getAll() throws Exception {
        String sql="select * from customers";
        return template.query(sql,
                new RowMapper<Customer>() {

            @Override
            public Customer mapRow(ResultSet rs) throws Exception {
                Customer customer=new Customer();
                customer.setId(rs.getInt("id"));
                customer.setFirstName(rs.getString("first_name"));
                customer.setLastName(rs.getString("last_name"));
                customer.setEmail(rs.getString("email"));
                customer.setAddedDate(rs.getDate("added_date"));
                customer.setStatus(rs.getBoolean("status"));
                return customer;
            }
        });
    }
    
}
