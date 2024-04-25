package aop.aspectj.demo;

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
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-aspect-aop.xml");
        GreetingImpl greetingImpl = context.getBean("greetingImpl", GreetingImpl.class);
        greetingImpl.sayHello("AspectJ ");

        GreetingTagImpl greetingTagImpl = context.getBean("greetingTagImpl", GreetingTagImpl.class);
        greetingTagImpl.sayHello("AspectJ Annotation ");
        greetingTagImpl.goodMorning("AspectJ Annotation ");
    }
}
