package model;

/**
 * This class stores the all stock as static variable, main purpose of it is the provide same stock objects
 * to both, stock container and market class.
 * @author Arda Göktoðan, Duygu Nur Yaldýz
 * @version 21.12.2018
 */

public class AllStocks {

	//final variables
	public static final int NUM_OF_STOCKS = 10;
	
	//variables
	private static Stock[] allStocks = null;
	
	StockDBConnector DBConnector = new StockDBConnector();
	
	
	/**
	 * constructs all stocks
	 */
	public AllStocks() {
		
		allStocks = new Stock[NUM_OF_STOCKS];
		
		for( int i = 0 ; i < NUM_OF_STOCKS ; i++ ) {
			
			allStocks[ i ] = new Stock( i );
		}
	}
	
	/**
	 * returns all stocks
	 * @return all stocks as stock array.
	 */
	public Stock[] getAllStocks( ) {
		return allStocks;
	}
	
	
	/**
	 * string representation of all stocks
	 * @return string representation of all stocks.
	 */
	public String toString(){
		
		String s = new String("");
		for( int i = 0 ; i < NUM_OF_STOCKS ; i++ ) {
			s += allStocks[i].toString();
		}
		
		return s;
	}
	


}
