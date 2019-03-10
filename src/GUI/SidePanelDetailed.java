/**
 * @author : Eren Þenoðlu, Ýrem Ecem Yelkanat, Batuhan Özçömlekçi
 * @version: 24.12.2018
 */
package GUI;


import model.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.Font;
import javax.swing.UIManager;

// TODO: Auto-generated Javadoc
/**
 * The Class SidePanelDetailed.
 */
public class SidePanelDetailed extends JPanel {

	/** The top frame. */
	//Properties
	JFrame topFrame;

	/** The time. */
	MarketTime time;
	
	/** The time label. */
	JLabel timeLabel;
	
	/** The news button. */
	JButton newsButton;

	/**
	 * Create the panel.
	 *
	 * @param frame the frame
	 */
	public SidePanelDetailed(JFrame frame) {

		topFrame = frame;

		//set panel's properties
		setBackground(new Color(230, 255, 255));
		Color buttonColor = new Color(200, 200, 200);
		setPreferredSize (new Dimension (212, 700));
		setLayout(null);

		//create profile button and add listener that changes the side panel to detailed one
		JButton profileButton = new JButton("Profile");
		profileButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		profileButton.setOpaque(true);
		profileButton.setBorderPainted(false);
		profileButton.setBackground( buttonColor );
		profileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		profileButton.setBounds(6, 6, 200, 50);
		add(profileButton);

		//create general information button and add listener that changes main panel to general information panel
		JButton generalInformationButton = new JButton("General Information");
		generalInformationButton.setBackground(new Color(211, 211, 211) );
		generalInformationButton.setOpaque(true);
		generalInformationButton.setBorderPainted(false);
		generalInformationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((ExternalInvestors)topFrame).changeMainPanel(3);
			}
		});
		generalInformationButton.setBounds(6, 56, 200, 29);
		add(generalInformationButton);

		//create  owned stocks panel and add listenr that changes main panel to owned stocks panel
		JButton ownedStocksButton = new JButton("Owned Stocks");
		ownedStocksButton.setBackground(new Color(211, 211, 211));
		ownedStocksButton.setOpaque(true);
		ownedStocksButton.setBorderPainted(false);
		ownedStocksButton.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				((ExternalInvestors)topFrame).changeMainPanel(15); 
			}
		});
		ownedStocksButton.setBounds(6, 87, 200, 29);
		add(ownedStocksButton);

		//create trading istory button and add listener that changes main panel to trading history panel
		JButton tradingHistoryButton = new JButton("Trading History");
		tradingHistoryButton.setBackground(new Color(211, 211, 211));
		tradingHistoryButton.setOpaque(true);
		tradingHistoryButton.setBorderPainted(false);
		tradingHistoryButton.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				((ExternalInvestors)topFrame).changeMainPanel(11);
			}
		});
		tradingHistoryButton.setBounds(6, 118, 200, 29);
		add(tradingHistoryButton);

		//create profile options button and add listener that changes main panel to profile options panel
		JButton profileOptionsButton = new JButton("Profile Options");
		profileOptionsButton.setBackground(new Color(211, 211, 211));
		profileOptionsButton.setOpaque(true);
		profileOptionsButton.setBorderPainted(false);
		profileOptionsButton.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				((ExternalInvestors)topFrame).changeMainPanel(9);
			}
		});
		profileOptionsButton.setBounds(6, 149, 200, 29);
		add(profileOptionsButton);

		//create market button and add listener that changes main panel to market panel
		JButton marketButton = new JButton("Market");
		marketButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		marketButton.setBackground( buttonColor );
		marketButton.setOpaque(true);
		marketButton.setBorderPainted(false);
		marketButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((ExternalInvestors)topFrame).changeMainPanel(7);
				((ExternalInvestors)topFrame).changeSidePanel(0);
			}
		});
		marketButton.setBounds(6, 181, 200, 50);
		add(marketButton);

		//Create leaderboard button and add listener that chages main panel to leaderboard panel
		JButton leaderboardButton = new JButton("Leaderboard");
		leaderboardButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		leaderboardButton.setBackground( buttonColor );
		leaderboardButton.setOpaque(true);
		leaderboardButton.setBorderPainted(false);
		leaderboardButton.setBounds(6, 233, 200, 50);
		leaderboardButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((ExternalInvestors)topFrame).changeMainPanel(5);
				((ExternalInvestors)topFrame).changeSidePanel(0);
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
		newsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				((ExternalInvestors)topFrame).resetNews();

				((ExternalInvestors)topFrame).changeMainPanel(8);
				((ExternalInvestors)topFrame).changeSidePanel(0);
			}
		});
		newsButton.setBounds(6, 285, 200, 50);
		add(newsButton);

		////Creates consult button and add listener that changes main panel to consult panel
		JButton consultButton = new JButton("Consult With An Expert");
		  consultButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		  consultButton.setBackground(new Color(169, 169, 169));
		  consultButton.setOpaque(true);
		  consultButton.setBorderPainted(false);
		  consultButton.addActionListener(new ActionListener() {
		   public void actionPerformed(ActionEvent e) {
			   ((ExternalInvestors)topFrame).changeMainPanel(16);
			   ((ExternalInvestors)topFrame).changeSidePanel(0);
			   
		   }
		  });
		  consultButton.setBounds(6, 337, 200, 50);
		  add(consultButton);
		
		
		//create logout button and add listener that removes side panel and changes main panel to login panel
		JButton logoutButton = new JButton("Logout");
		logoutButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		logoutButton.setBackground(new Color(220, 20, 60));
		logoutButton.setOpaque(true);
		logoutButton.setBorderPainted(false);
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO last access will be determined

				( (ExternalInvestors)topFrame ).getAccountContainer().getActiveUser().setLastAccess( new MarketTime() );
				((ExternalInvestors)topFrame).changeSidePanel(2);
				((ExternalInvestors)topFrame).changeMainPanel(6);
			}
		});
		logoutButton.setBounds(6, 389, 200, 50);
		add(logoutButton);

		//show time 
		time = new MarketTime();
		timeLabel = new JLabel( time.toString() );
		timeLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		timeLabel.setOpaque(true);
		timeLabel.setBounds(6, 440 , 200, 50);
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
