/**
 * @author : Eren Þenoðlu, Ýrem Ecem Yelkanat, Batuhan Özçömlekçi
 * @version: 24.12.2018
 */
package GUI;


import model.*;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

// TODO: Auto-generated Javadoc
/**
 * The Class WelcomePanel.
 */
public class WelcomePanel extends JPanel {

	/** The top frame. */
	//Properties
			JFrame topFrame;
	
	/**
	 * Create the panel.
	 *
	 * @param frame the frame
	 */
	public WelcomePanel(JFrame frame) {
		
		topFrame = frame;
		
		((ExternalInvestors)topFrame).resetNews();	
		
		setPreferredSize (new Dimension(850, 700));
		setLayout(null);
		
		JLabel lblWelcome = new JLabel("WELCOME");
		lblWelcome.setForeground(Color.BLUE);
		lblWelcome.setFont(new Font("Lucida Grande", Font.PLAIN, 60));
		lblWelcome.setBounds(219, 251, 378, 155);
		add(lblWelcome);

	}

}
