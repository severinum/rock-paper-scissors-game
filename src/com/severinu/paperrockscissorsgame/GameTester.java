package com.severinu.paperrockscissorsgame;

import java.util.Arrays;
import java.util.HashSet;

public class GameTester {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";


    public static void main(String[] args) {

        /* GAME 1 */
        System.out.println(ANSI_YELLOW + "----------------------------------- GAME 1 -----------------------------------" + ANSI_RESET);
        // create game instance
        PaperScissorsGame game = new PaperScissorsGame();

        // assign game elements and against whom they win
        GameElement gameElementRock = new GameElement("rock", new HashSet<>(Arrays.asList("scissors")));
        GameElement gameElementPaper = new GameElement("paper", new HashSet<>(Arrays.asList("rock")));
        GameElement gameElementScissors = new GameElement("scissors", new HashSet<>(Arrays.asList("paper")));

        // assign elements to the game
        game.addElement(gameElementRock);
        game.addElement(gameElementPaper);
        game.addElement(gameElementScissors);

        // create game players
        Player player1 = new Player("Adam");
        Player player2 = new Player("Mike");

        // add players to the game
        game.addPlayer(player1);
        game.addPlayer(player2);

        // run game
        game.play();


        /* GAME 1 */
        System.out.println("\n");
        System.out.println(ANSI_YELLOW + "----------------------------------- GAME 2 -----------------------------------" + ANSI_RESET);
        // create game instance
        PaperScissorsGame game2 = new PaperScissorsGame();

        // create new element for the game : water
        // water melts the paper, rust the scissors but loose with the rock
        GameElement gameElementWater = new GameElement("water", new HashSet<>(Arrays.asList("scissors","paper")));
        // just because we have added water ... the behaviour of paper, rock, scissors elements must be changed as some
        // of them are winning against the water (rock) and some of them loose (scissors, paper)
        GameElement gameElementRock2 = new GameElement("rock", new HashSet<>(Arrays.asList("scissors","water")));

        // assign elements to the game
        game2.addElement(gameElementRock2);
        game2.addElement(gameElementPaper);
        game2.addElement(gameElementScissors);
        game2.addElement(gameElementWater);

        // add players to the game
        game2.addPlayer(player1);
        game2.addPlayer(player2);

        // run game
        game2.play();

    }


}
