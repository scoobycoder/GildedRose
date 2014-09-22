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

}
