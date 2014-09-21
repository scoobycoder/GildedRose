import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GildedRoseTest {

	@Test
	public void shouldStockHandlerAllowAddingInventory() {
		List<Item> expectedItems = new ArrayList<Item>();
		Item manaCake = new ManaCake(10, 5);

		expectedItems.add(manaCake);
		
		StockHandler stocker = new StockHandler();
		stocker.addItem(manaCake);
		assertEquals(expectedItems, stocker.inventoryReport());
	}
	
	
	
}
