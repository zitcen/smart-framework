package aop.demo;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;
import org.springframework.stereotype.Component;

/**
 * @ClassName GreetingIntroAdvice
 * @Description TODO
 * @Author ztc
 * @Date 2024/4/24 14:07
 */
@Component
public class GreetingIntroAdvice extends DelegatingIntroductionInterceptor implements Apology {

    @Override
    public void saySorry(String name) {
        System.out.println("Sorry " + name);
    }

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        return super.invoke(mi);
    }
}
