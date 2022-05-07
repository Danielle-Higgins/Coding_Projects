package design_patterns.decorator;

/**
 * Abstract base class that forces children to implement the abstract method
 * @author Danielle Higgins
 */
public abstract class PasswordDecorator extends Password {
    protected Password passwordBeginning;

    /**
     * Creates the decorated password
     * @param passwordBeginning The generated password
     */
    public PasswordDecorator(Password passwordBeginning) {
        this.passwordBeginning = passwordBeginning;
    }

    /**
     * Abstract method which the children has to implement
     * @return The decorated password
     */
    public abstract String getPassword();
}
