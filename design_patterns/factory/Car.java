package design_patterns.factory;

import java.util.ArrayList;

/**
 * Keeps track of the cars based on different methods
 * @author Danielle Higgins
 */
public abstract class Car {
    private String make;
    private String model;
    protected ArrayList<Accessory> accessories;

    /**
     * Creates the car based on the make and model
     * @param make The make of the car
     * @param model The model of the car
     */
    public Car(String make, String model) {
        this.make = make;
        this.model = model;
        accessories = new ArrayList<Accessory>();
    }

    /**
     * Adds the different properties of the car while also displaying them
     */
    public void assemble() {
        addFrame();
        addWheels();
        addEngine();
        addWindows();
        addAccessories();
        displayAccessories();
    }

    /**
     * Abstract method which the children has to implement
     */
    protected abstract void addFrame();

    /**
     * Displays the wheels of the car
     */
    protected void addWheels() {
        System.out.println("Adding the Wheels");
    }

    /**
     * Displays the engine of the car
     */
    protected void addEngine() {
        System.out.println("Adding a Standard Engine");
    }

    /**
     * Displays the winddows of the car
     */
    protected void addWindows() {
        System.out.println("Adding Windows");
    }

    /**
     * Abstract method which the children has to implement
     */
    protected abstract void addAccessories();

    /**
     * Displays the accessories of the car
     */
    protected void displayAccessories() {
        System.out.println("Accessories:");

        for (Accessory a : accessories) {
            System.out.println("- " + a.name());
        }
    }
}
