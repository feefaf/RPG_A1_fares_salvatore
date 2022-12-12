package com.isep.rpg.mechants;

import com.isep.rpg.Combatant;
import com.isep.rpg.mechants.Ennemy;

public class Dragon extends Ennemy {

    public Dragon(String n) {
        // Le dragon possède 5 points de vie et inflige 3 points de dégats
        super(n, 5, 3);
    }

    // Implémentation de la méthode abstraite "fight" par le dragon
    @Override
    public void attack(Combatant combatant) {
        calculatedDamage = (int)((getDamagePoints() -(int)(getArmorPoint()*getDamagePoints())) * ((combatant.IsInDefense()) ? 0.5: 1));
        combatant.loose( calculatedDamage );
    }
    @Override
    public void Status(){
        System.out.println(getName() + " : " + getHealthPoint() + " PV  ,  " + getDamagePoints() + " ATK  ,  " + (getArmorPoint()*100) + "% DEF");
    }


    @Override
    public String getWeaponName() {
        return null;
    }

    @Override
    public String getArmorName() {
        return null;
    }

    @Override
    public int getWeaponDamage() {
        return 0;
    }

    @Override
    public float getArmorPoint() {
        return 0;
    }
    @Override
    public boolean IsInDefense() {
        return false;
    }

    @Override
    public void setIfInDefense(boolean InDefense) {
        //les ennemie ne peuvent jamais se mettre en défense.
    }

    public void rugissement(){
        System.out.println("je suis un dragon tres villain je rugis !...");
    }
    private int calculatedDamage;
}
