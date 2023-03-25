package com.isep.hpah.core.LogiqueJeu;

public class Enemy extends AbstractEnemy {
    private int damage;

    private int level;

    private String sentence;


    public Enemy(String name, int maxhp, int damage, String sentence, int level) {
        super(name, maxhp, level);
        this.name = name;
        this.maxhp = maxhp;
        this.damage = damage;
        this.level = level;

    }
}
