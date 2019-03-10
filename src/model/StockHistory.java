
package model;

import java.util.ArrayList;


/**
 * This class contains the stock history of data and provides particular history if needed.
 * @author Arda Göktoðan
 * @version 10.12.2018 
 */

public class StockHistory {


	//variables
	
	private ArrayList<StockHistoryDatum> stockHistoryData;
	
	StockHistoryDBConnector DBConnector = new StockHistoryDBConnector();
	
	/**
	 * Constructs a new stock history object with empty collection of data
	 */
	public StockHistory( int companyID ){
		
		stockHistoryData = DBConnector.getStockHistoryDatum( companyID );
		
	}
	
	/**
	 * returns the stock history datum at given time
	 * @param time time
	 * @return stock history datum at given time.
	 */
	public StockHistoryDatum getHistoryDataAt( MarketTime time ) {
		
		return stockHistoryData.get( findIndexOfMarketTime ( time, 0 , stockHistoryData.size() - 1  ) );
		
	}

	
	/**
	 * add given stock history datum to stock history.
	 * @param stockHistoryDatum stock history datum that is going to be added to stock history.
	 */
	public void add( StockHistoryDatum stockHistoryDatum ) {

		stockHistoryData.add( stockHistoryDatum );

	}

	/**
	 * computes the value difference between two dates of stock
	 * @param firstDate date of first stock history datum
	 * @param lastDate date of second stock history datum
	 * @return the value difference of first stock history datum and second stock history datum
	 */
	public double getDifference( MarketTime firstDate , MarketTime lastDate ) {

		int index1 = findIndexOfMarketTime( firstDate, 0 , stockHistoryData.size() - 1 );
		int index2 = findIndexOfMarketTime( lastDate , 0 , stockHistoryData.size() );
		//System.out.println( "index 1 = " + index1 + " index2 = " + index2 );
		
		if( stockHistoryData.size() == 0 ) {
			return 0;
		}

		double differenceValue = ( stockHistoryData.get( index2 ).getBuyValue() ) - ( stockHistoryData.get( index1 ).getBuyValue() );

		return differenceValue;
	}
	

	/**
	 * returns the arrayList of stock history datum consist of last 24 hours.
	 * @return the arrayList of stock history datum consist of last 24 hours.
	 */
	public ArrayList<StockHistoryDatum> getDailyStockHistory(){


		MarketTime firstMarketTime = new MarketTime();
		
		int firstMarketTimeIndex = findIndexOfMarketTime( firstMarketTime.getOneDayBefore() , 0 , stockHistoryData.size() - 1 );
		return getSubArrayList( firstMarketTimeIndex );

	}
	
	
	
	/**
	 * returns the arrayList of stock history datum consist of last 7 days.
	 * @return the arrayList of stock history datum consist of last 7 days.
	 */
	public ArrayList<StockHistoryDatum> getWeeklyStockHistory(){


		MarketTime firstMarketTime = new MarketTime();
		

		int firstMarketTimeIndex = findIndexOfMarketTime( firstMarketTime.getOneWeekBefore() , 0 , stockHistoryData.size() - 1 );
		
		
		return getSubArrayList( firstMarketTimeIndex );

	}
	
	
	/**
	 * returns the arrayList of stock history datum consist of last 30 days.
	 * @return the arrayList of stock history datum consist of last 30 days.
	 */
	public ArrayList<StockHistoryDatum> getMonthlyStockHistory(){

		MarketTime firstMarketTime = new MarketTime();

		int firstMarketTimeIndex = findIndexOfMarketTime( firstMarketTime.getOneMonthBefore() , 0 , stockHistoryData.size() - 1 );
		
		return getSubArrayList( firstMarketTimeIndex );
	}
	

	/**
	 * returns the sub ArrayList of stockHistoryData starting from given index
	 * @param index index of first variable of sub ArrayList
	 * @return sub ArrayList of stockHistoryData starting from given index
	 */
	private ArrayList<StockHistoryDatum> getSubArrayList( int index ){
		
		ArrayList<StockHistoryDatum> returnArrayList = new ArrayList<StockHistoryDatum>();
		
		while( index < stockHistoryData.size() ) {

			returnArrayList.add( stockHistoryData.get(index) );
			index++;

		}
		
		return returnArrayList;
	}


	/**
	 * finds the index of given date in stockHistoryData using binary Search
	 * @param date0 date that the method going to search for
	 * @param firstIndex left point restriction of ArrayList
	 * @param lastIndex right point restriction of ArrayList
	 * @return the index of stock history datum of given time. If there is no stock history datum corresponding to given date,
	 * then returns the latest stock history datum before given date.
	 */
	
	private int findIndexOfMarketTime( MarketTime date0 , int firstIndex , int lastIndex ) {


	
		//terminal point
		if( lastIndex == 0 ) {
			return 0;
		}
		
		if( firstIndex > lastIndex ) {

			//if the first index exceeds the size of the array, then return the last index. 
			
			if( firstIndex == stockHistoryData.size() ) {
				
				//System.out.println("case1:" + firstIndex +" "+ lastIndex + " total size: " + stockHistoryData.size() );
				
				if( stockHistoryData.size()  == 0 ) {
					return 0;
				}
				else return stockHistoryData.size() - 1;
			}

			//if the last index is less then zero, then return the first index ( 0 )
			else if ( lastIndex == -1 ) {
				
				//System.out.println("case2:" + firstIndex +" "+ lastIndex + " total size: " + stockHistoryData.size() );
				return 0;
			}
				

			//if none of the indexes exceeds the boundaries, return the smaller one 
			else {
				
				//System.out.println("case3:" + firstIndex +" "+ lastIndex + " total size: " + stockHistoryData.size() );
				
				//first index data0 a eþites first index döndür, deðilse last index döndür.
				
				return lastIndex;
			}

		}

		//recursion step
		else {
			
			//find the mid index of restricted array list.
			
			int midIndex = (firstIndex + lastIndex) / 2;
			
			if( midIndex == stockHistoryData.size() ){
				return midIndex - 1;
			}
			
			//if the date which method is searching for equals to date of datum whose index is middle index, return that index.
			
			if( stockHistoryData.get( midIndex ).getMarketTime().getTime() == date0.getTime() ) {
				
				//System.out.println("case4");
				return midIndex;
			}

			//if the date which method is searching for is later that the datum time whose index is middle index, continue
			//to search in the right half of the array list.
			
			else if( stockHistoryData.get( midIndex ).getMarketTime().getTime() < date0.getTime() ) {

				//System.out.println("case5");
				return findIndexOfMarketTime( date0 , midIndex + 1 , lastIndex );

			}

			//else continue to search in left half of the array list.
			
			else {
				
				//System.out.println("\ncase6 : date 0 :" + date0 + " mid time : " + stockHistoryData.get( midIndex ).getMarketTime() );
				
				return findIndexOfMarketTime( date0 , firstIndex , midIndex-1 );
			}
		}
		
		

	}
	
	/**
	 * returns the string representation of stock history data
	 * @return the string representation of stock history data
	 */
	public String toString( ) {
		return stockHistoryData.toString();
	}


}
