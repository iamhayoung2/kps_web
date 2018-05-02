package service.currentAbroad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Servlet implementation class CurBittrex
 */
public class CurBittrex {
	//DONE
	//https://bittrex.com/api/v1.1/public/getticker/?market=USDT-BTC 
	public static float getPrice() throws IOException{
		String url ="https://bittrex.com/api/v1.1/public/getticker/?market=USDT-BTC";
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
				if(resultList[i].equals("Last")) {
					price = resultList[i+1];
					break;
				}
			}
			return Float.parseFloat(price.substring(1, price.length()-2));
		}else {
			return 0;
		}
	}
}
