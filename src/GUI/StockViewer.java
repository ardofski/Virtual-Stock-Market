/**
 * @author : Eren Þenoðlu, Ýrem Ecem Yelkanat, Batuhan Özçömlekçi
 * @version: 24.12.2018
 */
package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;

import model.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

// TODO: Auto-generated Javadoc
/**
 * The Class StockViewer.
 */
public class StockViewer extends JPanel implements ActionListener {

	/** The btn buy. */
	JButton btnBuy;
	
	/** The btn sell. */
	JButton btnSell;
	
	/** The plotting pane. */
	Plotting plottingPane;
	
	/** The top frame. */
	JFrame topFrame;
	
	/** The stock. */
	Stock stock;
	
	/** The spinner 1. */
	JSpinner spinner1;
	
	/** The spinner 2. */
	JSpinner spinner2;
	
	/** The lbl buying price. */
	JLabel lblBuyingPrice;
	
	/** The lbl selling price. */
	JLabel lblSellingPrice;
	
	/** The message label. */
	JLabel messageLabel = new JLabel("");

	/**
	 * Instantiates a new stock viewer.
	 *
	 * @param viewedStock the viewed stock
	 * @param topFrame the top frame
	 */
	public StockViewer( Stock viewedStock, JFrame topFrame ) {
		
		stock = viewedStock;
		this.topFrame = topFrame;
		setLayout( null );
		int xMargin1 = 100;
		int xMargin2 = 500;

		Plotting plottingPane = new Plotting( viewedStock );
		System.out.println(plottingPane.getPreferredSize());
		plottingPane.setBounds( 90 , 250 , 600 , 400  );
		add( plottingPane );


		JLabel lblNewLabel = new JLabel( viewedStock.getCompanyName() );
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 36));
		lblNewLabel.setBounds( 60 , 50 , 300 , 50 );

		JButton btnBuy = new JButton("Buy");
		btnBuy.setBounds( xMargin1 , 200 , 80 , 30 );
		


		JButton btnSell = new JButton("Sell");
		btnSell.setBounds( xMargin2 , 200 , 80 , 30 );
		

		btnBuy.addActionListener( this);
		btnSell.addActionListener( this );

		
		SpinnerNumberModel numModel1 = new SpinnerNumberModel( 1 , 1, 5 ,1);
		SpinnerNumberModel numModel2 = new SpinnerNumberModel( 1 , 1, 5 ,1);
		spinner1 = new JSpinner( numModel1 );
		spinner2 = new JSpinner( numModel2 );
		

		String buyValue = String.format( "%.3f", viewedStock.getBuyValue() );
		String sellValue = String.format( "%.3f", viewedStock.getSellValue() );

		lblBuyingPrice = new JLabel("Buy Value: " + buyValue );
		lblBuyingPrice.setFont(new Font("Lucida Grande", Font.BOLD, 19));
		lblBuyingPrice.setBounds( xMargin1 , 110 , 200 , 50 );

		lblSellingPrice = new JLabel("Sell Value: " + sellValue );
		lblSellingPrice.setFont(new Font("Lucida Grande", Font.BOLD, 19));
		lblSellingPrice.setBounds( xMargin2 , 110 , 200 , 50 );
		
		
		spinner1.setBounds( xMargin1 , 150 , 80 , 40 );
		spinner2.setBounds( xMargin2 , 150 , 80 , 40 );
		
		messageLabel.setBounds(240,195,300,40 );
		
		
		add(lblNewLabel );
		add(lblBuyingPrice);
		add(lblSellingPrice );
		
		add(spinner1);
		add(spinner2);
		
		add( btnBuy);
		add( btnSell);
		
		add(messageLabel);


	}


	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed( ActionEvent e )
	{
		//if the clicked button is buy button
		
		if ( ( (JButton)e.getSource() ).getText().equals("Buy") ) 
		{
			
			//if user bought successfuly
			if( ((ExternalInvestors)topFrame).getAccountContainer().getActiveUser().buyStock( stock.getCompanyID() , (Integer) spinner1.getValue() ) ) {
				messageLabel.setText("You have bought stocks successfuly");
			} 
			
			//if user couldn't bought
			
			else {
				messageLabel.setText("You don't have enough cash to buy!");
			}

		}
		
		//if the clicked button is sell button
		else if ( ( (JButton)e.getSource() ).getText().equals("Sell") )
		{
			
			//if user sold successfuly
			if( ((ExternalInvestors)topFrame).getAccountContainer().getActiveUser().sellStock( stock.getCompanyID() , (Integer) spinner2.getValue() ) ) {
				messageLabel.setText("You have sold stocks successfully");
			} 
			
			//if user couldn't sold his or her stocks
			
			else {
				messageLabel.setText("You don't have enough stocks to sell!");
			}
		}
		
		String buyValue = String.format( "%.3f", stock.getBuyValue() );
		String sellValue = String.format( "%.3f", stock.getSellValue() );
		lblBuyingPrice.setText( "Buy Value: " + buyValue );
		lblSellingPrice.setText( "Sell Value: "+ sellValue );

		//plottingPane.refresh();
		repaint();
		validate();
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.drawLine(30, 100, 800, 100);

	}
}
