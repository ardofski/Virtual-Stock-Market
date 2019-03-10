package model;

/**
 * A class to hold information of bought stocks.
 * @author Duygu Nur Yaldiz
 * @version 16.12.2018
 */
public class StockContainer {

	
	//public constant instance
	public final static int TOTAL_NUM_OF_STOCKS = 10;
	public static Stock[] ALL_STOCKS;
	private int userID;
	

	
	//Properties
	
	private int[] stocks;
	
	private StockOwnerDBConnector DBConnector = new StockOwnerDBConnector();

	/**
	 * Creates a new stockContainer object.
	 */
	public StockContainer( int userID ) {
		
		this.userID = userID;

		stocks = new int[ TOTAL_NUM_OF_STOCKS ];
 
		for( int i = 0 ; i < TOTAL_NUM_OF_STOCKS ; i++ ) {
			stocks[i] = DBConnector.getNumOfStocksWith(  userID, i );
		}
		
	}

	
	/**
	 * returns the number of stocks
	 * @param stockID stock id
	 * @return number of stocks with given id
	 */
	public int getNumOfStocks( int stockID ) {
		
		return stocks[ stockID ];
		
	}
	

	/**
	 * Adds the number of bought stocks to corresponding index value, and updates the stocks buy and sell values
	 * @param compID the id number of the company
	 * @param numOfStocks number of bought stocks
	 */

	public void buyStock( int compID, int numOfStocks) {

		ALL_STOCKS[compID].increase(numOfStocks);

		stocks[compID] = stocks[compID] + numOfStocks;
		
		//reflect changes to database
		
		DBConnector.setNumOfStocksWith( userID , compID , stocks[compID] );

	}

	/**
	 * Subtracts the number of bought stocks to corresponding index value, and updates the stocks buy and sell values
	 * @param compID the id number of the company
	 * @param numOfStocks number of bought stocks
	 */
	public void sellStock( int compID, int numOfStocks) {

		ALL_STOCKS[ compID ].decrease( numOfStocks );

		stocks[compID] = stocks[compID ] - numOfStocks;
		
		//Reflect changes to database
		DBConnector.setNumOfStocksWith( userID , compID , stocks[compID] );

	}

	/**
	 * Returns the stock with given id
	 * @param compID id number of the company to return
	 * @return the stock with given id number
	 */
	public Stock getStock(int compID) {
		return ALL_STOCKS[compID];
	}

	/**
	 * Calculates total values of all belonged stocks and returns it
	 * @return total values of all belonged stocks
	 */
	public double getAllTotalSockValues() {
		double result;
		result = 0;
		for( int i = 0; i < stocks.length; i++ ) {
			if( stocks[i] != 0 )
				result += ALL_STOCKS[i].getSellValue() * stocks[i];
		}
		return result;
	}
	
	/**
	 * Returns the string representation of stock container.
	 * @return string representation of owned stocks.
	 */
	
	public String toString() {
		
		String s = new String();
		
		for( int i = 0 ; i < stocks.length ; i++ ) {
			s += "\n------------------";
			s = s + "\n stock number : " + i + " " + ALL_STOCKS[i].toString();
			s += "number of stocks is " + stocks[i];
			s += "\n--------------------";
		}
		
		return s ;
	}
}
