package model;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.UIManager;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class GUI {

	private JFrame frame;
	private JTextField userNameField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(255, 0, 255));
		frame.getContentPane().setBackground(new Color(240, 248, 255));
		frame.setBackground(SystemColor.window);
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		userNameField = new JTextField();
		userNameField.setBounds(297, 290, 200, 25);
		frame.getContentPane().add(userNameField);
		userNameField.setColumns(10);
		
		JLabel usernameLabel = new JLabel("USERNAME");
		usernameLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		usernameLabel.setBounds(188, 293, 97, 16);
		frame.getContentPane().add(usernameLabel);
		
		JLabel passwordLabel = new JLabel("PASSWORD");
		passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		passwordLabel.setBounds(188, 322, 97, 22);
		frame.getContentPane().add(passwordLabel);
		
		JButton loginButton = new JButton("Login");
		loginButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		loginButton.setForeground(Color.BLACK);
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		loginButton.setBounds(291, 372, 97, 25);
		frame.getContentPane().add(loginButton);
		
		JButton signUpButton = new JButton("Sign Up");
		signUpButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		signUpButton.setBounds(400, 372, 97, 25);
		frame.getContentPane().add(signUpButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(297, 323, 200, 25);
		frame.getContentPane().add(passwordField);
		
		JButton forgotPasswordButton = new JButton("Forgot Password?");
		forgotPasswordButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		forgotPasswordButton.setForeground(new Color(25, 25, 112));
		forgotPasswordButton.setBackground(new Color(240, 255, 255));
		forgotPasswordButton.setOpaque(true);
		forgotPasswordButton.setBounds(322, 410, 152, 25);
		frame.getContentPane().add(forgotPasswordButton);
	}
}
