/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller3;
import java.io.IOException;
import java.util.Random;
import ucn.*;
/**
 *
 * @author Ignacio
 */
public class Taller3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        WarriorList warriorList = new WarriorList(20);
        SpellList spellList = new SpellList(20);
        GuardianList guardianList = new GuardianList(20);
        SystemWorldDISCImpl system = new SystemWorldDISCImpl();
        PlayerList playerList = system.getPlayerList();
        
        readFile(warriorList, spellList, guardianList);
        mainMenu(warriorList, spellList, guardianList, playerList, system);
        
    }
    
    private static void readFile(WarriorList warriorList, SpellList spellList, GuardianList guardianList) throws IOException{
        ArchivoEntrada file = new ArchivoEntrada("Cards.txt");
            
        while(!file.isEndFile()){
            Registro regEnt = file.getRegistro();
            String[] list = new String[9];

            for(int i=0;i<list.length;i++){
                list[i] = regEnt.getString();
            }

            int fieldNumber = 0;
            int j = 0;

            while(list[j] != null){
                fieldNumber++;
                j++;
            }

            if(fieldNumber == 4){
                String name = list[0];
                String ID = list[1].toUpperCase();
                String rarity = list[2];
                double damage = Double.parseDouble(list[3]);

                Spell spell = new Spell(name, ID, rarity, damage);
                spellList.addSpell(spell);
            }
            if(fieldNumber == 5){
                String name = list[0];
                String ID = list[1].toUpperCase();
                String race = list[2];
                double HP = Double.parseDouble(list[3]);
                double damage = Double.parseDouble(list[4]);

                Guardian guardian = new Guardian(name, ID, race, HP, damage);
                guardianList.addGuardian(guardian);
            }
            if(fieldNumber == 6){
                String name = list[0];
                String ID = list[1].toUpperCase();
                String rarity = list[2];
                String race = list[3];
                double HP = Double.parseDouble(list[4]);
                double damage = Double.parseDouble(list[5]);

                Warrior warrior = new Warrior(name, ID, rarity, race, HP, damage);
                warriorList.addWarrior(warrior);
            }
        }
        file.close();
    }
    
    private static void mainMenu(WarriorList warriorList, SpellList spellList, GuardianList guardianList, PlayerList playerList, SystemWorldDISCImpl system){  
        StdOut.println("-- World of DISC --");
        StdOut.println("Please select an option: ");
        StdOut.println("1.- Play");
        StdOut.println("2.- Find Card-Game");
        StdOut.println("3.- Heroes that have participated");
        StdOut.println("4.- Details of The Last Duel");
        StdOut.println("5.- Exit");
        
        int number = StdIn.readInt();
        
        while(number != 5){
            
            if(number == 1){
                StdOut.println("Please type player one's name");
                String namePlayer1 = StdIn.readString();
                
                int warriorPlayer1 = 0;
                do{
                    StdOut.println(warriorList);
                    StdOut.println("Type Warrior's number you want to choose");
                    warriorPlayer1 = StdIn.readInt() - 1;
                }while(warriorPlayer1 >= 12);
                
                int spellPlayer1 = 0;
                do{
                    StdOut.println(spellList);
                    StdOut.println("Type Spell's number you want to choose");
                    spellPlayer1 = StdIn.readInt() - 1;
                }while(spellPlayer1 >= 10);
                
                int guardianPlayer1 = 0;
                do{
                    StdOut.println(guardianList);
                    StdOut.println("Type Guardian's number you want to choose");
                    guardianPlayer1 = StdIn.readInt() - 1;
                }while(guardianPlayer1 >= 11);
                
                Card[] deckPlayer1 = new Card[3];
                deckPlayer1[0] = warriorList.getWarriorI(warriorPlayer1);
                deckPlayer1[1] = spellList.getSpellI(spellPlayer1);
                deckPlayer1[2] = guardianList.getGuardianI(guardianPlayer1);
                
                Player player = new Player(namePlayer1, deckPlayer1);
                playerList.addPlayer(player);
                
                StdOut.println("Please type player two's name");
                String namePlayer2 = StdIn.readString();
                
                int warriorPlayer2 = 0;
                do{
                    StdOut.println(warriorList);
                    StdOut.println("Type Warrior's number you want to choose");
                    warriorPlayer2 = StdIn.readInt() - 1;
                }while(warriorPlayer2 >= 12);
                
                int spellPlayer2 = 0;
                do{
                    StdOut.println(spellList);
                    StdOut.println("Type Spell's number you want to choose");
                    spellPlayer2 = StdIn.readInt() - 1;
                }while(spellPlayer2 >= 10);
                
                int guardianPlayer2 = 0;
                do{
                    StdOut.println(guardianList);
                    StdOut.println("Type Guardian's number you want to choose");
                    guardianPlayer2 = StdIn.readInt() - 1;
                }while(guardianPlayer2 >= 11);
                
                Card[] deckPlayer2 = new Card[3];
                deckPlayer2[0] = warriorList.getWarriorI(warriorPlayer2);
                deckPlayer2[1] = spellList.getSpellI(spellPlayer2);
                deckPlayer2[2] = guardianList.getGuardianI(guardianPlayer2);
                
                Player player2 = new Player(namePlayer2, deckPlayer2);
                playerList.addPlayer(player2);
                
                double HPWarriorA = warriorList.getWarriorI(warriorPlayer1).getHP();
                double HPSpellA = spellList.getSpellI(spellPlayer1).getSpellDamage();
                double HPGuardianA = guardianList.getGuardianI(guardianPlayer1).getHP();
                
                double HPWarriorB = warriorList.getWarriorI(warriorPlayer2).getHP();
                double HPSpellB = spellList.getSpellI(spellPlayer2).getSpellDamage();
                double HPGuardianB = guardianList.getGuardianI(guardianPlayer2).getHP();
                
                int dice = throwDice(player, player2);
                int duelResult;
                if(dice == 1){
                    duelResult = duel(player, player2, warriorList, spellList, guardianList, system);
                    if(duelResult == 0){
                        double HP1 = player.getHP();
                        double HP2 = player2.getHP();
                        if(HP1 > HP2){
                            StdOut.println(player.getName() + " Wins");
                        }else{
                            if(HP2 > HP1){
                                StdOut.println(player2.getName() + " Wins");
                            }else{
                                StdOut.println("You both have drawn");
                            }
                        }
                    }else{
                        if(duelResult == -1){
                            StdOut.println(player.getName() + " Wins");
                        }else{
                            StdOut.println(player2.getName() + " Wins");
                        }
                        StdOut.println("Accion done");
                    }
                }else{
                    duelResult = duel(player2, player, warriorList, spellList, guardianList, system);   
                    if(duelResult == 0){
                        double HPB = player2.getHP();
                        double HPA = player.getHP();
                        if(HPB > HPA){
                            StdOut.println(player2.getName() + " Wins");
                        }else{
                            if(HPA > HPB){
                                StdOut.println(player.getName() + " Wins");
                            }else{
                                StdOut.println("You both have drawn");
                            }
                        }
                    }else{
                        if(duelResult == -1){
                            StdOut.println(player2.getName() + " Wins");
                        }else{
                            if(duelResult == 1){
                                StdOut.println(player.getName() + " Wins");
                            }
                        }
                    }
                }
                
                warriorList.getWarriorI(warriorPlayer1).setHP(HPWarriorA);
                spellList.getSpellI(spellPlayer1).setSpellDamage(HPSpellA);
                guardianList.getGuardianI(guardianPlayer1).setHP(HPGuardianA);
                
                warriorList.getWarriorI(warriorPlayer2).setHP(HPWarriorB);
                spellList.getSpellI(spellPlayer2).setSpellDamage(HPSpellB);
                guardianList.getGuardianI(guardianPlayer2).setHP(HPGuardianB);
                
            }else{
                if(number == 2){
                    StdOut.println("Please type ID you are looking for");
                    String ID = StdIn.readString().toUpperCase().replace(" ", "");
                    String cardRequired = system.findCard(ID, warriorList, spellList, guardianList);
                    if(cardRequired != null){
                        StdOut.println(cardRequired);
                        StdOut.println("Accion done");
                    }else{
                        StdOut.println("Sorry, card not found");
                    }
                }else{
                    if(number == 3){
                        system.heroesThatHaveParticipated(playerList);
                    }else{
                        if(number == 4){
                            system.detailsOfLastCombat(playerList);
                        }else{
                            if(number > 5){
                                StdOut.println("Sorry, number incorrect");
                            }
                        }
                    }
                }
            }
            
            StdOut.println("");
            StdOut.println("Please select an option: ");
            StdOut.println("1.- Play");
            StdOut.println("2.- Find Card-Game");
            StdOut.println("3.- Heroes that have participated");
            StdOut.println("4.- Details of The Last Duel");
            StdOut.println("5.- Exit");
            
            number = StdIn.readInt();
        }
        
        StdOut.println("Thanks for playing");
    }
    
    private static int throwDice(Player player, Player player2){
        Random rand = new Random();
        String player1Name = player.getName();
        String player2Name = player2.getName();
        
        int dicePlayer1;
        int dicePlayer2;
        
        do{
            dicePlayer1 = rand.nextInt(6) + 1;
            dicePlayer2 = rand.nextInt(6) + 1;
            
            StdOut.println(player1Name + " Throws");
            StdOut.println(dicePlayer1);
            
            StdOut.println(player2Name + " Throws");
            StdOut.println(dicePlayer2);
        }while(dicePlayer1 == dicePlayer2);
        
        if(dicePlayer1 > dicePlayer2){
            return 1;
        }else{
            return 0;
        }        
    }
    
    private static int duel(Player playerA, Player playerB, WarriorList warriorList, SpellList spellList, GuardianList guardianList, SystemWorldDISCImpl system){
        
        double playerAHP = playerA.getHP();
        double playerBHP = playerB.getHP();
        
        while(playerAHP != 0 && playerBHP != 0){
            StdOut.println(playerA.getName() + " Is now playing");
            StdOut.println("");
            StdOut.println("What would you like to do?");
            StdOut.println("1.- Use your Warrior");
            StdOut.println("2.- Use your Spell");
            StdOut.println("3.- Use your Guardian");
            
            int action = StdIn.readInt();
            
            if(action == 1){
                system.useWarrior(playerA, playerB, warriorList);
            }
            if(action == 2){
                system.useSpell(playerA, playerB, spellList, warriorList);
            }
            if(action == 3){
                system.useGuardian(playerA, guardianList);
            }
            
            if(playerB.getHP() == 0){
                break;
            }else{
                StdOut.println(playerB.getName() + " Is now playing");
                StdOut.println("");
                StdOut.println("What would you like to do?");
                StdOut.println("1.- Use your Warrior");
                StdOut.println("2.- Use your Spell");
                StdOut.println("3.- Use your Guardian");
                
                int action2 = StdIn.readInt();
                if(action2 == 1){
                    system.useWarrior(playerB, playerA, warriorList);
                }
                if(action2 == 2){
                    system.useSpell(playerB, playerA, spellList, warriorList);
                }
                if(action2 == 3){
                    system.useGuardian(playerB, guardianList);
                }
            }
            
            if(checkDuel(playerA, playerB) == true){
                break;
            }
            playerAHP = playerA.getHP();
            playerBHP = playerB.getHP();
        }
        
        if(playerA.getHP() != 0 && playerB.getHP() != 0){
            return 0;
        }else{
            if(playerA.getHP() == 0){
                return 1;
            }else{
                return -1;
            }
        }
    }
    
    private static boolean checkDuel(Player playerA, Player playerB){
        Guardian guardianA = (Guardian) playerA.getDeckI(2);
        Guardian guardianB = (Guardian) playerB.getDeckI(2);
        if(guardianA.getHP() == 0 && guardianB.getHP() == 0){
            Spell spellA = (Spell) playerA.getDeckI(1);
            Spell spellB = (Spell) playerB.getDeckI(1);
            if(spellA.getSpellDamage() == 0 && spellB.getSpellDamage() == 0){
                Warrior warriorA = (Warrior) playerA.getDeckI(0);
                Warrior warriorB = (Warrior) playerB.getDeckI(0);
                if(warriorA.getHP() == 0 && warriorB.getHP() == 0){
                    return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
}
