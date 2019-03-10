package GUI;

import model.*;

import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Observer;

import javax.swing.*;

/**
 * A frame for the application
 * 
 * @author Irem Ecem Yelkanat & Duygu Nur Yaldiz & Arda Goktogan
 * @version 23/12/2018
 */
public class ExternalInvestors extends JFrame {

	//Properties
	private JPanel sidePanel;
	private JPanel mainPanel;
	private AccountContainer accounts;
	private Market market;
	private NewsContainer news;
	private AllNews allNews;
	private MarketTime time;
	private TimeListener timeListener;
	private Timer timer;
	private int newsOccur = 0;
	private int unviewedNews = 0;
	private News nextNews;

	/**
	 * Constructs the main frame of the program which includes two panels and three model objects.
	 */
	public ExternalInvestors() {

		//create model objects
		accounts = new AccountContainer();
		market = new Market();
		news = new NewsContainer();
		allNews = new AllNews();
		timeListener = new TimeListener();

		// Initialize
		timer = new Timer( 1000 , timeListener );
		timer.start();
		unviewedNews = 0;

		// Get the newa
		try {
			nextNews = allNews.next();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		//set frame properties
		setBackground(new Color(233, 233, 233));
		setMaximumSize (new Dimension (1062,750));
		setMinimumSize (new Dimension (1062,750));
		setLayout(new BorderLayout());

		//initialize panels
		mainPanel = new LoginPanel(this);
		sidePanel = new SidePanel(this);

		//add main panel to the frame
		add(mainPanel, BorderLayout.CENTER);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	/**
	 * Changes the main panel of the program according to the given index parameter.
	 * @param index the index of the main panel to change.
	 */
	public void changeMainPanel( int index ) {

		//set panel according to given index

		JPanel panel;

		if( index == 0 ) 
		{
			panel = new ChangePasswordPanel(this);
		}
		else if( index == 1 ) 
		{
			panel = null;
		}
		else if( index == 2 ) 
		{
			panel = new ForgotPasswordPanel(this);
		}
		else if( index == 3 ) 
		{
			panel = new GeneralInformationPanel(this);
		}
		else if( index == 4 ) 
		{
			panel = new InAndOutPanel(this);
		}
		else if( index == 5 ) 
		{
			panel = new LeaderboardPanel(this);
		}
		else if( index == 6 ) 
		{
			panel = new LoginPanel(this);
		}
		else if( index == 7 ) 
		{
			panel = new MarketPanel(this);
		}

		else if( index == 8 ) 
		{
			panel = new NewsPanel( this );
			news.addObserver( (Observer) panel );
		}
		else if( index == 9 )
		{
			panel = new ProfileOptionsPanel(this);
		}
		else if( index == 10 )
		{
			//panel = new StockPanel( this );
			panel = null;
		}
		else if( index == 11 ) 
		{
			panel = new TradingHistoryPanel(this);
		}
		else if( index == 12 )
		{
			panel = new CreateAccount(this);
		}
		else if( index == 13 )
		{
			panel = new ChangeUsernamePanel(this);
		}
		else if( index == 14 )
		{
			panel = new WelcomePanel(this);
		}
		else if(index == 15)
		{
			panel = new OwnedStocksPanel( this );
		}
		else //index == 16
		{
			panel = new ConsultPanel(this);
		}

		//change main panel
		this.getContentPane().remove(mainPanel);
		mainPanel = panel;
		this.add(mainPanel, BorderLayout.CENTER );
		this.repaint();
		this.setVisible(true);
	}

	/**
	 * Changes the main panel to a stock panel that shows a specific stock
	 * @param stock the panel's
	 */
	public void changeMainPanel( Stock stock ) {

		JPanel panel;
		this.getContentPane().remove(mainPanel);
		panel = new StockViewer( stock , this );
		mainPanel = panel;
		this.add(mainPanel, BorderLayout.CENTER );
		this.repaint();
		this.setVisible(true);
	}

	/**
	 * Changes the main panel to a new panel that shows a specific news
	 * @param news
	 */
	public void changeMainPanel( News news ) {

		JPanel panel = new OneNewsPanel(this, news);

		this.getContentPane().remove(mainPanel);
		mainPanel = panel;
		this.add(mainPanel, BorderLayout.CENTER );
		this.repaint();
		this.setVisible(true);
	}

	/**
	 * Changes the main panel to a consultant panel that shows a specific consultant
	 * @param consultant the panel's
	 */
	public void changeMainPanel (  Consultant consultant ) {

		JPanel panel = new ConsultantPanelOne(this, consultant);

		this.getContentPane().remove(mainPanel);
		mainPanel = panel;
		this.add(mainPanel, BorderLayout.CENTER );
		this.repaint();
		this.setVisible(true);
	}

	/**
	 * Changes the side panel of the program according to the given index parameter
	 * @param index the index of the side panel to be changed
	 */
	public void changeSidePanel( int index ) {

		//remove existing side panel
		this.getContentPane().remove(sidePanel);

		//change side panel if necessary
		if( index == 0 || index == 1) {
			JPanel panel;
			if( index == 0 ) 
				panel = new SidePanel(this);
			else //index == 1
				panel = new SidePanelDetailed(this);

			sidePanel = panel;
			this.add(sidePanel, BorderLayout.WEST );
			this.repaint();
			this.setVisible(true);
		}
	}

	/** A class for listener
	 */ 
	class TimeListener implements ActionListener{

		/** Processes the action
		 * @param e the action event
		 */ 
		public void actionPerformed(ActionEvent e) {

			// Increase news
			newsOccur++;

			if( newsOccur == 50 ) {
				newsOccur = 0;
				unviewedNews++;

				if( sidePanel instanceof SidePanel ) {

					(( SidePanel ) sidePanel ).updateNews( unviewedNews );
				}

				else if( sidePanel instanceof SidePanelDetailed ) {
					( (SidePanelDetailed) sidePanel ).updateNews( unviewedNews );
				}

				// Add the news
				try {
					news.add( nextNews , market );
					nextNews = allNews.next();

				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}

			// Increase time
			MarketTime.increaseCurrentTime();

			// Increase displayed time
			if( sidePanel instanceof SidePanel ) {
				( (SidePanel) sidePanel ).updateTime();
			}

			else if( sidePanel instanceof SidePanelDetailed ) {
				( (SidePanelDetailed) sidePanel ).updateTime();
			}

			repaint();
			revalidate();
		}  
	}

	/**
	 * Returns the market object of the program
	 * @return the market object of the program
	 */
	public Market getMarket() {
		return market;
	}

	/**
	 * Returns the account container object of the program
	 * @return the account container object of the program
	 */
	public AccountContainer getAccountContainer() {
		return accounts;
	}

	/**
	 * returns the news container object of the program
	 * @return the newsContaier object of the program
	 */
	public NewsContainer getNewsContainer() {
		return news;
	}

	/**
	 * return the news which is going to occur.
	 * @return the news which is going to occur.
	 */
	public News getNextNews() {
		return nextNews;
	}

	/**
	 * resets the number of views
	 */ 
	public void resetNews() {

		unviewedNews = 0;

		if( sidePanel instanceof SidePanel ) {
			(( SidePanel ) sidePanel ).updateNews( unviewedNews );
		}

		else if( sidePanel instanceof SidePanelDetailed ) {
			( (SidePanelDetailed) sidePanel ).updateNews( unviewedNews );
		} 
	}

	/**
	 * returns number of unviewed news
	 * @return number of unviewed news
	 */
	public int getNumOfNews() {
		return unviewedNews;
	}


	/**
	 * Main method of the program to start it.
	 * @param args
	 */
	public static void main (String args[])
	{
		new ExternalInvestors();
	}

}