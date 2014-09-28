import java.util.ArrayList;
import java.util.List;

public class StockHandler {

	private static final String AGED_BRIE = "Aged Brie";
	private static final String SULFURAS_RAGNAROS = "Sulfuras, Hand of Ragnaros";
	private static final String TAFKAL80ETC = "Backstage passes to a TAFKAL80ETC concert";

	private List<Item> itemList = new ArrayList<Item>();

	public List<Item> inventoryReport() {
		return itemList;
	}

	public void addItem(Item item) {
		itemList.add(item);
	}

	public void updateQuality() {
		for (int itemNumber = 0; itemNumber < itemList.size(); itemNumber++) {
			
			handleTafkal80Etc(itemNumber);
			
			if (agedBrie(itemNumber)) {
				restockNeededItems(itemNumber);
			} else {
				handleInStockItems(itemNumber);
			}

			ageItems(itemNumber);
			handleSpoiledItems(itemNumber);
		}
	}

	private void handleTafkal80Etc(int itemNumber) {
		if (isTafkal80Etc(itemNumber)) {
			stockAtLeastThree(itemNumber);
		}
	}

	private void stockAtLeastThree(int itemNumber) {
		while (itemList.get(itemNumber).getQuality() <= 3) {
			buyItem(itemNumber);
		}
	}

	private void handleSpoiledItems(int itemNumber) {
		if (itemAboutToSpoil(itemNumber, 0)) {
			handleItemsThatAreCompletelySpoiled(itemNumber);
		}
	}

	private void ageItems(int itemNumber) {
		if (notSulfurasRagnaros(itemNumber)) {
			itemAgedADay(itemNumber);
		}
	}

	private void handleInStockItems(int itemNumber) {
		if (availableStock(itemNumber)) {
			if (notSulfurasRagnaros(itemNumber)) {
				removeItem(itemNumber);
			}
		}
	}

	private void handleItemsThatAreCompletelySpoiled(int itemNumber) {
		if (brieOrTafkal(itemNumber)) {
			restockNeededItems(itemNumber);
		} else {
			removeQuantity(itemNumber);
		}
	}

	private boolean brieOrTafkal(int itemNumber) {
		return agedBrie(itemNumber) || isTafkal80Etc(itemNumber);
	}

	private void removeQuantity(int itemNumber) {
		if (availableStock(itemNumber)) {
			if (notSulfurasRagnaros(itemNumber)) {
				removeItem(itemNumber);
			}
		} else {
			removeAllQuantity(itemNumber);
		}
	}

	private void restockNeededItems(int itemNumber) {
		if (needToRestock(itemNumber)) {
			buyItem(itemNumber);
		}
	}

	private boolean isTafkal80Etc(int itemNumber) {
		return TAFKAL80ETC.equals(itemList.get(itemNumber).getName());
	}

	private void removeAllQuantity(int itemNumber) {
		itemList.get(itemNumber).setQuality(
				itemList.get(itemNumber).getQuality()
						- itemList.get(itemNumber).getQuality());
	}

	private void removeItem(int itemNumber) {
		itemList.get(itemNumber).setQuality(
				itemList.get(itemNumber).getQuality() - 1);
	}

	private boolean agedBrie(int itemNumber) {
		return AGED_BRIE.equals(itemList.get(itemNumber).getName());
	}

	private boolean notSulfurasRagnaros(int itemNumber) {
		return !SULFURAS_RAGNAROS.equals(itemList.get(itemNumber).getName());
	}

	private void buyItem(int itemNumber) {
		itemList.get(itemNumber).setQuality(
				itemList.get(itemNumber).getQuality() + 1);
	}

	private void itemAgedADay(int itemNumber) {
		itemList.get(itemNumber).setSellIn(
				itemList.get(itemNumber).getSellIn() - 1);
	}

	private boolean availableStock(int itemNumber) {
		return itemList.get(itemNumber).getQuality() > 0;
	}

	private boolean itemAboutToSpoil(int itemNumber, int daysTillSpoiled) {
		return itemList.get(itemNumber).getSellIn() < daysTillSpoiled;
	}

	private boolean needToRestock(int itemNumber) {
		return itemList.get(itemNumber).getQuality() < 50;
	}

}
