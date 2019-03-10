package model;

import java.io.FileNotFoundException;

/**
 * @author Acer
 *
 */
public class NewsTest {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		AllNews all = new AllNews();
		
		System.out.println(all.next().toString());
		System.out.println(all.next().toString());
		System.out.println(all.next().toString());
		System.out.println(all.next().toString());
		
	}

}
