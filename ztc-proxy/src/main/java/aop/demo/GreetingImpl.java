package aop.demo;

import org.springframework.stereotype.Component;

/**
 * @ClassName GreetingImpl
 * @Description TODO
 * @Author ztc
 * @Date 2024/4/23 14:17
 */
@Component
public class GreetingImpl implements Greeting {
    @Override
    public void sayHello(String name) {
        System.out.println("Hello " + name);
    }

}
