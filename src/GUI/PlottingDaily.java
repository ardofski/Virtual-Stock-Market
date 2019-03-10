/**
 * @author : Eren Þenoðlu, Ýrem Ecem Yelkanat, Batuhan Özçömlekçi
 * @version: 24.12.2018
 */
package GUI;

import java.awt.BorderLayout;
import model.*;

import java.awt.Dimension;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

// TODO: Auto-generated Javadoc
/**
 * The Class PlottingDaily.
 */
public class PlottingDaily extends JPanel {

	/** The Constant X. */
	final public static int X = 700;
	
	/** The Constant Y. */
	final public static int Y = 700;
	
	/** The Constant C. */
	final public static int C = X/20;

	/** The stock. */
	Stock stock; 	
	
	/** The stock history. */
	StockHistory stockHistory;

	/**
	 * Instantiates a new plotting daily.
	 *
	 * @param stock the stock
	 */
	public PlottingDaily ( Stock stock  ) {

		this.stock = stock;
		draw();
	}
	
	/**
	 * Draw.
	 */
	public void draw()
	{

		removeAll();
		JFreeChart xyLineChart = ChartFactory.createXYLineChart( stock.getCompanyName(), "Daily", "Price", createDataset(), PlotOrientation.VERTICAL, true, true, true);
		ChartPanel chartPanel = new ChartPanel( xyLineChart );
		setLayout( new BorderLayout() );
		add( chartPanel, BorderLayout.CENTER );
		chartPanel.setPreferredSize( new Dimension( 500, 500 ));
		XYPlot plot = (XYPlot) xyLineChart.getPlot();
		ValueAxis range = plot.getDomainAxis();
		range.setVisible(false);
	}
	
	/**
	 * Creates the dataset.
	 *
	 * @return the XY dataset
	 */
	private XYDataset createDataset( ) {  

		stockHistory = stock.getStockHistory();
		final XYSeries buy = new XYSeries( "Buy" );  

		for ( int i = 0; i < stockHistory.getDailyStockHistory().size() ; i++ )
		{
			buy.add( stockHistory.getDailyStockHistory().get( i ).getMarketTime().getTime(), stockHistory.getDailyStockHistory().get(i).getBuyValue() );          
		}     
		
		final XYSeries sell = new XYSeries( "Sell" ); 
		
		for ( int i = 0; i < stockHistory.getDailyStockHistory().size() ;i++ )
		{
			sell.add( stockHistory.getDailyStockHistory().get( i ).getMarketTime().getTime(), stockHistory.getDailyStockHistory().get(i).getSellValue() );          
		}        
		final XYSeriesCollection dataset = new XYSeriesCollection();              
		dataset.addSeries( buy );          
		dataset.addSeries( sell );
		return dataset;
	}
}
