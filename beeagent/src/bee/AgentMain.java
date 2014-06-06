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
import bee.Scheduler;;

public class AgentMain {

	public static void main( String args[] ) throws Exception
	 {
           
	    //query1.GetQuery("select 1 from dual");
		//System.out.print(query1.RunQuery("oracle.jdbc.driver.OracleDriver","select FILE_NAME as FILEN,BYTES as SIZEB from dba_data_files","jdbc:oracle:thin:@localhost:1521:xe","system","test123")+"\n");
 
		final Scheduler Sched = new Scheduler();
   //     final DAL Dal1 = new DAL(); 
		final Runnable Test = new Runnable() 
		{
	       //public void run() { System.out.println("schedule"); }
			public void run() {
				final String XmlString;
				System.out.println("schedule");
				XmlString = DAL.RunQuery("com.mysql.jdbc.Driver","select user,host from user where password_expired = 'N'","jdbc:mysql://192.168.56.200:3306/mysql","root","test123");
			try {
				Ncom.putXML(XmlString,"http://192.168.56.200/ptest.php");
			} catch (Exception e) {
				//catch block
				e.printStackTrace();
			}// end try
			}

	    };
	    //--run 
	    Sched.ScheduleTask(Test, 1, 2);
	   	    
		//System.out.print(query1.RunQuery("oracle.jdbc.driver.OracleDriver","select open_mode from v$database","jdbc:oracle:thin:@localhost:1521:xe","system","test123")+"\n");		
	 
	//System.out.print(query1.RunQuery("com.mysql.jdbc.Driver","select user,host from user where password_expired = 'N'","jdbc:mysql://192.168.56.200:3306/mysql","root","test123"));
		//networkConn
	    
	    
	    /*  
	     * Test mail
	     *
	     */
	    
	//    String user = "agents@brillix.co.il";
    //    String pass = "JHDKSHlsmlsdjfLJLKJLJLKJljslfdj12312321";
      //  String[] to = {"omri@brillix.co.il","oded@brillix.co.il","baruch@brillix.co.il"}; // list of recipient email addresses
    //    String[] to = {"baruch@dbaces.com","oded@dbaces.com"};
    //    String subject = "thanks from the dbee agent team :-) dbaces.com ";
    //    String body = "Welcome to dbee agent from dbaces.com !";

      //  Ncom.sendMail(user,"agents@dbaces.com", pass, to, subject, body);

	 }

}
