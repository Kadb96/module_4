package com.codegym.ungdungmuonsach.logger;

import com.codegym.ungdungmuonsach.model.BookCard;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {

    @AfterThrowing(pointcut = "execution(public * com.codegym.ungdungmuonsach.controller.BookController.borrow(..))", throwing = "e")
    public void logSaveBookCardException(JoinPoint joinPoint, Throwable e) {
        BookCard bookCard = (BookCard) joinPoint.getArgs()[0];
        System.out.println("Save Book Card Unsuccessful: " + bookCard.getBorrowerName()
                + " try to borrow " + bookCard.getBook().getTitle() + " with current quantity " + bookCard.getBook().getQuantity());
    }

    @AfterThrowing(pointcut = "execution(public * com.codegym.ungdungmuonsach.controller.BookCardController.returnBookCard(..))", throwing = "e")
    public void logReturnBookException(JoinPoint joinPoint, Throwable e) {
        Long id = (Long) joinPoint.getArgs()[0];
        System.out.println("Return Book Card Unsuccessful: Book Card with id " + id + " try to return book already returned");
    }

    @Before("execution(public * com.codegym.ungdungmuonsach.controller.BookController.*(..))")
        public void logBook(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        String target = joinPoint.getArgs().toString();

        System.out.println(className + " before method: " + methodName + " with target object " + target);
    }

    @Before("execution(public * com.codegym.ungdungmuonsach.controller.BookCardController.*(..))")
        public void logBookCard(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        String target = joinPoint.getArgs().toString();
        System.out.println(className + " before method: " + methodName + " with target object " + target);
    }
}
