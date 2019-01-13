package databaseaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	public  Connection con;
	public  Statement stmt;
	
	public Statement getStatement() throws ClassNotFoundException, SQLException{
		String driverObj = "com.mysql.cj.jdbc.Driver"; 
		String Connection = "jdbc:mysql://localhost:3306/w3schooldb";
		String username = "root";
		String password = "LIFEisdifficult1";
		Class.forName(driverObj);
		con = DriverManager.getConnection(Connection, username, password);
		
		//CreateStatement() method of connection Interface is used to create statement. 
		//The Object of statement is responsible to execute queries with the db
		stmt = con.createStatement();
		return stmt;
		
	}
	public void insertData(String query) throws ClassNotFoundException, SQLException {
		Statement sta = getStatement();
		sta.executeUpdate(query);
		
	}
	public void getData(String query) throws ClassNotFoundException, SQLException{
		
		//The executeQuery() method of Satement I/F s used to execute queries to the db. 
		//This method returns the object of resultSet that can be used to get 
		//all the records of a table
		ResultSet data = getStatement().executeQuery(query);
		ResultSetMetaData rsmd = data.getMetaData();
		int columnsNumber = rsmd.getColumnCount();
		System.out.println(columnsNumber);
		 
		while(data.next()){
			for(int i=0; i<columnsNumber; i++){
				System.out.print(data.getString(i+1)+"\t\t"); //data.getString("ColumnName"); <-- Check this
				
			} 
			System.out.println();
		}
		//return data;
		
	}
	public void updateData(String Query) throws ClassNotFoundException, SQLException{
		getStatement().executeUpdate(Query);
		
	}
	//Closing Connection
	//By Closing connection objct statement and ResultSet will be closed automatically. 
	//The close() method of connection interface is used to close the connection.
	//con.close()
	
}
