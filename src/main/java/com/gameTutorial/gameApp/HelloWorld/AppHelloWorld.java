package com.gameTutorial.gameApp.HelloWorld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class AppHelloWorld {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(HelloWorldConfig.class) ;
        System.out.println(context.getBean("name")) ;
        System.out.println(context.getBean("age")) ;
        System.out.println(context.getBean(Person.class)) ;
        Arrays.stream(context.getBeanDefinitionNames()).forEach(x -> System.out.println(x)) ;
    }
}
