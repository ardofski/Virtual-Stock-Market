/**
 * @author : Eren Þenoðlu, Ýrem Ecem Yelkanat, Batuhan Özçömlekçi
 * @version: 24.12.2018
 */
package GUI;

import model.*;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginPanel.
 */
public class LoginPanel extends JPanel {

	/** The top frame. */
	//Properties
	JFrame topFrame;
	
	/** The text field. */
	private JTextField textField;
	
	/** The password field. */
	private JPasswordField passwordField;
	
	/** The img. */
	BufferedImage img;

	/**
	 * Create the panel.
	 *
	 * @param frame the frame
	 */
	public LoginPanel(JFrame frame) {

		topFrame = frame;



		//set panel's properties
		setPreferredSize(new Dimension (1062,750));
		setLayout(null);
		setBackground(new Color(233, 233, 233));

		//Create labels
		JLabel lblNewLabel = new JLabel("Invalid username or password!");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(438, 360, 215, 16);


		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblUsername.setBounds(268, 390, 117, 30);
		add(lblUsername);

		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblPassword.setBounds(268, 441, 112, 30);
		add(lblPassword);

		//Create text fields
		textField = new JTextField();
		textField.setBounds(397, 388, 299, 35);
		add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(397, 439, 299, 35);
		add(passwordField);

		//create login button and add listener to it
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnLogin.setBounds(397, 494, 117, 33);
		btnLogin.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String password = "";
				for ( char c : passwordField.getPassword() ) 
					password += Character.toString(c);

				//check if the user name and password matches
				boolean checkpoint = ((ExternalInvestors)topFrame).getAccountContainer().setActiveUser( textField.getText(), password);

				//if they match change the panels to in and out report and side panel 
				if(checkpoint) {
					((ExternalInvestors)topFrame).changeSidePanel(0);
					((ExternalInvestors)topFrame).changeMainPanel(4);
				}

				//if they do not match show warning label 
				else {
					add(lblNewLabel);
				}

				revalidate();
				//repaint();
			}
		});

		add(btnLogin);

		//create sign up button and add listener that changes the panel to create account panel
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnSignUp.setBounds(579, 494, 117, 33);
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((ExternalInvestors)topFrame).changeMainPanel(12);
			}
		});
		add(btnSignUp);

		//create forgot password button and add lister that changes the main panel to forgot password panel
		JButton btnForgotPassword = new JButton("Forgot Password?");
		btnForgotPassword.setForeground(Color.BLUE);
		btnForgotPassword.setBounds(478, 539, 138, 22);
		btnForgotPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((ExternalInvestors)topFrame).changeMainPanel(2);
			}
		});
		add(btnForgotPassword);


		try {
			String path = getClass().getClassLoader().getResource(".").getPath();
			path = path.substring( 0 , path.length() - 4  );
			path += "src/logo.png";
			img = ImageIO.read( new File( path ) );
		} catch (IOException e) {
			e.printStackTrace();
		}


	}
	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g) {
		g.drawImage( img , 220, 0, null );

	}
}
