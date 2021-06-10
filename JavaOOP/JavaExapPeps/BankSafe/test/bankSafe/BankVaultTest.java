package bankSafe;



import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class BankVaultTest {
    String name = "Maksim";
    String itemId = "12";
    Item item = new Item(name, itemId);
    BankVault bankVault = new BankVault();

   @Test
    public void testGetVaultCells(){
       assertEquals(bankVault.getVaultCells().size(), 12);
       assertNull(bankVault.getVaultCells().get("A1"));
   }
   @Test
    public void testAddWithValidParam() throws OperationNotSupportedException {
      String result =  bankVault.addItem("A1", item);
      assertEquals(result, "Item:12 saved successfully!");
       assertEquals(bankVault.getVaultCells().get("A1"), item);
       assertEquals(bankVault.getVaultCells().get("A1").getOwner(), name);
       assertEquals(bankVault.getVaultCells().get("A1").getItemId(), itemId);

   }
    @Test(expected = IllegalArgumentException.class)
    public void testAddWithNonExistingCell() throws OperationNotSupportedException {
        bankVault.addItem("V1", item);
   }
    @Test(expected = IllegalArgumentException.class)
    public void testAddWithTakenCell() throws OperationNotSupportedException {
        bankVault.addItem("A1", item);
        bankVault.addItem("A1", new Item("1", "11"));
    }
    @Test(expected = OperationNotSupportedException.class)
    public void testAddWithExistingItem() throws OperationNotSupportedException {
        bankVault.addItem("A1", item);
        bankVault.addItem("A2", item);
    }

    @Test
    public void testRemoveWithCorrectParam() throws OperationNotSupportedException {
       bankVault.addItem("A1", item);
        String result =bankVault.removeItem("A1", item);
                assertEquals(result, "Remove item:12 successfully!");
                assertEquals(bankVault.getVaultCells().size(), 12);
        assertNull(bankVault.getVaultCells().get("A1"));

    }
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveNonExistingCell() {

       bankVault.removeItem("A23", item);
   }
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveNonExistingItem() throws OperationNotSupportedException {
        bankVault.addItem("A1", new Item("1213", "1212"));
        bankVault.removeItem("A1", item);
    }

}