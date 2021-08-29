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
public interface SystemWorldDISC {
    
    public boolean useWarrior(Player player,Player player2, WarriorList warriorList);
    public boolean useSpell(Player player, Player player2, SpellList spellList, WarriorList warriorList);
    public boolean useGuardian(Player player, GuardianList guardianList);
    public String findCard(String ID,WarriorList warriorList,SpellList spellList,GuardianList guardianList);
    public void heroesThatHaveParticipated(PlayerList playerList);
    public void detailsOfLastCombat(PlayerList playerList);
}
