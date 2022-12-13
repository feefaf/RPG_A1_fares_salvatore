package com.isep.rpg.items;

public abstract class Item {

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public String priceInfo(){
        String message = getName()+ " : "+getPrice()+ " Gold";
        return (message);
    }

    private String name;
    protected int price = 0;
}
