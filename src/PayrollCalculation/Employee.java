package PayrollCalculation;

abstract class Employee {
    private String firstName;
    private String lastName;
    private String ssn;

    public Employee(String firstName, String lastName, String ssn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
    }

    public String toString() {
        return firstName + " " + lastName + " " + ssn;
    }
    public abstract double earning();

}
