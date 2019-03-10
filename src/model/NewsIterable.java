package model;

import java.io.FileNotFoundException;

/**
 * An interface containing next and shuffle methods
 * @author Duygu Nur Yaldiz
 * @version 09.12.2018
 */
public interface NewsIterable {

	//Methods
	public News next() throws FileNotFoundException ;
	public void shuffle();
	
}
