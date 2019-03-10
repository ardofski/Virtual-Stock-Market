package model;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;

public class TestAllNews {

	public static void main(String[] args) {

		//NewsContainer c = new NewsContainer();
		AccountContainer aa = new AccountContainer();
		
		//System.out.println(aa.getAccount("eren").getTradeHist());

		AllNews all = new AllNews();

		Market m = new Market();
		
		/*
		String s = new String("Starbucks");
		MarketTime time = new MarketTime();
		
		System.out.println( m.getDailySortedList(true) );
		
		System.out.println("------Differences---------");
		
		
		for( int i = 0; i < 10 ; i++ ) {
			System.out.println(  m.getStock(i).getCompanyName() + "  : " +   m.getStock(i).getDifference(time.getOneDayBefore(), time )  );
		}
		*/
		
		
		/*
		System.out.println( s.contains("s") );
		m= m.getSearchingResults( "s" );
		System.out.println( m );
		*/
		
		/*
		System.out.println("------Market---------");
		System.out.println( m );
		
		
		System.out.println("------Sorted Market---------");
		System.out.println( m.getSortedList( true ) );
		*/
		
		
		
		System.out.println("------Daily Stock History---------");
		
		System.out.println( m.getStock(8).getStockHistory().getDailyStockHistory() );
		
		System.out.println("------Weekly Stock History---------");
		
		System.out.println( m.getStock(8).getStockHistory().getWeeklyStockHistory() );
		
		System.out.println("------Monthly Stock History---------");
		
		System.out.println( m.getStock(8).getStockHistory().getMonthlyStockHistory() );
		
		System.out.println( m.getStock(8).getStockHistory().getDifference( new MarketTime( 120421801 ) , new MarketTime( 121672801 ) ));
		
		System.out.println( " first date : " +  new MarketTime( 120421801 ) + " last date : " + new MarketTime( 121672801 ) );
		
		
		/*
		System.out.println( new MarketTime( 143641301 ) );
		System.out.println( new MarketTime()  );
		System.out.println( m.getStock(3).getStockHistory().getDifference( new MarketTime( 143641301 ) , new MarketTime() ) );
		*/
		//120421801
		//121672801 
		
		
		
		/*
		Account duygu = new Account( 0 );
		Account arda = new Account( 1 );
		AccountContainer acc = new AccountContainer();
		
		//System.out.println( acc );
		System.out.println( acc.setActiveUser( "eren", "123456") );
		
		System.out.println( acc.getActiveUser().getLastAccess() );
		*/

		
		/*
		MarketTime time = new MarketTime( 18288000 );
		StockHistory hist = new StockHistory(1);
		hist.add( new StockHistoryDatum( 10 , 10 , new MarketTime( 18488000 )  , 1) );
		hist.add( new StockHistoryDatum( 10 , 10 , new MarketTime( 18588000 )  , 1) );
		hist.add( new StockHistoryDatum( 10 , 10 , new MarketTime( 18688000 )  , 1) );
		hist.add( new StockHistoryDatum( 10 , 10 , new MarketTime( 18738800 )  , 1) );
		hist.add( new StockHistoryDatum( 10 , 10 , new MarketTime( 18888000 )  , 1) );
		hist.add( new StockHistoryDatum( 10 , 10 , new MarketTime( 18988000 )  , 1) );
		hist.add( new StockHistoryDatum( 10 , 10 , new MarketTime( 19088000 )  , 1) );
		hist.add( new StockHistoryDatum( 10 , 10 , new MarketTime( 19188000 )  , 1) );
		hist.add( new StockHistoryDatum( 10 , 10 , new MarketTime( 19288000 )  , 1) );
		hist.add( new StockHistoryDatum( 10 , 10 , new MarketTime( 19388000 )  , 1) );
		
		System.out.println( hist.getWeeklyStockHistory() );


		StockHistoryDatum d = new StockHistoryDatum( 10 , 10 , new MarketTime( 18288000 ) );
		System.out.println( time );
		*/
		
		/*
		Question q = new Question("? ","x");
		Account duygu = new Account( "arda", "1234", q  ,2  );
		
		AccountContainer acc = new AccountContainer();
		System.out.println(acc);
		*/

		/*
		Stock stock = new Stock( 1 );
		System.out.println( stock.getStockHistory() );
		*/
		
		/*
		System.out.println( m );
		
		
		System.out.println( "******************************************************************" );

		Question q = new Question("? ","x");


		Account duygu = new Account( 0 );

		
		

		System.out.println( "****************BEFORE BUY**********************" );
		
		System.out.println(  duygu );


		System.out.println( "****************AFTER BUY**********************" );
		
		duygu.sellStock( 0, 3 );

		System.out.println(  duygu );
		
		System.out.println( m );
		
		*/
		
		TimeFileConnector connector = null;
		try {
			connector = new TimeFileConnector();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println( connector.readTime() );
		
		System.out.println( "*****************END OF PROGRAM***********************" );
		
		

	}
}
