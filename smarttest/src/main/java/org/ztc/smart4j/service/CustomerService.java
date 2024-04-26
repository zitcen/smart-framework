package org.ztc.smart4j.service;

import com.ztc.smart.farmework.annotation.Service;
import com.ztc.smart.farmework.annotation.Transaction;
import com.ztc.smart.farmework.helper.DatabaseHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.ztc.smart4j.pojo.Customer;

import java.util.List;
import java.util.Map;

/**
 * @ClassName CustomerService
 * @Description TODO
 * @Author ztc
 * @Date 2024/4/26 9:44
 */
@Service
public class CustomerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);


    /***
     * @Author ztc
     * @Description 獲取客戶數據列表
     * @Date 2024/4/15
     * @return java.util.List<com.ztc.demo.chapter1.model.Customer>
     *
     **/
    public List<Customer> getCustomerList() {

        String sql = "select * from customer;";

        List<Customer> customers = DatabaseHelper.queryEntityList( Customer.class, sql);
        return customers;
    }

    /***
     * @Author ztc
     * @Description 根據id 獲取具體客戶數據列表
     * @Date 2024/4/15
     * @param id
     * @return com.ztc.demo.chapter1.model.Customer
     *
     **/
    public Customer getCustomer(Long id) {
        String sql = "select * from customer where id = ?;";
        Customer customer = DatabaseHelper.queryEntity(Customer.class, sql, id);
        return customer;
    }

    /***
     * @Author ztc
     * @Description 創建客戶數據
     * @Date 2024/4/15
     * @param fieldMap
     * @return boolean
     *
     **/
    @Transaction
    public boolean createCustomer(Map<String, Object> fieldMap) {
        boolean b = DatabaseHelper.insertEntity(Customer.class, fieldMap);
        return b;
    }

    /***
     * @Author ztc
     * @Description 更新客戶數據
     * @Date 2024/4/15
     * @param fieldMap
     * @param id
     * @return boolean
     *
     **/
    @Transaction
    public boolean editCustomer(long id, Map<String, Object> fieldMap) {
        return DatabaseHelper.updateEntity(Customer.class,id,fieldMap);
    }

    /***
     * @Author ztc
     * @Description 刪除客戶數據
     * @Date 2024/4/15
     * @param id
     * @return boolean
     *
     **/
    @Transaction
    public boolean deleteCustomer(long id) {

        return DatabaseHelper.delEntity(id,Customer.class);
    }
}
