package GUI;

import model.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

/** A class to display news
  * 
  * @author Duygu Nur Yaldiz
  * @version 19/12/2018
  */ 
public class NewsPanel extends JPanel implements Observer {
   
   //Properties
   private JFrame topFrame;
   private JPanel panel;
   private JScrollPane scrollpane;
   private JPanel allNewsPanel = new JPanel();
   
   /**
    * Create the panel.
    *
    * @param frame the frame that the panel will be added
    */
   public NewsPanel(JFrame frame) {
      
      topFrame = frame;
      
      setPreferredSize (new Dimension(850, 700));
      setLayout(null);
      
      JLabel lblNewLabel = new JLabel("News");
      lblNewLabel.setForeground(Color.BLUE);
      lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
      lblNewLabel.setBounds(80, 63, 177, 31);
      add(lblNewLabel);
      
      JLabel lblDate = new JLabel("Date");
      lblDate.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
      lblDate.setBounds(705, 162, 43, 16);
      add(lblDate);
      
      JLabel lblTimeLabel = new JLabel("Time");
      lblTimeLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
      lblTimeLabel.setBounds(528, 162, 43, 16);
      add(lblTimeLabel);
      
      //add empty scroll pane
      add( scrollpane = new JScrollPane(  ) );
      
      //update all news
      updateAllNewsPanel();
      
      repaint();
   }
   
   /**
    * updates all news panel and shows it on the screen properly.
    */
   private void updateAllNewsPanel() {
      
      //remove previous scroll pane
      this.remove(scrollpane);
      
      //set all news panel to new panel
      allNewsPanel = new JPanel();
      
      //set its layout
      allNewsPanel.setLayout( new GridLayout(  ( (ExternalInvestors)topFrame ).getNewsContainer().getSize(),1  )  );
      
      //add all news inside the all news panel
      for( int i = ((ExternalInvestors)topFrame).getNewsContainer().getSize() - 1; i >= 0; i--) {
         allNewsPanel.add(new NewsLine(topFrame, ((ExternalInvestors)topFrame).getNewsContainer().getNews().get(i)));
      }
      
      //add new allNewsPanel to scroll pane
      scrollpane = new JScrollPane( allNewsPanel );
      scrollpane.setBounds(20, 180, 780, 443);
      
      //add scroll pane
      add(scrollpane);
      
   }
   
   /** Updates the display
     * @param obs the observer
     * @obj the object to be observed
     */ 
   public void update( Observable obs, Object obj )
   {
      if ( obs == ((ExternalInvestors)topFrame).getNewsContainer() )
      {
         updateAllNewsPanel();
         
         allNewsPanel.revalidate();
         allNewsPanel.repaint();
         revalidate();
         repaint();
      }
   }
   
   /* Paints the components
    * @param g the default swing parameter
    */
   public void paintComponent(Graphics g) {
      //super.paintComponent(g);
      g.drawLine(30, 100, 550, 100);
      g.drawLine(527, 190, 575, 190);
      g.drawLine(718, 190, 765, 190);
   }
}
