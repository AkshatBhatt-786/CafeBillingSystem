package models;

public class TaxInfo
{
    private String taxName;
    private double taxPercentage;

    public TaxInfo(String taxName, double taxPercentage)
    {
        this.taxName = taxName;
        this.taxPercentage = taxPercentage;
    }

    public String getTaxName()
    {
        return taxName;
    }

    public void setTaxName(String taxName)
    {
        this.taxName = taxName;
    }

    public double getTaxPercentage()
    {
        return taxPercentage;
    }

    public void setTaxPercentage(double taxPercentage)
    {
        this.taxPercentage = taxPercentage;
    }

    public double calculateTax(double amount)
    {
        return (amount * taxPercentage) / 100;
    }

    @Override
    public String toString()
    {
        return taxName + " (" + taxPercentage + "%)";
    }
}
