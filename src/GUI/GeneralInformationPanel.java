package GUI;

import model.*;
import java.awt.*;
import javax.swing.*;

/**
 * A panel for performing general information actions
 * 
 * @author Irem Ecem Yelkanat & Duygu Nur Yaldiz
 * @version 17/12/2018
 */
public class GeneralInformationPanel extends JPanel {
   
   //Properties
   private JFrame topFrame;
   
   /**
    * Create the panel.
    *
    * @param frame the frame that the panel will be added
    */
   public GeneralInformationPanel(JFrame frame) {
      
      // Initialize
      topFrame = frame;
      
      //set panel's properties
      setPreferredSize (new Dimension(850, 700));
      setLayout(null);
      setBackground(new Color(230, 255, 255));
      
      //Create labels
      JLabel profileLabel = new JLabel("Profile");
      profileLabel.setForeground( Color.BLUE );
      profileLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
      profileLabel.setBounds(45, 45, 85, 31);
      add(profileLabel);
      
      JLabel lblGeneralInformation = new JLabel("> General Information");
      lblGeneralInformation.setBounds(131, 45, 270, 31);
      lblGeneralInformation.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
      add(lblGeneralInformation);
      
      JLabel lblUsername = new JLabel("Username:");
      lblUsername.setBounds(67, 144, 76, 20);
      lblUsername.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
      add(lblUsername);
      
      JLabel lblUsername2 = new JLabel( ((ExternalInvestors)topFrame).getAccountContainer().getActiveUser().getUsername() );
      lblUsername2.setBounds(150, 144, 200, 20);
      lblUsername2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
      add(lblUsername2);
      
      JLabel lastAccessLabel = new JLabel("Last Access:");
      lastAccessLabel.setBounds(402, 144, 90, 19);
      lastAccessLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
      add(lastAccessLabel);
      
      JLabel lastAccessLabel2 = new JLabel( ( ( ExternalInvestors ) topFrame ).getAccountContainer().getActiveUser().getLastAccess().toString() );
      lastAccessLabel2.setBounds(497, 144, 200, 19 );
      lastAccessLabel2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
      add(lastAccessLabel2);
      
      JLabel lblPortfolio = new JLabel("Portfolio:");
      lblPortfolio.setBounds(79, 184, 66, 19);
      lblPortfolio.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
      add(lblPortfolio);
      
      JLabel lblPortfolio2 = new JLabel( "" + ((ExternalInvestors)topFrame).getAccountContainer().getActiveUser().getPortfolio() );
      lblPortfolio2.setBounds(150, 184, 150 , 19);
      lblPortfolio2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
      add(lblPortfolio2);
      
      JLabel firstAccessLabel = new JLabel("First Access:");
      firstAccessLabel.setBounds(400, 184, 92, 19);
      firstAccessLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
      add(firstAccessLabel);
      
      JLabel firstAccessLabel2 = new JLabel( ((ExternalInvestors)topFrame).getAccountContainer().getActiveUser().getFirstAccess().toString());
      firstAccessLabel2.setBounds(500, 184, 200, 19);
      firstAccessLabel2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
      add(firstAccessLabel2);
      
      JLabel cashLabel = new JLabel("Cash:");
      cashLabel.setBounds(98, 224, 40, 19);
      cashLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
      add(cashLabel);
      
      JLabel cashLabel2 = new JLabel( "" + ( ( ExternalInvestors ) topFrame ).getAccountContainer().getActiveUser().getCash() );
      cashLabel2.setBounds(150, 224, 150, 19);
      cashLabel2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
      add(cashLabel2);
      
      repaint();
   }
   
   /* Paints the components
    * @param g the default swing parameter
    */
   public void paintComponent(Graphics g) {
      
      //super.paintComponent(g);
      g.drawLine(30, 100, 800, 100);
   }
   
}