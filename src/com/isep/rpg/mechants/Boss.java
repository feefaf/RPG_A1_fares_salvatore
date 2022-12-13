package com.isep.rpg.mechants;

import com.isep.rpg.Combatant;

import static com.isep.rpg.Game.displayMessage;

public class Boss extends Ennemy {

    public Boss(String n, int HP, int dmg) {
        super(n, HP, dmg);
    }

    // Implémentation de la méthode abstraite "fight" par le dragon
    @Override
    public void attack(Combatant combatant) {
        displayMessage("M O R T   A U X   H E R O S");
        calculatedDamage = (int)((getDamagePoints() -(int)(getArmorPoint()*getDamagePoints())) * ((combatant.IsInDefense()) ? 0.5: 1));
        combatant.loose( calculatedDamage );
        displayMessage(getName() + " attaque "+combatant.getName() +" et lui inflige "+ calculatedDamage + "Degats");

    }

    @Override
    public int actionChoice() {
        return 0;
    }

    @Override
    public String actionMethodSwithcher(int choix) {
        return null;
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
