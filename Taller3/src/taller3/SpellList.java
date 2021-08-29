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
public class SpellList {
    
    private Spell[] spellList;
    private int spellNumber;
    private int max;
    private int spellUsage;
    
    public SpellList(int max){
        
        spellList = new Spell[max];
        spellNumber = 0;
        spellUsage = 0;
        this.max = max;
    }

    public int getSpellNumber() {
        return spellNumber;
    }
    
    public Spell getSpellI(int i) {
        if(i>=0 && i<spellNumber){
            return spellList[i];
        }else{
            return null;
        }
    }
    
     public Spell getSpellByName(String name) {
        int i;
        for(i=0; i<spellNumber;i++){
            if(spellList[i].getCardName().equalsIgnoreCase(name)){
                break;
            }
        }
        if(i<spellNumber){
            return spellList[i];
        }else{
            return null;
        }
    }

    public int getMax() {
        return max;
    }
    
    public boolean addSpell(Spell spell) {
        if(spellNumber < max){
            spellList[spellNumber] = spell;
            spellNumber++;
            return true;
        }else{
            return false;
        }
    }
    
    @Override
    public String toString() {
        String r = "";
        for(int i=0;i<spellNumber;i++){
            r = r + (i+1) +".- " + spellList[i].toString() + "\n";
        }
        return r;
    }
}
