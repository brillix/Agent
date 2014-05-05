/*
 * Main Class For Bee Agent
 * 
 * 
 * 
 * 
 * 4.5.2014 By baruch@brillix.co.il 
 * 
 */



package bee;



import  bee.DAL;
import bee.Ncom;


public class AgentMain {

	public static void main( String args[] ) throws Exception
	 {
	    DAL query1 = new  DAL();
	    String XmlString ;
	    //query1.GetQuery("select 1 from dual");
		//System.out.print(query1.RunQuery("oracle.jdbc.driver.OracleDriver","select FILE_NAME as FILEN,BYTES as SIZEB from dba_data_files","jdbc:oracle:thin:@localhost:1521:xe","system","test123")+"\n");

		//System.out.print(query1.RunQuery("oracle.jdbc.driver.OracleDriver","select open_mode from v$database","jdbc:oracle:thin:@localhost:1521:xe","system","test123")+"\n");		
	XmlString = query1.RunQuery("com.mysql.jdbc.Driver","select user,host from user where password_expired = 'N'","jdbc:mysql://192.168.56.200:3306/mysql","root","test123");
	Ncom.putXML(XmlString,"http://192.168.56.200/ptest.php");
	//System.out.print(query1.RunQuery("com.mysql.jdbc.Driver","select user,host from user where password_expired = 'N'","jdbc:mysql://192.168.56.200:3306/mysql","root","test123"));
		//networkConn
	 }

}
