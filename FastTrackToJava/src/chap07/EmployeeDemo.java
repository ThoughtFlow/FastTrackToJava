package chap07;

public class EmployeeDemo {
    public static void main(String[] args) {
        Employee e1 = new Employee();
        e1.name = "John";
        e1.ssn = "555-12-345";
        e1.emailAddress = "john@company.com";

        Employee e2 = new Employee();
        e2.name = "Tom";
        e2.ssn = "456-78-901";
        e2.yearOfBirth = 1974;

        System.out.println("Name: " + e1.name);
        System.out.println("SSN: " + e1.ssn);
        System.out.println("Email Address: " + e1.emailAddress);
        System.out.println("Year Of Birth: " + e1.yearOfBirth);

        System.out.println("Name: " + e2.name);
        System.out.println("SSN: " + e2.ssn);
        System.out.println("Email Address: " + e2.emailAddress);
        System.out.println("Year Of Birth: " + e2.yearOfBirth);

    }
}
