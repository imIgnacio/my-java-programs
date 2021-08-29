/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller3;

/**
 *
 * @author Ignacio
 */
public class Player {
    
    private String name;
    private Card[] deck;
    private double HP;
    private double damageCaused;

    public Player(String name, Card[] deck) {
        this.name = name;
        this.deck = deck;
        this.HP = 15;
        this.damageCaused = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Card[] getDeck() {
        return deck;
    }

    public void setDeck(Card[] deck) {
        this.deck = deck;
    }
    
    public Card getDeckI(int i){
        return deck[i];
    }
    
    public void setDeckI(int i, Card card){
        this.deck[i] = card;
    }

    public double getHP() {
        return HP;
    }

    public void setHP(double HP) {
        this.HP = HP;
    }

    public double getDamageCaused() {
        return damageCaused;
    }

    public void setDamageCaused(double damageCaused) {
        this.damageCaused = damageCaused;
    }
    
    

    
    
    @Override
    public String toString() {
        String rr = "";
        for(int i=0;i<deck.length;i++){
            rr = rr + deck[i].toString() + "\n";
        }
        return "Player = " + name + "\nDeck: \n" + rr;
    }   
}
