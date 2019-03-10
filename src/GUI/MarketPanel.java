package GUI;

import model.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;

/** A class to view market panel
  * 
  * @author Irem Ecem Yelkanat & Duygu Nur Yaldiz
  * @version 19/12/2018
  */ 
public class MarketPanel extends JPanel {
   
   // Properties
   private JTextField searchField;
   private SortedPanelContainer container;
   private ArrayList<SortedPanel> panels;
   private JPanel marketPanel;
   private JComboBox<String> comboBox;
   private JFrame topFrame;
   
   /**
    * Create the panel.
    * 
    * @param frame the frame that the panel will be added
    */
   public MarketPanel(JFrame frame) {
      
      // Set panel properties
      setPreferredSize (new Dimension(850, 700));
      setLayout(null);
      
      // Initialize
      topFrame = frame;
      container = new SortedPanelContainer(frame);  
      
      // Create labels
      JLabel lblMarketLabel = new JLabel("Market");
      lblMarketLabel.setForeground(Color.BLUE);
      lblMarketLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
      lblMarketLabel.setBounds(80, 63, 85, 31);
      add(lblMarketLabel);
      
      JLabel lblSortBy = new JLabel("Sort by");
      lblSortBy.setBounds(50, 139, 50, 16);
      add(lblSortBy);
      
      JLabel lblSearch = new JLabel("Search:");
      lblSearch.setBounds(335, 139, 50, 16);
      add(lblSearch);
      
      // Create fields
      searchField = new JTextField();
      searchField.setBounds(389, 132, 156, 30);
      add(searchField);
      searchField.setColumns(10);
      
      // Create panels
      marketPanel = new JPanel();
      marketPanel.setBounds(50, 220, 850, 400);
      marketPanel.setLayout(new GridLayout (10, 1));
      add(marketPanel);
      
      // Create buttons
      JButton searchButton = new JButton("Search");
      searchButton.setBounds(546, 134, 98, 29);
      searchButton.addActionListener( new SearchListener() );
      add(searchButton);
      
      // Create labels
      JLabel lblBuy = new JLabel("Buy ($)");
      lblBuy.setBounds(263, 185, 44, 16);
      add(lblBuy);
      
      JLabel lblSell = new JLabel("Sell ($)");
      lblSell.setBounds(471, 185, 50, 16);
      add(lblSell);
      
      JLabel lblName = new JLabel("Stock Name");
      lblName.setBounds(55, 185, 75, 16);
      add(lblName);
      
      JLabel lblChange = new JLabel("Change (%)");
      lblChange.setBounds(685, 185, 70, 16);
      add(lblChange);
      
      // Create combo box for filtering
      comboBox = new JComboBox<String>();
      comboBox.setBounds(101, 135, 144, 27);
      comboBox.addItem("Increasing");
      comboBox.addItem("Decreasing");
      comboBox.addItem("Change: Low to High");
      comboBox.addItem("Change: High to Low");
      comboBox.addActionListener( new SearchListener() );
      add(comboBox);
      panels = container.sortByIncreasingValue();
      
      // Add panels to main panel
      for (SortedPanel panel : panels) {
         marketPanel.add(panel);
      }
      repaint();
   }
   
   /** Class to implement action listener
     */ 
   class SearchListener implements ActionListener {
      
      /** Process the performed action
        * @param e the action event
        */ 
      public void actionPerformed(ActionEvent e) {
         
         marketPanel.removeAll();
         String s = (String) comboBox.getSelectedItem();
         
         // Process the choices
         if ( s.equals("Increasing") && searchField.getText().length() == 0) {
            
            panels = container.sortByIncreasingValue();
            
            for (SortedPanel panel : panels) {
               marketPanel.add(panel);
            }
         }
         
         else if ( s.equals("Increasing") && searchField.getText().length() != 0) {
            
            String text = searchField.getText();
            Market searchedMarket = ((ExternalInvestors)topFrame).getMarket().getSearchingResults( text );
            panels = container.sortByIncreasingValue(searchedMarket);
            
            for (SortedPanel panel : panels) {
               marketPanel.add(panel);
            }
         }
         
         else if (s.equals("Decreasing") && searchField.getText().length() == 0) {
            
            panels = container.sortByDecreasingValue();
            
            for (SortedPanel panel : panels) {
               marketPanel.add(panel);
            }
         }
         
         else if ( s.equals("Decreasing") && searchField.getText().length() != 0) {
            
            String text = searchField.getText();
            Market searchedMarket = ((ExternalInvestors)topFrame).getMarket().getSearchingResults( text );
            panels = container.sortByDecreasingValue(searchedMarket);
            
            for (SortedPanel panel : panels) {
               marketPanel.add(panel);
            }
         }
         
         else if ( s.equals("Change: Low to High") && searchField.getText().length() == 0 ) {
            
            panels = container.sortByIncreasingChange();
            
            for (SortedPanel panel : panels) {
               marketPanel.add(panel);
            }
         }
         
         else if( s.equals("Change: Low to High") && searchField.getText().length() != 0 ) {
            
            String text = searchField.getText();
            Market searchedMarket = ((ExternalInvestors)topFrame).getMarket().getSearchingResults( text );
            panels = container.sortByIncreasingChange(searchedMarket);
            
            for (SortedPanel panel : panels) {
               marketPanel.add(panel);
            }
         }
         
         else if ( s.equals("Change: High to Low") && searchField.getText().length() == 0 ) {
            
            panels = container.sortByDecreasingChange();
            
            for (SortedPanel panel : panels) {
               marketPanel.add(panel);
            }
         }
         
         else if( s.equals("Change: High to Low") && searchField.getText().length() != 0 ) {
            
            String text = searchField.getText();
            Market searchedMarket = ((ExternalInvestors)topFrame).getMarket().getSearchingResults( text );
            panels = container.sortByDecreasingChange(searchedMarket);
            
            for (SortedPanel panel : panels) {
               marketPanel.add(panel);
            }
         }
         
         repaint();
      }
   }
   
   /* Paints the components
    * @param g the default swing parameter
    */
   public void paintComponent(Graphics g) {
      
      super.paintComponent(g);
      g.drawLine(30, 110, 800, 110);
      g.drawLine(30, 210, 800, 210);
   }
   
}
