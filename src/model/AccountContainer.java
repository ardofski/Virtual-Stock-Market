package model;
import java.util.ArrayList;
import java.util.Collections;

/**
 * A class that holds all of the accounts created in the program.
 * @author Duygu Nur Yaldiz, Arda Göktoðan
 * @version 10.12.2018
 */

public class AccountContainer {

	//properties
	Account activeUser;
	ArrayList<Account> accounts;
	AccountDBConnector DBConnector = new AccountDBConnector();

	//Constructor
	/**
	 * Constructs a new AccountContainer object with no account objects in it by default.
	 */
	public AccountContainer() {

		accounts = new ArrayList<>();

		//DATABASE CONNECTION
		for(int i = 0; i < DBConnector.getNumOfAccounts() ; i++ ) {
			accounts.add( new Account(i) );
		}
	}

	//Methods

	/**
	 * Returns the active use
	 * @return the active user
	 */
	public Account getActiveUser() {

		return activeUser;
	}
	
	/**
	 * gets the rank of active user
	 * @return
	 */
	public int getRankOfUser( Account account ) {
		
		ArrayList<Account> acc = this.sort();
		for( int i = 1 ;  i <= acc.size(); i++ ){
			if( acc.get( i-1 ).getUsername().equals( account.getUsername() ) ) {
				return i;
			}
		}
		
		
		return 0;
		
	}

	/**
	 * sets the activeUser according to given parameters.
	 * @param userName name of user.
	 * @param password password of user.
	 * @return true userName and password match, false if they do not
	 */
	public boolean setActiveUser( String userName , String password) {

		if(!checkIfUsernameExist(userName))
			return false;
		else if(!getAccount(userName).checkPassword(password))
			return false;
		activeUser = getAccount(userName);
		return true;
	}

	/**
	 * if all the conditions hold, then the account with given informations is set as active user.
	 * @param userName the name of the account
	 * @param question the question of the account
	 * @param answer the answer of the question of the account
	 * @return 0 is every condition is satisfied, 3 is the username does not exist, 1 if the question does not match with the acoount's, 
	 * 2 if the answer does not match with the account's.
	 */
	public int setActiveUser( String userName , String question, String answer ) {

		if(!checkIfUsernameExist(userName))
			return 3;
		else if( !getAccount(userName).getQuestion().equals(question))
			return 1;
		else if( !getAccount(userName).checkQuestion(answer) )
			return 2;
		activeUser = getAccount(userName);
		return 0;
	}

	/**
	 * Returns the account with the given parameter name
	 * @param username name of the account to return
	 * @return the account with the given name
	 */
	public Account getAccount(String username) {
		
		for( int i = 0; i < accounts.size(); i++) {
			if(accounts.get(i).getUsername().equals(username))
				return accounts.get(i);
		}
		return null;
	}

	/**
	 * Deletes an account object from the list.
	 * @param index the index number of the account to be deleted
	 */
	public void deleteAccount( int index ) {
		accounts.remove(index);
	}

	/**
	 * First creates the new account object and then adds it to the list
	 * @param username name of the new account
	 * @param password password of the new account
	 * @param question question object of the new account
	 */
	public void addAccount( String username, String password, Question question) {

		accounts.add(new Account( username, password, question, accounts.size()) );

	}

	/**
	 * Checks if the account with the given username exists.
	 * @param username the name to look for
	 * @return true if the account with name exist, false if not
	 */
	public boolean checkIfUsernameExist(String username) {
		for( Account element : accounts ) {
			if(element.getUsername().equals(username))
				return true;
		}
		return false;
	}



	/**
	 * Sorts all the accounts by their cash values in a decreasing order
	 * @return an arrayList of all the accounts sorted by their cash values in a decreasing order
	 */
	public ArrayList<Account> sort(){
		
		ArrayList<Account> result = accounts;
		Collections.sort(result);	
		return result;
	}
	public String toString() {

		return accounts.toString();

	}
}
