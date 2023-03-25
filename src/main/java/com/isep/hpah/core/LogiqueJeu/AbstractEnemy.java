package com.isep.hpah.core.LogiqueJeu;

public abstract class AbstractEnemy {
    //Variables/Attributes all characters have
    public String name;
    public int maxhp, hp, level;

    public AbstractEnemy(String name, int maxhp, int level) {
        this.name = name;
        this.maxhp = maxhp;
        this.level = level;
    }

    }
