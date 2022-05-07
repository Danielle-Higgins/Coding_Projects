package design_patterns.factory;

/**
 * Uses a method to create the car
 * @author Danielle Higgins
 */
public class CarFactory {
    
    /**
     * Creates the car based on the type passed in
     * @param type The type of car, small, sedan, and/or luxury
     * @param make The make of the car
     * @param model The model of the car
     * @return The car
     */
    public static Car createCar(String type, String make, String model) {
        Car car = null;

        if (type.equalsIgnoreCase(CarType.SMALL.toString())) {
            System.out.println("Creating a " + make + " " + model);
            car = new SmallCar(make, model);
        } else if (type.equalsIgnoreCase(CarType.SEDAN.toString())) {
            System.out.println("Creating a " + make + " " + model);
            car = new SedanCar(make, model);
        } else if (type.equalsIgnoreCase(CarType.LUXURY.toString())) {
            System.out.println("Creating a " + make + " " + model);
            car = new LuxuryCar(make, model);
        }
        
        car.assemble();
        return car;
    }
}
