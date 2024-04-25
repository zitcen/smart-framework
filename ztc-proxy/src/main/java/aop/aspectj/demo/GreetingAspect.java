package aop.aspectj.demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @ClassName GreetingAspect
 * @Description TODO
 * @Author ztc
 * @Date 2024/4/24 15:39
 */
@Component
@Aspect
public class GreetingAspect {
    @Around("execution(* aop.aspectj.demo.GreetingImpl.*(..))")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        before();
        Object result = point.proceed();
        after();
        return result;
    }

    @Around("@annotation(aop.aspectj.demo.annotion.Tag)")
    public Object aroundTag(ProceedingJoinPoint point) throws Throwable {
        before();
        Object result = point.proceed();
        after();
        return result;
    }

    private void before(){
        System.out.println("Before");
    }

    private void after(){
        System.out.println("After");
    }
}
