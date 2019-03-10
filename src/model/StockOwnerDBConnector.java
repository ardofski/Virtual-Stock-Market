package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.*;

/**
 * A class that connects properties of accounts to the database.
 * @author Eren Þenoðlu
 * @version 10.12.2018
 */

public class StockOwnerDBConnector {
	// Properties
	Connection connection = null;
	
	//Methods
	
		/**
		 * Creates a connection between database and model.
		 */
	public void connect() {

		String url = "jdbc:mysql://localhost:3306/projectdb?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey&autoReconnect=true&useSSL=false";
		String username = "externalForces";
		String password = "xxxx";

		try{
			connection = DriverManager.getConnection(url, username, password);

		} catch (SQLException e) {
			throw new IllegalStateException(":(((((Cannot connect the database!", e);
		}
	}
	
	/**
	 * Returns the number of stocks owned by a specific user in the database.
	 * @param stockID userID value of the user.
	 * @param stockID stockID value of the stock. 
	 * @return the number of stock owned by user.
	 */
	public int getNumOfStocksWith( int userID, int stockID)   {
		connect();
		try {
			PreparedStatement myState = (PreparedStatement) connection.prepareStatement("select * from stockOwner where userID = ? and stockID = ?  ");
			myState.setInt(1,userID);
			myState.setInt(2,stockID);
			ResultSet myRs = myState.executeQuery();
			int count = 0;

			while(myRs.next()) {
				count = myRs.getInt("numOfStocks");
			}
			return count;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if( connection != null )
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		return 0;
	}
	/**
	 * Sets the number of stocks owned by a specific user in the database.
	 * @param userID userID value of the user.
	 * @param stockID stockID value of the stock. 
	 * @param the number of stock owned by user.
	 */
	public void setNumOfStocksWith( int userID, int stockID, int numOfStocks)   {
		connect();
		try {
			
			PreparedStatement myState = (PreparedStatement) connection.prepareStatement("update stockOwner set numOfStocks = ? where userID = ? and stockID = ?");
			myState.setInt(1,numOfStocks);
			myState.setInt(2,userID);
			myState.setInt(3,stockID);
			myState.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if( connection != null )
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	/**
	 * Adds a new stock owner to the database.
	 * @param userID userID value of the user.
	 */
	public void addStockOwner(int userID) {
		connect();
		try {
			PreparedStatement myState;
			for(int i = 0 ; i < 10 ; i++) {
			myState = (PreparedStatement) connection.prepareStatement("insert into stockOwner values(?,?,?)");
			myState.setInt(1,userID);
			myState.setLong(2,i);
			myState.setInt(3,0);
			myState.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if( connection != null )
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}
