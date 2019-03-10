/**
 * @author : Eren Þenoðlu, Ýrem Ecem Yelkanat, Batuhan Özçömlekçi
 * @version: 24.12.2018
 */
package GUI;


import model.*;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.UIManager;

// TODO: Auto-generated Javadoc
/**
 * The Class TradingHistoryPanel.
 */
public class TradingHistoryPanel extends JPanel {
	
	/** The text field. */
	private JTextField textField;

	/** The top frame. */
	//Properties
		JFrame topFrame;
		
		/** The scrollpane. */
		JScrollPane scrollpane;
	
	/**
	 * Create the panel.
	 *
	 * @param frame the frame
	 */
	public TradingHistoryPanel(JFrame frame) {
		
		topFrame = frame;
		
		setPreferredSize (new Dimension(850, 700));
		setLayout(null);
		
		JLabel profileLabel = new JLabel("Profile");
		profileLabel.setForeground( Color.BLUE );
		profileLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		profileLabel.setBounds(45, 45, 85, 31);
		add(profileLabel);
		
		JLabel lblGeneralInformation = new JLabel("> Trading History");
		lblGeneralInformation.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblGeneralInformation.setBounds(130, 45, 275, 31);
		add(lblGeneralInformation);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(104, 130, 35, 16);
		add(lblDate);
		
		JLabel lblBoughtsold = new JLabel("Status");
		lblBoughtsold.setBounds(235, 130, 85, 16);
		add(lblBoughtsold);
		
		JLabel lblStockName = new JLabel("Stock Name");
		lblStockName.setBounds(290, 130, 85, 16);
		add(lblStockName);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setBounds(400, 130, 61, 16);
		add(lblAmount);
		
		JLabel lblValuePerStock = new JLabel("Value Per Stock ($)");
		lblValuePerStock.setBounds(470, 130, 116, 16);
		add(lblValuePerStock);
		
		JLabel lblTotalValue = new JLabel("Total Value ($)");
		lblTotalValue.setBounds(630, 130, 96, 16);
		add(lblTotalValue);
		
		
		JPanel historyPanel = new JPanel();
//		historyPanel.setLayout(null);
//		historyPanel.setLayout(new GridLayout(((ExternalInvestors)topFrame ).getAccountContainer().getActiveUser().getTradeHist().getTrades().size(),1));
//		historyPanel.setOpaque( true );
//		historyPanel.setBackground( Color.RED );
//		historyPanel.setLayout( null );
//		historyPanel.setPreferredSize( new Dimension(800,500) );
		
		
		ArrayList<TradeAction> tradingHistory = ( (ExternalInvestors)topFrame ).getAccountContainer().getActiveUser().getTradeHist().getTrades();
		
		historyPanel.setPreferredSize(new Dimension (750, 57 * tradingHistory.size()));
		
		for( int i =  tradingHistory.size() - 1 ; i >= 0 ; i-- ) {
			
			TradingHistoryLine line =  new TradingHistoryLine (topFrame, tradingHistory.get(i));
			line.setBounds(0, 10  + 50 * i, 750, 57);
			historyPanel.add( new TradingHistoryLine (topFrame, tradingHistory.get(i)));
			
//			JLabel dateLabel = new JLabel( "" + tradingHistory.get(i).getDate() );
//			lblDate.setBounds(35, 130 + i*50 , 35, 16);
//			historyPanel.add(dateLabel);
//			
//			JLabel stockNameLabel = new JLabel( "" + tradingHistory.get(i).getCompanyname() );
//			lblStockName.setBounds(201, 130 + i*50, 85, 16);
//			historyPanel.add(stockNameLabel);
//			
//			JLabel isBoughtPanel = new JLabel("");
//			
//			if( tradingHistory.get(i).getIsBought() == true ) {
//				isBoughtPanel.setText( "Bought" );
//			}	
//			else {
//				isBoughtPanel.setText( "Sold" );
//			}
//			lblBoughtsold.setBounds(104, 130 + i*50 , 85, 16);
//			historyPanel.add(isBoughtPanel);
//			
//			
//			JLabel amountPanel = new JLabel( "" + tradingHistory.get(i).getNumOfStock() );
//			lblAmount.setBounds(347, 130 + i*50 , 61, 16);
//			historyPanel.add(amountPanel);
//			
//			JLabel valuePerStockPanel = new JLabel( "" + tradingHistory.get(i).getStockValue() );
//			lblValuePerStock.setBounds(420, 130 + i*50 , 116, 16);
//			historyPanel.add(valuePerStockPanel);
//			
//			double totalValue = tradingHistory.get(i).getStockValue() * tradingHistory.get(i).getNumOfStock();
//			JLabel totalValuePanel = new JLabel("" + totalValue );
//			lblTotalValue.setBounds(548, 130 + i*50 , 96, 16);
//			historyPanel.add(totalValuePanel);
			
		}

		scrollpane = new JScrollPane(historyPanel);
		scrollpane.setBounds(20, 160, 780, 500);
		add(scrollpane);
		
		repaint();
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g) {
		
		//super.paintComponent(g);
		g.drawLine(30, 100, 800, 100);
	}
}
