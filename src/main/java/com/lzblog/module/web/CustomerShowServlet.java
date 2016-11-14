package com.lzblog.module.web;

import com.lzblog.module.entity.Customer;
import com.lzblog.module.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 展示客户
 * Created by lz on 2016/11/11.
 */
@WebServlet("/show")
public class CustomerShowServlet extends HttpServlet {

    private CustomerService customerService;

    @Override
    public void init() throws ServletException {
        customerService = new CustomerService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Customer customer = customerService.getCustomer("123");
        req.setAttribute("customer",customer);
        req.getRequestDispatcher("/WEB-INF/jsp/customer.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //TODO
    }
}
