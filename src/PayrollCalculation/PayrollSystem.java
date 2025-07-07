package PayrollCalculation;

public class PayrollSystem{
    public static void main(String[] args) {
        Employee[] employees = new Employee[4];

        employees[0] = new SalariedEmployee("tamim","hossen","222-22-222",10000);
        employees[1] = new HourlyEmployee("Saikat","Islam","111-11-111",20,42);
        employees[2] = new CommissionEmployee("Darun", "Nayeem", "333-33-3333", 10000, 0.06);
        employees[3] = new BasePlusCommissionEmployee("Azizul", "Hakim", "444-44-4444", 5000, 0.04, 300);

        for ( Employee employee : employees ) {
            if (employee == null) continue;

            System.out.println(" " + employee);
            System.out.println(" Earned :  " + employee.earning());
        }

    }
}