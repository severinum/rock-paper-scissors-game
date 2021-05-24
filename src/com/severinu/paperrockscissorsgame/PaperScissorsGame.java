/**
 * <h1>Rock Paper Scissors Game</h1>
 * Very simple version of the game. However you can add new elements to it.
 * For example: water that wins against paper ans scissors and loose against rock.
 *
 * @author  Seweryn Michota
 * @version 1.0
 * @since   2019-01-05
 */
package com.severinu.paperrockscissorsgame;

import java.util.*;

public class PaperScissorsGame {

    public static int nextPlayerNumber = 1;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";

    private List<Player> players = new ArrayList<>();
    private Set<GameElement> gameElements = new HashSet<>();
    private Player[] winner = new Player[0];


    /**
     * Add player to the game
     * @param player
     */
    public void addPlayer(Player player) {
        players.add(player);
    }

    /**
     * Add GameElement to the game. re: "paper", "rock", "scissors"
     * @param gameElement
     */
    public void addElement(GameElement gameElement) {
        this.gameElements.add(gameElement);
    }

    /**
     * Choosing random GameElement to the all players and assign it to them
     */
    public void drawElementForPlayers() {
        for (Player player: players){
            player.setGameElement(this.drawElement());
        }
    }

    /**
     * Draw one random GameElement out of all possible GameElements
     * @return
     */
    private GameElement drawElement() {
        int numberOfElementsInGame = gameElements.size();
        int item = new Random().nextInt(numberOfElementsInGame);
        GameElement[] els = gameElements.toArray(new GameElement[gameElements.size()]);
        return els[item];
    }

    /**
     * Returns list of all players in the game
     * @return
     */
    public List<Player> getPlayers() {
        return players;
    }

    /**
     * Logic of the game.
     * If Players have the same GameElement it returns array of Players (calculated later as draw)
     * If Player2's element list of gameElements his GameElement wins against and that element
     * is actual Player1's element ... then Player2 wins  or else Player1 wins.
     * Why ? If it's not draw and Player1's element is not te one loosing against element of Player2's
     * then it mean that Player1 must win.
     */
    public void play() {
        this.displayGameRules();
        this.drawElementForPlayers();
        displayIntroData();

        if(this.players == null || players.size() < 2){
            System.out.println("The list of players is empty or there is just one player in the game");
        }

        if(players.get(1).getGameElement().getWinningAgainst().contains(players.get(0).getGameElement().getName())) {
            this.winner = new Player[]{players.get(1)};
        } else {
            this.winner = new Player[] { players.get(0)};
        }

        // draw
        if (players.get(1).getGameElement().getName().equals(players.get(0).getGameElement().getName())){
            this.winner =  new Player[]{players.get(0), players.get(1)};
        }

        this.displayResult();
    }

    /**
     * Displays players names and GameElements they have assigned during draw (random choice).
     */
    public void displayIntroData(){
        for(Player p: this.getPlayers()){
            System.out.println("Player " + p.getPlayerNumber() + " ("+p.getName()+") choose : " + p.getGameElement().getName());
        }
    }

    /**
     * Return winner of the game as an array
     * It can be 1 player (winner)
     * or 2 players (draw)
     * @return
     */
    public Player[] getWinner() {
        return this.winner;
    }

    /**
     * It displays result of the game.
     * If this.winner contains 0 players it mean there is no winner
     * If this.winner contains 1 players it mean there is 1 winner
     * If this.winner contains 2 players it mean there is a draw.
     */
    private void displayResult(){
        if(this.winner.length == 0) {
            System.out.println("There is no winner");
        } else if(this.winner.length == 1){
            Player winner = this.winner[0];
            System.out.println(ANSI_GREEN + "The winner is : Player " + winner.getPlayerNumber() + " (" + winner.getName() + ")" + ANSI_RESET );
        } else if(this.winner.length == 2){
            System.out.println(ANSI_GREEN + "There is a draw !" + ANSI_RESET);
        }
    }


    private void displayGameRules() {
        System.out.println("###### current game rules #########");
        for(GameElement gameElement: this.gameElements){
            String winningAgainst = String.join(",  ", gameElement.getWinningAgainst());
            System.out.println("\t" + gameElement.getName() + " winning against : " + winningAgainst);
        }
        System.out.println("###################################");
    }
}

