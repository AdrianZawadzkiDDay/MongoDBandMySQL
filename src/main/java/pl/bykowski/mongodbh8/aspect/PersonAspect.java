package pl.bykowski.mongodbh8.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PersonAspect {

    private static long startTime;

    @Before("@annotation(pl.bykowski.mongodbh8.aspect.PersonTimer)")
    private void startTimer() {
        startTime = System.currentTimeMillis();
        System.out.println("Start timer");
    }

    @After("@annotation(pl.bykowski.mongodbh8.aspect.PersonTimer)")
    private void stopTimer() {
        long time = System.currentTimeMillis() - startTime;
        System.out.println("Stop timer");
        System.out.println(" --- Time of operation: " + time + " ms --- ");
    }

}
