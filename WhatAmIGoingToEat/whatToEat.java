package WhatAmIGoingToEat;

/**
 * Simple program that randomly generates what I am going to eat when I can't decide
 * 3/31/2022
 */
import java.util.Random;
import java.util.Scanner;

public class whatToEat {

    public static void main(String[] args) {
        
        Random rand = new Random();
        Scanner key = new Scanner(System.in);

        System.out.println("Enter the number of different foods you want to be randomly selected:");
        int num = key.nextInt();

        String[] foods = new String[num];

        System.out.println("\nEnter " + num + " different foods or restaurants you want randomly selected:");
        key.nextLine();

        for (int i = 0; i < num; i++) {
            foods[i] = key.nextLine();
        }

        // randomly chooses an index from foods
        int random = rand.nextInt(foods.length);

        // prints the value that is stored at that index
        System.out.println("\nWhat you will be eating today is (at): " + foods[random]);
        System.out.println("Goodbye!");

        /*
		//This just prints what's stored in the array to check myself
		for (int i = 0; i < num; i++) {
			System.out.println(foods[i]);
		} */

    }
}