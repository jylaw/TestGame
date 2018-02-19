package com.company;

import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // system objects
        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        // game variable
        String[] enemies = {"Skeleton", "Zombie", "Warrior", "Assassin"};
        int maxEnemyHealth = 75;
        int enemyAttackDamage = 25;

        // player variable
        int health = 100;
        int maxHealth = 100;
        int attackDamage = 50;
        int numHpPotion = 3;
        int hpPotionHealAmount = 30;
        int hpPotionDropChance = 50; // percentage

        boolean running = true;

        System.out.println("Welcome to the Dungeon!");

        // label while loop as game
        GAME:
        while(running){
            System.out.println("------------------------------------------------");
            int enemyHealth = rand.nextInt(maxEnemyHealth);
            String enemy = enemies[rand.nextInt(enemies.length)];
            System.out.println("\t!!!--- " + enemy + " has appeared! ---!!!");

            while(enemyHealth > 0){
                System.out.println("\n\tYour HP: " + health);
                System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
                System.out.println("\n\tWhat would you like to do?");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Drink health potion");
                System.out.println("\t3. Run!");

                String input = in.nextLine();
                if(input.equals("1")){
                    int damageDealt = rand.nextInt(attackDamage);
                    int damageTaken = rand.nextInt(enemyAttackDamage);

                    enemyHealth -= damageDealt;
                    health -= damageTaken;

                    System.out.println("\t> You strike the " + enemy + " for " + damageDealt + " damage.");
                    System.out.println("\t> You received " + damageTaken + " damage in retaliation.");

                    if(health < 1){
                        System.out.println("\n\t> You have taken too much damage, you are too weak to go on!");
                        break;
                    }

                }
                else if(input.equals("2")){
                    if(numHpPotion > 0){
                        health += hpPotionHealAmount;
                        if(health > 100){
                            health = maxHealth;
                        }
                        numHpPotion--;
                        System.out.println("\t> You drink a health potion, healing yourself for " + hpPotionHealAmount
                                            + ".\n\t> You now have " + health + " HP.\n\t> You have " + numHpPotion
                                            + " health potions left.");

                        int damageTaken = rand.nextInt(enemyAttackDamage);
                        health -= damageTaken;
                        System.out.println("\t> You received " + damageTaken + " damage.");
                    }
                    else{
                        System.out.println("\t> You have no health potions left! Defeat enemies for a chance to get one!\n");
                    }
                }
                else if(input.equals("3")){
                    System.out.println("\t> You run away from the " + enemy + "!");
                    continue GAME;       // exit current loop into the main GAME loop
                }
                // check validation
                else{
                    System.out.println("\tInvalid command!");
                }

            }
            if(health < 1){
                System.out.println("\nYou limp out of the dungeon, weak from battle.");
                break;      // exit main GAME loop
            }
            System.out.println("------------------------------------------------");
            System.out.println(" # " + enemy + " was defeated! #");
            System.out.println(" # You have " + health + " HP left. #");
            if(rand.nextInt(100) < hpPotionDropChance){
                numHpPotion++;
                System.out.println(" # The " + enemy + " dropped a health potion! #");
                System.out.println(" # You now have " + numHpPotion + " health potion(s). #");
            }
            System.out.println("------------------------------------------------");
            System.out.println("What would you like to do now?");
            System.out.println("1. Continue fighting");
            System.out.println("2. Exit dungeon");

            String input = in.nextLine();

            while(!input.equals("1") && !input.equals("2")){
                System.out.println("Invalid command!");
                input = in.nextLine();
            }
            if(input.equals("1")){
                System.out.println("You continue on your adventure");
            }
            else if(input.equals("2")){
                System.out.println("You exit the dungeon, successful from your adventure!");
                break;
            }
        }
        System.out.println("------------------------------------------------");
        System.out.println("\t\t\tTHANK YOU FOR PLAYING!");
        System.out.println("------------------------------------------------");
    }
}
