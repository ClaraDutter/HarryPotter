package com.isep.hpah.core.LogiqueJeu;

public class Potion {
    private String name;
    private int hp;
    private int quantity;

    public Potion(String name, int hp, int quantity) {
        this.name = name;
        this.hp = hp;
        this.quantity = quantity;
    }

    public static Potion potion1(){
        return new Potion("Potion1", 20, 2);
    }


    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void drink(int nbr){
        quantity -= nbr;
    }
}
