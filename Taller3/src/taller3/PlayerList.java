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
public class PlayerList {
    
    private Player[] playerList;
    private int max;
    private int playerNumber;
    
    public PlayerList(int max){
        
        playerList = new Player[max];
        this.max = max;
        playerNumber = 0;
    }

    public int getMax() {
        return max;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }
    
    public Player getPlayerI(int i){
        return playerList[i];
    }

    public boolean addPlayer(Player player) {
        if(playerNumber < max){
            playerList[playerNumber] = player;
            playerNumber++;
            return true;
        }else{
            return false;
        }
    }
    
    @Override
    public String toString() {
        String r = "";
        for(int i=0;i<playerNumber;i++){
            r = r + (i+1) +".- " + playerList[i].toString() + "\n";
        }
        return r;
    }
    
    
}
