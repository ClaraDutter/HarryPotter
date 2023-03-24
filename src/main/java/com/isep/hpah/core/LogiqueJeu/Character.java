package com.isep.hpah.core.LogiqueJeu;

public abstract class Character {
    //Variables/Attributes all characters have
    public String name;
    public int maxhp, hp, level;

    //Constructor for character
    public Character(String name, int maxhp, int level) {
        this.name = name;
        this.hp = maxhp;
        this.maxhp = maxhp;
        this.level = level;
    }

    public abstract int attack();
}