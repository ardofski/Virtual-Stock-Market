/**
 * @author : Eren Þenoðlu, Ýrem Ecem Yelkanat, Batuhan Özçömlekçi
 * @version: 24.12.2018
 */
package GUI;

import model.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import java.awt.Button;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

// TODO: Auto-generated Javadoc
/**
 * The Class ProfileOptionsPanel.
 */
public class ProfileOptionsPanel extends JPanel {

	/** The text field. */
	private JTextField textField;

	/** The top frame. */
	//Properties
	JFrame topFrame;

	/**
	 * Create the panel.
	 *
	 * @param frame the frame
	 */
	public ProfileOptionsPanel(JFrame frame) {

		topFrame = frame;


		setPreferredSize (new Dimension(850,700));
		setLayout(null);

		JLabel profileLabel = new JLabel("Profile");
		profileLabel.setForeground(Color.BLUE);
		profileLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		profileLabel.setBounds(45, 45, 85, 31);
		add(profileLabel);

		JLabel generalInformationLabel = new JLabel("> Profile Options");
		generalInformationLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		generalInformationLabel.setBounds(131, 45, 275, 31);
		add(generalInformationLabel);

		JButton changeUsernameButton = new JButton("Change Username");
		changeUsernameButton.setBounds(88, 144, 175, 42);
		changeUsernameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((ExternalInvestors)topFrame).changeMainPanel(13);
			}
		});
		add(changeUsernameButton);

		JButton changePasswordButton = new JButton("Change Password");
		changePasswordButton.setBounds(88, 210, 175, 42);
		changePasswordButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((ExternalInvestors)topFrame).changeMainPanel(0);
			}
		});
		add(changePasswordButton);

		/*
		JButton deleteAccountButton = new JButton("Delete Account");
		deleteAccountButton.setBounds(88, 276, 175, 42);
		deleteAccountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int choice = JOptionPane.showConfirmDialog(topFrame, "Your account will be deleted permanently, are you sure?" ,"Delete Account", 0 ,1);
				// Process choice
				if (choice == 0) 
				{
					// Delete account from the database
					// System.exit(0);
				}
				if (choice == 1) 
				{

				}

			}
		});
		add(deleteAccountButton);
		*/

		repaint();


	}

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g) {

		//super.paintComponent(g);
		g.drawLine(30, 100, 800, 100);
	}
}