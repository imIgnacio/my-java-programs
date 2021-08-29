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
public class Warrior extends Card{
    
    private String race;
    private double HP;
    private double damage;
    private int deaths;

    public Warrior(String cardName, String ID, String type, String race, double HP, double damage){
        super(cardName, ID, type);
        this.race = race;
        this.HP = HP;
        this.damage = damage;
        usageQuantity = 0;
        deaths = 0;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public double getHP() {
        return HP;
    }

    public void setHP(double HP) {
        this.HP = HP;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths() {
        this.deaths++;
    }
    
    

    @Override
    public String toString() {
        return "Warrior{"+ " Card Name = "+ cardName + ", ID = "+ ID + ", Rarity = "+ type + ", Race = " + race + ", HP = " + HP + ", Damage = " + damage + '}';
    } 
}
