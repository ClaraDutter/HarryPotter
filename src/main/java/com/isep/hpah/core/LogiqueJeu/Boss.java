package com.isep.hpah.core.LogiqueJeu;

public class Boss extends AbstractEnemy {
    private String name;

    private int maxHp;

    private int damage;

    private Wand wand;

    public Boss(String name, int maxhp, int level) {
        super(name, maxhp, level);
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
