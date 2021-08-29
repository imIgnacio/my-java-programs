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
public class Guardian extends Card{
    
    private double HP;
    private double damage;

    public Guardian(String cardName, String ID, String type, double HP, double damage) {
        super(cardName, ID, type);
        this.HP = HP;
        this.damage = damage;
        usageQuantity = 0;
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

    @Override
    public String toString() {
        return "Guardian{" + " Card Name = "+ cardName + ", ID = "+ ID + ", Race = "+ type + ", HP = " + HP + ", Damage = " + damage + '}';
    }
}
