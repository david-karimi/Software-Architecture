import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manager {
    private List<DKcompetitor> competitors;

    public Manager() {
        this.competitors = new ArrayList<>();
    }

    public void readCompetitorsFromFile(String fileName) {
        try {
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(" ");
                // Assuming your constructor takes the necessary parameters
                DKcompetitor competitor = new DKcompetitor(
                        Integer.parseInt(data[0]),
                        data[1],
                        data[2],
                        Integer.parseInt(data[3]),
                        // Extract the scores
                        extractScores(data)
                );
                competitors.add(competitor);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private int[] extractScores(String[] data) {
        int[] scores = new int[data.length - 4];
        for (int i = 4; i < data.length; i++) {
            scores[i - 4] = Integer.parseInt(data[i]);
        }
        return scores;
    }

    public void displayCompetitorTable() {
        // Implement code to display a table of competitors with full details
        for (DKcompetitor competitor : competitors) {
            System.out.println(competitor.getFullDetailsWithScores());
        }
    }

    public void displayHighestScoreCompetitor() {
        // Implement code to display details of the competitor with the highest overall score
        DKcompetitor highestScoreCompetitor = getCompetitorWithHighestScore();
        if (highestScoreCompetitor != null) {
            System.out.println("Competitor with the highest score:\n" + highestScoreCompetitor.getFullDetailsWithScores());
        } else {
            System.out.println("No competitors found.");
        }
    }

    private DKcompetitor getCompetitorWithHighestScore() {
        // Implement logic to find and return the competitor with the highest overall score
        // You need to implement the getOverallScore() method in your DKCompetitor class first
        // After implementing it, you can iterate through competitors to find the one with the highest score
        // For simplicity, assuming higher score is better
        double highestScore = -1;
        DKcompetitor highestScoreCompetitor = null;
        for (DKcompetitor competitor : competitors) {
            double overallScore = competitor.getOverallScore();
            if (overallScore > highestScore) {
                highestScore = overallScore;
                highestScoreCompetitor = competitor;
            }
        }
        return highestScoreCompetitor;
    }

    public void displaySummaryStatistics() {
        // Implement code to display four other summary statistics of your choice
        // For example, you can calculate and display averages, totals, max, min, etc.
        // Use methods from the DKCompetitor class to get necessary information
    }

    public void displayFrequencyReport() {
        // Implement code to display a frequency report for individual scores
        // For each possible score (0-5), count how many times it appears across all competitors
        int[] scoreCounts = new int[6];
        for (DKcompetitor competitor : competitors) {
            int[] scores = competitor.getScores();
            for (int score : scores) {
                scoreCounts[score]++;
            }
        }

        System.out.println("Frequency report for individual scores:");
        for (int i = 0; i < scoreCounts.length; i++) {
            System.out.println("Score " + i + ": " + scoreCounts[i] + " occurrences");
        }
    }

    public void displayShortDetailsForCompetitor(int competitorNumber) {
        // Implement code to display short details for a specific competitor
        // Find the competitor with the given number and display short details
        for (DKcompetitor competitor : competitors) {
            if (competitor.getCompetitorNumber() == competitorNumber) {
                System.out.println("Short details for competitor " + competitorNumber + ":\n" + competitor.getShortDetails());
                return; // Exit the method once found
            }
        }
        System.out.println("Competitor with number " + competitorNumber + " not found.");
    }
}
