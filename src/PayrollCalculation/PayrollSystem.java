package PayrollCalculation;

import java.util.Scanner;

public class PayrollSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Employee[] employees = new Employee[10];
        int employeeCount = 4;

        employees[0] = new SalariedEmployee("Tamim", "Hossen", "222-22-2222", 10000);
        employees[1] = new HourlyEmployee("Saikat", "Islam", "111-11-1111", 20, 42);
        employees[2] = new CommissionEmployee("Darun", "Nayeem", "333-33-3333", 10000, 0.06);
        employees[3] = new BasePlusCommissionEmployee("Azizul", "Hakim", "444-44-4444", 5000, 0.04, 300);

        while (true) {
            System.out.println("\n====== Payroll System Menu =====");
            System.out.println("1. Display all employees informations");
            System.out.println("2. Add a new employee");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\n---- Employee Details ----");
                    for (int i = 0; i < employeeCount; i++) {
                        if (employees[i] != null) {
                            System.out.println(employees[i]);
                            System.out.println(" Earned: " + employees[i].earning());
                            System.out.println("----------------------------");
                        }
                    }
                    break;

                case 2:
                    if (employeeCount >= employees.length) {
                        System.out.println("Cannot add more employees.");
                        break;
                    }

                    System.out.println("\nSelect Employee Type:");
                    System.out.println("1. SalariedEmployee");
                    System.out.println("2. HourlyEmployee");
                    System.out.println("3. CommissionEmployee");
                    System.out.println("4. BasePlusCommissionEmployee");
                    System.out.print("Your choice: ");
                    int type = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("First Name: ");
                    String first = scanner.nextLine();

                    System.out.print("Last Name: ");
                    String last = scanner.nextLine();

                    System.out.print("SSN: ");
                    String ssn = scanner.nextLine();

                    switch (type) {
                        case 1:
                            System.out.print("Weekly Salary: ");
                            double salary = scanner.nextDouble();
                            employees[employeeCount++] = new SalariedEmployee(first, last, ssn, salary);
                            break;

                        case 2:
                            System.out.print("Wage: ");
                            double wage = scanner.nextDouble();
                            System.out.print("Hours: ");
                            double hours = scanner.nextDouble();
                            employees[employeeCount++] = new HourlyEmployee(first, last, ssn, wage, hours);
                            break;

                        case 3:
                            System.out.print("Gross Sales: ");
                            double sales = scanner.nextDouble();
                            System.out.print("Commission Rate: ");
                            double rate = scanner.nextDouble();
                            employees[employeeCount++] = new CommissionEmployee(first, last, ssn, sales, rate);
                            break;

                        case 4:
                            System.out.print("Gross Sales: ");
                            double baseSales = scanner.nextDouble();
                            System.out.print("Commission Rate: ");
                            double baseRate = scanner.nextDouble();
                            System.out.print("Base Salary: ");
                            double baseSalary = scanner.nextDouble();
                            employees[employeeCount++] = new BasePlusCommissionEmployee(first, last, ssn, baseSales, baseRate, baseSalary);
                            break;

                        default:
                            System.out.println("Invalid employee type.");
                            break;
                    }
                    break;

                case 3:
                    System.out.println("Exiting Payroll System.");
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
