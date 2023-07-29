import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Survey extends JFrame {
    private JLabel nameLabel;
    private JTextField nameField,suggestionsArea;
    private JLabel ratingLabel;
    private JSlider ratingSlider;
    private JLabel suggestionsLabel;

    private JButton submitButton;

    public Survey() {
        setTitle("Survey Form");


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 30, 10, 10)); // 4 rows, 2 columns, 10px vertical and horizontal gap



        nameLabel = new JLabel("Name:");

        nameField = new JTextField();


        ratingLabel = new JLabel("Rating:");
        ratingSlider = new JSlider(JSlider.HORIZONTAL, 0, 10, 5); // Slider from 0 to 10, default value 5
        suggestionsLabel = new JLabel("Any Suggestions:");

        suggestionsArea=new JTextField();
        submitButton = new JButton("Submit");

        int leftSpacing = 5; // Set your desired left spacing
        nameField.setMargin(new Insets(0, leftSpacing, 0, 0));




        add(nameLabel);
        add(nameField);
        add(ratingLabel);
        add(ratingSlider);
        add(suggestionsLabel);
        add(suggestionsArea);


         leftSpacing = 20; // Set your desired left spacing




        // Create a panel for the Submit button to center it
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(submitButton);
        add(buttonPanel);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the form submission here
                String name = nameField.getText();
                int rating = ratingSlider.getValue();
                String suggestions = suggestionsArea.getText();

                // You can process the survey data here, e.g., store it in a database, display a message, etc.

                // For this example, let's display the survey data in a message dialog


                try {
                    UserRegistration.Survey(name,rating,suggestions);

                    JOptionPane.showMessageDialog(Survey.this, "Thanks for your Feedback", "Survey Form Result", JOptionPane.INFORMATION_MESSAGE);


                } catch (SQLException ex) {
                    ex.printStackTrace();

                    JOptionPane.showMessageDialog(Survey.this, "You have already submitted", "Survey Form Result", JOptionPane.INFORMATION_MESSAGE);

                }




            }
        });

        pack();
        setLocationRelativeTo(null); // Center the form on the screen
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Survey form = new Survey();
            form.setVisible(true);
        });
    }
}
