/*
//The DAL Class - DATA access Layer for the agent 
//22.4.14  baruch@brillix.co.il create
// 26.4.2014 add RunQueryGetString and RunQueryGetNum
//
// to do :
1. fix the DB selection in the mysql part . 
2. add get int 
3. add get key value 

////////!!!!! delete on prod NOTE !!!! //////////////
note to run this 
set CLASSPATH=.;C:\Users\baruch\workspace\beeagent\bin\;C:\Users\baruch\workspace\beeagent\bin\bee\ojdbc6.jar
cd C:\Users\baruch\workspace\beeagent\bin 
java bee.OracleQuery
//static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";  
 * //  static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";   
*/

package bee;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class DAL {
	
	  // public string for Results
	    
	   //main empty for now
	public  void main( String args[] )
	 {
		//runQuery();
	 }// end main
	
	public static  String RunQuery(String DBDriver,String SqlString,String DBUrl,String User,String Pass)
	{
		Connection conn = null;
		java.sql.Statement stmt = null;
		String SQLResult;
	    String SQLResultStringCol = "<result>";
	    String SQLResultString = "<results>";
		try{
		      //STEP 2: Register JDBC driver   oracle.jdbc.driver.OracleDriver
		      Class.forName(DBDriver);
		      //STEP 3: Open a connection
		      conn = DriverManager.getConnection(DBUrl, User, Pass);
		      //STEP 4: Execute a query
		      stmt = conn.createStatement();		      
		      ResultSet rs = stmt.executeQuery(SqlString);
		      ResultSetMetaData rsmd = rs.getMetaData();
		      //STEP 5: Extract data from result set
		      int columnCount = rsmd.getColumnCount();
		      while(rs.next()){
		    	 //for every column
		    	for (int i=1; i<=columnCount; i++) {
		    	  //Retrieve column name 
		    	 String columnName = rsmd.getColumnName(i);
		         //Retrieve by column name
		         SQLResult = rs.getString(columnName);
		         SQLResultStringCol = SQLResultStringCol + "<"+ columnName+ ">"+ SQLResult +  "</" + columnName + ">";
		    	}// end for columnCount
		         //Create Result string from the results values
		         SQLResultString = SQLResultString  + SQLResultStringCol +"</result>";
		      }
		      SQLResultString = SQLResultString + "</results>";
		      rs.close();
		      conn.close();
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            conn.close();
		      }catch(SQLException se){
		      }// do nothing
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		
		   return SQLResultString;
	
	}// end RunQuery
		
	///run query get string 

		
}// end public class DAL  


// class for testing connection to DB after first connection 
class TestConn{
	static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";  
	   static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";   
	   //  Database credentials
	   static final String USER = "system";
	   static final String PASS = "test123";
	public static void main (String [] args)
	   {	
System.out.println("-------- Oracle JDBC Connection Testing ------");
		//load jdbc driver 
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
 
			System.out.println("Where is your Oracle JDBC Driver?");
			e.printStackTrace();
			return;
 
		}

		// 		System.out.println("Oracle JDBC Driver Registered!");
		Connection connection = null;
		 
		try {
			connection = DriverManager.getConnection(
					DB_URL, USER,
					PASS);
 
		} catch (SQLException e) {
 
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
 
		}
 
		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
		
		
		
	   }
	
}// end TestConn class 
		
		
	