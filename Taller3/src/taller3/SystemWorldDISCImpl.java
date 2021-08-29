/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller3;

import ucn.*;

/**
 *
 * @author Ignacio
 */
public class SystemWorldDISCImpl implements SystemWorldDISC {

    private PlayerList playerList;
    
    
    public SystemWorldDISCImpl() {
        playerList = new PlayerList(100);
    }

    public PlayerList getPlayerList() {
        return playerList;
    }
    
    /**
     * Method that lets you use your Warrior
     * @param player
     * @param player2
     * @param warriorList
     * @return boolean
     */
    @Override
    public boolean useWarrior(Player player,Player player2, WarriorList warriorList){
        
        Warrior warrior = (Warrior) player.getDeckI(0);
        double damage = warrior.getDamage();
        Warrior warrior2 = (Warrior) player2.getDeckI(0);
        double warriorHP2 = warrior2.getHP();
        StdOut.println("");
        StdOut.println("Warrior name: " + warrior.getCardName());
        StdOut.println("Warrior's damage: " + warrior.getDamage());
        StdOut.println("Warrior's current HP: " + warrior.getHP());
        
        if(warrior.getHP() == 0){
            StdOut.println("");
            StdOut.println("Your warrior is gone");
            return false;
        }else{
            double totalDamage = player.getDamageCaused();
            player.setDamageCaused(totalDamage + warrior.getDamage());
            warriorList.getWarriorByName(warrior.getCardName()).setUsageQuantity();
            if(warriorHP2 > 0){
                StdOut.println("");
                StdOut.println(warrior.getCardName() + " Attacks -> " + warrior2.getCardName());
                double difference = warriorHP2-damage;
                
                if(difference > 0){
                    warrior2.setHP(difference);
                    StdOut.println("");
                    StdOut.println(warrior2.getCardName() + " Current HP: " + warrior2.getHP());
                    return true;
                }else{
                    warrior2.setHP(0);
                    warriorList.getWarriorByName(warrior2.getCardName()).setDeaths();
                    StdOut.println("");
                    StdOut.println(player2.getName() + ", your Warrior is gone");
                    StdOut.println("");
                    return true;
                }
            }else{
                double player2HP = player2.getHP();
                double attack = player2HP - warrior.getDamage();
                if(attack > 0){
                    player2.setHP(attack);
                    StdOut.println("");
                    StdOut.println(player2.getName() + " Current HP: " + player2.getHP());
                    StdOut.println("");
                    return true;
                }else{
                    player2.setHP(0);
                    StdOut.println("Hero dead");
                    StdOut.println("");
                    return true;
                }
            }   
        }
    }
    
    /**
     *  Method that lets you use your Spell
     * @param player
     * @param player2
     * @param spellList
     * @param warriorList
     * @return boolean
     */
    @Override
    public boolean useSpell(Player player, Player player2, SpellList spellList, WarriorList warriorList){
        
        Spell spell = (Spell) player.getDeckI(1);
        double spellDamage = spell.getSpellDamage();
        Warrior warrior2 = (Warrior) player2.getDeckI(0);
        StdOut.println("");
        StdOut.println("Spell name: " + spell.getCardName());
        StdOut.println("Spell damage: " + spell.getSpellDamage());
        
        if(spell.getSpellDamage() == 0){
            StdOut.println("");
            StdOut.println("You have already used your Spell");
            return false;
        }else{
            double totalDamage = player.getDamageCaused();
            player.setDamageCaused(totalDamage + spell.getSpellDamage());
            spellList.getSpellByName(spell.getCardName()).setUsageQuantity();
            if(warrior2.getHP() > 0){
                StdOut.println("");
                StdOut.println(spell.getCardName() + " Attacks -> " + warrior2.getCardName());
                
                double difference = warrior2.getHP() - spellDamage;
                if(difference > 0){
                    warrior2.setHP(difference);
                    spell.setSpellDamage(0);
                    StdOut.println("");
                    StdOut.println(warrior2.getCardName() + " Current HP: " + warrior2.getHP());
                    StdOut.println("");
                    return true;
                }else{
                    warrior2.setHP(0);
                    spell.setSpellDamage(0);
                    warriorList.getWarriorByName(warrior2.getCardName()).setDeaths();
                    StdOut.println("");
                    StdOut.println(player2.getName() + ", your Warrior is dead");
                    StdOut.println("");
                    return true;
                }
            }else{
                double heroHP = player2.getHP();
                double attack = heroHP - spellDamage;
                
                if(attack > 0){
                    player2.setHP(attack);
                    StdOut.println("");
                    StdOut.println(player2.getName() + ", Current HP: " + player2.getHP());
                    StdOut.println("");
                    return true;
                }else{
                    spell.setSpellDamage(0);
                    StdOut.println("Hero dead");
                    StdOut.println("");
                    return true;
                }          
            }
        }
    }
    
    /**
     *  Method that lets you use your Guardian
     * @param player
     * @param guardianList
     * @return boolean
     */
    @Override
    public boolean useGuardian(Player player, GuardianList guardianList){
        
        Guardian guardian = (Guardian) player.getDeckI(2);
        Warrior warrior = (Warrior) player.getDeckI(0);
        StdOut.println("");
        StdOut.println("Guardian name: "+ guardian.getCardName());
        StdOut.println("HP Bonus: "+ guardian.getHP());
       
        if(guardian.getHP() != 0){
            guardianList.getGuardianByName(guardian.getCardName()).setUsageQuantity();
            double warriorHP = warrior.getHP();
            double bonus = warriorHP + guardian.getHP();
            warrior.setHP(bonus);
            guardian.setHP(0);
            StdOut.println("");
            StdOut.println("Warrior HP: " + warrior.getHP());
            return true;
        }else{
            StdOut.println("");
            StdOut.println("Guardian already used");
            return false;
        }
    }
    
    /**
     * Method that seeks by ID a card
     * @param ID
     * @param warriorList
     * @param spellList
     * @param guardianList
     * @return String
     */
    @Override
    public String findCard(String ID,WarriorList warriorList,SpellList spellList,GuardianList guardianList){
        int i;
        for(i=0; i<warriorList.getWarriorNumber();i++){
            if(warriorList.getWarriorI(i).getID().equalsIgnoreCase(ID)){
                break;
            }
        }
        if(i < warriorList.getWarriorNumber()){
            String nameWFound = warriorList.getWarriorI(i).getCardName();
            String rarityWFound = warriorList.getWarriorI(i).getType();
            String raceWFound = warriorList.getWarriorI(i).getRace();
            String usageWFound = Integer.toString(warriorList.getWarriorI(i).getUsageQuantity());
            String deathWFound = Integer.toString(warriorList.getWarriorI(i).getDeaths());
            String retW = "Warrior = { " + nameWFound + ", Rarity =  " + rarityWFound + ", Race =  " + raceWFound + ", Usages = " + usageWFound + ", Deaths = " + deathWFound + " }";
            return retW ;
        }else{
            i=0;
            for(i=0;i<spellList.getSpellNumber();i++){
                if(spellList.getSpellI(i).getID().equalsIgnoreCase(ID)){
                    break;
                }
            }
            if(i<spellList.getSpellNumber()){
                 String nameSFound = spellList.getSpellI(i).getCardName();
                 String raritySFound = spellList.getSpellI(i).getType();
                 String usageSFound = Integer.toString(spellList.getSpellI(i).getUsageQuantity());
                 String retS = "Spell = { " + nameSFound + ", Rarity =  " + raritySFound + ", Usages = " + usageSFound + " }";
                 return retS;         
            }else{
                i=0;
                for(i=0;i<guardianList.getGuardianNumber();i++){
                    if(guardianList.getGuardianI(i).getID().equalsIgnoreCase(ID)){
                        break;
                    }
                }
                if(i<guardianList.getGuardianNumber()){
                    String nameGFound = guardianList.getGuardianI(i).getCardName();
                    String rarityGFound = guardianList.getGuardianI(i).getType();
                    String usageGFound = Integer.toString(guardianList.getGuardianI(i).getUsageQuantity());
                    String retG = "Spell = { " + nameGFound + ", Rarity =  " + rarityGFound + ", Usages = " + usageGFound + " }";
                    return retG;
                }else{
                    return null;
                }       
            }
        }  
    } 
    
    /**
     *  Method that displays all duels and heroes who played
     * @param playerList
     */
    @Override
    public void heroesThatHaveParticipated(PlayerList playerList){
        if(playerList.getPlayerNumber() != 0){
            int seeker;
            for(seeker=0; seeker < playerList.getPlayerNumber(); seeker+=2){
                Player heroA = playerList.getPlayerI(seeker);
                Player heroB = playerList.getPlayerI(seeker+1);

                StdOut.println("Hero: "+ heroA.getName() + " VS Hero: " + heroB.getName());
            }
            StdOut.println("Accion done");
        }else{
            StdOut.println("There are no players who have participated");
        }
    }
    
    /**
     *  Method that displays details of the last combat
     * @param playerList
     */
    @Override
    public void detailsOfLastCombat(PlayerList playerList){
        int number = playerList.getPlayerNumber();
        
        if(number != 0){
            Player playerX = playerList.getPlayerI(number-2);
            Player playerY = playerList.getPlayerI(number-1);

            StdOut.println("Hero 1: "+ playerX.getName());
            StdOut.println("Deck: ");
            for(int i=0; i<3; i++){
                StdOut.println(playerX.getDeckI(i));
            }
            StdOut.println("Total damage caused: " + playerX.getDamageCaused());

            StdOut.println("Hero 2: "+ playerY.getName());
            StdOut.println("Deck: ");
            for(int i=0; i<3; i++ ){
                StdOut.println(playerY.getDeckI(i));
            }
            StdOut.println("Total damage caused: " + playerY.getDamageCaused());
            StdOut.println("Accion done");
        }else{
            StdOut.println("There are no duels yet");
        }
    }
}
