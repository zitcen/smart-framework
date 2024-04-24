package aop.demo;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @ClassName GreetingThrowAdvice
 * @Description TODO
 * @Author ztc
 * @Date 2024/4/24 11:35
 */
@Component
public class GreetingThrowAdvice implements ThrowsAdvice {
    public void afterThrowing(Method method, Object[] args, Object target, Exception e){
        System.out.println("------ Throw Exception -------");
        System.out.println("target class:" + target.getClass().getName());
        System.out.println("method name:" + method.getName());
        System.out.println("exception msg: "+ e.getMessage());
        System.out.println("-------------");

    }
}
