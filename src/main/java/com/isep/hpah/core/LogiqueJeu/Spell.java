package com.isep.hpah.core.LogiqueJeu;



public class Spell extends AbstractSpell {
    private String resultSpell;

    public Spell(String name, int damage, String resultSpell) {
        super(name, damage);
        this.resultSpell = resultSpell;
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

