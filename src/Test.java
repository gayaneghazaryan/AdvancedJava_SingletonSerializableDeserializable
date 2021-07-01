public class Test {
    public static void main(String[] args) {
        Employee employee = Employee.getInstance();
        employee.setName("Hakob");
        employee.setSalary(200000);
        System.out.println(employee);
        System.out.println(employee.hashCode());
        EmployeeService.serializeEmployee(employee);

        Employee employee1 = EmployeeService.deSerializeEmployee();
        System.out.println(employee1);
        System.out.println(employee1.hashCode());
        System.out.println(employee.hashCode() == employee1.hashCode());
        System.out.println(employee.equals(employee1));
    }
}
