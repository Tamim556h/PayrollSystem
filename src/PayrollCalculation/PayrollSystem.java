package PayrollCalculation;

public class PayrollSystem{
    public static void main(String[] args) {
        Employee[] employees = new Employee[3];

        employees[0] = new SalariedEmployee("tamim","hossen","222-22-222",10000);


        for ( Employee employee : employees ) {
            if (employee == null) continue;

            System.out.println(" " + employee);
            System.out.println(" Earned :  " + employee.earning());
        }

    }
}