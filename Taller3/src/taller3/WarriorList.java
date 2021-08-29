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
public class WarriorList {
    
    private Warrior[] warriorList;
    private int warriorNumber;
    private int max;
    
    public WarriorList(int max){
        warriorList = new Warrior[max];
        warriorNumber = 0;
        this.max = max;
    }

    public int getWarriorNumber() {
        return warriorNumber;
    }
    
    public Warrior getWarriorI(int i) {
        if(i>=0 && i<warriorNumber){
            return warriorList[i];
        }else{
            return null;
        }
    }
    
     public Warrior getWarriorByName(String name) {
        int i;
        for(i=0; i<warriorNumber;i++){
            if(warriorList[i].getCardName().equalsIgnoreCase(name)){
                break;
            }
        }
        if(i<warriorNumber){
            return warriorList[i];
        }else{
            return null;
        }
    }

    public int getMax() {
        return max;
    }    

    public boolean addWarrior(Warrior warrior) {
        if(warriorNumber < max){
            warriorList[warriorNumber] = warrior;
            warriorNumber++;
            return true;
        }else{
            return false;
        }
    }
    
    @Override
    public String toString() {
        String r = "";
        for(int i=0;i<warriorNumber;i++){
            r = r + (i+1) +".- " + warriorList[i].toString() + "\n";
        }
        return r;
    }
}
