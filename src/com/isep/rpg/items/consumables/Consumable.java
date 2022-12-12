package com.isep.rpg.items.consumables;

import com.isep.rpg.items.Item;

public abstract class Consumable extends Item {
    public Consumable(String name) {
        super(name);
    }
    public abstract String info();

}
