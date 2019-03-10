/**
 * @author : Eren Þenoðlu, Ýrem Ecem Yelkanat, Batuhan Özçömlekçi
 * @version: 24.12.2018
 */

package GUI;

import model.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

// TODO: Auto-generated Javadoc
/**
 * The Class SidePanel.
 */
public class SidePanel extends JPanel {

	/** The top frame. */
	//Properties
	JFrame topFrame;
	
	/** The time. */
	MarketTime time;
	
	/** The time label. */
	JLabel timeLabel;
	
	/** The news button. */
	private JButton newsButton;

	/**
	 * Create the panel.
	 *
	 * @param frame the frame
	 */
	public SidePanel( JFrame frame) {

		topFrame = frame;

		//set panel's properties
		setBackground(new Color(230, 255, 255));
		setPreferredSize (new Dimension (212, 700));
		setMaximumSize( new Dimension (212, 700) );
		setLayout(null);
		Color buttonColor = new Color(200, 200, 200);

		//create profile button and add listener that changes the side panel to detailed one
		JButton profileButton = new JButton("Profile");
		profileButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		profileButton.setOpaque(true);
		profileButton.setBorderPainted(false);
		profileButton.setBackground( buttonColor );
		profileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((ExternalInvestors)topFrame).changeSidePanel(1);
			}
		});
		profileButton.setBounds(6, 6, 200, 50);
		add(profileButton);

		//create market button and add listener that changes main panel to market panel
		JButton marketButton = new JButton("Market");
		marketButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		marketButton.setBackground( buttonColor );
		marketButton.setOpaque(true);
		marketButton.setBorderPainted(false);
		marketButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((ExternalInvestors)topFrame).changeMainPanel(7);
			}
		});
		marketButton.setBounds(6, 58, 200, 50);
		add(marketButton);

		//Create leaderboard button and add listener that chages main panel to leaderboard panel
		JButton leaderboardButton = new JButton("Leaderboard");
		leaderboardButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		leaderboardButton.setBackground( buttonColor );
		leaderboardButton.setOpaque(true);
		leaderboardButton.setBorderPainted(false);
		leaderboardButton.setBounds(6, 110, 200, 50);
		leaderboardButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((ExternalInvestors)topFrame).changeMainPanel(5);
			}
		});
		add(leaderboardButton);

		//create news button and add listener that changes main panel to news panel
		newsButton = new JButton("News");
		int numOfUnviewedNews = ((ExternalInvestors)topFrame).getNumOfNews();
		
		if( numOfUnviewedNews > 0 )
			newsButton.setText( "News " + "(" + numOfUnviewedNews + ")" );
		else
			newsButton.setText( "News" );

		newsButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		newsButton.setBackground( buttonColor );
		newsButton.setOpaque(true);
		newsButton.setBorderPainted(false);
		newsButton.setBounds(6, 162, 200, 50);
		newsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				((ExternalInvestors)topFrame).resetNews();
				
				((ExternalInvestors)topFrame).changeMainPanel(8);
			}
		});
		add(newsButton);
		
		JButton consultButton = new JButton("Consult With An Expert");
		  consultButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		  consultButton.setBackground(new Color(169, 169, 169));
		  consultButton.setOpaque(true);
		  consultButton.setBorderPainted(false);
		  consultButton.setBounds(6, 214, 200, 50);
		  consultButton.addActionListener(new ActionListener() {
		   public void actionPerformed(ActionEvent e) {
		    ((ExternalInvestors)topFrame).changeMainPanel(16);
		   }
		  });
		  add(consultButton);


		//create logout button and add listener that removes side panel and changes main panel to login panel
		JButton logoutButton = new JButton(" Logout");
		logoutButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		logoutButton.setBackground( new Color(220, 20, 60) );
		logoutButton.setOpaque(true);
		logoutButton.setBorderPainted(false);
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO last access will be determined
				
				//set last access
				( (ExternalInvestors)topFrame ).getAccountContainer().getActiveUser().setLastAccess( new MarketTime() );
				
				((ExternalInvestors)topFrame).changeSidePanel(2);
				((ExternalInvestors)topFrame).changeMainPanel(6);
			}
		});
		logoutButton.setBounds(6, 318, 200, 50);
		add(logoutButton);

		//show time 
		time = new MarketTime();
		timeLabel = new JLabel( time.toString() );
		timeLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		timeLabel.setOpaque(true);
		timeLabel.setBounds(6, 266, 200, 50);
		add(timeLabel);
		

	}
	
	/**
	 * Update time.
	 */
	public void updateTime() {
		
		time = new MarketTime();
		timeLabel.setText( time.toString() );
		revalidate();
		repaint();
	}
	
	
	/**
	 * Update news.
	 *
	 * @param num the num
	 */
	public void updateNews( int num ) {
		if( num > 0 )
			newsButton.setText( "News " + "(" + num + ")" );
		else
			newsButton.setText( "News" );
	}


}

