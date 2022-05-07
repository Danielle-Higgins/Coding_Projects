package design_patterns.singleton;

import java.util.Random;
import java.util.Scanner;

/**
 * The singleton that creates one math game
 * @author Danielle Higgins
 */
public class MathGame {
    private static MathGame mathGame;
    private int score;
    private Random rand;
    private Scanner reader;
    private String[] operands = {"+", "-", "*", "/"};

    /**
     * Creates the random and scanner objects as well as print a message
     */
    private MathGame() {
        rand = new Random();
        reader = new Scanner(System.in);
        System.out.println("Let's have fun with Math!");
    }

    /**
     * Creates an instance of MathGame if one doesn't already exists
     * @return The instance of MathGame
     */
    public static MathGame getInstance() {
        if (mathGame == null) {
            mathGame = new MathGame();
        }
        return mathGame;
    }

    /**
     * Allows the user to play the game as long as they want
     */
    public void play() {
        while (true) {
            System.out.println("(P)lay or (Q)uit:");
            String response = reader.next();
            if (response.equalsIgnoreCase("p")) {
                playRound();
            } else if (response.equalsIgnoreCase("q")) {
                System.out.println("You won " + score + " game(s)! \nGoodbye");
                System.exit(0);
            } else {
                System.out.println("Sorry, you must enter p or q");
            }
        }
    }

    /**
     * Generates a round the user will play
     * @return True or False based on correct answer
     */
    private boolean playRound() {
        int num = 1 + rand.nextInt(100);
        int num2 = 1 + rand.nextInt(100);
        int index = rand.nextInt(operands.length);
        double correct = 0;
        if (operands[index] == "+") {
            correct = num + num2;
        } else if (operands[index] == "-") {
            correct = num - num2;
        } else if (operands[index] == "*") {
            correct = num * num2;
        } else {
            correct =  num/num2;
        }
        System.out.println("Specify the whole number when dividing!");
        System.out.println(num + " " + operands[index]  + " " + num2 + " = ");
        int answer = reader.nextInt();
        if (answer == correct) {
            System.out.println("You got it!");
            score++;
            return true;
        } else {
            System.out.println("Too Bad! \nThe correct answer is " + correct);
            return false;
        }
    }
}
