public class MainClass {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAO();

        Employee newEmployee = new Employee("John Doe", "Developer", 60000);
        employeeDAO.addEmployee(newEmployee);

        System.out.println("Список співробітників:");
        for (Employee employee : employeeDAO.getAllEmployees()) {
            System.out.println(employee);
        }

        Employee existingEmployee = new Employee(1, "John Doe", "Senior Developer", 75000);
        employeeDAO.updateEmployee(existingEmployee);

        employeeDAO.deleteEmployee(1);
    }
}