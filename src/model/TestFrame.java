package model;
import GUI.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class TestFrame extends JFrame{
	
	TimeListener timeListener = new TimeListener() ;
	
	double value = 0;

	Timer timer = new Timer( 1 , timeListener );
	
	MarketTime marketTime = new MarketTime();
	Scanner sc = new Scanner( System.in );
	int mod = 0;
	ArrayList<Stock> stocks = new ArrayList<Stock>();
	
	int numOfStocks;
	
	
	public TestFrame() {
		
		timer.start();
		
		for( int i = 0 ; i < 10 ; i++ ) {
			
			stocks.add( new Stock( i ) );
			
			System.out.println( stocks.get( i ) );
			
		}
	}
	
	class TimeListener implements ActionListener{


		@Override
		public void actionPerformed(ActionEvent e) {

			MarketTime.increaseCurrentTime();

			//System.out.println(  MarketTime.getCurrentTime() );
			
			mod++;
			if( mod == 100 ) {
				
				mod = 0;
				marketTime = new MarketTime();
				System.out.println(  marketTime );
				value += 0.1;

			}
			
			for( int i = 0 ; i < stocks.size() ; i++ ) {
				
				stocks.get( i ).increase( 2 );
				
			}
			
			
		


		}

	}
}
