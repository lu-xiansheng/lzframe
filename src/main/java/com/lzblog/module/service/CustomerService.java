package com.lzblog.module.service;

import com.lzblog.module.annotation.Service;
import com.lzblog.module.entity.Customer;
import com.lzblog.module.help.DataBaseHelper;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * 客户服务层
 * Created by lz on 2016/11/11.
 */
@Service
public class CustomerService {

private final Logger logger = Logger.getLogger(CustomerService.class);

    /**
     * 获取所有客户列表
     * @return 所有客户
     */
    public List<Customer> getAllCustomer() {
        //TODO
        return null;
    }

    /**
     * 通过id获取客户
     * @param id
     * @return
     */
    public Customer getCustomer(String id) {
        String sql = "SELECT * FROM customer WHERE id = "+id;
        return DataBaseHelper.queryEntity(Customer.class,sql);

    }
}
