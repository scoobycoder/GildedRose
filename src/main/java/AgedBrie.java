
public class AgedBrie implements Item {

	private int quantity;
	private int sellIn;
	
	public AgedBrie(int quantity, int sellIn) {
		this.quantity = quantity;
		this.sellIn = sellIn;
	}

	@Override
	public String getName() {
		return "Aged Brie";
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
		return this.quantity;
	}

	@Override
	public void setQuality(int quality) {
		this.quantity = quality;
	}

}
