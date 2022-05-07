package design_patterns.iterator;

import java.util.ArrayList;

/**
 * Holds information about the PT and adds the exercises
 * @author Danielle Higgins
 */
public class PT {
    private String firstName;
    private String lastName;
    private String bio;
    private Exercise[] exercises = new Exercise[2];
    private int numExercises = 0;

    /**
     * Creates the PT
     * @param firstName The firstname of PT
     * @param lastName The lastname of PT
     * @param bio The bio of PT
     */
    public PT(String firstName, String lastName, String bio) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bio = bio;
    }

    /**
     * Adds the exercises
     * @param title The title of exercise
     * @param muscleGroups The muscles associated with the exercise
     * @param directions The directions of the exercises
     */
    public void addExercise(String title, ArrayList<String> muscleGroups, ArrayList<String> directions) {
        Exercise exercise = new Exercise(title, muscleGroups, directions);
        if (numExercises == exercises.length) {
           exercises = growArray(exercises);
        }
        exercises[numExercises] = exercise;
        numExercises++;
    }

    /**
     * Displays the name
     * @return The firstname of PT
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Displays the name
     * @return The lastname of PT
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Displays the bio
     * @return The bio of PT
     */
    public String getBio() {
        return bio;
    }

    /**
     * Doubles the size of the exercises array
     * @param exercises The exercises array
     * @return The doubled size of the array
     */
    private Exercise[] growArray(Exercise[] exercises) {
        Exercise[] exercise = new Exercise[exercises.length * 2];
        for (int i = 0; i < exercises.length; i++) {
            exercise[i] = exercises[i];
        }
        return exercise;
    }

    /**
     * The iterator that iterates through the array
     * @return The iterator
     */
    public ExerciseIterator createIterator() {
        return new ExerciseIterator(exercises);
    }

    /**
     * Returns the string of the firstname, lastname, and bio in a certain way
     * @return String representation of firstname, lastname, and bio
     */
    public String toString() {
        return firstName + " " + lastName + "\n" + "" + bio + "\n";
    }
}
