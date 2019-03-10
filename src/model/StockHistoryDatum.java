package model;

/**
 * This class contains the stock history of datum.
 * @author Arda Göktoðan, Duygu Nur Yaldýz
 * @version 10.12.2018 
 */

public class StockHistoryDatum {

	//variables
	StockHistoryDBConnector DBConnector = new StockHistoryDBConnector();
	
	private double buyValue;
	private double sellValue;
	private MarketTime date;
	
	/** Constructs a new stock history data with given parameters.
	 * @param buyValue
	 * @param sellValue
	 * @param date
	 */
	
	public StockHistoryDatum( double buyValue, double sellValue, MarketTime date ) {
		
		this.buyValue = buyValue;
		this.sellValue = sellValue;
		this.date = date;
		
	}
	
	/**
	 * 
	 * @param buyValue
	 * @param sellValue
	 * @param date
	 * @param StockID
	 */
	public StockHistoryDatum( double buyValue, double sellValue, MarketTime date , int StockID ) {
		
		this.buyValue = buyValue;
		this.sellValue = sellValue;
		this.date = date;
			
		DBConnector.addStockHistory(buyValue,sellValue,date.getTime(),StockID);
		
	}
	
	/**
	 * returns buy value at particular date
	 * @return buy value at particular date
	 */
	
	public double getBuyValue() {
		return buyValue;
	}
	
	
	
	/**
	 * returns sell value at particular date
	 * @return sell value at particular date
	 */
	
	public double getSellValue() {
		return sellValue;
	}
	
	/**
	 * returns the date of the given stock history data
	 * @return the date of the given stock history data
	 */
	
	public MarketTime getMarketTime() {
		return date;
	}

	
	/**
	 * returns the string representation of a single stock history datum object.
	 * @return the string representation of a single stock history datum object.
	 */
	public String toString() {
		return new String("\n buy value is : "+ String.format ("%.3f", buyValue ) +" sell value is : " + String.format ("%.3f", sellValue ) + " and date is : " +  date + "\n");
	}

}
