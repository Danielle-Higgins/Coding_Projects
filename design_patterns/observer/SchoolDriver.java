package design_patterns.observer;

/**
 * A driver for our student government polling system.
 */
public class SchoolDriver {
    private static final String CANDIDATE_1 = "Jim Roberts";
    private static final String CANDIDATE_2 = "Cindy Smith";

    public SchoolDriver(){}

    /**
     * Runs our student government polling system.
     */
    public void run() {
        StudentGovPoll schoolPolls = new StudentGovPoll("Fun Collegiate");
        Observer tallyDisplay = new TallyDisplay(schoolPolls);
        Observer PercentageDisplay = new PercentageDisplay(schoolPolls);

        System.out.println("Welcome to " + schoolPolls.getSchool() + "'s Student Gov Poll");

        schoolPolls.addCandidate(CANDIDATE_1);
        schoolPolls.addCandidate(CANDIDATE_2);

        schoolPolls.enterVotes(CANDIDATE_1, 20);
        schoolPolls.enterVotes(CANDIDATE_2, 15);
        schoolPolls.enterVotes(CANDIDATE_1, 7);
        schoolPolls.enterVotes(CANDIDATE_2, 9);
    }

    public static void main(String[] args) {
        SchoolDriver driver = new SchoolDriver();
        driver.run();
    }
    
}
