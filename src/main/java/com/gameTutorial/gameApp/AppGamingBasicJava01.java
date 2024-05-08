package com.gameTutorial.gameApp;

import game.GameRunner;
import game.GamingConsole;
import game.MarioGame;
import game.SuperContraGame;

public class AppGamingBasicJava01 {
    public static void main(String[] args) {
        MarioGame marioGame = new MarioGame() ;
        GamingConsole superContraGame = new SuperContraGame() ;
        GameRunner gameRunner = new GameRunner(superContraGame) ;
        gameRunner.run() ;
    }
}
