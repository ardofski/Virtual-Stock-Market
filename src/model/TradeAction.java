package model;

/**
 * A class which holds information (which company's how many stocks are bought/sold.
 *  when and the values of the stocks at the time the action happened) of a trade action.
 * @author Duygu Nur Yaldiz,Arda Göktoðan
 * @version 12.09.2018
 */
public class TradeAction {

	//properties
	String companyName;
	boolean isBought;
	int numOfStock;
	double stockValue;
	MarketTime date;
	
	//Constructor
	/**
	 * Constructs a new TradeAction object with the given parameters.
	 * @param compName the name of the company
	 * @param isBought true for bought action, false for sold action
	 * @param numOfStock number of stocks in the trading action
	 * @param stockValue the value of the stocks when the action is occurred
	 */
	
	public TradeAction( String compName, boolean isBought, int numOfStock, double stockValue , MarketTime date) {
		
		companyName = compName;
		this.isBought = isBought;
		this.numOfStock = numOfStock;
		this.stockValue = stockValue;
		this.date = date;
		
		//TODO if date is later than the date of last row of database, add new trade action to database
		
	}
	
	//Methods
	/**
	 * Return the company name
	 * @return company name
	 */
	public String getCompanyname() {
		return companyName;
	}
	
	/**
	 * returns if the stock is bought
	 * @return true if the stock is bought, false if it is sold
	 */
	public boolean getIsBought() {
		return isBought;
	}
	
	/**
	 * Returns the number of stocks in the trading action
	 * @return number of stocks in the action
	 */
	public int getNumOfStock() {
		return numOfStock;
	}
	
	/**
	 * Returns the stock value when the action is happened
	 * @return the stock value when the action is happened
	 */
	public double getStockValue() {
		return stockValue;
	}
	
	/**
	 * Returns the date that action happened 
	 * @return the date that action happened 
	 */
	public MarketTime getDate() {
		return date;
	}
	
	/**
	 * Returns string representation of Trade Action
	 * @return string representation of Trade Action
	 */
	public String toString()
	{
		if (isBought == true)
		{
			return "\nFrom " + companyName + " " + numOfStock + " number of stock(s)" + " bought with the value " + stockValue + " on " + date; 
		}
		else
		{
			return "\nTo " + companyName + " " + numOfStock + " number of stock(s)" + " sold with the value " + stockValue + " on " + date;
		}
	}
	
}
