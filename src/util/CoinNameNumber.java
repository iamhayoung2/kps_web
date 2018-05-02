package util;

public class CoinNameNumber {
	public static final int BITCOIN = 1;
	public static final int ETHERIUM = 2;

	public static String getString(int no) {
		if(no == BITCOIN) {
			return "BitCoin";
		}else {
			return "Etherium";
		}
	}
}

