/**
 * @author : Eren Þenoðlu, Ýrem Ecem Yelkanat, Batuhan Özçömlekçi
 * @version: 24.12.2018
 */
package GUI;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButtonMenuItem;
import model.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Plotting.
 */
public class Plotting extends JPanel  implements ActionListener {

	/** The one. */
	JRadioButtonMenuItem one;
	
	/** The two. */
	JRadioButtonMenuItem two;
	
	/** The three. */
	JRadioButtonMenuItem three;
	
	/** The current pane. */
	JPanel currentPane;
	
	/** The btn refresh. */
	JButton btnRefresh;
	
	/** The viewed stock. */
	Stock viewedStock;

	/**
	 * Instantiates a new plotting.
	 *
	 * @param viewedStock the viewed stock
	 */
	public Plotting( Stock viewedStock ) {

		btnRefresh = new JButton( "Refresh" );
		btnRefresh.setForeground( Color.BLACK );
		btnRefresh.addActionListener( this );
		setLayout(new BorderLayout( 0, 0 ));
		add( btnRefresh, BorderLayout.NORTH );

		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);

		one = new JRadioButtonMenuItem("Daily");
		one.setSelected(true);
		panel.add(one);
		currentPane = new PlottingDaily( viewedStock );
		one.addActionListener(this);

		two= new JRadioButtonMenuItem("Weekly");
		two.setSelected(false);
		panel.add(two);
		two.addActionListener(this);

		three = new JRadioButtonMenuItem( "Monthly" );
		three.setSelected(false);
		panel.add( three );
		three.addActionListener(this);
		
		add( currentPane, BorderLayout.CENTER );

		ButtonGroup period = new ButtonGroup();

		period.add( one );
		period.add( two );
		period.add( three );
		
		this.viewedStock = viewedStock;

		setVisible( true );
		
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed( ActionEvent e )
	{
		if( e.getSource() == btnRefresh )
		{
			if (currentPane instanceof PlottingDaily)
			{
				((PlottingDaily) currentPane).draw();
			}
			else if (currentPane instanceof PlottingWeekly)
			{
				((PlottingWeekly) currentPane).draw();
			}
			else if (currentPane instanceof PlottingMonthly)
			{
				((PlottingMonthly) currentPane).draw();
			}
		}
		else if( one.isSelected() )
		{
			remove( currentPane );	
			currentPane = new PlottingDaily( viewedStock );
			add( currentPane, BorderLayout.CENTER );
			
		}
		else if ( two.isSelected() )
		{
			remove( currentPane );
			currentPane = new PlottingWeekly( viewedStock ); 
			add( currentPane, BorderLayout.CENTER );
		}
		else if ( three.isSelected() )
		{
			remove( currentPane );
			currentPane = new PlottingMonthly( viewedStock );
			add( currentPane, BorderLayout.CENTER );
		}
		
		validate();
		repaint();
	}	
	
	/**
	 * Refresh.
	 */
	public void refresh()
	{
		if (currentPane instanceof PlottingDaily)
		{
			((PlottingDaily) currentPane).draw();
		}
		else if (currentPane instanceof PlottingWeekly)
		{
			((PlottingWeekly) currentPane).draw();
		}
		else if (currentPane instanceof PlottingMonthly)
		{
			((PlottingMonthly) currentPane).draw();
		}
	}
}
