
public class DexterityVest implements Item {

	private int quantity;
	private int sellIn;
	private String name = "Dexterity Vest";	
	
	public DexterityVest(int quantity, int sellIn) {
		this.quantity = quantity;
		this.sellIn = sellIn;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getSellIn() {
		return sellIn;
	}

	@Override
	public void setSellIn(int sellIn) {
		this.sellIn = sellIn;
	}

	@Override
	public int getQuality() {
		return quantity;
	}

	@Override
	public void setQuality(int quality) {
		this.quantity = quality;
	}

}
