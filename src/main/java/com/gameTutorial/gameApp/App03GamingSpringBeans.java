package com.gameTutorial.gameApp;

import game.GameRunner;
import game.GamingConsole;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App03GamingSpringBeans {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(GamingConfig.class) ;

        context.getBean(GameRunner.class).run() ;
    }
}
