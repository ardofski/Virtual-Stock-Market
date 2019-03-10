package model;

import java.util.Arrays;
import java.util.Collections;
import java.io.FileNotFoundException;

/**
 * A class that holds all pre-written News's text file locations, and creates News objects
 * @author Duygu Nur Yaldiz, Arda Göktoðan
 * @version 09.12.2018
 */
public class AllNews implements NewsIterable {

	//properties
	String[] news = { "New0.txt", "New1.txt", "New2.txt", "New3.txt", "New4.txt", "New5.txt", "New6.txt", "New7.txt", "New8.txt", "New9.txt" };
	int index;
	
	//Constructor
	/**
	 * Constructs a new AllNews object with initial index 0.
	 */
	public AllNews() {
		index = 0;
	}
	
	/**
	 * Shuffles the news array.
	 */
	@Override
	public void shuffle() {
		Collections.shuffle(Arrays.asList(news));
	}
	
	/**
	 * Reads the next News object's information from text file and creates a new News object and returns it.
	 * @return the new News object
	 */
	@Override
	public News next() throws FileNotFoundException  {
		//if all the news in the list are created, then shuffle the array and set index = 0 again
		shuffle();
		if( index == news.length ) {
			
			shuffle();
			index = 0;
			
		}
	    
		//create file reader object to read information of the news
	    NewsFileReader fileReader = new NewsFileReader( news[index] );
	    
	    //update index
	    index++;
	    
		return fileReader.getNews();
	}

}
