package service.currentAbroad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServlet;

/**
 * Servlet implementation class CurKraken
 */
public class CurKraken extends HttpServlet {
	//DONE
	//https://api.kraken.com/0/public/Ticker?pair=XBTUSD",
	
	public static float getPrice() throws IOException{
		String url ="https://api.kraken.com/0/public/Ticker?pair=XBTUSD";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		obj = new URL(url);
		con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		int returnCode= con.getResponseCode();
		InputStream conIn =null;
		if(returnCode == 200) {
			conIn = con.getInputStream();
			BufferedReader buffer = new BufferedReader(new InputStreamReader(conIn));
			String inputLine = "";
			String resultLine = "";
			while((inputLine = buffer.readLine()) != null) {
				resultLine = inputLine;
			}
			buffer.close();
			String resultList[] = resultLine.split("\"");
			String price = "";
			for(int i = 0 ; i < resultList.length ; i++) {
				if(resultList[i].equals("c")) {
					price = resultList[i+2];
					break;
				}
			}
			return Float.parseFloat(price);
		}else {
			return 0;
		}
	}
}
