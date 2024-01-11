package org.example.aspectj;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class LoggingAspect {


    // 1 advice
//    @Before("execution(public String getName())")
//    public void loggingAdvice(){
//        System.out.println("Advice run. Get method called");
//    }
//
//    @Before("execution(public String org.example.service.Circle.getName())")
//    public void loggingAdviceCircle(){
//        System.out.println("Advice Circle run. Get method called");
//    }
//
//    @Before("execution(public * get*())")
//    public void loggingAdviceSecond(){
//        System.out.println("loggingAdviceSecond log...");
//    }

    // 2 pointcut
//    @Before("allGetter() && allCircleMethod()")
//    public void loggingAdvice(){
//        System.out.println("Advice run. Get method called");
//    }
//
//    @Before("allGetter()")
//    public void loggingAdviceSecond(){
//        System.out.println("Advice run 2");
//    }
//
//    @Pointcut("execution(public String getName())")
//    public void allGetter(){
//
//    }
//
//    @Pointcut("within(org.example.service.Circle))")
//    public void allCircleMethod(){
//
//    }

    // 3 advice with argument
//    @Before("allCircleMethod()")
//    public void loggingAdvice(JoinPoint joinPoint){
//        // execution(String org.example.service.Circle.getName())
//        System.out.println(joinPoint.toString());
//
//        // org.example.service.Circle@3b809711
//        System.out.println(joinPoint.getTarget());
//    }
//
//    @Before("allCircleMethod() && args(name))")
//    public void stringArgumentMethods(String name){
//        System.out.println("A method setter called [name]: " + name);
//    }
//
//    @Pointcut("within(org.example.service.Circle))")
//    public void allCircleMethod(){
//
//    }
//
//    @Pointcut("execution(public String getName())")
//    public void allGetter(){
//
//    }



//    // 4 handle exception
//    @Before("allCircleMethod()")
//    public void loggingAdvice(JoinPoint joinPoint){
//    }
//
////    @After("allCircleMethod() && args(name))")
////    public void stringArgumentMethods(String name){
////        System.out.println("A method setter called [name]: " + name);
////    }
//
//    @AfterReturning(pointcut =  "allCircleMethod() && args(name))", returning = "returnString")
//    public void stringArgumentMethods(String name, String returnString){
//        System.out.println("A method setter called [name]: " +  name);
//        System.out.println("The output value [returnString]: " +  returnString);
//    }
//
//    @AfterThrowing("allCircleMethod() && args(name))")
//    public void exceptionAdvice(String name){
//        System.out.println("An exception has been thrown [name]: " + name);
//    }
//
//    @Pointcut("within(org.example.service.Circle))")
//    public void allCircleMethod(){
//
//    }
//
//    @Pointcut("execution(public String getName())")
//    public void allGetter(){
//
//    }


    // 5 around
    @Before("allCircleMethod()")
    public void loggingAdvice(JoinPoint joinPoint){
    }

//    @After("allCircleMethod() && args(name))")
//    public void stringArgumentMethods(String name){
//        System.out.println("A method setter called [name]: " + name);
//    }

    @AfterReturning(pointcut =  "allCircleMethod() && args(name))", returning = "returnString")
    public void stringArgumentMethods(String name, String returnString){
        System.out.println("A method setter called [name]: " +  name);
        System.out.println("The output value [returnString]: " +  returnString);
    }

    @Around("@annotation(org.example.aspectj.Loggable)")
    public Object myAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
        Object returnValue = null;
        try{
            System.out.println("Before advice");
            returnValue = proceedingJoinPoint.proceed(); // proceed method in pointcut
            System.out.println("After advice");
        }catch (Throwable e){
            System.out.println("After throwing");
            e.printStackTrace();
        }
        System.out.println("After finally");
        return returnValue;
    }

    @AfterThrowing("allCircleMethod() && args(name))")
    public void exceptionAdvice(String name){
        System.out.println("An exception has been thrown [name]: " + name);
    }

    @Pointcut("within(org.example.service.Circle))")
    public void allCircleMethod(){

    }

    @Pointcut("execution(public String getName())")
    public void allGetter(){

    }
}
