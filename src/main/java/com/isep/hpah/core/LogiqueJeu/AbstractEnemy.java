package com.isep.hpah.core.LogiqueJeu;

public abstract class AbstractEnemy extends Character {
    //Variables/Attributes all characters have
    public String name;
    public int maxhp, hp, level;

    public String location;

    public AbstractEnemy(String name, int maxhp, int level, String location, int damage) {
        super(name, maxhp, level, damage);
        this.name = name;
        this.maxhp = maxhp;
        this.level = level;
        this.location = location;
        this.damage = damage;
    }

    public int getMaxhp() {
        return maxhp;
    }

    public boolean isAlive() {
        return false;
    }

    @Override
    public int attack() {
        return 0;
    }

}
