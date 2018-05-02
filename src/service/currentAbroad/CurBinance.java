package service.currentAbroad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Servlet implementation class CurBinance
 */
public class CurBinance {
	//DONE
	// https://api.binance.com/api/v3/ticker/price   -- {"symbol":"BTCUSDT","price":"7099.13000000"}
	public static float getPrice() throws IOException{
		String url ="https://api.binance.com/api/v3/ticker/price";
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
				if(resultList[i].equals("BTCUSDT")) {
					price = resultList[i+4];
					break;
				}
			}
			return Float.parseFloat(price);
		}else {
			return 0;
		}
	}
}
