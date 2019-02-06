/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.web.controller;

import com.cibt.web.dao.CustomerDAO;
import com.cibt.web.dao.impl.CustomerDAOImpl;
import com.cibt.web.entity.Customer;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USER
 */
@WebServlet(name = "home",urlPatterns = "/")
public class HomeController extends Controller {
    private CustomerDAO customerDAO=new CustomerDAOImpl();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("name","CIBT");
        try{
        customerDAO.insert(new Customer(0,"Rabin","Pokhareli", 
                "rabin@mylovelypokhara.com", true));
                request.setAttribute("customers",
                        customerDAO.getAll());
        }catch(Exception e){
            
        }
        view("index", request, response);
    }
    
}
