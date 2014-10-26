
public class Item {

	private int quantity;
	private int sellIn;
	private String name = "not a real name";
	
	public Item(int sellIn, int quantity) {
		this.sellIn = sellIn;
		this.quantity = quantity;
	}	
	
	public boolean stockRemains() {
		if (this.sellIn > 0)
			return true;
		
		return false;
	}

	public void dayPasses() {
		this.sellIn--;
	}
    
	
}
