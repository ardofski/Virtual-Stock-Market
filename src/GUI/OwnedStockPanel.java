/**
 * @author : Eren Þenoðlu, Ýrem Ecem Yelkanat, Batuhan Özçömlekçi
 * @version: 24.12.2018
 */
package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.JPanel;

import model.Account;
import model.MarketTime;
import model.Stock;
import model.StockContainer;

// TODO: Auto-generated Javadoc
/**
 * The Class OwnedStockPanel.
 */
public class OwnedStockPanel extends JPanel {

	/** The top frame. */
	// Properties
	JFrame topFrame;
	
	/** The active user. */
	Account activeUser;
	
	/** The i. */
	int i;
	
	/**
	 * Create the panel.
	 *
	 * @param frame the frame
	 */
	public OwnedStockPanel(JFrame frame) {

		topFrame = frame;

		setPreferredSize (new Dimension(800, 550));
		setLayout(new GridLayout(10,5));


		JLabel label;
		activeUser = ( ( ExternalInvestors ) topFrame ).getAccountContainer().getActiveUser();

		for( i = 0 ; i < StockContainer.TOTAL_NUM_OF_STOCKS ; i++) {
			

			label = new JLabel( "" + activeUser.getStocks().getStock(i).getCompanyName() );

			label.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent e) {

					//change main panel

					( (ExternalInvestors)topFrame ).changeMainPanel( activeUser.getStocks().getStock( i ) );
				}

				public void mouseExited(MouseEvent e) {

					System.out.println(topFrame == null);
					setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				}

			});


			add(label); 

			label = new JLabel("            " + activeUser.getStocks().getNumOfStocks(i));

			add(label); 

			label =new JLabel(""+String.format("%.4f",activeUser.getStocks().getStock(i).getBuyValue() ));

			add(label); 

			label =new JLabel(""+String.format("%.4f",activeUser.getStocks().getNumOfStocks(i)*activeUser.getStocks().getStock(i).getBuyValue()));

			add(label); 

			JButton infoButton = new JButton("?");
			infoButton.setPreferredSize(new Dimension(10,10));
			infoButton.setBackground(UIManager.getColor("Button.background"));
			infoButton.setOpaque(true);

		}
	}

}
