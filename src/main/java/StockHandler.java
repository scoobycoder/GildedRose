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
			if (notAgedBrie(itemNumber) && notTafkal80Etc(itemNumber)) {
				if (availableStock(itemNumber)) {
					if (notSulfurasRagnaros(itemNumber)) {
						removeItem(itemNumber);
					}
				}
			} else {
				if (needToRestock(itemNumber)) {
					buyItem(itemNumber);

					if (isTafkal80Etc(itemNumber)) {
						restockItemsAboutToSpoil(itemNumber);
					}
				}
			}

			if (notSulfurasRagnaros(itemNumber)) {
				itemAgedADay(itemNumber);
			}

			if (itemAboutToSpoil(itemNumber, 0)) {
				if (notAgedBrie(itemNumber) && notTafkal80Etc(itemNumber)) {
					if (availableStock(itemNumber)) {
						if (notSulfurasRagnaros(itemNumber)) {
							removeItem(itemNumber);
						}
					} else {
						removeAllQuantity(itemNumber);
					}
				} else {
					restockNeededItems(itemNumber);
				}
			}
		}
	}

	private void restockItemsAboutToSpoil(int itemNumber) {
		int daysTillSpoiled = 11;

		while (itemAboutToSpoil(itemNumber, daysTillSpoiled)) {
			restockNeededItems(itemNumber);

			daysTillSpoiled -= 1;
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

	private boolean notTafkal80Etc(int itemNumber) {
		return !isTafkal80Etc(itemNumber);
	}

	private boolean notAgedBrie(int itemNumber) {
		return !AGED_BRIE.equals(itemList.get(itemNumber).getName());
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
