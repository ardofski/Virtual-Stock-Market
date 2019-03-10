package model;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


/**
 * This class is responsible for the store and read current time from text file.
 * @author Arda Göktoðan
 * @version 16.12.2018
 */
public class TimeFileConnector {

	//properties

	//adjust proper filepath
	

	String path = getPath();
	File file = new File( path );
	Scanner in;
	PrintWriter pw;

	/**
	 * reads the time from text file and returns it.
	 * @return
	 */
	public long readTime(){
		
		try {
			in = new Scanner( file );
			long time = in.nextLong();
			return time;
		} catch ( FileNotFoundException e) {
			System.out.println(" Time file not found :(");
		}

		return 0;

	}
	
	/**
	 * returns the filePath of text file.
	 * @return the filePath of text file. 
	 */
	private String getPath() {
		
		String path = getClass().getClassLoader().getResource(".").getPath();
		path = path.substring( 0 , path.length() - 4 );
		path = path +"src/time.txt";
		return path;
	}

	/**
	 * writes the time to text file.
	 * @param time time that is going to be written to text file.
	 */
	public void writeTime( long time ) {
		try {
			pw = new PrintWriter( file );	
		} catch ( FileNotFoundException e) {
			System.out.println(" Time file not found :(");
		}

		pw.print( time );
		pw.close();
	}



}
