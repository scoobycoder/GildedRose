public class Item {

	private static final boolean NOT_SOLD = false;
	private static final boolean SOLD = true;
	private int quantity;
	private int sellIn;
	private String name = "not a real name";

	public Item(int sellIn, int quantity) {
		this.sellIn = sellIn;
		this.quantity = quantity;
	}

	public boolean stockRemains() {
		if (sellIn > 0)
			return true;

		return false;
	}

	public void dayPasses() {
		sellIn--;
	}

	public boolean sell() {
		if (canBeSold()) {
			sellOneItem();
			return SOLD;
		} else
			return NOT_SOLD;
	}

	private void sellOneItem() {
		quantity--;
	}

	private boolean canBeSold() {
		return quantity > 0;
	}

}
