import java.util.List;

public class GildedRose {

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
            if ((!"Aged Brie".equals(items.get(itemNumber).getName())) && !"Backstage passes to a TAFKAL80ETC concert".equals(items.get(itemNumber).getName())) 
            {
                if (items.get(itemNumber).getQuality() > 0)
                {
                    if (!"Sulfuras, Hand of Ragnaros".equals(items.get(itemNumber).getName()))
                    {
                        items.get(itemNumber).setQuality(items.get(itemNumber).getQuality() - 1);
                    }
                }
            }
            else
            {
                if (needToRestock(itemNumber))
                {
                    items.get(itemNumber).setQuality(items.get(itemNumber).getQuality() + 1);

                    if ("Backstage passes to a TAFKAL80ETC concert".equals(items.get(itemNumber).getName()))
                    {
                        if (items.get(itemNumber).getSellIn() < 11)
                        {
                            if (needToRestock(itemNumber))
                            {
                                items.get(itemNumber).setQuality(items.get(itemNumber).getQuality() + 1);
                            }
                        }

                        if (items.get(itemNumber).getSellIn() < 6)
                        {
                            if (needToRestock(itemNumber))
                            {
                                items.get(itemNumber).setQuality(items.get(itemNumber).getQuality() + 1);
                            }
                        }
                    }
                }
            }

            if (!"Sulfuras, Hand of Ragnaros".equals(items.get(itemNumber).getName()))
            {
                items.get(itemNumber).setSellIn(items.get(itemNumber).getSellIn() - 1);
            }

            if (items.get(itemNumber).getSellIn() < 0)
            {
                if (!"Aged Brie".equals(items.get(itemNumber).getName()))
                {
                    if (!"Backstage passes to a TAFKAL80ETC concert".equals(items.get(itemNumber).getName()))
                    {
                        if (items.get(itemNumber).getQuality() > 0)
                        {
                            if (!"Sulfuras, Hand of Ragnaros".equals(items.get(itemNumber).getName()))
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
                        items.get(itemNumber).setQuality(items.get(itemNumber).getQuality() + 1);
                    }
                }
            }
        }
    }



	private static boolean needToRestock(int itemNumber) {
		return items.get(itemNumber).getQuality() < 50;
	}

}