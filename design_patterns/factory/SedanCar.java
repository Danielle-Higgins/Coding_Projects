package design_patterns.factory;

/**
 * Keeps track of what makes a sedan car
 * @author Danielle Higgins
 */
public class SedanCar extends Car {
    
    /**
     * Creates a sedan car
     * @param make The make of the car
     * @param model The model of the car
     */
    public SedanCar(String make, String model) {
        super(make, model);
    }

    /**
     * Displays the frame of the car
     */
    protected void addFrame() {
        System.out.println("Adding a three part frame");
    }

    /**
     * Adds the accessories that make up a sedan car
     */
    protected void addAccessories() {
        accessories.add(Accessory.FLOOR_MATTS);
        accessories.add(Accessory.PHONE_CHARGER);
        accessories.add(Accessory.BACK_UP_CAMERA);
        accessories.add(Accessory.EXTRA_CUP_HOLDERS);
        accessories.add(Accessory.HEATED_SEATS);
    }
}
