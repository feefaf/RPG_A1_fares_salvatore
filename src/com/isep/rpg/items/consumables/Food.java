package com.isep.rpg.items.consumables;

import com.isep.rpg.gentils.Hero;

import static com.isep.rpg.Game.displayMessage;

public class Food extends Consumable{
    public Food(String name, int hpContenance, int nbre, int price) {
        super(name);
        this.hpRecovery = hpContenance;
        this.quantity = nbre;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    public void eat(Hero hero){
        if (quantity >0){
            hero.heal(hpRecovery);
            quantity -= 1;
            displayMessage(hero.getName()+ " consomme "+name+" et regagne "+ hpRecovery+" HP !");
        } else {
            displayMessage("Vous n'avez plus de assez de "+ name +" pour en consommer !");
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
        String message = getQuantity()+"X "+ name + " : "+hpRecovery+" HP.";
        return message;
    }

    private String name;
    private int hpRecovery;
    private int quantity;
}
