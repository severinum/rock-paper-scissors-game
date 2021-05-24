package com.severinu.paperrockscissorsgame;

import java.util.HashSet;
import java.util.Set;

/**
 * This is just a regular game element
 * It can be "rock","paper","scissors" (or anything you want to add)
 */
class GameElement {
    private String name;
    private Set<String> winningAgainst = new HashSet<>();

    /**
     * Constructor.
     * It assign name to new element as well as set of names of elements he is winning against
     * For example paper can win with rock so you add ("paper" , new HashSet<>(Arrays.asList("rock"))
     *
     * @param elementName    String , name of the element
     * @param winningAgainst HashSet  of elements he is winning agains
     */
    public GameElement(String elementName, Set<String> winningAgainst) {
        this.name = elementName;
        this.winningAgainst = winningAgainst;
    }

    public String getName() {
        return name;
    }

    /**
     * Returns Set of all names of other GameElements that he wins agains
     *
     * @return
     */
    public Set<String> getWinningAgainst() {
        return winningAgainst;
    }
}