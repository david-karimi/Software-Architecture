public class DKcompetitor {
    private int competitorNumber;
    private String name;
    private String country;
    private int age;
    private int[] scores;

    private static final int MIN_SCORE = 0;
    private static final int MAX_SCORE = 5;

    public DKcompetitor(int competitorNumber, String name, String country, int age, int[] scores) {
        this.competitorNumber = competitorNumber;
        this.name = name;
        this.country = country;
        this.age = age;
        this.scores = scores;
    }

    public int getCompetitorNumber() {
        return competitorNumber;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getAge() {
        return age;
    }

    public int[] getScores() {
        return scores;
    }

    public double getOverallScore() {
        // Placeholder value for now
        return 5.0;
    }

    public String getFullDetailsWithScores() {
        StringBuilder details = new StringBuilder();
        details.append("Competitor number ").append(competitorNumber).append(", name ").append(name)
                .append(", country ").append(country).append(".\n")
                .append(name).append(" is aged ").append(age)
                .append(" and received these scores: ");
        for (int score : scores) {
            details.append(score).append(", ");
        }
        details.deleteCharAt(details.length() - 2); // Remove the last comma
        details.append("\nThis gives them an overall score of ").append(getOverallScore()).append(".");
        return details.toString();
    }

    public String getShortDetails() {
        return "CN " + competitorNumber + " (" + getInitials() + ") has an overall score of " + getOverallScore() + ".";
    }

    // Helper method to get initials
    private String getInitials() {
        StringBuilder initials = new StringBuilder();
        String[] nameParts = name.split(" ");
        for (String part : nameParts) {
            initials.append(part.charAt(0));
        }
        return initials.toString().toUpperCase();
    }

}


