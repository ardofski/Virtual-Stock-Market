package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.*;
import java.util.ArrayList;

/**
 * A class that connects properties of user trade history to the database.
 * @author Eren Þenoðlu
 * @version 10.12.2018
 */


public class UserTradeHistoryDBConnector {

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
		 * Returns the trade action history of a specified account in the database.
		 * @param userID userID value of the user.
		 * @return the trade action array list.
		 */
		public ArrayList<TradeAction> getUserTradeHistory( int userID )   {

			connect();
			StockDBConnector stockDB = new StockDBConnector();
			try {
				String compName;
				TradeAction result ;
				ArrayList<TradeAction> arr = new ArrayList<TradeAction>();
				PreparedStatement myState = (PreparedStatement) connection.prepareStatement("select * from userTradeHistory where userID = ? ");
				myState.setInt(1,userID);
				ResultSet myRs = myState.executeQuery();
				while(myRs.next()) {
					compName = stockDB.getCompanyNameWith(myRs.getInt("stockID"));
					result = new TradeAction(compName,myRs.getBoolean("bs"),myRs.getInt("numOfStocks"),myRs.getDouble("value"),new MarketTime(myRs.getLong("date")));
					arr.add(result);
				}
				
				return arr;
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
		 * Adds a new trade action to the database.
		 * @param buyOrSell determines whether action is buy or sell.
		 * @param stockID stockID value of the stock.
		 * @param numberOfStocks number of stocks that bought or sold.
		 * @param date date value.
		 * @param userID userID value of the user.
		 * @param value value of the trade.
		 */
		public void addTradeAction( boolean buyOrSell,int stockID, int numberOfStocks, long date, int userID, double value) {
			connect();
			try {
				PreparedStatement myState = (PreparedStatement) connection.prepareStatement("insert into userTradeHistory values(?,?,?,?,?,?)");
				myState.setBoolean(1,buyOrSell);
				myState.setLong(2,stockID);
				myState.setInt(3,numberOfStocks);
				myState.setLong(4,date);
				myState.setInt(5,userID);
				myState.setDouble(6,value);
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


