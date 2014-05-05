package bee;

import java.io.OutputStreamWriter;
import java.net.*;


public class Ncom {
	public static void main(String[] args) throws Exception {
	
	}
	
	
	public static void putXML(String XmlString,String Url) throws Exception
	{
		//"http://192.168.56.200/ptest.php"
		URL url = new URL(Url);
		HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
		httpCon.setDoOutput(true);
		httpCon.setRequestMethod("PUT");
		OutputStreamWriter out = new OutputStreamWriter(
			httpCon.getOutputStream());
			out.write(XmlString);
			out.close();
			httpCon.getInputStream();
	}
	
	
}
