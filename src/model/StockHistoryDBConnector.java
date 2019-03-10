package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 * A class that connects properties of stock history to the database.
 * @author Eren Þenoðlu
 * @version 10.12.2018
 */
public class StockHistoryDBConnector {
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
		 * Returns the stock history datum with specified ID in the database.
		 * @return the array list  of stock history datum.
		 */
		public ArrayList<StockHistoryDatum> getStockHistoryDatum( int ID )   {

			connect();
			
			try {
				StockHistoryDatum a ;
				ArrayList<StockHistoryDatum> arr = new ArrayList<StockHistoryDatum>();
				PreparedStatement myState = (PreparedStatement) connection.prepareStatement("select * from stockHistory where stockID = ? ");
				myState.setInt(1,ID);
				ResultSet myRs = myState.executeQuery();
				while(myRs.next()) {
					a = new StockHistoryDatum(myRs.getDouble("buyValue"),myRs.getDouble("sellValue"),new MarketTime(myRs.getLong("date")));
					arr.add(a);
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
		 * Adds stock history with given parameters to the database.
		 * @param buyValue buy value of stock.
		 * @param sellValue sell value of stock.
		 * @param date date of the perform.
		 * @param stockID stockID value of the stock.
		 */
		public void addStockHistory(double buyValue,double sellValue, long date, int stockID) {
			connect();
			try {
				PreparedStatement myState = (PreparedStatement) connection.prepareStatement("insert into stockHistory values(?,?,?,?)");
				myState.setDouble(1,buyValue);
				myState.setDouble(2,sellValue);
				myState.setLong(3,date);
				myState.setInt(4,stockID);
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


