import javax.swing.*;
import java.util.List;

public class Manager {
    private CompetitorList competitorList;

    public Manager() {
        this.competitorList = new CompetitorList();
    }

    public void readCompetitorsFromFile(String filePath) {
        competitorList.readCompetitorsFromFile(filePath);
    }

    public void displayShortDetailsForCompetitor(int competitorNumber) {
        List<DKcompetitor> competitors = competitorList.getCompetitors();

        for (DKcompetitor competitor : competitors) {
            if (competitor.getCompetitorNumber() == competitorNumber) {
                System.out.println(competitor.getShortDetails());
                return;
            }
        }

        System.out.println("Competitor not found with number: " + competitorNumber);
    }

    public void updateCompetitorScore(int competitorId, int index, int newScore) {
        competitorList.updateCompetitorScore(competitorId, index, newScore);
    }

    public void removeCompetitor(int competitorId) {
        competitorList.removeCompetitor(competitorId);
    }

    public void initGUI() {
        SwingUtilities.invokeLater(() -> {
            CompetitorGUI gui = new CompetitorGUI(this);
        });
    }

    // finds the RunCompetitor.CSV file
    public static void main(String[] args) {
        Manager manager = new Manager();
        String filePath = "/Users/davidkarimi/Desktop/Software Architecture assignment 2/Software Architecture 2/RunCompetitor.csv";
        manager.readCompetitorsFromFile(filePath);
        manager.displayShortDetailsForCompetitor(100);
        manager.initGUI();
    }
}



