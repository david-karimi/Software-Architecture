import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CompetitorList {
    private ArrayList<DKcompetitor> competitors;

    public CompetitorList() {
        this.competitors = new ArrayList<>();
    }

    public void addCompetitor(DKcompetitor competitor) {
        competitors.add(competitor);
    }

    public ArrayList<DKcompetitor> getCompetitors() {
        return competitors;
    }

    public void readCompetitorsFromFile(String filePath) {
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");

                try {
                    int competitorNumber = Integer.parseInt(data[0]);
                    String name = data[1];
                    int age = Integer.parseInt(data[2]);
                    String gender = data[3];
                    String country = data[4];

                    ArrayList<Integer> scores = new ArrayList<>();
                    for (int i = 5; i < data.length; i++) {
                        scores.add(Integer.parseInt(data[i]));
                    }

                    addCompetitor(new DKcompetitor(competitorNumber, name, country, gender, age, scores));
                } catch (NumberFormatException e) {
                    System.err.println("Error parsing data: " + Arrays.toString(data));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public int getNextCompetitorNumber() {
        int maxNumber = 0;
        for (DKcompetitor competitor : competitors) {
            maxNumber = Math.max(maxNumber, competitor.getCompetitorNumber());
        }
        return maxNumber + 1;
    }

    public void removeCompetitor(int competitorId) {
        for (int i = 0; i < competitors.size(); i++) {
            if (competitors.get(i).getCompetitorNumber() == competitorId) {
                competitors.remove(i);
                return;
            }
        }

        System.out.println("Competitor not found with ID: " + competitorId);
    }

    public void updateCompetitorScore(int competitorId, int index, int newScore) {
        for (DKcompetitor competitor : competitors) {
            if (competitor.getCompetitorNumber() == competitorId) {
                competitor.setScoreAtIndex(index, newScore);
                return;
            }
        }

        System.out.println("Competitor not found with ID: " + competitorId);
    }

    public void updateCompetitorDetails(int competitorId, String newName, int newAge, String newCountry) {
        for (DKcompetitor competitor : competitors) {
            if (competitor.getCompetitorNumber() == competitorId) {
                competitor.setName(newName);
                competitor.setAge(newAge);
                competitor.setCountry(newCountry);
                return;
            }
        }

        System.out.println("Competitor not found with ID: " + competitorId);
    }
}






