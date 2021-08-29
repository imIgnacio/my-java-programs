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
public class GuardianList {
    
    private Guardian[] guardianList;
    private int guardianNumber;
    private int max;
    
    public GuardianList(int max){
        
        guardianList = new Guardian[max];
        guardianNumber = 0;
        this.max = max;
    }

    public int getGuardianNumber() {
        return guardianNumber;
    }
    
    public Guardian getGuardianI(int i) {
        if(i>=0 && i<guardianNumber){
            return guardianList[i];
        }else{
            return null;
        }
    }
    
    public Guardian getGuardianByName(String name) {
        int i;
        for(i=0; i<guardianNumber;i++){
            if(guardianList[i].getCardName().equalsIgnoreCase(name)){
                break;
            }
        }
        if(i<guardianNumber){
            return guardianList[i];
        }else{
            return null;
        }
    }

    public int getMax() {
        return max;
    }
    
    public boolean addGuardian(Guardian guardian) {
        if(guardianNumber < max){
            guardianList[guardianNumber] = guardian;
            guardianNumber++;
            return true;
        }else{
            return false;
        }
    }
    
    @Override
    public String toString() {
        String r = "";
        for(int i=0;i<guardianNumber;i++){
            r = r + (i+1) +".- " + guardianList[i].toString() + "\n";
        }
        return r;
    }
}
