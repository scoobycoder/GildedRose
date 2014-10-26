import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class GildedRoseTest {

	private List<Item> expectedItems;
	private StockHandler stocker;

	private void sellFiftyVests(Item vest) {
		for (int i = 0; i < 50; i++){
			vest.sell();
		}
	}
	
	@Before
	public void setup() {
		expectedItems = new ArrayList<Item>();
		stocker = new StockHandler();
	}
	
	@Test
	public void stockHandlerShouldAllowAddingInventory() {
		Item manaCake = new ManaCake(10, 5);
		expectedItems.add(manaCake);
		stocker.addItem(manaCake);
		assertEquals(expectedItems, stocker.inventoryReport());
	}
	
	@Test
	public void stockHandlerShouldAllowAddingAllTypes() {
		Item manaCake = new ManaCake(10, 5);
		Item dexterityVest = new DexterityVest(10, 20);
		Item agedBrie = new AgedBrie(2, 0);
		Item elixirMongoose = new ElixirMongoose(5, 7);
		Item sulfurasRagnaros = new SulfurasRagnaros(0, 80);
		Item backstagePasses = new BackstagePasses(15, 20);
		
		expectedItems.add(manaCake);
		expectedItems.add(dexterityVest);
		expectedItems.add(agedBrie);
		expectedItems.add(elixirMongoose);
		expectedItems.add(sulfurasRagnaros);
		expectedItems.add(backstagePasses);
		
		stocker.addItem(manaCake);
		stocker.addItem(dexterityVest);
		stocker.addItem(agedBrie);
		stocker.addItem(elixirMongoose);
		stocker.addItem(sulfurasRagnaros);
		stocker.addItem(backstagePasses);
		
		assertEquals(expectedItems, stocker.inventoryReport());
	}

	@Test
	public void removeManaCakeWhenAboutToSpoil() {
		Item manaCake = new ManaCake(1, 1);
		manaCake.dayPasses();
		assertEquals(false, manaCake.stockRemains());
	}

	@Test
	public void neverRemoveAgedBrieForSpoiling() {
		Item agedBrie = new AgedBrie(1, 1);
		agedBrie.dayPasses();
		assertEquals(true, agedBrie.stockRemains());
	}
	
	@Test
	public void Tafkal80EtcAboutToSpoilAddTwoUnits() {
		Item tafkal80 = new Tafkal80(1, 1);
		tafkal80.dayPasses();
		assertEquals(true, tafkal80.stockRemains());
	}
	
	@Test
	public void dexterityVestShouldBeSoldIfStockAvailable() {
		Item vest = new DexterityVest(10, 10);
		vest.dayPasses();
		assertEquals(true, vest.stockRemains());
	}
	
	@Test
	public void sellDexterityVestIfStockAvailable() {
		Item vest = new DexterityVest(3, 3);
		vest.dayPasses();
		assertEquals(true, vest.sell());
	}
	
	@Test
	public void failToSellDexterityVestIfNoStockAvailable() {
		Item vest = new DexterityVest(1, 0);
		vest.dayPasses();
		assertEquals(false, vest.sell());
	}
	
	@Test
	public void sulfurasRagnarosNeverSpoils() {
		Item sulfur = new SulfurasRagnaros(0, 1);
		sulfur.dayPasses();
		assertEquals(true, sulfur.stockRemains());
	}
	
	@Test
	public void removeAllQuantityForSpoiledItems() {
		Item brie = new AgedBrie(0, 5);
		brie.dayPasses();
		assertEquals(false, brie.stockRemains());
	}
	
	@Test
	public void buyDexterityVestWhenNoStockShouldAllowSales() {
		Item vest = new DexterityVest(5, 0);
		vest.restock();
		vest.dayPasses();
		
		assertEquals(true, vest.sell());
	}
	
	@Test
	public void sellingTwoVestsWhenOneRemainsShouldFail() {
		Item vest = new DexterityVest(2, 1);
		vest.sell();
		assertEquals(false, vest.sell());
	}
	
	@Test
	public void shouldRestock50ItemsAtATime() {
		Item vest = new DexterityVest(2, 1);
		vest.restock();
		sellFiftyVests(vest);
		assertEquals(true, vest.sell());
	}

}
