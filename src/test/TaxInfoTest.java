package test;
import models.TaxInfo;

public class TaxInfoTest
{
    public static void main(String args[])
    {
        TaxInfo gst = new TaxInfo("GST", 3.0);
        double taxAmount = gst.calculateTax(300);
        System.out.println(gst);
        System.out.println(300 + taxAmount);
    }
}
