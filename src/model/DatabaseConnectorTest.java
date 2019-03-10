package model;

import java.io.*;
import java.sql.*;
public class DatabaseConnectorTest {

	public static void main(String[] args) {
		
		/*
		AccountDBConnector a = new AccountDBConnector();
		System.out.println(a.getNumOfAccounts());
		
		
		a.addNewUser(1, "eren", "1234567", "asad", "asdadsad", 1231231, 123123132, 123123123);

		System.out.println(a.getUserNameWith( 1 ));
		System.out.println(a.getPasswordWith( 1 ));
		System.out.println(a.getQuestionWith( 1 ));
		System.out.println(a.getAnswerWith( 1 ));
		System.out.println(a.getCashWith( 1 ));
		System.out.println(a.getFirstAccessWith( 1 ));
		System.out.println(a.getLastAccessWith( 1 ));
		a.setUserNameWith(1,"erenhekledi");
		System.out.println(a.getUserNameWith( 1 ));

		Question q = new Question("question", "answer");
		Account acc = new Account( "duygu" , "sdfghjk", q , 3 );

		Account acc2 = new Account( "arda" , "sdfghjk", q , 3 );
		
		Market m = new Market();
		
		System.out.println( acc );
		*/
		
		
		
		StockDBConnector a = new StockDBConnector();
		a.setBuyValueWith( 0 , 19.5 );
		a.setSellValueWith( 0 , 16.5 );
		System.out.println( a.getCompanyNameWith( 0 ) );
		System.out.println( a.getBuyValueWith( 0 ) );
		System.out.println( a.getSellValueWith( 0 ) );
		
		/*
		a.setBuyValueWith( 0, 22);
		a.setSellValueWith( 0, 20);
		System.out.println(a.getBuyValueWith( 1 ));
		System.out.println(a.getSellValueWith( 1 ));
		*/

		//Stock stock = new Stock( 2 );
		//System.out.println( stock );

		
		

		/*
		NewsDBConnector a = new NewsDBConnector();
		System.out.println(a.getNumberOfNews());
		System.out.println(a.getNewsIDWith( 1 ));
		System.out.println(a.getNewsIDWith( 2 ));
		a.addNews(7, 12312313,3);
		System.out.println(a.getNumberOfNews());
		*/

		/*
		StockHistoryDBConnector a = new StockHistoryDBConnector();
		
		System.out.println(a.getStockHistoryDatum(1));
		System.out.println(a.getStockHistoryDatum(2));
		a.addStockHistory(50, 55, 28000, 3);
		System.out.println(a.getStockHistoryDatum(3));
		*/
		 

		/*
		NewsDBConnector a = new NewsDBConnector();

		int size = a.getNumberOfNews();


		for( int i = 1 ; i <= size ; i++ ) {
			
			System.out.println("new ýd with id = " + i + " news id = " + a.getNewsIDWith( i ) );

		}
		*/
		/*StockOwnerDBConnector a = new StockOwnerDBConnector();
		a.setNumOfStocksWith(1, 2, 11);
		System.out.println(a.getNumOfStocksWith(1, 2));
		a.addStockOwner(2);
		System.out.println("end of program");
	*/
		
		/*
		UserTradeHistoryDBConnector a = new UserTradeHistoryDBConnector();
		a.addTradeAction(true, 1, 3, 18000, 1, 25);
		System.out.println(a.getUserTradeHistory(1));
		*/
	}

}