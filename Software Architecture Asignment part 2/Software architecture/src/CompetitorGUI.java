// CompetitorGUI.java
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CompetitorGUI extends JFrame {
    private CompetitorList competitorList;

    public CompetitorGUI(CompetitorList competitorList) {
        this.competitorList = competitorList;
        initComponents();
    }

    private void initComponents() {
        // Initialize GUI components, buttons, labels, etc.

        JButton viewTableButton = new JButton("View Competitor Table");
        viewTableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayCompetitorTable();
            }
        });

        // Add other components and event listeners

        // Set up layout using GroupLayout or another layout manager

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    private void displayCompetitorTable() {
        // Implement code to display a table of competitors in the GUI
        // You can use a JTable or another component to display the data
        // Competitor data can be obtained from competitorList
    }

    // Add other methods for different GUI functionalities
}
