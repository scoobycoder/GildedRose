
public class SulfurasRagnaros extends Item {

	public SulfurasRagnaros(int sellIn, int quantity) {
		super(sellIn, quantity);
	}

	@Override
	public boolean stockRemains() {
		return true;
	}
	
}
