import java.util.ArrayList;
import java.util.List;

public class StockHandler {

	private List<Item> itemList = new ArrayList<Item>();

	public List<Item> inventoryReport() {
		return itemList;
	}

	public void addItem(Item item) {
		itemList.add(item);
	}

	public void updateQuality() {
		for (Item item : itemList) {
			item.dayPasses();
			if (item.stockRemains() == false)
				itemList.remove(item);
		}
		
	}

}
