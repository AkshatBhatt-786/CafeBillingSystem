package models;
import java.util.UUID;

public class Item
{
    private String id;
    private String name;
    private int quantity;
    private double unitPrice;
    private double totalPrice;

    public Item(String name, int quantity, double unitPrice)
    {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalPrice = quantity * unitPrice;
    }

    public String getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public double getUnitPrice()
    {
        return unitPrice;
    }

    public double getTotalPrice()
    {
        return totalPrice;
    }

    public void setId(String id)
    {
       String previousId = this.id;
       this.id = id;
       System.out.println("id changed from " + previousId + " to " + this.id);
    }

    public void setName(String name)
    {
        String previousName = this.name;
        this.name = name;
        System.out.println("name changed from " + previousName + " to " + this.name);
    }

    public void setQuantity(int quantity)
    {
        int previousQuantity = this.quantity;
        this.quantity = quantity;
        System.out.println("quantity changed from " + previousQuantity + " to " + this.quantity);
        recalculateTotal();
    }

    public void recalculateTotal()
    {
        this.totalPrice = this.quantity * this.unitPrice;
        System.out.println("recalculating...");
        System.out.println("= Rs " + this.totalPrice + "/-");
    }

    public void setUnitPrice(double unitPrice)
    {
        double previousPrice = this.unitPrice;
        this.unitPrice = unitPrice;
        System.out.println("unit price changed for " + name + " from " + previousPrice + " to " + this.unitPrice);
        recalculateTotal();
    }



    @Override
    public String toString()
    {
        return name + " x " + quantity + " @ Rs " + unitPrice + "/-" + " = Rs " + totalPrice + "/-";
    }
}
