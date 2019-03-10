package GUI;


import model.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

/**
 * A panel for show in and out report
 * 
 * @author Arda Goktogan
 * @version 20/12/2018
 */
public class LeaderboardPanel extends JPanel {
   
   //Properties
   private JFrame topFrame;
   
   // Static variables
   final static int LEADER_NUMBER = 5;
   final static int TITLE_SIZE = 25;
   final static int TEXT_SIZE = 15;
   
   /**
    * Create the panel.
    *
    * @param frame the frame that the panel will be added
    */
   public LeaderboardPanel(JFrame frame) {
      
      // Initialize
      topFrame = frame;
      
      // Set panel properties
      setPreferredSize (new Dimension(850, 700));
      setLayout(null);
      
      // Create labels
      JLabel lblLeaderboardLabel = new JLabel("Leaderboard");
      lblLeaderboardLabel.setForeground(Color.BLUE);
      lblLeaderboardLabel.setFont( new Font("Lucida Grande", Font.PLAIN, TITLE_SIZE ) );
      lblLeaderboardLabel.setBounds(80, 63, 177, 31);
      add(lblLeaderboardLabel);
      
      JLabel lblRankLabel = new JLabel("Rank");
      lblRankLabel.setFont(new Font("Lucida Grande", Font.PLAIN, TEXT_SIZE));
      lblRankLabel.setBounds(51, 142, 61, 16);
      add(lblRankLabel);
      
      JLabel lblUsernameLabel = new JLabel("Username");
      lblUsernameLabel.setFont(new Font("Lucida Grande", Font.PLAIN, TEXT_SIZE));
      lblUsernameLabel.setBounds(258, 142, 80, 16);
      add(lblUsernameLabel);
      
      JLabel lblPortfolioLabel = new JLabel("Portfolio ($)");
      lblPortfolioLabel.setFont(new Font("Lucida Grande", Font.PLAIN, TEXT_SIZE));
      lblPortfolioLabel.setBounds(483, 142, 93, 16);
      add(lblPortfolioLabel);
      
      // Set bounds of the labels
      int RankX = 51;
      int rankY= 142;
      int userNameX = 258;
      int userNameY = 142;
      int portfolioX = 483;
      int portfolioY = 142;
      
      ArrayList<Account> accounts = ( (ExternalInvestors)topFrame ).getAccountContainer().sort();
      boolean isActieUserPrinted = false;
      Color blue = new Color(46,118,161);
      
      for( int  i = 1 ; i <= LEADER_NUMBER ; i++) {
         
         //create labels
         JLabel rankLabel = new JLabel( "" + i );
         JLabel userLabel = new JLabel( "" + accounts.get( i - 1).getUsername() );
         JLabel portfolioLabel = new JLabel( "" + accounts.get( i - 1 ).getPortfolio() );
         
         //if the current line is active user, print it in different way.
         if( accounts.get( i - 1) == ( (ExternalInvestors)topFrame ).getAccountContainer().getActiveUser() ) {
            isActieUserPrinted = true;
            rankLabel.setForeground( blue );
            userLabel.setForeground( blue );
            portfolioLabel.setForeground( blue );
            rankLabel.setFont(new Font("Lucida Grande", Font.BOLD, TEXT_SIZE));
            userLabel.setFont(new Font("Lucida Grande", Font.BOLD, TEXT_SIZE));
            portfolioLabel.setFont(new Font("Lucida Grande", Font.BOLD, TEXT_SIZE));
         }
         
         //if the current line is not active user, print it in normal way.
         else {
            rankLabel.setForeground( Color.BLACK );
            userLabel.setForeground( Color.BLACK );
            portfolioLabel.setForeground( Color.BLACK );
            rankLabel.setFont(new Font("Lucida Grande", Font.PLAIN, TEXT_SIZE ) );
            userLabel.setFont(new Font("Lucida Grande", Font.PLAIN, TEXT_SIZE ) );
            portfolioLabel.setFont(new Font("Lucida Grande", Font.PLAIN, TEXT_SIZE ));
         }
         
         rankLabel.setBounds( RankX, rankY + 50*i , 100, 20);
         add(rankLabel);
         
         userLabel.setBounds( userNameX, userNameY + 50*i , 100, 20);
         add(userLabel);
         
         portfolioLabel.setBounds(portfolioX,portfolioY + 50*i , 200, 20);
         add(portfolioLabel);
      }
      
      //if the active user is not in the top list, print it at the end of the list.
      if( !isActieUserPrinted ) {
         
         // Process labels
         JLabel rankLabel = new JLabel( "" + ( (ExternalInvestors)topFrame ).getAccountContainer().getRankOfUser( ( (ExternalInvestors)topFrame ).getAccountContainer().getActiveUser()  ) );
         JLabel userLabel = new JLabel( "" + ( (ExternalInvestors)topFrame ).getAccountContainer().getActiveUser().getUsername() );
         JLabel portfolioLabel = new JLabel( "" + ( (ExternalInvestors)topFrame ).getAccountContainer().getActiveUser().getPortfolio() );
         
         rankLabel.setFont(new Font("Lucida Grande", Font.BOLD, TEXT_SIZE) );
         userLabel.setFont(new Font("Lucida Grande", Font.BOLD, TEXT_SIZE ) );
         portfolioLabel.setFont(new Font("Lucida Grande", Font.BOLD, TEXT_SIZE ) );
         
         rankLabel.setForeground( blue );
         userLabel.setForeground( blue );
         portfolioLabel.setForeground( blue );
         
         rankLabel.setBounds( RankX, rankY + 50*6 , 100, 20);
         add(rankLabel);
         
         userLabel.setBounds( userNameX, userNameY + 50*6 , 100, 20);
         add(userLabel);
         
         portfolioLabel.setBounds(portfolioX,portfolioY + 50*6 , 200, 20);
         add(portfolioLabel);
      }
      
      repaint();
   }
   
   /* Paints the components
    * @param g the default swing parameter
    */
   public void paintComponent(Graphics g) {
      
      g.drawLine(30, 100, 600, 100);
      g.drawLine(30, 167, 600, 167);
   }
}
