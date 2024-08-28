public class EmployeeManagementSystem {
    private Employee[] employees;
    private int size;

    public EmployeeManagementSystem(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    // Add employee to the array
    public void addEmployee(Employee employee) {
        if (size < employees.length) {
            employees[size] = employee;
            size++;
        } else {
            System.out.println("Array is full. Cannot add more employees.");
        }
    }

    // Search for an employee by employeeId
    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    // Traverse the array and print all employees
    public void traverseEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println("Employee ID: " + employees[i].getEmployeeId());
            System.out.println("Name: " + employees[i].getName());
            System.out.println("Position: " + employees[i].getPosition());
            System.out.println("Salary: " + employees[i].getSalary());
            System.out.println();
        }
    }

    // Delete an employee by employeeId
    public void deleteEmployee(int employeeId) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < size - 1; i++) {
                employees[i] = employees[i + 1];
            }
            size--;
        } else {
            System.out.println("Employee not found.");
        }
    }

    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem(10);

        Employee emp1 = new Employee(1, "John Doe", "Software Engineer", 50000);
        Employee emp2 = new Employee(2, "Jane Doe", "Marketing Manager", 60000);
        Employee emp3 = new Employee(3, "Bob Smith", "Sales Representative", 40000);

        ems.addEmployee(emp1);
        ems.addEmployee(emp2);
        ems.addEmployee(emp3);

        System.out.println("Traversing employees:");
        ems.traverseEmployees();

        System.out.println("Searching for employee with ID 2:");
        Employee searchedEmp = ems.searchEmployee(2);
        if (searchedEmp != null) {
            System.out.println("Employee ID: " + searchedEmp.getEmployeeId());
            System.out.println("Name: " + searchedEmp.getName());
            System.out.println("Position: " + searchedEmp.getPosition());
            System.out.println("Salary: " + searchedEmp.getSalary());
        } else {
            System.out.println("Employee not found.");
        }

        System.out.println("Deleting employee with ID 2:");
        ems.deleteEmployee(2);

        System.out.println("Traversing employees after deletion:");
        ems.traverseEmployees();
    }
}