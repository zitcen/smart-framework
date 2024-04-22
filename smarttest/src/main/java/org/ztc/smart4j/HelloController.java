package org.ztc.smart4j;

import com.ztc.smart.farmework.annotation.Action;
import com.ztc.smart.farmework.annotation.Controller;
import com.ztc.smart.farmework.bean.View;

/**
 * @ClassName controller
 * @Description TODO
 * @Author ztc
 * @Date 2024/4/22 15:04
 */
@Controller
public class HelloController {

    @Action("get:/customer")
    public View hello(){
        System.out.println("hello");
        return new View("/index.jsp");
    }
}
