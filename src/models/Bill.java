package models;

import java.time.LocalDateTime;
import java.util.List;
import java.text.DecimalFormat;

public class Bill
{
    private static int billCounter = 0;

    private String billId;
    private List<Item> items;
    private TaxInfo taxInfo;
    private LocalDateTime dateTime;

    public Bill(List<Item> items, TaxInfo taxInfo)
    {
        this.items = items;
        this.taxInfo = taxInfo;
        this.dateTime = LocalDateTime.now();
        this.billId = generateBillId();
    }

    public String generateBillId()
    {
        billCounter ++;
        return String.format("BILL-%03d", billCounter);
    }

    public String getBillId()
    {
        return billId;
    }

    public List<Item> getItems() {
        return items;
    }

    public TaxInfo getTaxInfo() {
        return taxInfo;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public double calculateSubTotal()
    {
        double subtotal = 0;
        for (Item item : items)
        {
            subtotal += item.getTotalPrice();
        }
        return subtotal;
    }

    public double calculateTax()
    {
        return taxInfo.calculateTax(calculateSubTotal());
    }

    public double calculateTotal() {
        return calculateSubTotal() + calculateTax();
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        DecimalFormat df = new DecimalFormat("0.00");

        sb.append("🧾 Bill ID: ").append(billId).append("\n");
        sb.append("🕒 Date: ").append(dateTime).append("\n");
        sb.append("Items:\n");

        for (Item item : items) {
            sb.append(" - ").append(item.getName())
                    .append(" x ").append(item.getQuantity())
                    .append(" = Rs ").append(df.format(item.getTotalPrice())).append("/- ").append("\n");
        }

        sb.append("Subtotal: Rs ").append(df.format(calculateSubTotal())).append("/-").append("\n");
        sb.append("Tax [").append(taxInfo.getTaxName()).append("]: /-")
                .append(df.format(calculateTax())).append("\n");
        sb.append("Total: Rs ").append(df.format(calculateTotal())).append("/-").append("\n");

        return sb.toString();
    }
}
