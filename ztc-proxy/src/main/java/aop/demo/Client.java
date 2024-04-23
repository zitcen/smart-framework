package aop.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @ClassName Client
 * @Description TODO
 * @Author ztc
 * @Date 2024/4/24 7:44
 */
public class Client {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-aop.xml");
        Greeting greetingProxy = context.getBean("greetingProxy", Greeting.class);
        greetingProxy.sayHello("Spring AOP ");
    }
}
