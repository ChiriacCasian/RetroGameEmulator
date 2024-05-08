package com.gameTutorial.gameApp.HelloWorld;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person(String name, int age){} ;
@Configuration
public class HelloWorldConfig {
    @Bean
    public String name(){
        return "Ranga" ;
    }
    @Bean
    public int age(){
        return 15 ;
    }
    @Bean(name = "2argsPerson")
    public Person person(){
        return new Person("casian", 12) ;
    }
    @Bean
    @Primary
    public Person person2MethodCall(){
        return new Person(name(), age()) ;
    }
    @Bean
    public Person person3(String name, int age){
        return new Person(name, age) ;
    }
}
