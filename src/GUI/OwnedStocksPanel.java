package GUI;

import model.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import java.awt.Button;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

/** Displays owned stocks 
 * 
 * @author Eren Senoglu
 * @version 20/12/2018
 */ 
public class OwnedStocksPanel extends JPanel {

	private JTextField textField;

	//Properties
	JFrame topFrame;

	/**
	 * Create the panel with the given parameter
	 * 
	 * @param frame the frame that the panel will be added
	 */
	public OwnedStocksPanel(JFrame frame) {

		// Initializw
		topFrame = frame;

		// Set the properties of the panel
		setPreferredSize (new Dimension(850,700));
		setLayout(null);

		// Create labels
		JLabel profileLabel = new JLabel("Profile");
		profileLabel.setForeground( Color.BLUE );
		profileLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		profileLabel.setBounds(45, 45, 85, 31);
		add(profileLabel);

		JLabel generalInformationLabel = new JLabel("> Owned Stocks");
		generalInformationLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		generalInformationLabel.setBounds(131, 45, 275, 31);
		add(generalInformationLabel);

		JLabel lblStockName = new JLabel("Stock Name");
		lblStockName.setBounds(45, 162, 85, 16);
		add(lblStockName);

		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setBounds(275, 162, 59, 16);
		add(lblAmount);

		JLabel lblCurrentValuePer = new JLabel("Current Value");
		lblCurrentValuePer.setBounds(435, 141, 93, 23);
		add(lblCurrentValuePer);

		JLabel lblPerStock = new JLabel("Per Stock ($)");
		lblPerStock.setBounds(435, 162, 83, 16);
		add(lblPerStock);

		JLabel lblTotalValue = new JLabel("Total Value ($)");
		lblTotalValue.setBounds(638, 162, 93, 16);
		add(lblTotalValue);

		JPanel stockPanel = new OwnedStockPanel(topFrame);
		stockPanel.setBounds(45, 200, 800, 400);
		add(stockPanel);

		repaint();

	}

	/* Paints the components
	 * @param g the default swing parameter
	 */
	public void paintComponent(Graphics g) {
		g.drawLine(30, 100, 800, 100);
		g.drawLine(30 , 195, 800, 195);

	}
}
