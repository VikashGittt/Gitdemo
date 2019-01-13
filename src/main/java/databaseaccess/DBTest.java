package databaseaccess;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class DBTest extends Database{
	WebDriver driverObj;
	String rowCount;
	@Test
	public void selectDBdata() throws ClassNotFoundException, SQLException{
		//String textData = driverObj.findElement(By.xpath("")).getText();
		//String query = "Select shippername From Shippers where ShipperID = 5";
		String query = "Select * From customers";
		//String query = "SELECT COUNT(*) FROM Shippers;"; 
		//String query = "Select * from Shippers";
		//ResultSet data1 = database.getData(Query);
		Database selectData = new Database();
		selectData.getData(query);  
	 
	
	 /*	if(textData.contains(data.getString(1)))){
	 	
	 	}	
	 	*/
		 
	 	 
	 	
	
	}
  
	
	//@Test
	public void insertDBdata() throws ClassNotFoundException, SQLException{
		String query = "Insert Into Shippers values(5, 'Amexp1', '4585658545')";
		Database database = new Database();
		database.insertData(query);
	}
	//@Test
	public void updateDBdata() throws ClassNotFoundException, SQLException{
		String query = "Update w3schooldb.Shippers Set Phone = '5254585658' where ShipperID = 4;";
		Database database = new Database();
		database.updateData(query);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
