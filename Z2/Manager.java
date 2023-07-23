public class Manager extends Employee {
    public Manager(String name, String position, String phone, double salary, int age) {
        super(name, position, phone, salary, age);
    }

    public static void raiseSalary(Employee[] employees, int age, double amount) {
        for (Employee employee : employees) {
            if (!(employee instanceof Manager) && employee.age > age) {
                employee.salary += amount;
            }
        }
    }
}



