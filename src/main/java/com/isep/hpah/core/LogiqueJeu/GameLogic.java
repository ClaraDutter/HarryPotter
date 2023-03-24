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

        //get the house for the wizard
        int n = rand.nextInt(4);// contient un chiffre entre 0-3
        House house = houses.get(n);
        System.out.println("The SortingHat is deciding in which house you are...You are in " + house.getName() + " !");

        //get the wand for the wizard
        System.out.println("Now, go to the Ollivander shop and discover which wand will you be given !");
        System.out.println("Hello, my name is Ollivander, I am glad to meet you. This is your time to know which wand " +
                "corresponds to you. For that, don't think about anything and let the magic begins...");
        Wand wand = new Wand(choiceCore(), 20);

        System.out.println("(a wand appears from nowhere) Look " + name + " ,your wand is composed of " + wand.getCore() +
                " and the size is " + wand.getSize() + "cm.");

        System.out.println("Now, it's time to choose your pet. Are you excited ? Let's go to the shop :)");

        Pet chosenAnimal = listAnimal()









    }
}
