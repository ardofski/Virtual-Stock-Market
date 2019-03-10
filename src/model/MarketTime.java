package model;

import java.io.FileNotFoundException;

/**
 * This class is responsible for the time operations.
 * @author Arda Göktoðan, Duygu Nur Yaldýz
 * @version 10.12.2018
 */


public class MarketTime {

	//CONSTANTS

	static final int REAL_TIME_SCALE = 3;
	static final int START_YEAR = 2018;
	static final int SEC_PER_MIN = 60;
	static final int MIN_PER_HOUR = 60;
	static final int HOUR_PER_DAY = 24;
	static final int DAY_PER_MONTH = 30;
	static final int MONTH_PER_YEAR = 12;
	static final int DAY_PER_WEEK = 7;

	//static variable

	private static long currentTime;

	//properties

	private long time;
	private int sec,min,hour,day,month,year;


	/**
	 * Constructs a new MarketTime object whose time is given in the parameter.
	 *  
	 */
	public MarketTime( long newTime ) {

		//sets time to current time ( time when the constructor is called )
		time = newTime;

		//sets the variables
		setVariables();
	}

	/**
	 * Constructs a new MarketTime object whose time the time when the constructor is called.
	 * @throws FileNotFoundException 
	 * 
	 */
	public MarketTime(){

		TimeFileConnector connector = new TimeFileConnector();
		currentTime = connector.readTime();
		//sets time to current time ( time when the constructor is called )
		time = currentTime;

		//sets the variables 
		setVariables();
	}

	/**
	 * sets the values seconds, minutes, hour,day,month and year to corresponding values associated with time.
	 */

	private void setVariables() {

		//set seconds of object to corresponding value of time

		sec = (int) (time % SEC_PER_MIN);

		//set minutes of object to corresponding value of time

		min = (int) ( ( time / SEC_PER_MIN ) %  MIN_PER_HOUR );

		//set hours of object to corresponding value of time

		hour = (int)( ( time / ( SEC_PER_MIN *  MIN_PER_HOUR ) ) %  HOUR_PER_DAY );

		//set days of object to corresponding value of time

		day = (int)( ( time / ( SEC_PER_MIN *  MIN_PER_HOUR * HOUR_PER_DAY) ) %  DAY_PER_MONTH ) + 1;

		//set months of object to corresponding value of time

		month = (int)( ( time / ( SEC_PER_MIN *  MIN_PER_HOUR * HOUR_PER_DAY * DAY_PER_MONTH ) ) %  MONTH_PER_YEAR ) + 1;

		//set years of object to corresponding value of time

		year = (int)( ( time / ( SEC_PER_MIN *  MIN_PER_HOUR * HOUR_PER_DAY * DAY_PER_MONTH * MONTH_PER_YEAR ) ) + START_YEAR ) ;
	}

	/**
	 * increases the current time.
	 */
	public static void increaseCurrentTime() {
		
		currentTime += 300;
		TimeFileConnector connector = new TimeFileConnector();
		connector.writeTime( currentTime );
		
	}

	/**
	 * returns the current time.
	 * @return the current time.
	 */
	public static long getCurrentTime(){

		return currentTime;

	}


	/**
	 * returns the time of the object.
	 * @return time of the object.
	 */
	public long getTime(){
		return time;
	}


	/**
	 * returns the seconds of MarketTime
	 * @return returns the seconds of MarketTime
	 */
	public int getSec() {
		return sec;
	}

	/**
	 * returns the minutes of MarketTime
	 * @return minutes of MarketTime
	 */
	public int getMin(){
		return min;
	}

	/**
	 * returns the hours of MarketTime.
	 * @return hours of MarketTime.
	 */
	public int getHour() {
		return hour;
	}

	/**
	 * returns the days of MarketTime.
	 * @return days of MarketTime.
	 */
	public int getDay() {
		return day;
	}

	/**
	 * returns the months of MarketTime.
	 * @return months of MarketTime.
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * returns the years of MarketTime.
	 * @return years of MarketTime.
	 */
	public int getYear() {
		return year;
	}

	/**
	 * returns the MarketTime object of Hour before
	 * @return MarketTime object of one day before
	 */
	public MarketTime getOneHourBefore() {
		MarketTime returnTime = new MarketTime( time - ( SEC_PER_MIN *  MIN_PER_HOUR ) );
		return returnTime;
	}

	/**
	 * returns the MarketTime object of one day before
	 * @return MarketTime object of one day before
	 */
	public MarketTime getOneDayBefore() {
		MarketTime returnTime = new MarketTime( time - ( SEC_PER_MIN *  MIN_PER_HOUR * HOUR_PER_DAY ) ) ;
		return returnTime;
	}


	/**
	 * returns the MarketTime object of one week before
	 * @return MarketTime object of one week before
	 */
	public MarketTime getOneWeekBefore() {
		MarketTime returnTime = new MarketTime( time - ( SEC_PER_MIN *  MIN_PER_HOUR * HOUR_PER_DAY * DAY_PER_WEEK ) ) ;
		return returnTime;
	}


	/**
	 * returns the MarketTime object of one month week before
	 * @return the marketTime object of one month week before
	 */
	public MarketTime getOneMonthBefore() {
		MarketTime returnTime = new MarketTime( time - ( SEC_PER_MIN *  MIN_PER_HOUR * HOUR_PER_DAY * DAY_PER_MONTH ) ) ;
		return returnTime;
	}


	/**
	 * returns the string representation of MarketTime
	 * string representation is "day month year hour:minutes:seconds"
	 */
	public String toString() {

		String monthString = new String();
		String date = new String();

		switch ( getMonth() ) {
		case 1:  monthString = "January";
		break;
		case 2:  monthString = "February";
		break;
		case 3:  monthString = "March";
		break;
		case 4:  monthString = "April";
		break;
		case 5:  monthString = "May";
		break;
		case 6:  monthString = "June";
		break;
		case 7:  monthString = "July";
		break;
		case 8:  monthString = "August";
		break;
		case 9:  monthString = "September";
		break;
		case 10: monthString = "October";
		break;
		case 11: monthString = "November";
		break;
		case 12: monthString = "December";
		break;
		}
		
		if( day < 10 ) {
			date = "0" + day;
		}
		else date = " " + day;
		date += " " + monthString;
		date += " " + year;
		
		if( hour < 10 ) {
			date += ",  0" + hour;
		}
		else date += ",  " + hour;
		
		if( min < 10 ) {
			date += ":0" + min;
		}
		else date += ":" + min;
		
		if( sec < 10 ) {
			date += ":0" + sec;
		}
		else date += ":" + sec;

		return date;
	}

}
