package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.*;


/**
 * A class that connects properties of stocks to the database.
 * @author Eren Þenoðlu
 * @version 10.12.2018
 */
public class StockDBConnector {
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
			throw new IllegalStateException("Cannot connect the database!", e);
		}
	}
	/**
	 * Returns the buy value of stock with specified ID in the database.
	 * @param ID ID value of the stock.
	 * @return the buy value of stock.
	 */
	public double getBuyValueWith( int ID)   {
		connect();
		try {
			PreparedStatement myState = (PreparedStatement) connection.prepareStatement("select * from stocks where id = ? ");
			myState.setInt(1,ID);
			ResultSet myRs = myState.executeQuery();
			double result = 0;
			while(myRs.next()) {
				result = myRs.getDouble("buyvalue");
			}
			return result;
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

	public double getSellValueWith( int ID)   {
		connect();
		try {
			PreparedStatement myState = (PreparedStatement) connection.prepareStatement("select * from stocks where id = ? ");
			myState.setInt(1,ID);
			ResultSet myRs = myState.executeQuery();
			double result = 0;
			while(myRs.next()) {
				result = myRs.getDouble("sellvalue");
			}
			return result;
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
	 * Returns the company name of stock with specified ID in the database.
	 * @param ID ID value of the stock.
	 * @return the company name of stock.
	 */
	public String getCompanyNameWith( int ID)   {
		connect();
		try {
			PreparedStatement myState = (PreparedStatement) connection.prepareStatement("select * from stocks where id = ? ");
			myState.setInt(1,ID);
			ResultSet myRs = myState.executeQuery();
			String result = null;
			while(myRs.next()) {
				result = myRs.getString("companyname");
			}
			return result;
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
		return null;
	}
	/**
	 * Returns the initial value of stock with specified ID in the database.
	 * @param ID ID value of the stock.
	 * @return the initial value of stock.
	 */
	public double getInitialValueWith( int ID)   {
		connect();
		try {
			PreparedStatement myState = (PreparedStatement) connection.prepareStatement("select * from stocks where id = ? ");
			myState.setInt(1,ID);
			ResultSet myRs = myState.executeQuery();
			double result = 0;
			while(myRs.next()) {
				result = myRs.getInt("initialValue");
			}
			return result;
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
	 * Sets the buy value of stock with specified ID in the database.
	 * @param ID ID value of the stock.
	 * @param current wanted value of the stock.
	 */
	public void setBuyValueWith( int ID, double current)   {
		connect();
		try {
			PreparedStatement myState = (PreparedStatement) connection.prepareStatement("update stocks set buyvalue = ? where id = ?");
			myState.setDouble(1,current);
			myState.setInt(2,ID);
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
	 * Sets the sell value of stock with specified ID in the database.
	 * @param ID ID value of the stock.
	 * @param current wanted value of the stock.
	 */
	public void setSellValueWith( int ID, double current)   {
		connect();
		try {
			PreparedStatement myState = (PreparedStatement) connection.prepareStatement("update stocks set sellvalue = ? where id = ?");
			myState.setDouble(1,current);
			myState.setInt(2,ID);
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

}
