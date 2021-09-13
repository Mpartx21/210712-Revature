package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        System.out.println( "Hello World!" );
        ApplicationContext appcontext =  new ClassPathXmlApplicationContext("config.xml");

//        appcontext.registerShutdownHook();
        Employee student = (Employee) appcontext.getBean("employee12");

        Student student2 = (Student) appcontext.getBean("student12");

        System.out.println(student
        +"\n"+student2);


    }
}
