package com.gameTutorial.gameApp;

import game.GameRunner;
import game.GamingConsole;
import game.PacmanGame;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GamingConfig {
    @Bean
    public GamingConsole game(){
        PacmanGame game = new PacmanGame() ;
        return  game ;
    }
    @Bean
    public GameRunner gameRunner(GamingConsole game){
        return new GameRunner(game) ;
    }
}
