/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.jdbc.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class JdbcTemplate<T> {
    
    private Connection conn;
    
    public void connect()throws Exception{
        Class.forName("org.postgresql.Driver");
        String url="jdbc:postgresql://ec2-50-17-193-83.compute-1.amazonaws.com/d9p2fl6so6ib7c?sslmode=require";
        String user="aziujgyydcnzay";
        String password="e990c9f767a382a90e7ab1b1c2ce1c99391e63b714e251f1b87ebd6f9aa6d084";
        conn=DriverManager
                .getConnection(url,user,password);
    }
    
    public List<T> query(String sql,RowMapper<T> mapper)throws Exception
    {
        List<T> rows=new ArrayList<>();
        connect();
        PreparedStatement stmt=
                conn.prepareStatement(sql);
        ResultSet rs=stmt.executeQuery();
        while(rs.next()){
            rows.add(mapper.mapRow(rs));
        }
        conn.close();
        return rows;
    }
    
    public int update(String sql,Object... params)throws Exception{
        connect();
        PreparedStatement stmt=conn.prepareStatement(sql);
        int i=1;
        for(Object param:params){
            stmt.setObject(i, param);
            i++;
        }
        int result=stmt.executeUpdate();
        conn.close();
        return result;
        
    }
    
}
