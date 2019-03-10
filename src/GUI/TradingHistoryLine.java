/**
 * @author : Eren Þenoðlu, Ýrem Ecem Yelkanat, Batuhan Özçömlekçi
 * @version: 24.12.2018
 */
package GUI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.*;

// TODO: Auto-generated Javadoc
/**
 * The Class TradingHistoryLine.
 */
public class TradingHistoryLine extends JPanel {


	/** The top frame. */
	//Properties
	JFrame topFrame;
	
	/** The action. */
	TradeAction action;
	
	/**
	 * Create the panel.
	 *
	 * @param frame the frame
	 * @param action the action
	 */
	public TradingHistoryLine(JFrame frame, TradeAction action) {

		topFrame = frame;
		this.action = action;
		
		setPreferredSize (new Dimension(750, 57));
		setLayout(null);
		
		JLabel lblDate = new JLabel( ""+ action.getDate() );
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDate.setBounds(0, 13, 194, 33);
		add(lblDate);
		
		JLabel lblBoughtSold = new JLabel();
		if (action.getIsBought() ) {
			lblBoughtSold.setText("Bought");
		}
		else {
			lblBoughtSold.setText("Sold");
		}
		lblBoughtSold.setBounds(204, 13, 40, 33);
		add(lblBoughtSold);
		
		JLabel lblCompanyName = new JLabel(action.getCompanyname() );
		lblCompanyName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCompanyName.setBounds(257, 13, 109, 33);
		add(lblCompanyName);
		
		JLabel lblAmount = new JLabel( "" + action.getNumOfStock());
		lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAmount.setBounds(382, 13, 27, 33);
		add(lblAmount);
		
		JLabel lblStockValue = new JLabel( "" + action.getStockValue());
		lblStockValue.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblStockValue.setBounds(433, 13, 136, 33);
		add(lblStockValue);
		
		JLabel lblTotalValue = new JLabel( "" + (action.getNumOfStock()  * action.getStockValue()));
		lblTotalValue.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTotalValue.setBounds(596, 13, 144, 33);
		add(lblTotalValue);
	}
}
