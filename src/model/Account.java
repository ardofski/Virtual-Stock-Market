package model;

/**
 * A class that holds all necessary information of an account.
 * @author Duygu Nur Yaldiz, Arda Göktoðan
 * @version 10.12.2018
 */
public class Account implements Comparable<Account> {

	final static int INITIAL_CASH = 1000; //TODO degisebilir.
	
	//Properties
	
	String username;
	String password;
	Question question;
	double cash;
	int ID;
	MarketTime firstAccess;
	MarketTime lastAccess;
	StockContainer stocks;
	TradingHistory tradeHist;
	
	//database connectors
	private AccountDBConnector DBConnection= new AccountDBConnector();
	private StockOwnerDBConnector DBConnector2 = new StockOwnerDBConnector();
	private UserTradeHistoryDBConnector DBConnector3 = new UserTradeHistoryDBConnector();
	

	//Constructor
	/**
	 * Constructs a new account object by using given parameters and initializes 
	 * StockContainer and TradingHistory properties, initializes cash as 1000 by default.
	 * @param username the name of the user
	 * @param password the password of the account 
	 * @param question the question object of the user
	 * @param ID the id number of the account
	 */
	public Account(String username, String password, Question question, int ID ) {

		//set variables
		this.username = username;
		this.password = password;
		this.question = question;
		this.ID = ID;
		cash = INITIAL_CASH;
		firstAccess = new MarketTime();
		lastAccess = firstAccess;
		stocks = new StockContainer( ID );
		tradeHist = new TradingHistory( ID );
		

		//add new user to database

		
		DBConnection.addNewUser( ID , username , password, question.getQuestion() , question.getAnswer() , cash , firstAccess.getTime() , firstAccess.getTime() );

		DBConnector2.addStockOwner( ID );
	}

	/**
	 * According to given id, takes the values of account from database and sets them.
	 * @param ID
	 */
	public Account( int ID ) {

		//database connection : create account according to given id

		this.username = DBConnection.getUserNameWith( ID );
		this.password = DBConnection.getPasswordWith( ID );
		this.question = new Question( DBConnection.getQuestionWith( ID ), DBConnection.getAnswerWith( ID ) );
		this.ID = ID;
		cash = DBConnection.getCashWith( ID );
		
		firstAccess = new MarketTime( DBConnection.getFirstAccessWith( ID ) );
		lastAccess = new MarketTime( DBConnection.getLastAccessWith( ID ) );
		
		//create empty stock container and trading history
		stocks = new StockContainer( ID );
		tradeHist = new TradingHistory( ID );

	}

	//Accessory Methods

	/**
	 * Returns the name of the user
	 * @return the name of the user
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Returns the password of the user
	 * @return the password of the user
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Returns the cash
	 * @return the cash
	 */
	public double getCash() {
		return cash;
	}

	/**
	 * Returns the id of the user
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}

	/**
	 * Returns the time of the first access to the program
	 * @return the firstAccess
	 */
	public MarketTime getFirstAccess() {
		return firstAccess;
	}

	/**
	 * Returns the last access time of the user to the program
	 * @return the lastAccess
	 */
	public MarketTime getLastAccess() {
		return lastAccess;
	}

	/**
	 * Returns the trading history of the user
	 * @return the tradeHist
	 */
	public TradingHistory getTradeHist() {
		return tradeHist;
	}

	/**
	 * Returns the question string of the account
	 * @return the question string of the account
	 */
	public String getQuestion() {
		return question.getQuestion();
	}

	/**
	 * Calculates the portfolio of the user by adding cash and stock values that the user has
	 * @return the portfolio of the user
	 */
	public double getPortfolio() {
		
		return cash + stocks.getAllTotalSockValues();
		
	}


	//Mutator Methods

	/**
	 * Sets cash to given parameter
	 * @param cash the cash to set
	 */
	public void setCash( double cash ) {



		this.cash = cash;

		//set cash to database
		
		DBConnection.setCashWith( ID , cash );

	}

	/**
	 * Sets username to given parameter
	 * @param name the name to set
	 */
	public void setUserName( String name) {

		username = name;

		//set new user name to database
		
		DBConnection.setUserNameWith( ID , username );
	}

	/**
	 * Sets the password of the account to the given parameter
	 * @param password the new password to set
	 */
	public void setPassword( String password) {

		this.password = password;

		//set password to database

		DBConnection.setPasswordWith(ID, password);
	}

	/**
	 * Sets last access of the user to given parameter
	 * @param last last access time of the user
	 */
	public void setLastAccess( MarketTime last ) {

		lastAccess = last;

		DBConnection.setLastAccessWith( ID , lastAccess.getTime() );
	}

	//Other methods
	/**
	 * Buys new stock(s), updates  stock container object, creates a TradeAction object and
	 * adds it to tradeHist property, updates cash.
	 * @param index the compID of the of the stock whose stocks are bought
	 * @param numOfStocks the number of stocks to buy
	 */
	public boolean buyStock( int index, int numOfStocks) {
		
		if( cash >= numOfStocks * StockContainer.ALL_STOCKS[ index ].getBuyValue() ) {
			
			System.out.println("able to buy");
			
			MarketTime time = new MarketTime();
			
			DBConnector3.addTradeAction( true , index, numOfStocks, time.getTime() , ID , stocks.getStock(index).getBuyValue() );
			
			tradeHist.add(new TradeAction( stocks.getStock(index).getCompanyName(), true, numOfStocks, stocks.getStock(index).getBuyValue(), new MarketTime() ));
			
			stocks.buyStock( index, numOfStocks );

			this.setCash( cash - stocks.getStock(index).getBuyValue() * numOfStocks );

			
			return true;
		}

		return false;


	}

	/**
	 * Sells new stock(s), updates  stock container object, creates a TradeAction object and
	 * adds it to tradeHist property, updates cash.
	 * @param index the compID of the of the stock whose stocks are sold
	 * @param numOfStocks the number of stock to sell
	 */
	public boolean sellStock( int index, int numOfStocks) {

		if( stocks.getNumOfStocks( index ) >= numOfStocks ) {
			
			System.out.println("able to sell");

			MarketTime time = new MarketTime();
			
			DBConnector3.addTradeAction( false , index, numOfStocks, time.getTime() , ID , stocks.getStock(index).getSellValue() );
			
			tradeHist.add( new TradeAction( stocks.getStock(index).getCompanyName(), false, numOfStocks, stocks.getStock(index).getSellValue() , new MarketTime() ));
			
			stocks.sellStock( index, numOfStocks );

			this.setCash( cash + stocks.getStock( index ).getSellValue() * numOfStocks );
			
			return true;
			
		}
		
		return false;



	}

	/**
	 * Checks if the given password is the same with account's
	 * @param password the password to check
	 * @return true if passwords are the same, false if not
	 */
	public boolean checkPassword( String password) {
		return this.password.equals(password);
	}

	/**
	 * Checks if the given answer is the answer of the question object
	 * @param answer the answer to be checked
	 * @return true if they match, false if not
	 */
	public boolean checkQuestion(String answer ) {
		return question.checkAnswer( answer );
	}

	/**
	 * Compares two account objects according to their portfolios
	 * @param account the other account to compare
	 * @return the difference between accounts' portfolio values
	 */
	@Override
	public int compareTo(Account account) {

		return (int) (account.getPortfolio() - this.getPortfolio());

	}
	
	/**
	 * string representation of account
	 * @return string representation of account
	 */
	public String toString() {
		
		String s = new String();
		
		s += "\nusername : " + username + " password :  " + password + " cash : " + cash +" OwnedStocks: \n" +  stocks.toString() ;
	
		return s;
	}

	public StockContainer getStocks() {
		// TODO Auto-generated method stub
		return stocks;
	}
}
