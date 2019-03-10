package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import GUI.ExternalInvestors;
import javax.swing.JButton;
import javax.swing.JFrame;
import model.*;

/** Panel to display a single new
  * 
  * @author Duygu nur Yaldiz
  * @version 20/12/2018
  */ 
public class NewsLine extends JPanel {
   
   //Properties
   private JFrame topFrame;
   private News news;
   
   /**
    * Create the panel.
    *
    * @param frame the frame that the panel will be added
    * @param news the new to be displayed
    */
   public NewsLine( JFrame frame, News news ) {
      
      // Initialize
      topFrame = frame;
      this.news = news;
      
      // Set the panel properties
      setPreferredSize (new Dimension(750, 57));
      setLayout(null);
      
      // Create labels and add to panel
      JLabel lblTitle = new JLabel(news.getTitle());
      lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
      lblTitle.setBounds(86, 13, 340, 33);
      add(lblTitle);
      
      JLabel lblTime = new JLabel( "" + news.getDate().getHour() + " : " + news.getDate().getMin());
      lblTime.setFont(new Font("Tahoma", Font.PLAIN, 18));
      lblTime.setBounds(498, 22, 91, 16);
      add(lblTime);
      
      JLabel lblDate = new JLabel("" + news.getDate().getDay() + "." + news.getDate().getMonth() + "." + news.getDate().getYear());
      lblDate.setHorizontalAlignment(SwingConstants.RIGHT);
      lblDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
      lblDate.setBounds(601, 22, 137, 16);
      add(lblDate);
      
      // Create button and add to panel
      JButton readButton = new JButton("READ");
      readButton.setFont(new Font("Tahoma", Font.BOLD, 13));
      readButton.setHorizontalAlignment(SwingConstants.LEFT);
      readButton.setBounds(7, 13, 70, 34);
      readButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            ((ExternalInvestors)topFrame).changeMainPanel(news);
         }
      });
      add(readButton);
      
   }
}
