/**
 * @author : Eren Þenoðlu, Ýrem Ecem Yelkanat, Batuhan Özçömlekçi
 * @version: 24.12.2018
 */
package GUI;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.*;


// TODO: Auto-generated Javadoc
/**
 * The Class SortedPanel.
 */
public class SortedPanel extends JPanel {

	/** The top frame. */
	//Properties
		JFrame topFrame;
		
		/** The stock. */
		Stock stock;
		
	/**
	 * Create the panel.
	 *
	 * @param stock the stock
	 * @param topFrame the top frame
	 */
	public SortedPanel(Stock stock, JFrame topFrame ) {
		
		this.stock = stock;
		//topFrame = frame;
		MarketTime startTime = new MarketTime();
		startTime = startTime.getOneDayBefore();
		MarketTime endTime = new MarketTime();
		
		
		
		setLayout(new GridLayout(1,4));
		
		JLabel companyName = new JLabel ( stock.getCompanyName() );
		
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				// TODO change main panel
				
				System.out.println(topFrame == null);
				System.out.println("BÝZ BURDAYIZ");
				((ExternalInvestors)topFrame ).changeMainPanel( stock );
			}
		});
		
		addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {
				
				//change main panel
				
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		
		add (companyName);
		
		add (new JLabel ( String.format("%5.4f", stock.getBuyValue() )    )   );
		add (new JLabel( String.format("%5.4f", stock.getSellValue() )   )   );
		add (new JLabel( String.format("%5.4f", stock.getDifference(startTime, endTime) )   )   );
		
		repaint();
	}
	
	/* (non-Javadoc)
	 * @see java.awt.Component#toString()
	 */
	public String toString() {
		return stock.toString();
	}

	

}
