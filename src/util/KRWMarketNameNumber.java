package util;

public class KRWMarketNameNumber {
	public static final int Bitthum = 0;
	public static final int Coinone = 1;
	public static final int Upbit = 2;
	
	public static String getName(int a) {
		if(a == 0) {
			return "Bitthum";
		}else if(a == 1) {
			return "Coinone";
		}else{
			return "Upbit";
		}
	}
}
