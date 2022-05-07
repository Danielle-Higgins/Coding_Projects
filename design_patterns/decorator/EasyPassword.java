package design_patterns.decorator;

import java.util.Random;

/**
 * Makes an easy password based on the phrase passed in
 * @author Danielle Higgins
 */
public class EasyPassword extends Password {
    
    /**
     * Constructs based on the phrase
     * @param phrase The phrase the user inputs
     */
    public EasyPassword(String phrase) {
        this.password = phrase;
    }

    /**
     * Creates the password which has no white space and has a random number
     * @return The password
     */
    public String getPassword() {
        Random r = new Random();
        String pass = password.replaceAll("\\s", "");
        int num = r.nextInt(101);
        pass = pass + num;
        return pass;
        
    }
}
