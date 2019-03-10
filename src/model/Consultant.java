package model;

/**
 * A class that holds all of the accounts created in the program.
 * @author Eren Þenoðlu,
 * @version 23.12.2018
 */

public class Consultant {

	//Properties

	private int price;
	private String name; 
	private int successRate;
	private String text;
	private String photo;


	//database connectors
	StockDBConnector dbConnector = new StockDBConnector();

	//Constructor
	/**
	 * Constructs a new consultant object by using given parameters. 
	 * @param price cost of the consultant.
	 * @param successRate success rate of consultant.
	 * @param name name of the consultant.
	 * @param text dialog text of the consultant.
	 * @param photo file location of the photo.
	 */
	public Consultant(int price, int successRate, String name, String text,String photo ) {

		this.price = price;
		this.successRate = successRate;
		this.text = text;
		this.name = name;
		this.photo = photo;
	}

	public boolean consult(Account activeUser) {
		if(activeUser.getCash() >= price) {
			
			activeUser.setCash(activeUser.getCash() - price);
			
			return true;
		}
		return false;
	}
	/**
	 * Returns the price of the user
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}
	/**
	 * Returns the success rate of the user
	 * @return the successRate
	 */

	public int getRate() {
		return successRate;
	}
	/**
	 * Returns the text of the user
	 * @return the text
	 */

	public String getText() {
		return text;
	}
	/**
	 * Returns the name of the user
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Returns the photo string of the user
	 * @return the photo string
	 */
	public String getPhoto() {
		return photo;
	}
	/**
	 * According to given news, returns a advice string.
	 * @param activeUser active user of the session.
	 * @param news news object.
	 * @return advice string.
	 */
	public String getAdvice(Account activeUser, News news) {

		int compID;


		if( (Math.random() * 100 ) <= successRate ) {
			compID =  news.getCompID();
		}
		else {
			compID = StockContainer.TOTAL_NUM_OF_STOCKS - news.getCompID() - 1;
		}

		String compName = dbConnector.getCompanyNameWith( compID );

		String returnString;

		if( news.getEffectRate() > 1 ) {
			returnString = new String("I'm expecting a rise from " + compName +  "  in short term. I think we can buy some stocks from " + compName );
		}
		else {
			returnString = new String("I'm expecting a decrease from " + compName +  "  in short term. I think we can sell some stocks from " +  compName );
		}

		return returnString;
	}
}
