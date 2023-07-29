
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;


public class Dashboard extends JPanel {
    private JPanel formPanel, loginformPanel;
    private JLabel imageLabel;
    public static Integer ID;
    public JButton registerButton,loginButton,submitButton,lButton;

        public Dashboard() {
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            String imagePath="src/survey.png";

            // Load the image using ImageIcon

            Image image = resizeImage(imagePath, 200, 150);

            ImageIcon imageIcon = new ImageIcon(image);
            // Create a label to display the image
            imageLabel = new JLabel(imageIcon);
            imageLabel.setAlignmentX(CENTER_ALIGNMENT); // Align the image to the center




            // Create a label with the big text "Survey System"
            JLabel titleLabel = new JLabel("Survey System");
            titleLabel.setFont(titleLabel.getFont().deriveFont(30f)); // Increase the font size
            titleLabel.setAlignmentX(CENTER_ALIGNMENT); // Align the text to the center

            // Create the "Register" button
             registerButton = new JButton("Register");
            registerButton.setAlignmentX(CENTER_ALIGNMENT); // Align the button to the center

            // Create the "Login" button
            loginButton = new JButton("Login for survey");
            loginButton.setAlignmentX(CENTER_ALIGNMENT); // Align the button to the center

            // Add spacing between components using Box.createVerticalStrut
            int spacing = 20;
            add(Box.createVerticalStrut(spacing));
            add(titleLabel);
            add(Box.createVerticalStrut(spacing));
            add(imageLabel);
            add(Box.createVerticalStrut(30));
            add(registerButton);
            add(Box.createVerticalStrut(spacing));
            add(loginButton);





            // Create the registration form components
            formPanel = new JPanel();
            formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
            formPanel.setVisible(false); // Initially, hide the registration form

            JLabel tlbel = new JLabel("Survey System");
            titleLabel.setFont(titleLabel.getFont().deriveFont(30f)); // Increase the font size
            titleLabel.setAlignmentX(CENTER_ALIGNMENT); // Align the text to the center


             spacing = 10;
            formPanel.add(Box.createVerticalStrut(spacing));

            formPanel.add(tlbel);


            formPanel.add(Box.createVerticalStrut(spacing));

            // Create the label and text field for the name
            JPanel namePanel = new JPanel();
            namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.X_AXIS));
            JLabel nameLabel = new JLabel("Name:     ");
            JTextField nameField = new JTextField();
            nameField.setPreferredSize(new Dimension(100, 10)); // Set the preferred size for the nameField
            namePanel.add(nameLabel);
            namePanel.add(Box.createHorizontalStrut(5)); // Add some horizontal spacing between label and text field
            namePanel.add(nameField);
            formPanel.add(namePanel);

            // Create the label and text field for the username
            JPanel usernamePanel = new JPanel();
            usernamePanel.setLayout(new BoxLayout(usernamePanel, BoxLayout.X_AXIS));
            JLabel usernameLabel = new JLabel("Username: ");
            JTextField userNameField = new JTextField();
            userNameField.setPreferredSize(new Dimension(250, 30)); // Set the preferred size for the userNameField
            usernamePanel.add(usernameLabel);
            usernamePanel.add(Box.createHorizontalStrut(5)); // Add some horizontal spacing between label and text field
            usernamePanel.add(userNameField);
            formPanel.add(usernamePanel);

            // Create the label and text field for the email
            JPanel emailPanel = new JPanel();
            emailPanel.setLayout(new BoxLayout(emailPanel, BoxLayout.X_AXIS));
            JLabel emailLabel = new JLabel("Email:     ");
            JTextField emailField = new JTextField();
            emailField.setPreferredSize(new Dimension(200, 30)); // Set the preferred size for the emailField
            emailPanel.add(emailLabel);
            emailPanel.add(Box.createHorizontalStrut(5)); // Add some horizontal spacing between label and text field
            emailPanel.add(emailField);
            formPanel.add(emailPanel);

            // Create the label and text field for the password
            JPanel passwordPanel = new JPanel();
            passwordPanel.setLayout(new BoxLayout(passwordPanel, BoxLayout.X_AXIS));
            JLabel passwordLabel = new JLabel("Password: ");
            JTextField passwordField = new JTextField();
            passwordField.setPreferredSize(new Dimension(200, 30)); // Set the preferred size for the passwordField
            passwordPanel.add(passwordLabel);
            passwordPanel.add(Box.createHorizontalStrut(5)); // Add some horizontal spacing between label and text field
            passwordPanel.add(passwordField);
            formPanel.add(passwordPanel);


            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
            buttonPanel.add(Box.createVerticalGlue()); // Empty glue to center the button
            submitButton = new JButton("Submit");
            submitButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Center the button
            buttonPanel.add(submitButton);
            buttonPanel.add(Box.createVerticalGlue()); // Empty glue to center the button



            formPanel.add(buttonPanel);



            // Set preferred and maximum sizes for the text fields
            int textFieldWidth = 200; // Set your desired text field width
            int textFieldHeight = 30; // Set your desired text field height
            Dimension textFieldDimension = new Dimension(textFieldWidth, textFieldHeight);

            nameField.setPreferredSize(textFieldDimension);
            nameField.setMaximumSize(textFieldDimension);

            userNameField.setPreferredSize(textFieldDimension);
            userNameField.setMaximumSize(textFieldDimension);

            emailField.setPreferredSize(textFieldDimension);
            emailField.setMaximumSize(textFieldDimension);

            passwordField.setPreferredSize(textFieldDimension);
            passwordField.setMaximumSize(textFieldDimension);





           // add(formPanel);



            registerButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {


                    JFrame registrationFrame = new JFrame("Registration Form");
                    registrationFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    registrationFrame.setSize(500, 400);
                    registrationFrame.setLocationRelativeTo(null); // Center the frame on the screen

                    // Add the formPanel to the registrationFrame
                    registrationFrame.add(formPanel);
                    formPanel.setVisible(true);

                    // Make the registrationFrame visible
                    registrationFrame.setVisible(true);

                    // Disable the "Register" button while the registration form is open
                    registerButton.setEnabled(false);
                }
            });



            //Login Panel


            loginformPanel=new JPanel();
            loginformPanel.setLayout(new BoxLayout(loginformPanel, BoxLayout.Y_AXIS));
            loginformPanel.setVisible(false); // Initially, hide the registration form

            JLabel tilbel = new JLabel("Survey System");
            titleLabel.setFont(titleLabel.getFont().deriveFont(30f)); // Increase the font size
            titleLabel.setAlignmentX(CENTER_ALIGNMENT); // Align the text to the center




            spacing = 10;


            loginformPanel.add(tlbel);


           loginformPanel.add(Box.createVerticalStrut(spacing));

            // Create the label and text field for the name
            JPanel nPanel = new JPanel();
            nPanel.setLayout(new BoxLayout(nPanel, BoxLayout.X_AXIS));
            JLabel nLabel = new JLabel("Username:");
            JTextField nField = new JTextField();
            nField.setPreferredSize(new Dimension(200, 30)); // Set the preferred size for the nameField
            nPanel.add(nLabel);
            nPanel.add(Box.createHorizontalStrut(5)); // Add some horizontal spacing between label and text field
            nPanel.add(nField);
            loginformPanel.add(nPanel);


            loginformPanel.add(Box.createVerticalStrut(5));

            // Create the label and text field for the username
            JPanel uPanel = new JPanel();
            uPanel.setLayout(new BoxLayout(uPanel, BoxLayout.X_AXIS));
            JLabel uLabel = new JLabel("Password:");
            JTextField uField = new JTextField();
            uField.setPreferredSize(new Dimension(200, 30)); // Set the preferred size for the userNameField
            uPanel.add(uLabel);
            uPanel.add(Box.createHorizontalStrut(5)); // Add some horizontal spacing between label and text field
            uPanel.add(uField);
            loginformPanel.add(uPanel);




            lButton = new JButton("Login");
            lButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Center the button






            loginformPanel.add(lButton);


            loginformPanel.add(Box.createVerticalStrut(5));


            // Set preferred and maximum sizes for the text fields
            textFieldWidth = 150; // Set your desired text field width
            textFieldHeight = 30; // Set your desired text field height
            textFieldDimension = new Dimension(textFieldWidth, textFieldHeight);

            nField.setPreferredSize(textFieldDimension);
            nField.setMaximumSize(textFieldDimension);

            uField.setPreferredSize(textFieldDimension);
            uField.setMaximumSize(textFieldDimension);








            loginButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {


                    JFrame loginFrame = new JFrame("Login Form");
                    loginFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    loginFrame.setSize(350, 250);
                    loginFrame.setLocationRelativeTo(null); // Center the frame on the screen

                    // Add the loginPanel to the Login Frame
                    loginFrame.add(loginformPanel);
                    loginFrame.setVisible(true);

                    // Make the login form visible
                    loginformPanel.setVisible(true);

                    // Disable the "Register" button while the registration form is open
                    loginButton.setEnabled(false);

                }
            });




            submitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // This code will be executed when the submit button is clicked
                    // Handle the registration data here
                    String name = nameField.getText();
                    String email = emailField.getText();
                    String username = userNameField.getText();
                    String password = passwordField.getText();


                    try {
                        UserRegistration.Registration(name,email,username,password);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                    String message="Registration Done";

                    JOptionPane.showMessageDialog(Dashboard.this, message, "Registration Form", JOptionPane.INFORMATION_MESSAGE);











                    // Clear the form fields
                    nameField.setText("");
                    emailField.setText("");

                    passwordField.setText("");
                    userNameField.setText("");


                    // Hide the registration form after submission
                    formPanel.setVisible(false);
                    registerButton.setEnabled(true);
                }
            });




            lButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {



                    String username = nField.getText();

                    String password = uField.getText();

                    try {
                       ID=Login.Login(username,password);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                    SwingUtilities.invokeLater(() -> {
                        Survey surveyForm = new Survey();
                        surveyForm.setVisible(true);
                    });



                    loginButton.setEnabled(true);



                }
            });
        }


        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                JFrame frame = new JFrame("Survey Application");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                // Create the panel with buttons
                Dashboard panel =new Dashboard();


                frame.add(panel);
                panel.setPreferredSize(new Dimension(500, 400));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            });
        }




    // Method to resize the image to the specified width and height
    private Image resizeImage(String imagePath, int width, int height) {
        try {
            Image image = ImageIO.read(new File(imagePath));
            return image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    }
