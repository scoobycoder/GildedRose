
public class ItemFactory {

	static final String MANA_CAKE = "Conjured Mana Cake";
	static final String DEXTERITY_VEST = "+5 Dexterity Vest";
	static final String ELIXIR = "Elixir of the Mongoose";
	static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
	static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
	static final String AGED_BRIE = "Aged Brie";
	
	static final int DEFAULT_QUALITY_DELTA = -1;
	static final int VALUATING_QUALITY_DELTA = 1;
	static final int CONJURING_QUALITY_DELTA = -2;
	
	public static StoreKeepingItem create(String typeName, int sellIn, int quality) { 
		if (ItemFactory.SULFURAS.equals(typeName)) {
			return new ImmutableItem(typeName, sellIn, quality);
		} else if (ItemFactory.AGED_BRIE.equals(typeName)) {
			return new StoreKeepingItem(typeName, sellIn, quality, VALUATING_QUALITY_DELTA);
		} else if (ItemFactory.BACKSTAGE_PASSES.equals(typeName)) {
			return new BackstagePassStoreKeepingItem(typeName, sellIn, quality, VALUATING_QUALITY_DELTA);
		} else if (ItemFactory.MANA_CAKE.equals(typeName)) {
			return new StoreKeepingItem(typeName, sellIn, quality, CONJURING_QUALITY_DELTA);
		} else {
			return new StoreKeepingItem(typeName, sellIn, quality, DEFAULT_QUALITY_DELTA);
		}
	}

}
