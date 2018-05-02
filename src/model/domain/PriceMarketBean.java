package model.domain;

public class PriceMarketBean{
	float value;
	
	public PriceMarketBean() {}
	public PriceMarketBean(float value) {
		super();
		this.value = value;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "PriceMarketBean [value=" + value + "]";
	}
	
}
