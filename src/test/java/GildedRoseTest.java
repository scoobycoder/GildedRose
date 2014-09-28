import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class GildedRoseTest {

	private List<Item> expectedItems;
	private StockHandler stocker;

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
		stocker.addItem(new ManaCake(0, 1));
		stocker.updateQuality();
		
		assertEquals(0, stocker.inventoryReport().get(0).getQuality());
	}

	@Test
	public void neverRemoveAgedBrieForSpoiling() {
		stocker.addItem(new AgedBrie(0, 1));
		stocker.updateQuality();
		
		assertEquals(1, stocker.inventoryReport().get(0).getQuality());
	}
	
	@Test
	public void Tafkal80EtcAboutToSpoilAddTwoUnits() {
		stocker.addItem(new BackstagePasses(1, 10));
		stocker.updateQuality();
		
		assertEquals(3, stocker.inventoryReport().get(0).getQuality());
	}
	
	@Test
	public void dexterityVestShouldBeSoldIfStockAvailable() {
		stocker.addItem(new DexterityVest(10, 10));
		stocker.updateQuality();
		
		assertEquals(9, stocker.inventoryReport().get(0).getQuality());
	}
	
}
