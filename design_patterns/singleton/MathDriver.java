package design_patterns.singleton;

public class MathDriver {
    public MathDriver() {

    }

    public void run() {
        MathGame game = MathGame.getInstance();
        game.play();
    }

    public static void main(String[] args){
        MathDriver driver = new MathDriver();
        driver.run();
    }
}