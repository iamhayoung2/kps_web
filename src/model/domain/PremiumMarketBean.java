package model.domain;

public class PremiumMarketBean extends PriceMarketBean{
	private String kMarket;
	private String uMarket;
	
	public PremiumMarketBean(float price, String kMarket, String uMarket) {
		super(price);
		this.kMarket = kMarket;
		this.uMarket = uMarket;
	}
	public String getkMarket() {
		return kMarket;
	}
	public void setkMarket(String kMarket) {
		this.kMarket = kMarket;
	}
	public String getuMarket() {
		return uMarket;
	}
	public void setuMarket(String uMarket) {
		this.uMarket = uMarket;
	}
	@Override
	public String toString() {
		return super.toString()+"PremiumMarketBean [kMarket=" + kMarket + ", uMarket=" + uMarket + "]";
	}
}
