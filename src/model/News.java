package model;

/**
 * A class that holds all information of a news
 * @author Duygu Nur Yaldiz, Arda Göktoðan
 * @version 09.12.2018
 */
public class News {

	//Properties
	private int id;
	private String title;
	private String author;
	private String text;
	private MarketTime date;
	private int affectedCompNum;
	private double effectRate;
	
	//Constructor
	/**
	 * Constructs a new News object with the given parameters.
	 * @param title the title of the news
	 * @param author the author of the news
	 * @param text the text of the news
	 * @param date the date that the news is created
	 * @param compID the id number of the company that is affected bay the news
	 * @param effectRate the rate that the stock values are affected
	 */
	public News( int id ,String title, String author, String text, MarketTime date, int compID, double effectRate) {
		
		this.id = id;
		this.title = title; 
		this.author = author; 
		this.text = text;
		this.date = date; 
		affectedCompNum = compID;
		this.effectRate = effectRate;
		
	}
	
	//Accessory Methods 
	
	/**
	 * returns id
	 * @return id
	 */
	public int getID() {
		return id;
	}
	
	/**
	 * Returns the title of the news
	 * @return the title of the news
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Returns the author of the news
	 * @return the author of the news
	 */
	public String getAuthor() {
		return author;
	}
	
	/**
	 * Returns the text of the news
	 * @return the text of the news
	 */
	public String getText() {
		return text;
	}
	
	/**
	 * Returns the ID number of company affected by the news
	 * @return the ID number of company affected by the news
	 */
	public int getCompID() {
		return affectedCompNum;
	}
	
	/**
	 * Returns the rate of the stocks of the company to be affected by the news
	 * @return the rate of the stocks of the company to be affected by the news
	 */
	public double getEffectRate() {
		return effectRate;
	}
	
	/**
	 * Return the date of the news
	 * @return the date of the news
	 */
	public MarketTime getDate() {
		return date;
	}
	
	/**
	 * sets the date of the new
	 */
	public void setDate( MarketTime date ) {
		this.date = date; 
	}
	
	
	/**
	 * returns the string representation of a news.
	 * @return the string representation of a news.
	 */
	public String toString() {
		return "Title : " + title + "\nAuthor : " + author + "\n Date : " + date + "\nafeccted company number : " + affectedCompNum +
				"\nEffect rate : " + effectRate + "\nText : " + text;
	}
}
