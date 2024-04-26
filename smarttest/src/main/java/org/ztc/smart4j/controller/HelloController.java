package org.ztc.smart4j.controller;

import com.ztc.smart.farmework.annotation.Action;
import com.ztc.smart.farmework.annotation.Controller;
import com.ztc.smart.farmework.annotation.Inject;
import com.ztc.smart.farmework.bean.View;
import org.ztc.smart4j.pojo.Customer;
import org.ztc.smart4j.service.CustomerService;

import java.util.List;

/**
 * @ClassName controller
 * @Description TODO
 * @Author ztc
 * @Date 2024/4/22 15:04
 */
@Controller
public class HelloController {

    @Inject
    private CustomerService customerService;

    @Action("get:/customer")
    public View hello(){
        System.out.println("hello");
        List<Customer> customerList = customerService.getCustomerList();
        return new View("customer.jsp").addModel("customerList",customerList);
    }
}
