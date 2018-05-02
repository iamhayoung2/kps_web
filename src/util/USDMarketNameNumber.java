package util;

public class USDMarketNameNumber {
	public static final int Binance = 0;
	public static final int BitFinex = 1;
	public static final int Bittrex = 2;
	public static final int Gdax = 3;
	public static final int Kraken = 4;
	
	public static String getName(int a) {
		if(a == 0) {
			return "Binance";
		}else if(a == 1) {
			return "BitFinex";
		}else if(a == 2){
			return "Bittrex";
		}else if(a == 3){
			return "Gdax";
		}else {
			return "Kraken";
		}
	}
}
