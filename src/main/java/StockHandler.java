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

	private static List<Item> items = null;
	
    public static void updateQuality()
    {
        for (int itemNumber = 0; itemNumber < items.size(); itemNumber++)
        {
            if (notAgedBrie(itemNumber) && notTafkal80Etc(itemNumber)) 
            {
                if (outOfStock(itemNumber))
                {
                    if (notSulfurasRagnaros(itemNumber))
                    {
                        removeItem(itemNumber);
                    }
                }
            }
            else
            {
                if (needToRestock(itemNumber))
                {
                    buyItem(itemNumber);

                    if (isTafkal80Etc(itemNumber))
                    {
                        if (itemAboutToSpoil(itemNumber, 11))
                        {
                            restockNeededItems(itemNumber);
                        }

                        if (itemAboutToSpoil(itemNumber, 6))
                        {
                            restockNeededItems(itemNumber);
                        }
                    }
                }
            }

            if (notSulfurasRagnaros(itemNumber))
            {
                itemAgedADay(itemNumber);
            }

            if (itemAboutToSpoil(itemNumber, 0))
            {
                if (notAgedBrie(itemNumber))
                {
                    if (notTafkal80Etc(itemNumber))
                    {
                        if (outOfStock(itemNumber))
                        {
                            if (notSulfurasRagnaros(itemNumber))
                            {
                                removeItem(itemNumber);
                            }
                        }
                    }
                    else
                    {
                        removeAllQuantity(itemNumber);
                    }
                }
                else
                {
                    restockNeededItems(itemNumber);
                }
            }
        }
    }



	private static void restockNeededItems(int itemNumber) {
		if (needToRestock(itemNumber))
		{
		    buyItem(itemNumber);
		}
	}



	private static boolean isTafkal80Etc(int itemNumber) {
		return TAFKAL80ETC.equals(items.get(itemNumber).getName());
	}



	private static void removeAllQuantity(int itemNumber) {
		items.get(itemNumber).setQuality(items.get(itemNumber).getQuality() - items.get(itemNumber).getQuality());
	}



	private static void removeItem(int itemNumber) {
		items.get(itemNumber).setQuality(items.get(itemNumber).getQuality() - 1);
	}



	private static boolean notTafkal80Etc(int itemNumber) {
		return !isTafkal80Etc(itemNumber);
	}



	private static boolean notAgedBrie(int itemNumber) {
		return !AGED_BRIE.equals(items.get(itemNumber).getName());
	}



	private static boolean notSulfurasRagnaros(int itemNumber) {
		return !SULFURAS_RAGNAROS.equals(items.get(itemNumber).getName());
	}



	private static void buyItem(int itemNumber) {
		items.get(itemNumber).setQuality(items.get(itemNumber).getQuality() + 1);
	}



	private static void itemAgedADay(int itemNumber) {
		items.get(itemNumber).setSellIn(items.get(itemNumber).getSellIn() - 1);
	}



	private static boolean outOfStock(int itemNumber) {
		return items.get(itemNumber).getQuality() > 0;
	}



	private static boolean itemAboutToSpoil(int itemNumber, int daysTillSpoiled) {
		return items.get(itemNumber).getSellIn() < daysTillSpoiled;
	}



	private static boolean needToRestock(int itemNumber) {
		return items.get(itemNumber).getQuality() < 50;
	}

	
}
