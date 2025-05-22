package test;

import models.Bill;
import models.Item;
import models.TaxInfo;
import java.util.ArrayList;
import java.util.List;

public class TestBill
{
    public static void main(String[] args)
    {
        // Create some items (name, quantity, unitPrice)
        Item item1 = new Item("Apple", 5, 10.0);  // 5 apples @ ₹10 each
        Item item2 = new Item("Milk", 2, 25.0);   // 2 milk bottles @ ₹25 each
        Item item3 = new Item("Bread", 1, 40.0);  // 1 bread loaf @ ₹40

        // Add items to a list
        List<Item> items = new ArrayList<>();
        List<Item> items2 = new ArrayList<>();

        items.add(item1);
        items.add(item2);
        items.add(item3);
        items2.add(item3);

        // Create TaxInfo for the bill (e.g., GST 12%)
        TaxInfo taxInfo = new TaxInfo("GST", 12.0);

        // Create bill with items and tax info
        Bill bill1 = new Bill(items, taxInfo);
        Bill bill2 = new Bill(items2, taxInfo);

        // Print bill details using Bill's toString()
        System.out.println(bill1);
        System.out.println(bill2);
    }
}
