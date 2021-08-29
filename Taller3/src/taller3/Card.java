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
public class Card {
    
    protected String cardName;
    protected String ID;
    protected String type;
    protected int usageQuantity;

    public Card(String cardName, String ID, String type) {
        this.cardName = cardName;
        this.ID = ID;
        this.type = type;
        usageQuantity = 0;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getUsageQuantity() {
        return usageQuantity;
    }

    public void setUsageQuantity() {
        this.usageQuantity++;
    }   
}
