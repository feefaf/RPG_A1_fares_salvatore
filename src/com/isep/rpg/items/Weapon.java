package com.isep.rpg.items;

public class Weapon extends Item {

    public Weapon(String name, String holder,int damagePoints) {
        super(name);
        this.holder = holder;
        this.damagePoints = damagePoints;
    }

    public int getDamagePoints() {
        return damagePoints;
    }
    // Une arme inflige des points de dégats
    public String WhoCanHoldIt(){ return holder;}
    private int damagePoints;
    private String holder;
}
