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
public class Spell extends Card{
    
    private double spellDamage;

    public Spell(String cardName, String ID, String type, double spellDamage) {
        super(cardName, ID, type);
        this.spellDamage = spellDamage;
        usageQuantity = 0;
    }

    public double getSpellDamage() {
        return spellDamage;
    }

    public void setSpellDamage(double spellDamage) {
        this.spellDamage = spellDamage;
    }

    @Override
    public String toString() {
        return "Spell{" + " Card Name = "+ cardName + ", ID = "+ ID + ", Rarity = " + type + ", Damage = " + spellDamage + '}';
    } 
}
