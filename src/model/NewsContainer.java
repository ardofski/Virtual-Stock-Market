package model;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Observable;
/**
 * A class that holds all news that occurred in the program 
 * @author Duygu Nur Yaldiz, Arda Göktoðan
 * @version 09.12.2018, updated 10.12.2018
 */
public class NewsContainer extends Observable {

	public final static int NEWS_AFFECT = 15;
	//properties
	ArrayList<News> news;

	//db connectors
	private NewsDBConnector DBConnector = new NewsDBConnector();
	

	//Constructor
	/**
	 * Constructs a new NewsContainer object, initializes news property
	 */
	public NewsContainer() {



		news = new ArrayList<>();

		int size = DBConnector.getNumberOfNews();
		NewsFileReader newsFileReader = null;

		News currentNew;

		for( int i = 0 ; i < size ; i++ ) {

			try {

				newsFileReader = new NewsFileReader( "New" + DBConnector.getNewsIDWith( i ) + ".txt" );

			} catch (FileNotFoundException e) {

				e.printStackTrace();
			}

			currentNew = newsFileReader.getNews();

			currentNew.setDate( new MarketTime( DBConnector.getNewsDateWith( i ) ));

			news.add( currentNew );

		}

	}

	//Methods
	/**
	 * Adds the new New to the list, and updates the related stocks trade values.
	 * @param news the new News object to add
	 * @param market the market to reach the related stock
	 */
	public void add( News news, Market market) {

		//add the news to the list
		this.news.add( news );



		//get company id and effect rate of the news

		int compID = news.getCompID();
		double effectRate = news.getEffectRate();

		//update the stock values according to the information
		
		if( effectRate > 1 ) {
			
			market.getStock(compID).increase( NEWS_AFFECT ) ;
		}
		
		else {
			market.getStock(compID).decrease( NEWS_AFFECT ) ;
		}
		
		market.getStock(compID).getStockHistory().add( new StockHistoryDatum( market.getStock(compID).getBuyValue() , market.getStock(compID).getSellValue() , news.getDate() , compID ) );
		
		setChanged();
		notifyObservers();

		/*
		double buyValue = market.getStock(compID).getBuyValue() * effectRate;

		double sellValue = market.getStock(compID).getSellValue() * effectRate;

		market.getStock( compID ).setBuyValue( buyValue );

		market.getStock( compID ).setSellValue( sellValue );
		*/

		//create new stock history datum object based on the occurred news

		//market.getStock(compID).getStockHistory().add( new StockHistoryDatum( buyValue , sellValue , news.getDate() , compID ) );

		//add news to the database

		DBConnector.addNews( DBConnector.getNumberOfNews() , news.getDate().getTime() , news.getID() ); 

	}


	/**
	 * Returns the size of the news array list
	 * @return the size of the news array list
	 */
	public int getSize() {
		
		return news.size();
	}

	/**
	 * Returns the news array list
	 * @return the news array list
	 */
	public ArrayList<News> getNews(){
		
		return news;
	}

	/**
	 * returns the string representation of all news occurred so far.
	 * @return the string representation of all news occurred so far.
	 */
	public String toString() {

		String s = new String("");
		for( int i = 0 ; i < news.size(); i++ ) {
			s += "\n " + news.get(i);
		}

		return s;
	}
}
