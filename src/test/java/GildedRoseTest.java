import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class GildedRoseTest {

	@Test
	public void shouldAllowAddingInventory() {
		List<Item> expectedItems = new ArrayList<Item>();
		Item manaCake = new ManaCake();

		expectedItems.add(manaCake);
		
		StockHandler stocker = null;
		assertEquals(expectedItems.get(0), stocker.inventoryReport());
	}
}
