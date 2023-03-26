package com.isep.hpah.core.LogiqueJeu;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;


public class GameLogic {
    static Scanner scanner = new Scanner(System.in);
    private static ArrayList<House> houses;

    static Wizard wizard;

    public static Core choiceCore() {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        Random core = new Random();
        int coreindex = threadLocalRandom.nextInt(Core.values().length);
        return Core.values()[coreindex];
    }


    //method to start the game
    public static void startGame() {
        houses = new ArrayList<House>();
        House Hufflepuff = new House("Hufflepuff");
        House Gryffindor = new House("Gryffindor");
        House Ravenclaw = new House("Ravenclaw");
        House Slytherin = new House("Slytherin");

        houses.add(Hufflepuff);
        houses.add(Gryffindor);
        houses.add(Ravenclaw);
        houses.add(Slytherin);

        boolean gameName = false;
        Random rand = new Random();

        //print title screen
        System.out.println("Harry Potter at Home");
        System.out.println("Text RPG by Clara Dutter");

        //introduction to the game
        System.out.println("Welcome to the Harry Potter at Home game, " +
                "the RPG for wizards. Do you have what it takes to be the greatest wizard?" +
                "Can you meet all the challenges ? Let's get started !" +
                "Your goal is to complete your education.");

        //get the name of the player for his/her wizard
        System.out.println("\nWhat is your wizard's name ?");
        String name = scanner.nextLine();
        System.out.println("Your name is " + name);

        //get the wand for the wizard
        System.out.println("Now, go to the Ollivander shop and discover which wand will you be given !");
        System.out.println("Hello, my name is Ollivander, I am glad to meet you. This is your time to know which wand " +
                "corresponds to you. For that, don't think about anything and let the magic begins...");
        Wand wand = new Wand(choiceCore(), 20);

        System.out.println("(a wand appears from nowhere) Look " + name + " ,your wand is composed of " + wand.getCore() +
                " and the size is " + wand.getSize() + "cm.");


        //get the pet for the wizard
        System.out.println("Now, it's time to choose your pet. Are you excited ? Let's go to the shop :)");
        System.out.println("Choose a pet among this list : ");
        for (Pet pet : Pet.values()) {
            System.out.println(pet.toString());
        }

        String choice = scanner.nextLine();
        Pet chosenPet = Pet.valueOf(choice.toUpperCase());
        System.out.println("Your pet is " + chosenPet);

        // resume all the features of the wizard
        System.out.println("Okay, you have everything that you need for your first day tomorrow at Poudlard. " +
                "Let's take some rest !");

        System.out.println("(The sun is rising...(first day at school) Don't panic, it's going to be okay." +
                "You are entering in the Dining Hall." + "You are going to be assigned to one House depending on your" +
                "personality thanks to the SortingHat.");

        System.out.println("It's your turn ! Go ahead and put the SortingHat on your head.");

        //get the house for the wizard
        int n = rand.nextInt(4);// contient un chiffre entre 0-3
        House house = houses.get(n);
        System.out.println("The SortingHat is deciding in which house you are...You are in " + house.getName() + " !");

        System.out.println("Congratulations! Now you have everything you need to start this adventure :) ");

        //initialize everything the wizard needs to start level 1
        Potion healingPotion = new Potion("healingPotion", 50, 3);
        Spell useSpell = new Spell("Wingardium Leviosa", 30, "The spell used is Wingardium Leviosa, you can use it to throw stones at the troll");

        //start the level 1
        class GameManager {
            private int MAX_LEVEL = 7;
            private int maxhp = 100;
            private int Initial_enemy_hp = 100;

            private int currentLevel;
            private Wizard wizard;
            private Enemy enemy;

            public GameManager() {
                wizard = new Wizard(maxhp);
                currentLevel = 1;


                while (currentLevel <= MAX_LEVEL) {
                    System.out.println("This is the level : " + currentLevel);
                    enemy = levelEnemy(currentLevel);
                    playLevel();

                }

            }
            private Enemy levelEnemy(int currentLevel) {
                    if (currentLevel == 1) {
                        return new Enemy("Troll", 100, 10, "I beat you with 10 points of damage", 1);
                    } else if (currentLevel == 2) {
                        return new Enemy("Basilisk", 120, 20, "I am going to bite you tssss, 20 points of damage", 2);
                    } else if (currentLevel == 3) {
                        return new Enemy("Dementor", 140, 30, "I am going to suck your soul with 30 points of damage", 3);
                    } else if (currentLevel == 4) {
                        return new Enemy("Voldemort and Peter Pettigrow", 160, 50, "This is your time to die young wizard, this is a spell with 50 points of damage", 4);
                    } else if (currentLevel == 5) {
                        return new Enemy("Dolores Ombrage", 180, 60, "I controll you, don't try to escape me, 60 points of damage", 5);
                    } else if (currentLevel == 6) {
                        return new Enemy("Death Eaters", 190, 80, "We are with Voldemort, there is nothing you can do to beat us", 6);
                    } else if (currentLevel == 7) {
                        return new Enemy("Voldemort and Bellatrix Lestrange", 200, 100, "We are the final boss, come defy us !", 7);
                    }
                    return null;
                }
            }

        }
    }







