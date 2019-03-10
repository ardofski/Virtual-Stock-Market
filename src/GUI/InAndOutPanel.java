package GUI;


import model.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.JScrollBar;

/**
 * A panel for show in and out report
 * 
 * @author Arda Goktogan
 * @version 20/12/2018
 */
public class InAndOutPanel extends JPanel {
   
   //Properties
   private JFrame topFrame;
   private int xMargin1;
   private int xMargin2;
   private int xMargin3;
   private int xMargin4;
   private int yMargin;
   private int rowMargin;
   private JLabel stockName;
   private JLabel changeLabel;
   private JLabel oldPriceLabel;
   private JLabel newPriceLabel;
   private MarketTime lastAccess; 
   
   /**
    * Create the panel.
    *
    * @param frame the frame that the panel will be added
    */
   public InAndOutPanel(JFrame frame) {
      
      // Initialize
      topFrame = frame;
      xMargin1 = 60;
      xMargin2 = 196;
      xMargin3 = 371;
      xMargin4 = 510;
      yMargin = 150;
      rowMargin = 40;
      lastAccess = ( (ExternalInvestors)topFrame ).getAccountContainer().getActiveUser().getLastAccess(); 
      
      // Reset the new
      ((ExternalInvestors)topFrame).resetNews(); 
      
      // Set panel properties
      setPreferredSize (new Dimension(850, 700));
      setLayout(null);
      
      // Add labels
      JLabel lblInOutLabel = new JLabel("In and Out Report");
      lblInOutLabel.setForeground(Color.BLUE);
      lblInOutLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
      lblInOutLabel.setBounds(80, 63, 235, 31);
      add(lblInOutLabel);
      
      JLabel lblStockLabel = new JLabel("Stock Name");
      lblStockLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
      lblStockLabel.setBounds(60, 148, 92, 20);
      add(lblStockLabel);
      
      JLabel lblChangeLabel = new JLabel("Change In Value");
      lblChangeLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
      lblChangeLabel.setBounds(196, 149, 129, 20);
      add(lblChangeLabel);
      
      JLabel lblOldPriceLabel = new JLabel("Old Price ($)");
      lblOldPriceLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
      lblOldPriceLabel.setBounds(371, 149, 94, 20);
      add(lblOldPriceLabel);
      
      JLabel lblNewPriceLabel = new JLabel("New Price ($)");
      lblNewPriceLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
      lblNewPriceLabel.setBounds(510, 149, 94, 20);
      add(lblNewPriceLabel);
      
      // Set the layouts
      for( int  i = 1 ; i <= StockContainer.TOTAL_NUM_OF_STOCKS ; i++ ) {
         
         System.out.println(i);
         
         //create labels
         stockName = new JLabel();
         changeLabel = new JLabel( );
         oldPriceLabel = new JLabel( );
         newPriceLabel = new JLabel( );
         
         stockName.setText( "" + ( (ExternalInvestors)topFrame).getMarket().getStocks()[i-1].getCompanyName()  );  
         stockName.setBounds( xMargin1, yMargin + rowMargin*i , 150, 20);
         add(stockName);
         
         String difference = String.format( "%.3f", ( (ExternalInvestors)topFrame).getMarket().getStocks()[i-1].getDifference( lastAccess, new MarketTime() ) );
         changeLabel.setText( "" + difference  );
         changeLabel.setBounds( xMargin2, yMargin + rowMargin*i , 150, 20);
         add(changeLabel);
         
         String oldPrice = String.format( "%.3f", ( (ExternalInvestors)topFrame).getMarket().getStocks()[i-1].getStockHistory().getHistoryDataAt( lastAccess ).getBuyValue() );
         oldPriceLabel.setText( "" + oldPrice  );
         oldPriceLabel.setBounds( xMargin3, yMargin + rowMargin*i , 150, 20);
         add(oldPriceLabel);
         
         String newPrice = String.format( "%.3f", ( (ExternalInvestors)topFrame).getMarket().getStocks()[i-1].getBuyValue() );
         newPriceLabel.setText( "" + newPrice  );
         newPriceLabel.setBounds( xMargin4, yMargin + rowMargin*i , 150, 20);
         add(newPriceLabel);  
      }
      
      repaint();
   }
   
   public void paintComponent(Graphics g) {
      
      //super.paintComponent(g);
      g.drawLine(30, 110, 800, 110);
      g.drawLine(30, 180, 800, 180);
   }
}
