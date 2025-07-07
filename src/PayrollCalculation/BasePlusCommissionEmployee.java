package PayrollCalculation;

class BasePlusCommissionEmployee extends CommissionEmployee {
    private double baseSalary;

    public BasePlusCommissionEmployee(String fristName, String lastName,String ssn, double grossSales,double commissionRate,double baseSalary) {
        super(fristName,lastName,ssn,grossSales,commissionRate);
        this.baseSalary = baseSalary;
    }

    public void increaseBaseSalary(double percent) {
        baseSalary *= (1 + percent/100.0);
    }
    @Override
    public double earning() {
        return baseSalary + super.earning();
    }

    @Override
    public String toString() {
        return "Base Plus Commission Employee : " + super.toString()+ "\n Base Salary : " + baseSalary;
    }
}
