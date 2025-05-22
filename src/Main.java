import models.Bill;
import models.Item;
import models.TaxInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        List<Item> catalog = new ArrayList<>();
        catalog.add(new Item("Coffee", 0, 30.0));
        catalog.add(new Item("Sandwich", 0, 50.0));
        catalog.add(new Item("Cake Slice", 0, 70.0));
        catalog.add(new Item("Tea", 0, 25.0));
        catalog.add(new Item("Cookie", 0, 10.0));

        System.out.println("Welcome! Please enter quantity for each item:");

        List<Item> selectedItems = new ArrayList<>();

        for (Item item : catalog)
        {
            System.out.print(item.getName() + " (Unit Price: Rs " + item.getUnitPrice() + "): Quantity = ");
            int qty = scanner.nextInt();

            if (qty > 0)
            {
                // Create new Item with quantity input by customer
                Item selectedItem = new Item(item.getName(), qty, item.getUnitPrice());
                selectedItems.add(selectedItem);
            }
        }

        System.out.print("Enter tax name (e.g., GST, VAT): ");
        String taxName = scanner.nextLine();

        System.out.print("Enter tax percentage (e.g., 5 for 5%): ");
        double taxPercent = scanner.nextDouble();

        TaxInfo taxInfo = new TaxInfo(taxName, taxPercent);

        Bill bill = new Bill(selectedItems, taxInfo);

        System.out.println("\n==== Your Bill ====");
        System.out.println(bill);

        scanner.close();
    }
}
