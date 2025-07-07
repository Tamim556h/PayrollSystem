package PayrollCalculation;

class CommissionEmployee extends  Employee {
    private double grossSales;
    private double commissionRate;

    public CommissionEmployee(String fristName, String lastName, String ssn, double grossSales, double commissionRate) {
        super(fristName,lastName,ssn);
        this.grossSales = grossSales;
        this.commissionRate = commissionRate;

    }
    @Override
    public double earning() {
        return grossSales*commissionRate;
    }

    @Override
    public String toString() {
        return "Commission Employee : " + super.toString()+ "\n Gross Sales" + "\n Commission Rate: " + commissionRate;

    }

}
