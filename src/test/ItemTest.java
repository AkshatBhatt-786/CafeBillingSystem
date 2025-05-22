package test;

import models.Item;

public class ItemTest
{
    public static void main(String args[])
    {
        Item coffee = new Item("Coffee", 10, 70.0);
        Item snackbar = new Item("Snackbar", 1000, 5.0);

        System.out.println(coffee);
        System.out.println(snackbar);

        coffee.setQuantity(3);
        coffee.setUnitPrice(100);
        System.out.println(coffee);
    }
}
