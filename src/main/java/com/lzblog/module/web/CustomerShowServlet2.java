package com.lzblog.module.web;

import com.lzblog.module.Bean.Param;
import com.lzblog.module.Bean.View;
import com.lzblog.module.annotation.Action;
import com.lzblog.module.annotation.Controller;
import com.lzblog.module.annotation.Inject;
import com.lzblog.module.entity.Customer;
import com.lzblog.module.service.CustomerService;

import javax.servlet.http.HttpServlet;

/**
 * 展示客户
 * Created by lz on 2016/11/18.
 */
@Controller
public class CustomerShowServlet2 extends HttpServlet {

    @Inject
    private CustomerService customerService;

    @Action("get:/show")
    public View show(Param param) {
        Customer customer = customerService.getCustomer("123");
        return new View("customer.jsp").addModel("customer",customer);
    }
}
