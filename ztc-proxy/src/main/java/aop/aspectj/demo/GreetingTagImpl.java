package aop.aspectj.demo;

import aop.aspectj.demo.annotion.Tag;
import aop.demo.Greeting;
import org.springframework.stereotype.Component;

/**
 * @ClassName GreetingImpl
 * @Description TODO
 * @Author ztc
 * @Date 2024/4/23 14:17
 */
@Component
public class GreetingTagImpl implements Greeting {
    @Override
    public void sayHello(String name) {

        System.out.println("Hello " + name);
//        throw new RuntimeException("Error");
    }

    @Tag
    public void goodMorning(String name){
        System.out.println("Good morning "+ name);
    }

    public void goodNight(String name){
        System.out.println("Good night "+ name);
    }

}
