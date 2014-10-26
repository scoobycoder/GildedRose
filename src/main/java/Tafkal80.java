
public class Tafkal80 extends Item {

	private int sellIn;
	private int quantity;

	public Tafkal80(int sellIn, int quantity) {
		super(sellIn, quantity);
	}

	@Override
	public boolean stockRemains() {
		if (this.sellIn > 0)
			return true;
		else
			this.quantity += 2;
			return true;
	}
	
}
