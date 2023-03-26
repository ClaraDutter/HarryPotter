package com.isep.hpah.core.LogiqueJeu;

public class Enemy extends AbstractEnemy {
    private int damage;

    private int level;

    private String sentence;



    public Enemy(String name, int maxhp, int level, String location, String sentence, int damage) {
        super(name, maxhp, level, location, damage);
        this.name = name;
        this.maxhp = maxhp;
        this.damage = damage;
        this.level = level;
        this.sentence = sentence;
        this.location = location;

    }

    public int attack() {
        return damage;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public int getMaxhp() {
        return super.getMaxhp();
    }
}
