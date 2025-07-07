package PayrollCalculation;

class HourlyEmployee extends Employee {
    private double hourlyWage;
    private double workingHours;
    public HourlyEmployee(String firstName, String lastName,String snn, double hourlyWage, double workingHours) {
        super(firstName, lastName, snn);
        this.hourlyWage = hourlyWage;
        this.workingHours = workingHours;

    }
    @Override
    public double earning() {
        if(workingHours <= 40)
            return hourlyWage * workingHours;
        else
            return 40*hourlyWage + (workingHours - 40)*workingHours*1.5;
    }

    @Override
    public String toString() {
        return "Hourly Employee : " + super.toString() + "\n HourlyWage : " + hourlyWage + "\n WorkingHours : " + workingHours;
    }

}
