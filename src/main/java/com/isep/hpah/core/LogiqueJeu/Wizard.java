package com.isep.hpah.core.LogiqueJeu;

import java.util.List;

public class Wizard extends Character {
    private Pet pet;
    private Wand wand;
    private House house;
    private Spell spell;
    private List<Potion> potions;


    public Wizard(String name, int maxhp, int level,
                  Pet pet, Wand wand, House house, Spell spell, List<Potion> potions) {
        super(name, maxhp, level);
        this.pet = pet;
        this.wand = wand;
        this.house = house;
        this.potions = potions;
        this.spell = spell;
    }

    public Pet getPet() {
        return pet;
    }

    public House getHouse() {
        return house;
    }

    public Wand getWand() {
        return wand;
    }

    //setters
    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public void setSpell(Spell spell) {
        this.spell = spell;
    }

    public void setPotions(List<Potion> potions) {
        this.potions = potions;
    }

    public void setWand(Wand wand) {
        this.wand = wand;
    }

    public int defend() {
        return 0;
    }

    @Override
    public int attack() {
        return 0;
    }

    //method to choose a random Pet in the enumeration
    public static void chosePet(Pet pet) {
        RandomEnum<Pet> r = new RandomEnum<Pet>(Pet.class);
        System.out.println(r.random());
    }


    //method for life recovery
    public void heal(int healPoint){
        if((hp + healPoint) > maxhp){
            hp = maxhp;
        } else {
            hp = hp + healPoint;
        }
    }

    //method to make the wizard drinks the potion
    public void drinkPotion(Potion potion) {
        if(potion.getQuantity() > 0) {

            if ((this.house.getName()).equals("Hufflepuff")) {
                heal((int) (potion.getHp()*1.2));
            } else {
                heal(potion.getHp());
            }

            potion.drink(1);
        }else {
            System.out.println("You don't have enough potions :(");
        }
    }
}