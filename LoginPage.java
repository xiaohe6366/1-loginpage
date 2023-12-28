import java.awt.Color;		// Import necessary Java libraries
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPage implements ActionListener{	// Define the class LoginPage which implements the ActionListener
	
	JFrame frame = new JFrame();	// Declare GUI components as class variables, Main frame, Button, field, Label
	JButton loginButton = new JButton("Login");
	JButton resetButton = new JButton("Reset");
	JTextField userIDField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();
	JLabel userIDLabel = new JLabel("userID: ");
	JLabel userPasswordLabel = new JLabel("password: ");
	JLabel messageLabel = new JLabel();
	
	HashMap<String,String> logininfo = new HashMap<String,String>();	// HashMap to store user login information (username and password).
	
	LoginPage(HashMap<String,String> loginInfoOriginal){	// Constructor of the LoginPage class.
		logininfo = loginInfoOriginal;	//both logininfo and loginInfoOriginal will refer to the same HashMap object in memory
		
		userIDLabel.setBounds(50,100,75,25);	// Set the position and size of user ID and password labels.
		userPasswordLabel.setBounds(50,150,75,25);
		
		messageLabel.setBounds(125,250,250,35);	// Configure the message label (for displaying login messages)
		messageLabel.setFont(new Font(null,Font.ITALIC,25));
		
		userIDField.setBounds(125,100,200,25);	// Set the position and size of user ID and password input fields.
		userPasswordField.setBounds(125,150,200,25);
		
		loginButton.setBounds(125,200,100,25);	// Configure the login button with position, size, and action listener.
		loginButton.setFocusable(false);
		loginButton.addActionListener(this);
		
		resetButton.setBounds(225,200,100,25);	// Configure the reset button with position, size, and action listener.
		resetButton.setFocusable(false);	//button will not become highlighted or show any visual indication of focus when interacted with
		resetButton.addActionListener(this);
		
		frame.add(userIDLabel);		//adding various components to the frame
		frame.add(userPasswordLabel);
		frame.add(messageLabel);
		frame.add(userIDField);
		frame.add(userPasswordField);
		frame.add(loginButton);
		frame.add(resetButton);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//terminate (stop running) when the user closes the window
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {	//implement the ActionListener interface in a class (implements ActionListener), you are required to define the actionPerformed method.
		
		if(e.getSource()==resetButton) {	//it checks if the resetButton was clicked.
			userIDField.setText("");	//for entering a user ID) to an empty string ("").
			userPasswordField.setText("");	//Similar to password
		}
		
		if(e.getSource()==loginButton) {	//check if loginButton is clicked
			
			String userID = userIDField.getText();		//to get whatever text the user has typed into the text field.
			String password = String.valueOf(userPasswordField.getPassword());	//a special kind of text field where the input is hidden for privacy,converts the password from a character array to a String.
			
			if(logininfo.containsKey(userID)) {		//It checks if the HashMap contains a specific key. In your case, the key is userID,
				if(logininfo.get(userID).equals(password)) {	//compare if the password is the same
					messageLabel.setForeground(Color.green);	//message label become green 
					messageLabel.setText("Login successful");	//write login successful in the text
					frame.dispose();		//close the interface
					WelcomePage welcomePage = new WelcomePage(userID);		//creating a new instance of a class named WelcomePage, passing userID as a parameter to its constructor
				}
				else {
					messageLabel.setForeground(Color.red);		//else change color to red
					messageLabel.setText("Wrong password");		//mention wrong password
				}
			}
			else {
				messageLabel.setForeground(Color.red);		//red
				messageLabel.setText("username not found"); 	// say it as username not found
			}
		}
	}
}