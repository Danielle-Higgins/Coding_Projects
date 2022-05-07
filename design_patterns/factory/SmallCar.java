package design_patterns.factory;

/**
 * Keeps track of what makes a sedan car
 * @author Danielle Higgins
 */
public class SmallCar extends Car {
    
    /**
     * Creates a small car
     * @param make The make of the car
     * @param model The model of the car
     */
    public SmallCar(String make, String model) {
        super(make, model);
    }

    /**
     * Displays the frame of the car
     */
    protected void addFrame() {
        System.out.println("Adding a small frame");
    }

    /**
     * Adds the accessories that make up a small car
     */
    protected void addAccessories() {
        accessories.add(Accessory.FLOOR_MATTS);
        accessories.add(Accessory.PHONE_CHARGER);
    }
}
