package store;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class StoreTests {
    private final String name = "Pepsi";
    private final int quantity = 100;
    private final double price = 10;
    Product product;
    Store store;

    @Before
    public void setUp() {
        product = new Product(name, quantity, price);
        store = new Store();
    }

    @Test
    public void testConstructor() {
        assertNotNull(store);
    }

    @Test
    public void testGetProducts() {
        store.addProduct(product);
        List<Product> products = store.getProducts();
        assertEquals(1, products.size());
        assertEquals(product, products.get(0));

    }

    @Test(expected = UnsupportedOperationException.class)
    public void testUnmodifileList() {
        store.addProduct(product);
        List<Product> products = store.getProducts();
        products.remove(product);
    }

    @Test
    public void testAddProductValid() {
        store.addProduct(product);
        assertEquals("Pepsi", store.getProducts().get(0).getName());
        assertEquals(quantity, store.getProducts().get(0).getQuantity());
        assertEquals(price, store.getProducts().get(0).getPrice(), 0.1);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddProductNullProduct() {
        store.addProduct(null);


    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddProductInvalidQuantity() {
        product.setQuantity(-1);
        store.addProduct(product);
    }

    @Test
    public void testGetCount() {
        store.addProduct(product);
        assertEquals(1, store.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestBuyProductWithNull() {
        store.buyProduct("Cola", 100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestBuyProductInvalidQuantity() {
        store.buyProduct("Pepsi", 200);
    }

    @Test
    public void BuyProductValid() {
        store.addProduct(product);

        Product product1 = store.getProducts().get(0);
        double price = store.buyProduct("Pepsi", 49);
        assertEquals(51, product1.getQuantity());
        assertEquals(490, price, 0.1);

    }


    @Test
    public void getTheMostExpensiveProduct() {
        store.addProduct(product);
        store.addProduct(new Product("Cola", 100, 11));
        store.addProduct(new Product("Juice", 100, 5));
        store.addProduct(new Product("Gold", 100, 50));
        Product theMostExpensiveProduct = store.getTheMostExpensiveProduct();
        assertEquals(50, theMostExpensiveProduct.getPrice(), 0.1);

    }
}