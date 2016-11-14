package com.lzblog.module.service;

import com.lzblog.module.entity.Customer;
import org.apache.log4j.Logger;
import org.junit.Test;

/**
 *customerService单元测试类
 * Created by lz on 2016/11/11.
 */
public class CustomerServiceTest {
    private final Logger logger = Logger.getLogger(this.getClass());
    private CustomerService customerService;

    @Test
    public void testGetAllCustomer() throws Exception {

    }

    @Test
    public void testGetCustomer() throws Exception {
        customerService = new CustomerService();
        Customer customer = customerService.getCustomer("123");
        /*System.out.print(customer.getName());*/
        logger.error(customer.getEmail());
    }

}