/**
 * @author : Eren Þenoðlu, Ýrem Ecem Yelkanat, Batuhan Özçömlekçi
 * @version: 24.12.2018
 */
package GUI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import model.*;

// TODO: Auto-generated Javadoc
/**
 * The Class StockPanel.
 */
public class StockPanel extends JPanel {

	/** The top frame. */
	//Properties
		JFrame topFrame;
		
		/** The stock. */
		Stock stock;
	
	/**
	 * Create the panel.
	 *
	 * @param frame the frame
	 * @param stock the stock
	 */
	public StockPanel(JFrame frame, Stock stock) {
		
		topFrame = frame;

		setPreferredSize (new Dimension(850, 700));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Stock Name");
		lblNewLabel.setForeground(UIManager.getColor("Button.light"));
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel.setBounds(80, 63, 177, 31);
		add(lblNewLabel);
		
		repaint();
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g) {

		g.drawLine(30, 100, 550, 100);
	}
}