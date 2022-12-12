package com.isep.rpg.items.consumables;

import com.isep.rpg.gentils.SpellCaster;

import static com.isep.rpg.Game.displayMessage;

public class Potion extends Consumable{
    public Potion(String name, int manaContenance, int nbre) {
        super(name);
        this.manaRecovery = manaContenance;
        this.quantity = nbre;
    }

    public void usePotion(SpellCaster manaUser){
        if (quantity >0){
            manaUser.heal(manaRecovery);
            quantity -= 1;
            displayMessage(manaUser.getName()+ " consomme "+getName()+" et regagne "+ manaRecovery+" MANA !");
        } else {
            displayMessage("Vous n'avez plus de assez de "+getName()+" pour en consommer !");
        }
    }

    public int getQuantity() {
        return quantity;
    }
    public void addQuantity(int addition){
        quantity += addition;
    }

    @Override
    public String info(){
        String message = getQuantity()+"X "+getName() + " : "+manaRecovery+" MANA.";
        return message;
    }

    private String name;
    private int manaRecovery;
    private int quantity;
}
