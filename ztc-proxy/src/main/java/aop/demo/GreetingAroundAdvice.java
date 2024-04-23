package aop.demo;




import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @ClassName GreetingAroundAdvice
 * @Description TODO
 * @Author ztc
 * @Date 2024/4/24 7:38
 */
@Component
public class GreetingAroundAdvice implements MethodInterceptor {

    private void before(){
        System.out.println("Before");
    }

    private void after(){
        System.out.println("After");
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        before();
        Object result = invocation.proceed();
        after();
        return result;
    }
}
