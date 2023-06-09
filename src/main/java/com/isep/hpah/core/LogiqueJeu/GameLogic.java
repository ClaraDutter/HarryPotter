package com.isep.hpah.core.LogiqueJeu;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;



public class GameLogic {
    static Scanner scanner = new Scanner(System.in);
    private static ArrayList<House> houses;

    private static Wizard wizard;
    private static Enemy enemy;

    private static int currentLevel = 1;


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
        Wizard wizard1;

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
        Pet petName = null;
        Wand wand = null;
        House house = null;
        wizard = new Wizard(name, 100, 1, 0, petName, wand, house);
        System.out.println("Your name is " + name);

        //get the wand for the wizard
        System.out.println("Now, go to the Ollivander shop and discover which wand will you be given !");
        System.out.println("Hello, my name is Ollivander, I am glad to meet you. This is your time to know which wand " +
                "corresponds to you. For that, don't think about anything and let the magic begins...");
        wand = new Wand(choiceCore(), 20);
        wizard.setWand(wand);

        System.out.println("(a wand appears from nowhere) Look " + name + " ,your wand is composed of " + wand.getCore() +
                " and the size is " + wand.getSize() + "cm.");


        //get the pet for the wizard
        System.out.println("Now, it's time to choose your pet. Are you excited ? Let's go to the shop :)");
        System.out.println("Choose a pet among this list : ");
        for (Pet pet : Pet.values()) {
            System.out.println(pet.toString());
        }

        String choice = scanner.nextLine();
        petName= Pet.valueOf(choice.toUpperCase());
        wizard.setPet(petName);
        System.out.println("Your pet is " + petName);

        // resume all the features of the wizard
        System.out.println("Okay, you have everything that you need for your first day tomorrow at Poudlard. " +
                "Let's take some rest !");

        System.out.println("(The sun is rising...(first day at school) Don't panic, it's going to be okay." +
                "You are entering in the Dining Hall." + "You are going to be assigned to one House depending on your" +
                "personality thanks to the SortingHat.");

        System.out.println("It's your turn ! Go ahead and put the SortingHat on your head.");

        //get the house for the wizard
        int n = rand.nextInt(4);// contient un chiffre entre 0-3
        house = houses.get(n);
        wizard.setHouse(house);
        System.out.println("The SortingHat is deciding in which house you are...You are in " + house + " !");

        System.out.println("Congratulations! Now you have everything you need to start this adventure :) ");


        //print wizard information


        //condition for all the levels
        while (currentLevel <= 7) {
            switch (currentLevel) {
                case 1:
                    levelOne();
                    break;
                case 2:
                    levelTwo();
                    break;
                case 3:
                    levelThree();
                    break;
                case 4:
                    levelFour();
                    break;
                case 5:
                    levelFive();
                    break;
                case 6:
                    levelSix();
                    break;
                case 7:
                    levelSeven();
                    break;
            }
            currentLevel++;
        }
        System.out.println("Congratulations! You kill all enemies, the game is finished :) Hope you enjoy");

    }

    //Method for levelOne
    public static void levelOne() {
        System.out.println("**** Level One: The Philosopher's Stone ****");

        //initialization for level1
        Enemy enemy = new Enemy("Troll", 100, 1, "Toilets of the Donjon", "I dont' know yet", 20);
        Potion healingPotion = new Potion("healingPotion", 30, 3);
        Spell spell = new Spell("Wingardium Leviosa", 30,
                "The spell used is Wingardium Leviosa, " +
                        "you can use it to throw stones at the troll");

        int wizardHp = 100;
        int enemyHp = enemy.getMaxhp();
        int quantityPotions = 3;

        //loop for the fight whereas one of us is not dead
        while (wizardHp > 0 && enemyHp > 0) {
            //Wizard's turn
            System.out.println("It's your turn. What do you want to do ?");
            System.out.println("1. Cast a spell");
            System.out.println("2. Drink a potion");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.println("house " + wizard.getHouse().getName());
                if (wizard.getHouse().getName().equals("Slytherin")) {
                    enemyHp -= (int) (spell.getDamage() * 1.5);
                } else {
                    System.out.println("You cast the spell " + spell.getName() + " !");
                    enemyHp -= spell.getDamage();

                    System.out.println(spell.getResultSpell());
                }
            }

            else if (choice == 2) {
                if (quantityPotions > 0) {

                    wizard.drinkPotion(Potion.potion1());


                    /*wizardHp = Math.min(wizardHp + healingPotion.getHp(), 100);
                    quantityPotions--;
                    System.out.println("You can drink this potion and take back " + healingPotion.getHp() + " healing points.");
                    System.out.println("You now have " + quantityPotions + " potions");*/

                } else {
                    System.out.println("There are no more potions available.");
                }
            } else {
                System.out.println("Invalid choice, you can't play wait for your turn.");
            }


            //display the total of each character
            System.out.println("Enemy's healing points: " + enemyHp);
            System.out.println("Your healing points: " + wizardHp);

            //we verify if the enemy is dead
            if (enemyHp <= 0) {
                System.out.println("You win against " + enemy.name + " !");
                break;
            }

            //Enemy's turn
            System.out.println("It is the turn of " + enemy.name);
            int enemyDamage = enemy.attack();
            if (wizard.getHouse().getName().equals("Gryffondor")) {
                enemyDamage = (int) (enemyDamage * 0.8);
                System.out.println("You are resisting better because of your house");
            } else if (wizard.getHouse().getName().equals("Ravenclaw")) {
                enemyDamage = (int) (enemyDamage * 1.2);
                System.out.println();
            }
            wizardHp -= enemy.attack();
            System.out.println("You lost " + enemy.getDamage() + " healing points");

            //display the total of each character
            System.out.println("Enemy's healing points: " + enemyHp);
            System.out.println("Your healing points: " + wizardHp);

            //we verify if the wizard is dead
            if (wizardHp <= 0) {
                System.out.println("You have been beaten by " + enemy.name + " !");
                gameOver();
                return;
            }
        }

        //end of the fight: the wizard
        System.out.println("End of the game !");
        System.out.println("");
        wizardHp = 150;
        quantityPotions += 2;
    }


    public static void levelTwo() {
        System.out.println("**** Level Two: The Chamber of Secrets ****");
        System.out.println("");

        //initialization for level1
        Enemy enemy = new Enemy("Basilik", 120, 2, "Chamber of Secrets", "I dont' know yet", 20);
        Potion healingPotion = new Potion("healingPotion", 30, 3);
        Spell spell = new Spell("Accio", 40,
                "The spell used is Accio, " +
                        "you can use it to catch le Croc of the Basilik");
        Weapon weapon = new Weapon("Sword Of Gryffondor", 50);
        int wizardHp = 150;
        int enemyHp = enemy.getMaxhp();
        int quantityPotions = 5;

        //loop for the fight whereas one of us is not dead
        while (wizardHp > 0 && enemyHp > 0) {
            //Wizard's turn
            System.out.println("It's your turn. What do you want to do ?");
            System.out.println("1. Cast a spell");
            System.out.println("2. Drink a potion");
            System.out.println("3. Use a weapon");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.println("You cast the spell " + spell.getName() + " !");
                enemyHp -= spell.getDamage();
                if (enemyHp <= 0) {
                    enemyHp = 0;
                    break;
                }
                String spellResult = (spell.getResultSpell());


            } else if (choice == 2) {
                if (quantityPotions > 0) {

                    wizardHp = Math.min(wizardHp + healingPotion.getHp(), 100);
                    quantityPotions--;
                    System.out.println("You can drink this potion and take back " + healingPotion.getHp() + " healing points.");
                    System.out.println("You now have " + quantityPotions + " potions");
                } else {
                    System.out.println("There are no more potions available.");
                }

            } else if (choice == 3) {
                System.out.println("You use your " + weapon.getName() + " !");
                enemyHp -= weapon.getDamage();
            } else {
                System.out.println("Invalid choice, you can't play wait for your turn.");

            }

            //display the total of each character
            System.out.println("Enemy's healing points: " + enemyHp);
            System.out.println("Your healing points: " + wizardHp);

            //we verify if the enemy is dead
            if (enemyHp <= 0) {
                System.out.println("You win against " + enemy.name + " !");
                break;
            }

            //Enemy's turn
            System.out.println("It is the turn of " + enemy.name);
            wizardHp -= enemy.attack();
            System.out.println("You lost " + enemy.getDamage() + " healing points");

            //display the total of each character
            System.out.println("Enemy's healing points: " + enemyHp);
            System.out.println("Your healing points: " + wizardHp);

            //we verify if the wizard is dead
            if (wizardHp <= 0) {
                System.out.println("You have been beaten by " + enemy.name + " !");
                gameOver();
                return;
            }
        }

        //end of the fight: the wizard
        System.out.println("End of the game !");
        System.out.println("");
        wizardHp = 150;
        quantityPotions += 2;
    }


    public static void levelThree() {
        System.out.println("**** Level Three: The Prisonner of Azkaban ****");
        System.out.println("");

        //initialization for level"
        Enemy enemy = new Enemy("Dementors", 150, 3, "Lake in the Forbidden Forest", "I dont' know yet", 50);
        Potion healingPotion = new Potion("healingPotion", 30, 3);
        Spell spell = new Spell("Expecto Patronum", 60,
                "The spell used is Expecto Patronum, " +
                        "you can use it to make appear your Patronus");

        int wizardHp = 150;
        int enemyHp = enemy.getMaxhp();
        int quantityPotions = 5;

        //loop for the fight whereas one of us is not dead
        while (wizardHp > 0 && enemyHp > 0) {
            //Wizard's turn
            System.out.println("It's your turn. What do you want to do ?");
            System.out.println("1. Cast a spell");
            System.out.println("2. Drink a potion");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.println("You cast the spell " + spell.getName() + " !");
                enemyHp -= spell.getDamage();
                if (enemyHp <= 0) {
                    enemyHp = 0;
                    break;
                }
                String spellResult = (spell.getResultSpell());


            } else if (choice == 2) {
                if (quantityPotions > 0) {

                    wizardHp = Math.min(wizardHp + healingPotion.getHp(), 100);
                    quantityPotions--;
                    System.out.println("You can drink this potion and take back " + healingPotion.getHp() + " healing points.");
                    System.out.println("You now have " + quantityPotions + " potions");
                } else {
                    System.out.println("There are no more potions available.");
                }
            }

            //display the total of each character
            System.out.println("Enemy's healing points: " + enemyHp);
            System.out.println("Your healing points: " + wizardHp);

            //we verify if the enemy is dead
            if (enemyHp <= 0) {
                System.out.println("You win against " + enemy.name + " !");
                break;
            }

            //Enemy's turn
            System.out.println("It is the turn of " + enemy.name);
            wizardHp -= enemy.attack();
            System.out.println("You lost " + enemy.getDamage() + " healing points");

            //display the total of each character
            System.out.println("Enemy's healing points: " + enemyHp);
            System.out.println("Your healing points: " + wizardHp);

            //we verify if the wizard is dead
            if (wizardHp <= 0) {
                System.out.println("You have been beaten by " + enemy.name + " !");
                gameOver();
                return;
            }
        }

        //end of the fight: the wizard
        System.out.println("End of the game !");
        System.out.println("");
        wizardHp = 200;
        quantityPotions += 3;
    }

    public static void levelFour() {
        System.out.println("**** Level Four: The Goblet of Fire ****");
        System.out.println("");
        //initialization for level1
        Enemy enemy = new Enemy("Voldemort and Peter Pettigrow", 120, 4, "Graveyard of Little Hangleton", "I dont' know yet", 20);
        Potion healingPotion = new Potion("healingPotion", 30, 3);
        Spell spell = new Spell("Accio", 40,
                "The spell used is Accio, " +
                        "you can use it to attract the Portolion");
        int wizardHp = 150;
        int enemyHp = enemy.getMaxhp();
        int quantityPotions = 5;

        //loop for the fight whereas one of us is not dead
        while (wizardHp > 0 && enemyHp > 0) {
            //Wizard's turn
            System.out.println("It's your turn. What do you want to do ?");
            System.out.println("1. Cast a spell");
            System.out.println("2. Drink a potion");
            System.out.println("3. Use a weapon");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.println("You cast the spell " + spell.getName() + " !");
                enemyHp -= spell.getDamage();
                if (enemyHp <= 0) {
                    enemyHp = 0;
                    break;
                }
                String spellResult = (spell.getResultSpell());


            } else if (choice == 2) {
                if (quantityPotions > 0) {

                    wizardHp = Math.min(wizardHp + healingPotion.getHp(), 100);
                    quantityPotions--;
                    System.out.println("You can drink this potion and take back " + healingPotion.getHp() + " healing points.");
                    System.out.println("You now have " + quantityPotions + " potions");
                } else {
                    System.out.println("There are no more potions available.");
                }
            }

            //display the total of each character
            System.out.println("Enemy's healing points: " + enemyHp);
            System.out.println("Your healing points: " + wizardHp);

            //we verify if the enemy is dead
            if (enemyHp <= 0) {
                System.out.println("You win against " + enemy.name + " !");
                break;
            }

            //Enemy's turn
            System.out.println("It is the turn of " + enemy.name);
            wizardHp -= enemy.attack();
            System.out.println("You lost " + enemy.getDamage() + " healing points");

            //display the total of each character
            System.out.println("Enemy's healing points: " + enemyHp);
            System.out.println("Your healing points: " + wizardHp);

            //we verify if the wizard is dead
            if (wizardHp <= 0) {
                System.out.println("You have been beaten by " + enemy.name + " !");
                gameOver();
                return;
            }
        }

        //end of the fight: the wizard
        System.out.println("End of the game !");
        System.out.println("");
        wizardHp = 150;
        quantityPotions += 2;
    }


    public static void levelFive() {
        System.out.println("**** Level Five: The Order of the Phoenix ****");
        System.out.println("");
        //initialization for level1
        Enemy enemy = new Enemy("Dolores Ombrage", 120, 5, "Hogwarts Exam Hall", "I dont' know yet", 20);
        Potion healingPotion = new Potion("healingPotion", 30, 3);
        Spell spell = new Spell("Accio", 40,
                "The spell used is Accio, " +
                        "you can use it to catch le Croc of the Basilik");
        Weapon weapon = new Weapon("Sword Of Gryffondor", 50);
        int wizardHp = 150;
        int enemyHp = enemy.getMaxhp();
        int quantityPotions = 5;
        int fireworks = 5;

        //loop for the fight whereas one of us is not dead
        while (wizardHp > 0 && enemyHp > 0) {
            //Wizard's turn
            System.out.println("It's your turn. What do you want to do ?");
            System.out.println("1. Cast a spell");
            System.out.println("2. Drink a potion");
            System.out.println("3. Use a weapon");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.println("You cast the spell " + spell.getName() + " !");
                enemyHp -= spell.getDamage();
                if (enemyHp <= 0) {
                    enemyHp = 0;
                    break;
                }
                String spellResult = (spell.getResultSpell());


            } else if (choice == 2) {
                if (quantityPotions > 0) {

                    wizardHp = Math.min(wizardHp + healingPotion.getHp(), 100);
                    quantityPotions--;
                    System.out.println("You can drink this potion and take back " + healingPotion.getHp() + " healing points.");
                    System.out.println("You now have " + quantityPotions + " potions");
                } else {
                    System.out.println("There are no more potions available.");
                }

            } else if (choice == 3) {
                System.out.println("You use your " + weapon.getName() + " !");
                enemyHp -= weapon.getDamage();
            } else {
                System.out.println("Invalid choice, you can't play wait for your turn.");

            }

            //display the total of each character
            System.out.println("Enemy's healing points: " + enemyHp);
            System.out.println("Your healing points: " + wizardHp);

            //we verify if the enemy is dead
            if (enemyHp <= 0) {
                System.out.println("You win against " + enemy.name + " !");
                fireworks++;
                wizard.addToInventory("Fireworks", fireworks);
                break;
            }

            //Enemy's turn
            System.out.println("It is the turn of " + enemy.name);
            wizardHp -= enemy.attack();
            System.out.println("You lost " + enemy.getDamage() + " healing points");

            //display the total of each character
            System.out.println("Enemy's healing points: " + enemyHp);
            System.out.println("Your healing points: " + wizardHp);

            //we verify if the wizard is dead
            if (wizardHp <= 0) {
                System.out.println("You have been beaten by " + enemy.name + " !");
                gameOver();
                return;
            }
        }

        //end of the fight: the wizard
        System.out.println("End of the game !");
        System.out.println("");

        wizardHp = 150;
        quantityPotions += 2;
    }



    public static void levelSix() {
        System.out.println("**** Level Six: The Half-Blood Prince ****");
        System.out.println("");
        //initialization for level1
        Enemy enemy = new Enemy("The Eath Eaters", 120, 6, "Astronomy Tower", "I dont' know yet", 20);
        Potion healingPotion = new Potion("healingPotion", 30, 3);
        Spell spell = new Spell("Sectumsempra", 40,
                "The spell used is Sectumsempra, " +
                        "you can use it to kill the Death Eaters");

        int wizardHp = 150;
        int enemyHp = enemy.getMaxhp();
        int quantityPotions = 5;

        //proposition to wizard to join the Death Eaters if he is from Slytherin
        if (wizard.getHouse().equals("Slytherin")) {
            System.out.println("As a Slytherin, you can join if you want the Death Eaters's team.");
            System.out.println("Do you want it ? If this case, you become an ally of Voldemort and the game is finished (yes/no)");
            String choice = scanner.nextLine();
            if (choice.equals("yes")) {
                System.out.println("You have joined the Death Eaters. End of the game, replay to have a different ending :) ");
                return;
            }
        }

        //loop for the fight whereas one of us is not dead
        while (wizardHp > 0 && enemyHp > 0) {
            //Wizard's turn
            System.out.println("It's your turn. What do you want to do ?");
            System.out.println("1. Cast a spell");
            System.out.println("2. Drink a potion");
            System.out.println("3. Use a weapon");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.println("You cast the spell " + spell.getName() + " !");
                enemyHp -= spell.getDamage();
                if (enemyHp <= 0) {
                    enemyHp = 0;
                    break;
                }
                String spellResult = (spell.getResultSpell());


            } else if (choice == 2) {
                if (quantityPotions > 0) {

                    wizardHp = Math.min(wizardHp + healingPotion.getHp(), 100);
                    quantityPotions--;
                    System.out.println("You can drink this potion and take back " + healingPotion.getHp() + " healing points.");
                    System.out.println("You now have " + quantityPotions + " potions");
                } else {
                    System.out.println("There are no more potions available.");
                }
            }

            //display the total of each character
            System.out.println("Enemy's healing points: " + enemyHp);
            System.out.println("Your healing points: " + wizardHp);

            //we verify if the enemy is dead
            if (enemyHp <= 0) {
                System.out.println("You win against " + enemy.name + " !");
                break;
            }

            //Enemy's turn
            System.out.println("It is the turn of " + enemy.name);
            wizardHp -= enemy.attack();
            System.out.println("You lost " + enemy.getDamage() + " healing points");

            //display the total of each character
            System.out.println("Enemy's healing points: " + enemyHp);
            System.out.println("Your healing points: " + wizardHp);

            //we verify if the wizard is dead
            if (wizardHp <= 0) {
                System.out.println("You have been beaten by " + enemy.name + " !");
                gameOver();
                return;
            }
        }

        //end of the fight: the wizard
        System.out.println("End of the game !");
        System.out.println("");
        wizardHp = 150;
        quantityPotions += 2;
    }



    public static void levelSeven() {
        System.out.println("**** Level Seven: The Deathly Hallows ****");
        System.out.println("");
        //initialization for level1
        Enemy enemy = new Enemy("Voldemort and Bellatrix Lestrange", 120, 7, "Chamber of Secrets", "I dont' know yet", 20);
        Potion healingPotion = new Potion("healingPotion", 30, 3);
        Spell spell = new Spell("Ava Kedavra", 40,
                "The spell used is Accio, " +
                        "you can use it to catch le Croc of the Basilik");

        int wizardHp = 150;
        int enemyHp = enemy.getMaxhp();
        int quantityPotions = 5;

        //loop for the fight whereas one of us is not dead
        while (wizardHp > 0 && enemyHp > 0) {
            //Wizard's turn
            System.out.println("It's your turn. What do you want to do ?");
            System.out.println("1. Cast a spell");
            System.out.println("2. Drink a potion");
            System.out.println("3. Use a weapon");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.println("You cast the spell " + spell.getName() + " !");
                enemyHp -= spell.getDamage();
                if (enemyHp <= 0) {
                    enemyHp = 0;
                    break;
                }
                String spellResult = (spell.getResultSpell());


            } else if (choice == 2) {
                if (quantityPotions > 0) {

                    wizardHp = Math.min(wizardHp + healingPotion.getHp(), 100);
                    quantityPotions--;
                    System.out.println("You can drink this potion and take back " + healingPotion.getHp() + " healing points.");
                    System.out.println("You now have " + quantityPotions + " potions");
                } else {
                    System.out.println("There are no more potions available.");
                }
            }

            //display the total of each character
            System.out.println("Enemy's healing points: " + enemyHp);
            System.out.println("Your healing points: " + wizardHp);

            //we verify if the enemy is dead
            if (enemyHp <= 0) {
                System.out.println("You win against " + enemy.name + " !");
                break;
            }

            //Enemy's turn
            System.out.println("It is the turn of " + enemy.name);
            wizardHp -= enemy.attack();
            System.out.println("You lost " + enemy.getDamage() + " healing points");

            //display the total of each character
            System.out.println("Enemy's healing points: " + enemyHp);
            System.out.println("Your healing points: " + wizardHp);

            //we verify if the wizard is dead
            if (wizardHp <= 0) {
                System.out.println("You have been beaten by " + enemy.name + " !");
                gameOver();
                return;
            }
        }

        //end of the fight: the wizard
        System.out.println("End of the game !");
        System.out.println("");
        wizardHp = 150;
        quantityPotions += 2;
    }


    private static void gameOver() {
        System.out.println("GAME OVER");
        System.exit(0);
    }


}







