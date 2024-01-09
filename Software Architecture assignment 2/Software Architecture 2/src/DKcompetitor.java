import java.util.ArrayList;

public class DKcompetitor {
    private int competitorNumber;
    private String name;
    private String country;
    private String level;
    private int age;
    private ArrayList<Integer> scores;

    public DKcompetitor(int competitorNumber, String name, String country, String level, int age, ArrayList<Integer> scores) {
        this.competitorNumber = competitorNumber;
        this.name = name;
        this.country = country;
        this.level = level;
        this.age = age;
        this.scores = scores;
    }

    public int getCompetitorNumber() {
        return competitorNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLevel() {
        return level;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<Integer> getScores() {
        return scores;
    }

    // Add setter for scores
    public void setScores(ArrayList<Integer> scores) {
        this.scores = scores;
    }

    // Add setter for a single score at a specific index
    public void setScoreAtIndex(int index, int score) {
        if (index >= 0 && index < scores.size()) {
            scores.set(index, score);
        } else {
            System.out.println("Invalid index for setting score.");
        }
    }

    // Add getter for a single score at a specific index
    public int getScoreAtIndex(int index) {
        if (index >= 0 && index < scores.size()) {
            return scores.get(index);
        } else {
            System.out.println("Invalid index for getting score.");
            return 0; // You can modify the default value as needed
        }
    }

    public double getOverallScore() {
        // Calculate overall score based on your criteria
        return 0.0;
    }

    public String getFullDetails() {
        // Construct and return full details as a String
        return "";
    }

    public String getShortDetails() {
        // Construct and return short details as a String
        return "";
    }
}
