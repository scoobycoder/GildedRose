
public class ManaCake implements Item {

	private int quantity;
	private int sellIn;
	private String name = "Mana Cake";

	public ManaCake(int sellIn, int quantity) {
		this.sellIn = sellIn;
		this.quantity = quantity;
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
		quantity = quality;
	}

}
