package design_patterns.decorator;

import java.util.Random;

/**
 * Adds random casing to password
 * @author Danielle Higgins
 */
public class RandomCasing extends PasswordDecorator {
    
    /**
     * Allows the password to be built upon
     * @param passwordBeginning The generated password
     */
    public RandomCasing(Password passwordBeginning) {
        super(passwordBeginning);
    }

    /**
     * Builds upon the inputted password and adds random casing
     * @return The password that will have upper or lower case casing
     */
    public String getPassword() {
        Random r = new Random();
        int num = r.nextInt(101);
        String pass = "";
        if (num <= 50) {
            pass = passwordBeginning.getPassword().toUpperCase();
        } else {
            pass = passwordBeginning.getPassword().toLowerCase();
        }
        return pass;
    }
}
