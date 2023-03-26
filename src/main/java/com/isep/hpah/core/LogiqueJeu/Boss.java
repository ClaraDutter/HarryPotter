package com.isep.hpah.core.LogiqueJeu;

public class Boss extends AbstractEnemy {
    private String name;

    private int maxHp;

    private int damage;

    private Wand wand;




    public Boss(String name, int maxhp, int level, String location, int damage ) {
        super(name, maxhp, level, location, damage);
        this.name = name;
        this.maxHp = maxhp;
        this.level = level;
        this.location = location;
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public String getName() {
        return name;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public Wand getWand() {
        return wand;
    }
}
