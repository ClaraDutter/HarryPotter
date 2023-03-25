
package com.isep.hpah.core.LogiqueJeu;

public abstract class AbstractSpell {
    private String name;
    private int damage;

    public AbstractSpell(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public String getName() {
        return name;
    }
}



