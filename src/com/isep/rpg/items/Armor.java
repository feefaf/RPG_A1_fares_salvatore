package com.isep.rpg.items;

public class Armor extends Item{

    public Armor(String name, String holder, float dV) {
        super(name);
        this.holder = holder;
        this.defValue = dV;
    }

    //getters
    public float getDefValue() { return defValue; }
    public String WhoCanHoldIt(){ return holder;}
    //setters
    public void setDefValue(float defValue) { this.defValue = defValue; }
    private float defValue;
    private String holder;
}
