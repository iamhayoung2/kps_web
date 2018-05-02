package service.currency;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * Servlet implementation class CurrencyKRWUSD
 */
public class CurrencyKRWUSD {

	public static float getPrice() throws IOException{
		// TODO Auto-generated method stub
		String url = "http://info.finance.naver.com/marketindex/?tabSel=exchange#tab_section";
		Document doc = Jsoup.connect(url).get();
		Elements tags = doc.getAllElements();
		String currency = tags.select("div > span.value").first().text().replace(",", "");
		return Float.parseFloat(currency);
	}
}
