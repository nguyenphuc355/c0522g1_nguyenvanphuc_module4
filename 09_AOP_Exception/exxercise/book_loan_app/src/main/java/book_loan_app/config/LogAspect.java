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
    private int counts = 0;

    @Pointcut("within(book_loan_app.controller.BookController*) ")
    public void allMethodPointCut() {
    }

    @AfterReturning("allMethodPointCut()")
    public void afterCallMethod(JoinPoint joinPoint) {
        counts++;
        System.err.println("số lần ghé thăm thư viện: " + counts);
        System.err.println("End method name: " + joinPoint.getSignature().getName() + "Time: " + LocalDateTime.now());
    }

    @Pointcut("execution(* book_loan_app.controller.BookController.save*(..))")
    public void borrowAndPayMethod(){}
    

    @AfterReturning("borrowAndPayMethod()")
    public void borrowAndPayMethod(JoinPoint joinPoint) {
        System.err.println("End method name: " + joinPoint.getSignature().getName() + "Time:" + LocalDateTime.now());
    }





}
