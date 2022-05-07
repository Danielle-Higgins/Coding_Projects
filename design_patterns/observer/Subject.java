package design_patterns.observer;

/**
 * Interface that makes child classes implement the classes associated with it
 * @author Danielle Higgins
 */
public interface Subject {
    public void registerObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObservers();
}
