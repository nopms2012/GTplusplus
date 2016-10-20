package gtPlusPlus.core.util.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class NetworkUtils {

	public static String getContentFromURL(String args) {
		if (netIsAvailable()){
			try {
				URL url;
				// get URL content
				url = new URL(args);
				URLConnection conn = url.openConnection();
				// open the stream and put it into BufferedReader
				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String inputLine;
				String tempLine = null;
				while ((inputLine = br.readLine()) != null) {
					tempLine = inputLine;
				}
				br.close();
				return tempLine;
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}		
		return null;
	}

	private static boolean netIsAvailable() {                                                                                                                                                                                                 
		try {                                                                                                                                                                                                                                 
			final URL url = new URL("http://www.google.com");                                                                                                                                                                                 
			final URLConnection conn = url.openConnection();                                                                                                                                                                                  
			conn.connect();                                                                                                                                                                                                                   
			return true;                                                                                                                                                                                                                      
		} catch (MalformedURLException e) {                                                                                                                                                                                                   
			throw new RuntimeException(e);                                                                                                                                                                                                    
		} catch (IOException e) {                                                                                                                                                                                                             
			return false;                                                                                                                                                                                                                     
		}                                                                                                                                                                                                                                     
	}  

}