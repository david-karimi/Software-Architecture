import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CompetitorGUI extends JFrame {

    private Manager manager;
    private JPanel infoPanel;

    public CompetitorGUI(Manager manager) {
        this.manager = manager;

        // Set up the GUI components
        setupComponents();

        // Set JFrame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800); // Increased size
        setLocationRelativeTo(null); // Center on screen
        setTitle("Competitor GUI");

        // Display the JFrame
        setVisible(true);
    }

    private void setupComponents() {
        // Create main panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Create info panel
        infoPanel = new JPanel();
        infoPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        infoPanel.setPreferredSize(new Dimension(800, 100));

        // Create buttons panel
        JPanel buttonsPanel = new JPanel(new GridLayout(2, 4, 10, 10)); // 2 rows, 4 columns, 10px horizontal and vertical gap

        // Create buttons
        JButton editScoreButton = new JButton("Edit Score");
        JButton removeCompetitorButton = new JButton("Remove Competitor");

        // Add action listener for the Edit Score button
        editScoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editScore();
            }
        });

        // Add action listener for the Remove Competitor button
        removeCompetitorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeCompetitor();
            }
        });

        JButton sortByIdButton = new JButton("Sort by ID");
        JButton sortByNameButton = new JButton("Sort by Name");
        JButton viewDetailsButton = new JButton("View Details");
        JButton viewShortDetailsButton = new JButton("View Short Details");
        JButton editDetailsButton = new JButton("Edit Details");
        JButton closeButton = new JButton("Close");

        // Add buttons to panel
        buttonsPanel.add(editScoreButton);
        buttonsPanel.add(removeCompetitorButton);
        buttonsPanel.add(sortByIdButton);
        buttonsPanel.add(sortByNameButton);
        buttonsPanel.add(viewDetailsButton);
        buttonsPanel.add(viewShortDetailsButton);
        buttonsPanel.add(editDetailsButton);
        buttonsPanel.add(closeButton);

        // Add buttons panel and info panel to the main panel
        mainPanel.add(buttonsPanel, BorderLayout.SOUTH);
        mainPanel.add(infoPanel, BorderLayout.CENTER);

        // Add the main panel to the content pane
        getContentPane().add(mainPanel);
    }

    private void editScore() {
        String competitorIdString = JOptionPane.showInputDialog(this, "Enter Competitor ID:");
        if (competitorIdString != null && !competitorIdString.isEmpty()) {
            int competitorId = Integer.parseInt(competitorIdString);
            String indexString = JOptionPane.showInputDialog(this, "Enter Index of Score to Edit:");
            if (indexString != null && !indexString.isEmpty()) {
                int index = Integer.parseInt(indexString);
                String newScoreString = JOptionPane.showInputDialog(this, "Enter New Score:");
                if (newScoreString != null && !newScoreString.isEmpty()) {
                    int newScore = Integer.parseInt(newScoreString);

                    // Call the Manager method to update the score
                    manager.updateCompetitorScore(competitorId, index, newScore);

                    // Update the info panel or perform any other necessary actions
                    updateInfoPanel("Score for Competitor " + competitorId + " updated at index " + index + " to " + newScore);
                }
            }
        }
    }

    private void removeCompetitor() {
        String competitorIdString = JOptionPane.showInputDialog(this, "Enter Competitor ID to Remove:");
        if (competitorIdString != null && !competitorIdString.isEmpty()) {
            int competitorId = Integer.parseInt(competitorIdString);

            // Call the Manager method to remove the competitor
            manager.removeCompetitor(competitorId);

            // Update the info panel or perform any other necessary actions
            updateInfoPanel("Competitor " + competitorId + " removed");
        }
    }

    private void updateInfoPanel(String message) {
        // Update the info panel with the provided message
        infoPanel.removeAll();
        JLabel label = new JLabel(message);
        infoPanel.add(label);
        infoPanel.revalidate();
        infoPanel.repaint();
    }

    public static void main(String[] args) {
        // Create an instance of the Manager class
        Manager manager = new Manager();

        // Create an instance of the CompetitorGUI class and pass the manager to it
        CompetitorGUI gui = new CompetitorGUI(manager);

        // Ensure GUI components are set up
        gui.setupComponents();
    }
}

