package com.isep.hpah.core.LogiqueJeu;

import java.util.*;

public class Spell {
    private String name;
    private int damage;

    private String resultSpell;

    public Spell(String name, int damage, String resultSpell) {
        this.name = name;
        this.damage = damage;
        this.resultSpell = resultSpell;
    }

    public int getDamage() {
        return damage;
    }

    public String getName() {
        return name;
    }

    public String getResultSpell() {
        return resultSpell;
    }

}



        /*public static void main(String args[])
        {
           ArrayList<String> knownSpells = new ArrayList<>();
           knownSpells.add("Expectro Patronum");
           knownSpells.add("Accio");
           knownSpells.add("Sectumsempra");
           knownSpells.add("Avada Kedavra");
           knownSpells.add("Expelliarmus");
           System.out.println(knownSpells);
        }*/

