package design_patterns.decorator;

import java.util.Random;

/**
 * Adds special characters to password
 * @author Danielle Higgins
 */
public class SpecialChars extends PasswordDecorator{
    
    /**
     * Allows the password to be built upon even more
     * @param passwordBeginning The generated password
     */
    public SpecialChars(Password passwordBeginning) {
        super(passwordBeginning);
    }

    /**
     *  Builds upon the inputted password and adds special characters
     * @return The password which will have speacial characters
     */
    public String getPassword() {
        Random r = new Random();
        int ran = r.nextInt(31);
        String pass = "";
        String chars = "*!%+.{}";
        for (int i = 0;  i < chars.length(); i++) {
            if (ran <= 30) {
                pass = passwordBeginning.getPassword() + chars;
            }
        }
        return pass;
    }
}
