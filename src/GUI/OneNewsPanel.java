/**
 * @author : Eren Þenoðlu, Ýrem Ecem Yelkanat, Batuhan Özçömlekçi
 * @version: 24.12.2018
 */
package GUI;

import model.News;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFrame;

// TODO: Auto-generated Javadoc
/**
 * The Class OneNewsPanel.
 */
public class OneNewsPanel extends JPanel {

	/** The top frame. */
	//Properties
	JFrame topFrame;
	
	/** The news. */
	News news;
	
	/**
	 * Create the panel.
	 *
	 * @param panel the panel
	 * @param news the news
	 */
	public OneNewsPanel( JFrame panel, News news ) {
		
		topFrame = panel;
		this.news = news;
		
		//set panel's properties
		setPreferredSize (new Dimension(850, 700));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("News");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel.setBounds(80, 63, 177, 31);
		add(lblNewLabel);
		
		JTextArea title = new JTextArea();
		title.setRows(2);
		title.setWrapStyleWord(true);
		title.setLineWrap(true);
		title.setEditable(false);
		title.setBackground(UIManager.getColor("Button.background"));
		title.setFont(new Font("Tahoma", Font.PLAIN, 27));
		title.setText(news.getTitle());
		title.setBounds(61, 129, 698, 89);
		add(title);
		
		JLabel labelAuthor = new JLabel("by " + news.getAuthor());
		labelAuthor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelAuthor.setBounds(61, 222, 344, 31);
		add(labelAuthor);
		
		JLabel labelDate = new JLabel(news.getDate().toString());
		labelDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelDate.setHorizontalAlignment(SwingConstants.RIGHT);
		labelDate.setBounds(444, 228, 260, 21);
		add(labelDate);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setRows(40);
		textArea.setFont(new Font("Modern No. 20", Font.PLAIN, 16));
		textArea.setBackground(UIManager.getColor("Button.background"));
		textArea.setText(news.getText());
		textArea.setBounds(61, 266, 669, 360);
		add(textArea);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnBack.setBounds(61, 630, 97, 31);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((ExternalInvestors)topFrame).changeMainPanel(8);
			}
		});
		add(btnBack);
		


		repaint();
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g) {

		//super.paintComponent(g);
		g.drawLine(30, 100, 550, 100);
	}
}
