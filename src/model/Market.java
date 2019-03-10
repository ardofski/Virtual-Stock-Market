package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * A class that holds an array of stocks.
 * @author Duygu Nur Yaldiz, Arda Göktoðan
 * @version 09.12.2018 updated 16.12.2018
 */
public class Market implements Comparator<Stock>{

	final static int NUM_OF_STOCKS = 10;
	//properties
	Stock[] stocks;

	AllStocks all = new AllStocks();

	//Constructor
	/**
	 * Constructs a new Market object with given stock array
	 * @param stocks the array list of the stocks
	 */
	public Market( Stock[] stocks ) {
		this.stocks = stocks;
	}

	/**
	 * Constructs a new Market object based on the stocks in database
	 */
	public Market( ) {


		stocks = all.getAllStocks();
		StockContainer.ALL_STOCKS = all.getAllStocks();

	}

	/**
	 * returns the sorted list of stocks
	 * @param isIncreasing determines whether sorting should be based on increasing order or decreasing order
	 * if isIncreasing equals true, stocks should be sorted in increasing order.
	 * if isIncreasing equals false, stocks should be sorted in decreasing order.
	 * @return sorted array list of stocks
	 */
	public ArrayList<Stock> getSortedList( boolean isIncreasing ){

		//Comparator to sort in increasing order.
		
		Comparator<Stock> increasingSort =  new Comparator<Stock>() {

			public int compare(Stock s1, Stock s2) {

				return (int) (s1.getBuyValue() - s2.getBuyValue() );
			}
		};

		//Comparator to sort in decreasing order.
		
		Comparator<Stock> decreasingSort =  new Comparator<Stock>() {
			public int compare(Stock s1, Stock s2) {

				return (int) (s2.getBuyValue() - s1.getBuyValue() );
			}
		};

		ArrayList<Stock> result  = new ArrayList<Stock>( Arrays.asList(stocks) );


		//if sorting is in increasing order
		if( isIncreasing ) {
			Collections.sort( result, increasingSort );
		}
		
		//if sorting is in decreasing order
		else {
			Collections.sort( result, decreasingSort );
		}


		return result;
	}


	/**
	 * returns the sorted list of stocks based on their daily changes
	 * @param isIncreasing determines whether sorting should be based on increasing order or decreasing order
	 * if isIncreasing equals true, stocks should be sorted based on their daily changes in increasing order.
	 * if isIncreasing equals false, stocks should be sorted based on their daily changes in decreasing order.
	 * @return 
	 */
	public ArrayList<Stock> getDailySortedList( boolean isIncreasing ){

		//comparator for increasing order
		
		Comparator<Stock> increasingDailySort =  new Comparator<Stock>() {
			
			public int compare(Stock s1, Stock s2) {
				MarketTime current = new MarketTime();
				
				if( (s1.getDifference( current.getOneDayBefore() , current  ) - s2.getDifference( current.getOneDayBefore() , current) ) > 0  )
					return 1;
				else 
					return -1;
			}
		};

		//comparator for decreasing order
		
		Comparator<Stock> decreasingDailySort =  new Comparator<Stock>() {
			
			public int compare(Stock s1, Stock s2) {
				MarketTime current = new MarketTime();

				if( (s1.getDifference( current.getOneDayBefore() , current  ) - s2.getDifference( current.getOneDayBefore() , current) ) > 0  )
					return -1;
				else 
					return 1;
				
			}
		};

		ArrayList<Stock> result  = new ArrayList<Stock>(Arrays.asList(stocks));

		if( isIncreasing )
			Collections.sort( result , increasingDailySort);
		else
			Collections.sort( result , decreasingDailySort);
		return result;
	}

	/**
	 * returns the sorted list of stocks based on their weekly changes
	 * @param isIncreasing determines whether sorting should be based on increasing order or decreasing order
	 * if isIncreasing equals true, stocks should be sorted based on their weekly changes in increasing order.
	 * if isIncreasing equals false, stocks should be sorted based on their weekly changes in decreasing order.
	 * @return 
	 */
	public ArrayList<Stock> getWeeklySortedList( boolean isIncreasing ){

		Comparator<Stock> increasingWeeklySort =  new Comparator<Stock>() {

			public int compare(Stock s1, Stock s2) {
				MarketTime current = new MarketTime();
				return (int) (s1.getDifference(current, current.getOneWeekBefore()) - s2.getDifference(current,current.getOneWeekBefore() ));
			}
		};

		Comparator<Stock> decreasingWeeklySort =  new Comparator<Stock>() {

			public int compare(Stock s1, Stock s2) {
				MarketTime current = new MarketTime();
				return (int) (s2.getDifference(current, current.getOneWeekBefore()) - s1.getDifference(current,current.getOneWeekBefore() ));
			}
		};

		ArrayList<Stock> result  = new ArrayList<Stock>(Arrays.asList(stocks));

		if( isIncreasing )
			Collections.sort( result , increasingWeeklySort);
		else
			Collections.sort( result , decreasingWeeklySort);
		return result;
	}
	/**
	 * returns the sorted list of stocks based on their monthly changes
	 * @param isIncreasing determines whether sorting should be based on increasing order or decreasing order
	 * if isIncreasing equals true, stocks should be sorted based on their monthly changes in increasing order.
	 * if isIncreasing equals false, stocks should be sorted based on their monthly changes in decreasing order.
	 * @return 
	 */
	public ArrayList<Stock> getMonthlySortedList( boolean isIncreasing ){

		Comparator<Stock> increasingMonthlySort =  new Comparator<Stock>() {
			public int compare(Stock s1, Stock s2) {
				MarketTime current = new MarketTime();
				return (int) (s1.getDifference(current, current.getOneMonthBefore()) - s2.getDifference(current, current.getOneMonthBefore()));
			}
		};
		Comparator<Stock> decreasingMonthlySort =  new Comparator<Stock>() {
			public int compare(Stock s1, Stock s2) {
				MarketTime current = new MarketTime();
				return (int) (s2.getDifference(current, current.getOneMonthBefore()) - s1.getDifference(current, current.getOneMonthBefore()));
			}
		};

		ArrayList<Stock> result  = new ArrayList<Stock>(Arrays.asList(stocks));

		if( isIncreasing )
			Collections.sort( result , increasingMonthlySort);
		else
			Collections.sort( result , decreasingMonthlySort);
		return result;
	}

	/**
	 * Returns the stock with given id number
	 * @param compID the id number of the wanted company
	 * @return the stock
	 */
	public Stock getStock( int compID ) {
		return stocks[compID];
	}

	/**
	 * return stocks
	 * @return stocks
	 */
	public Stock[] getStocks() {
		return stocks;
	}

	/**
	 * Return a new market object only containing the stocks with given word
	 * @param word the searched word to be contained in the stock's name
	 * @return market only containing the stocks with the word
	 */
	public Market getSearchingResults( String word ){

		Stock[] result = new Stock[ stocks.length ];
		int index = 0;
		for( int i = 0; i < stocks.length; i++ ) {
			if( stocks[i].getCompanyName().toLowerCase().contains(  word.toLowerCase() ) ) {
				result[index] = stocks[i];
				index++;
			}
		}
		return new Market( Arrays.copyOfRange(result, 0, index ) );
	}

	@Override
	public int compare(Stock o1, Stock o2) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * returns the string representation of market
	 * @return string representation of market
	 */
	public String toString() {
		return Arrays.toString( stocks );
	}
}

