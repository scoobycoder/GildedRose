import java.util.List;

public class GildedRose {



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

        StockHandler.updateQuality();
}



}