package com.isep.hpah.core.LogiqueJeu;

public abstract class Character {
    //Variables/Attributes all characters have
    public String name;
    public int maxhp, hp, level, damage;

    //Constructor for character
    public Character(String name) {
        this.name = name;
        this.hp = maxhp;
        this.maxhp = maxhp;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public int getMaxhp() {
        return maxhp;
    }

    public int getDamage() {
        return damage;
    }

    public abstract int attack();

}