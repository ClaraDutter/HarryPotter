package com.isep.hpah.core.LogiqueJeu;

import java.util.ArrayList;
import java.util.List;

public class Wizard extends Character {
    private Pet pet;
    private Wand wand;
    private House house;
    private Spell spell;
    private List<Potion> potions;

    private Weapon weapon;

    private List<Item> inventory;

    public void addToInventory(Item item) {
        this.inventory.add(item);
        System.out.println(item.getName() + "has been added to your inventory");
    }

    public Wizard(String name, int maxhp, int level, int damage, Pet pet, Wand wand, House house ) {
        super(name, maxhp, level, damage);
        this.pet = pet;
        this.wand = wand;
        this.house = house;
        this.potions = new ArrayList<>();
    }

    public Pet getPet() {
        return pet;
    }

    public List<Potion> getPotions() {
        return potions;
    }


    public House getHouse() {
        return house;
    }

    public Wand getWand() {
        return wand;
    }

    public Weapon getWeapon() {
        return weapon;
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

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public int defend() {
        return 0;
    }

    @Override
    public int attack() {
        return 0;
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
                System.out.println("huff");

                heal(potion.getHp() + 20);
            } else {
                heal(potion.getHp());
            }

            potion.drink(1);
        }else {
            System.out.println("You don't have enough potions :(");
        }
    }

    public void addToInventory(String fireworks, int fireworks1) {
    }


    //method to cause more damage if the wizard is Slytherin


    //method if the wizard is Gryffindor to resist more to the damages


    //method if the wizard is Ravenclaw to be more precise
}
