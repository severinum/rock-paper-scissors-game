package com.severinu.paperrockscissorsgame;

public class Player {

    private static int nextPlayerNumber = 1;
    private String name;
    private GameElement gameElement;
    private int playerNumber;

    public Player(String name) {
        this.name = name;
        this.playerNumber = nextPlayerNumber;
        nextPlayerNumber++;
    }

    public String getName() {
        return name;
    }

    public GameElement getGameElement() {
        return gameElement;
    }

    public void setGameElement(GameElement gameElement) {
        this.gameElement = gameElement;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }
}
