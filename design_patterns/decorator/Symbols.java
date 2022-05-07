package design_patterns.decorator;

/**
 * Adds symbols to password
 * @author Danielle Higgins
 */
public class Symbols extends PasswordDecorator {
    
    /**
     * Allows the password to be built upon
     * @param passwordBeginning The generated password
     */
    public Symbols(Password passwordBeginning) {
        super(passwordBeginning);
    }

    /**
     * Builds upon the inputted password and adds symbols
     * @return The password with symbols added
     */
    public String getPassword() {
        String pass = passwordBeginning.getPassword().replace("a", "@").replace("b", "8").replace("e", "3").replace
        ("g", "9").replace("i", "!").replace("o", "0").replace("s", "$").replace("t", "7");
        return pass;
    }
}
