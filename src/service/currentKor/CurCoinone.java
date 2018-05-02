package service.currentKor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Servlet implementation class CurrentKPS
 */
public class CurCoinone  {

	public static float getPrice() throws IOException{
		String url ="https://api.coinone.co.kr/ticker/?format=json";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		//코인원
		//String responseURL= request(1, "https://api.coinone.co.kr/ticker/?format=json");
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
			String coinOneBitPrice = "";
			for(int i = 0 ; i < resultList.length ; i++) {
				if(resultList[i].equals("last")) {
					coinOneBitPrice = resultList[i+2];
					break;
				}
			}
			return Float.parseFloat(coinOneBitPrice);
		}else {
			return 0;
		}
	}
}
