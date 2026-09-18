public class EmployeeAndCompanyInformationManagement {

    static class Employee {
        String empName;
        double salary;
        static String companyName = "Bright Horizon Technologies";
        static int employeeCount = 0;

        Employee(String empName, double salary) {
            this.empName = empName;
            this.salary = salary;
            employeeCount++;
        }

        static void printCompanyInfo() {
            System.out.println(companyName);
            System.out.println("Employees on record: " + employeeCount);
        }
    }

    public static void main(String[] args) {
        Employee first = new Employee("Divya", 65000);
        Employee second = new Employee("Arjun", 0);
        Employee third = new Employee("Priya", 50000);
        Employee.printCompanyInfo();
    }
}
