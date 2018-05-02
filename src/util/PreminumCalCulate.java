package util;

public class PreminumCalCulate {
	public static float getPreminum(float krw, float usd, float currency){
		float premium = (krw-(usd*currency))/(krw)*100;
		return premium;
	}
}
