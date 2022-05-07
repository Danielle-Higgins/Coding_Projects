package design_patterns.factory;

/**
 * Keeps track of what makes a luxury car
 * @author Danielle Higgins
 */
public class LuxuryCar extends Car{
    
    /**
     * Creates a luxury car
     * @param make The make of the car
     * @param model The model of the car
     */
    public LuxuryCar(String make, String model) {
        super(make, model);
    }

    /**
     * Displays the frame of the car
     */
    protected void addFrame() {
        System.out.println("Adding a beautiful frame");
    }

    /**
     * Displays the engine of the car
     */
    @Override
    protected void addEngine() {
        System.out.println("Adding a Supped up Engine");
    }

    /**
     * Adds the accessories that make up a luxury car
     */
    protected void addAccessories() {
        accessories.add(Accessory.FLOOR_MATTS);
        accessories.add(Accessory.PHONE_CHARGER);
        accessories.add(Accessory.BACK_UP_CAMERA);
        accessories.add(Accessory.EXTRA_CUP_HOLDERS);
        accessories.add(Accessory.HEATED_SEATS);
        accessories.add(Accessory.SPORTS_SEATS);
        accessories.add(Accessory.WINDOW_TINT);
        accessories.add(Accessory.HIGH_END_SOUND);
        accessories.add(Accessory.TRUNK_ORGANIZER);
        accessories.add(Accessory.BLUE_TOOTH);
    }
}
