package design_patterns.iterator;

import java.util.ArrayList;

public class Gym {
    public Gym(){}

    public void run(){
        PT ashley = new PT("Ashley", "James", "Ashley is in her 3rd year of PT, and specializes in body weight exercises");

        //Creating exercise 1
        ArrayList<String> LungeMuscles = new ArrayList<String>();
        LungeMuscles.add("Quads");
        LungeMuscles.add("Glutes");
        LungeMuscles.add("Hamstrings");

        ArrayList<String> lungeDirections = new ArrayList<String>();
        lungeDirections.add("Take a step forward with your leg");
        lungeDirections.add("Bend your knees");
        lungeDirections.add("Lower tojust above the ground");
        lungeDirections.add("Slowely stand back up");

        ashley.addExercise("Lunges", LungeMuscles, lungeDirections);

        //Creating exercise 2
        ArrayList<String> pushupMuscles = new ArrayList<String>();
        pushupMuscles.add("Quads");
        pushupMuscles.add("Glutes");
        pushupMuscles.add("Hamstrings");

        ArrayList<String> pushupDirections = new ArrayList<String>();
        pushupDirections.add("Start in a plank position");
        pushupDirections.add("Bend elbows");
        pushupDirections.add("Slowely lower down");
        pushupDirections.add("Slowely push up with elbows");

        ashley.addExercise("Pushups", pushupMuscles, pushupDirections);

        //Creating exercise 3
        ArrayList<String> SkippingMuscles = new ArrayList<String>();
        SkippingMuscles.add("Quads");
        SkippingMuscles.add("Glutes");
        SkippingMuscles.add("Hamstrings");

        ArrayList<String> SkippingDirections = new ArrayList<String>();
        SkippingDirections.add("Start with the rope behind you");
        SkippingDirections.add("Swing it above your head, and in front of you");
        SkippingDirections.add("Jump over the rope");
        SkippingDirections.add("Repeat");

        ashley.addExercise("Jumping Rope", SkippingMuscles, SkippingDirections);

        System.out.println(ashley);

        ExerciseIterator eIterator = ashley.createIterator();
        displayExercises(eIterator);
        

    }

    private void displayExercises(ExerciseIterator eIterator){
        System.out.println("Exercises: ");
        while(eIterator.hasNext()) {
            Exercise exercise = eIterator.next();
            System.out.print(exercise.toString());
        }
    }

    public static void main(String[] args){
        Gym gym = new Gym();
        gym.run();
    }
}

