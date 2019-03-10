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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import model.Account;
import model.AllNews;
import model.Consultant;

/**
 * A panel for consultant
 * 
 * @author Eren Senoglu, Batuhan Özçömlekçi
 * @version 23/12/2018
 */
public class ConsultantPanelOne extends JPanel {

	// Properties
	private JFrame topFrame;
	private Account activeUser;
	private ExternalInvestors gameModel;
	private Consultant consultant;
	private BufferedImage img;

	/** Constructs a consultant pane with the given parameters
	 * @param frame the frame that the panel will be added
	 * @param consultant the consultant
	 */ 
	public ConsultantPanelOne(JFrame frame, Consultant consultant) {

		// Initialize
		this.consultant = consultant;
		topFrame = frame;
		activeUser = ( ( ExternalInvestors ) topFrame ).getAccountContainer().getActiveUser();
		gameModel = ( ExternalInvestors ) topFrame;

		//set panel's properties
		setPreferredSize (new Dimension(850, 700));
		setLayout(null);

		//Create labels
		JLabel headerLabel = new JLabel("Consultant");
		headerLabel.setBounds(84, 63, 476, 31);
		headerLabel.setForeground(Color.BLUE);
		headerLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		add(headerLabel);

		JLabel consultantName = new JLabel(consultant.getName());
		consultantName.setBounds(200, 150, 476, 31);
		consultantName.setForeground(Color.BLACK);
		consultantName.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		add(consultantName);

		JTextArea adviceInfo = new JTextArea();
		String advice = consultant.getAdvice( ( (ExternalInvestors)topFrame 
				).getAccountContainer().getActiveUser() , ( (ExternalInvestors)topFrame 
						).getNextNews()  );
		String myString2 =   advice ;
		adviceInfo.setText(myString2);
		adviceInfo.setEditable(false);
		adviceInfo.setWrapStyleWord(true);
		adviceInfo.setLineWrap(true);
		adviceInfo.setBounds(200, 180, 476, 116);
		adviceInfo.setForeground(Color.BLACK);
		adviceInfo.setBackground(UIManager.getColor("Button.background"));
		adviceInfo.setFont(new Font("Modern No. 20", Font.PLAIN, 16));
		add(adviceInfo);

		JButton marketLabel = new JButton("Go To Market");
		marketLabel.setBounds(160, 565, 200, 31);
		marketLabel.setForeground(Color.RED);
		marketLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 17));

		marketLabel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				((ExternalInvestors)topFrame).changeMainPanel(7);

			}
		});
		add(marketLabel);

		// Add return label
				JButton returnLabel = new JButton("Return");
				returnLabel.setBounds(460, 565, 200, 31);
				returnLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 17));

				returnLabel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						((ExternalInvestors)topFrame).changeMainPanel(16);

					}
				});
				add(returnLabel);

				// Insert the image

				try {
					img = ImageIO.read( new File( consultant.getPhoto() ) );

				} catch (IOException e) {
					e.printStackTrace();
				}
	}

	/* Paints the components
	 * @param g the default swing parameter
	 */
	public void paintComponent(Graphics g) {

		g.drawLine(30, 110, 800, 110);
		g.drawImage(img, 60, 150, null);
		g.drawRect(60, 150, 120, 150);
	}
}
