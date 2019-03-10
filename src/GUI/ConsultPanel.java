/**
 * @author : Eren Þenoðlu, Ýrem Ecem Yelkanat, Batuhan Özçömlekçi
 * @version: 24.12.2018
 */
package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.Border;

import model.Account;
import model.Consultant;
import model.ConsultantContainer;

// TODO: Auto-generated Javadoc
/**
 * The Class ConsultPanel.
 */
public class ConsultPanel extends JPanel {

	/** The top frame. */
	JFrame topFrame;

	/** The active user. */
	Account activeUser;

	/** The consultant list. */
	ConsultantContainer consultantList;

	/** The img 2. */
	BufferedImage img,img1,img2;

	/**
	 * Instantiates a new consult panel.
	 *
	 * @param frame the frame
	 */
	public ConsultPanel(JFrame frame) {

		consultantList = new ConsultantContainer();


		topFrame = frame;
		activeUser = ( ( ExternalInvestors ) topFrame ).getAccountContainer().getActiveUser();

		//set panel's properties
		setPreferredSize (new Dimension(850, 700));
		setLayout(null);

		int alignX = 200 ;


		for(int i = 0 ; i < 3 ; i++) {

		}

		//Create labels
		JLabel headerLabel = new JLabel("Consult With An Expert");
		headerLabel.setBounds(84, 63, 476, 31);
		headerLabel.setForeground(Color.BLUE);
		headerLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		add(headerLabel);

		// First Consultant
		String nameOne = consultantList.getConsultant(0).getName();
		JLabel firstConsultantName = new JLabel(nameOne);
		firstConsultantName.setBounds(200, 150, 476, 31);
		firstConsultantName.setForeground(Color.BLACK);
		firstConsultantName.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		add(firstConsultantName);

		JTextArea firstConsultantInfo = new JTextArea();
		String infoOne = consultantList.getConsultant(0).getText() ;
		firstConsultantInfo.setEditable(false);
		firstConsultantInfo.setWrapStyleWord(true);
		firstConsultantInfo.setLineWrap(true);
		firstConsultantInfo.setText(infoOne);
		firstConsultantInfo.setBounds(200, 180, 355, 85);
		firstConsultantInfo.setForeground(Color.BLACK);
		firstConsultantInfo.setFont(new Font("Modern No. 20", Font.PLAIN, 
				16));
		firstConsultantInfo.setBackground(UIManager.getColor("Button.background"));
		add(firstConsultantInfo);


		String successRateOne = "Success Rate : " + consultantList.getConsultant(0).getRate()+"%";
		JLabel firstSuccessRate = new JLabel(successRateOne);
		firstSuccessRate.setBounds(200, 265, 176, 31);
		firstSuccessRate.setForeground(Color.BLACK);
		firstSuccessRate.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		add(firstSuccessRate);

		String costOne = "Cost : " + consultantList.getConsultant(0).getPrice()+"$";
		JLabel firstCost = new JLabel(costOne);
		firstCost.setBounds(465, 265, 476, 31);
		firstCost.setForeground(Color.BLACK);
		firstCost.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		add(firstCost);

		JButton consultLabel = new JButton("Consult");
		consultLabel.setBounds(640, 265, 100, 31);
		consultLabel.setForeground(Color.RED);
		consultLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 17));


		consultLabel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(consultantList.getConsultant(0).consult(activeUser))
					((ExternalInvestors)topFrame).changeMainPanel(consultantList.getConsultant(0));
				else {					
					JOptionPane.showMessageDialog(null, "You don't have enough cash to perform this action.");
				}

			}});
		add(consultLabel);

		// Second Consultant

		String nameTwo =  consultantList.getConsultant(1).getName();
		JLabel secondConsultantName = new JLabel(nameTwo);
		secondConsultantName.setBounds(200, 320, 476, 31);
		secondConsultantName.setForeground(Color.BLACK);
		secondConsultantName.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		add(secondConsultantName);

		JTextArea secondConsultantInfo = new JTextArea();
		String infoTwo = consultantList.getConsultant(1).getText();
		secondConsultantInfo.setEditable(false);
		secondConsultantInfo.setWrapStyleWord(true);
		secondConsultantInfo.setLineWrap(true);
		secondConsultantInfo.setText(infoTwo);
		secondConsultantInfo.setBounds(200, 350, 355, 85);
		secondConsultantInfo.setForeground(Color.BLACK);
		secondConsultantInfo.setBackground(UIManager.getColor("Button.background"));
		secondConsultantInfo.setFont(new Font("Modern No. 20", Font.PLAIN, 
				16));
		add(secondConsultantInfo);

		String successRateTwo = "Success Rate : " + consultantList.getConsultant(1).getRate()+"%";
		JLabel secondSuccessRate = new JLabel(successRateTwo);
		secondSuccessRate.setBounds(200, 435, 176, 31);
		secondSuccessRate.setForeground(Color.BLACK);
		secondSuccessRate.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		add(secondSuccessRate);

		String costTwo = "Cost : " + consultantList.getConsultant(1).getPrice()+"$";
		JLabel secondCost = new JLabel(costTwo);
		secondCost.setBounds(465, 435, 476, 31);
		secondCost.setForeground(Color.BLACK);
		secondCost.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		add(secondCost);

		JButton consultLabel2 = new JButton("Consult");
		consultLabel2.setBounds(640, 435, 100, 31);
		consultLabel2.setForeground(Color.RED);
		consultLabel2.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		consultLabel2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(consultantList.getConsultant(1).consult(activeUser))
					((ExternalInvestors)topFrame).changeMainPanel(consultantList.getConsultant(1));
				else {					
					JOptionPane.showMessageDialog(null, "You don't have enough cash to perform this action.");
				}
			}});
		add(consultLabel2);

		// Third Consultant

		String nameThree =  consultantList.getConsultant(2).getName();
		JLabel thirdConsultantName = new JLabel(nameThree);
		thirdConsultantName.setBounds(200, 490, 476, 31);
		thirdConsultantName.setForeground(Color.BLACK);
		thirdConsultantName.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		add(thirdConsultantName);

		JTextArea thirdConsultantInfo = new JTextArea();
		String infoThree = consultantList.getConsultant(2).getText();
		thirdConsultantInfo.setText(infoThree);
		thirdConsultantInfo.setEditable(false);
		thirdConsultantInfo.setWrapStyleWord(true);
		thirdConsultantInfo.setLineWrap(true);
		thirdConsultantInfo.setBounds(200, 520, 355, 85);
		thirdConsultantInfo.setForeground(Color.BLACK);
		thirdConsultantInfo.setBackground(UIManager.getColor("Button.background"));
		thirdConsultantInfo.setFont(new Font("Modern No. 20", Font.PLAIN, 
				16));
		add(thirdConsultantInfo);


		String successRateThree = "Success Rate : " + consultantList.getConsultant(2).getRate()+"%";
		JLabel thirdSuccessRate = new JLabel(successRateThree);
		thirdSuccessRate.setBounds(200, 605, 176, 31);
		thirdSuccessRate.setForeground(Color.BLACK);
		thirdSuccessRate.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		add(thirdSuccessRate);

		String costThree = "Cost : " + consultantList.getConsultant(2).getPrice()+"$";
		JLabel thirdCost = new JLabel(costThree);
		thirdCost.setBounds(465, 605, 476, 31);
		thirdCost.setForeground(Color.BLACK);
		thirdCost.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		add(thirdCost);

		JButton consultLabel3 = new JButton("Consult");
		consultLabel3.setBounds(640, 605, 100, 31);
		consultLabel3.setForeground(Color.RED);
		consultLabel3.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		consultLabel3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(consultantList.getConsultant(2).consult(activeUser))
					((ExternalInvestors)topFrame).changeMainPanel(consultantList.getConsultant(2));
				else {					
					JOptionPane.showMessageDialog(null, "You don't have enough cash to perform this action.");
				}
			}
		});
		add(consultLabel3);

		repaint();


		try {
			img = ImageIO.read( new File( consultantList.getConsultant(0).getPhoto() ) );
			img1 = ImageIO.read( new File( consultantList.getConsultant(1).getPhoto() ) );
			img2 = ImageIO.read( new File( consultantList.getConsultant(2).getPhoto() ) );
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g) {

		//super.paintComponent(g);

		g.drawLine(30, 110, 800, 110);
		g.drawImage( img , 60, 150, null );
		g.drawImage( img1 , 60, 320, null );
		g.drawImage( img2 , 60, 490, null );
		g.drawRect(60, 150, 120, 150);
		g.drawRect(60, 320, 120, 150);
		g.drawRect(60, 490, 120, 150);
	}
}
