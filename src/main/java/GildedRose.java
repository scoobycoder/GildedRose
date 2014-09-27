import java.util.List;

public class GildedRose {

	private static final String AGED_BRIE = "Aged Brie";
	private static final String SULFURAS_RAGNAROS = "Sulfuras, Hand of Ragnaros";
	private static final String TAFKAL80ETC = "Backstage passes to a TAFKAL80ETC concert";
	private static List<Item> items = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
        System.out.println("OMGHAI!");
		
        StockHandler stockHandler = new StockHandler();
        stockHandler.addItem(new ManaCake(10, 5));
        stockHandler.addItem(new DexterityVest(10, 20));
        stockHandler.addItem(new AgedBrie(2, 0));
        stockHandler.addItem(new ElixirMongoose(5, 7));
        stockHandler.addItem(new SulfurasRagnaros(0, 80));
        stockHandler.addItem(new BackstagePasses(15, 20));

        items = stockHandler.inventoryReport();
        updateQuality();
}


	
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
                        items.get(itemNumber).setQuality(items.get(itemNumber).getQuality() - 1);
                    }
                }
            }
            else
            {
                if (needToRestock(itemNumber))
                {
                    buyItem(itemNumber);

                    if (TAFKAL80ETC.equals(items.get(itemNumber).getName()))
                    {
                        if (itemAboutToSpoil(itemNumber, 11))
                        {
                            if (needToRestock(itemNumber))
                            {
                                buyItem(itemNumber);
                            }
                        }

                        if (itemAboutToSpoil(itemNumber, 6))
                        {
                            if (needToRestock(itemNumber))
                            {
                                buyItem(itemNumber);
                            }
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
                                items.get(itemNumber).setQuality(items.get(itemNumber).getQuality() - 1);
                            }
                        }
                    }
                    else
                    {
                        items.get(itemNumber).setQuality(items.get(itemNumber).getQuality() - items.get(itemNumber).getQuality());
                    }
                }
                else
                {
                    if (needToRestock(itemNumber))
                    {
                        buyItem(itemNumber);
                    }
                }
            }
        }
    }



	private static boolean notTafkal80Etc(int itemNumber) {
		return !TAFKAL80ETC.equals(items.get(itemNumber).getName());
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