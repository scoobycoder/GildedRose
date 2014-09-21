
public class ManaCake implements Item {

	private int quantity;
	private int sellIn;

	public ManaCake(int sellIn, int quantity) {
		this.sellIn = sellIn;
		this.quantity = quantity;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getSellIn() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setSellIn(int sellIn) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getQuality() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setQuality(int quality) {
		// TODO Auto-generated method stub

	}

}
