package book_loan_app.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
public class LogAspect {
    int count = 0;

    @Pointcut("within(book_loan_app.controller.BookController*) ")
    public void allMethodPointCut() {
    }
    @Pointcut("execution(* book_loan_app.controller.BookController.showList(..))")
    public void callShowMethod(){

    }
    @Before("allMethodPointCut()")
    public void beforeCallMethod(JoinPoint joinPoint) {
        System.err.println("Start method name: " + joinPoint.getSignature().getName() + "Time:" + LocalDateTime.now());
    }

    @AfterReturning("allMethodPointCut()")
    public void afterCallMethod(JoinPoint joinPoint) {
        System.err.println("End method name: " + joinPoint.getSignature().getName() + "Time: " + LocalDateTime.now());
    }

    @AfterReturning("callShowMethod()")
    public void afterCallShowMethod(JoinPoint joinPoint){
        count++;
        System.err.println("số lần ghé thăm thư viện: "+count);
    }

}
