// 2. Опишите класс руководителя, наследник от сотрудника. Перенесите статический метод повышения зарплаты в класс руководителя, 
// модифицируйте метод таким образом, чтобы он мог поднять заработную плату всем, кроме руководителей. 
// В основной программе создайте руководителя и поместите его в общий массив сотрудников. 
// Повысьте зарплату всем сотрудникам и проследите, чтобы зарплата руководителя не повысилась.

public class Employee {
    private String name;
    private String position;
    private String phone;
    protected double salary;
    protected int age;

    public Employee(String name, String position, String phone, double salary, int age) {
        this.name = name;
        this.position = position;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void printInfo() {
        System.out.printf("ФИО: %s\nДолжность: %s\nТелефон: %s\nЗарплата: %.2f\nВозраст: %d\n",
                name, position, phone, salary, age);
    }

    public static void raiseSalary(Employee[] employees, int age, double amount) {
        for (Employee employee : employees) {
            if (employee.age > age) {
                employee.salary += amount;
            }
        }
    }

    public static double getAverageAge(Employee[] employees) {
        int sum = 0;
        for (Employee employee : employees) {
            sum += employee.age;
        }
        return (double) sum / employees.length;
    }

    public static double getAverageSalary(Employee[] employees) {
        double sum = 0;
        for (Employee employee : employees) {
            sum += employee.salary;
        }
        return sum / employees.length;
    }

    public static void main(String[] args) {
        Employee[] employees = new Employee[6];
        employees[0] = new Employee("Иванов Иван Иванович", "Менеджер", "8-800-555-35-35", 50000, 30);
        employees[1] = new Employee("Петров Петр Петрович", "Разработчик", "8-800-555-35-36", 70000, 40);
        employees[2] = new Employee("Сидоров Сидор Сидорович", "Аналитик", "8-800-555-35-37", 60000, 50);
        employees[3] = new Employee("Кузнецова Анна Ивановна", "Дизайнер", "8-800-555-35-38", 40000, 25);
        employees[4] = new Employee("Михайлова Екатерина Александровна", "Тестировщик", "8-800-555-35-39", 45000, 35);
        employees[5] = new Manager("Смирнов Василий Иванович", "Руководитель", "8-800-555-35-40", 100000, 45);

        System.out.println("Информация о сотрудниках:");
        for (Employee employee : employees) {
            employee.printInfo();
            System.out.println();
        }

        System.out.println("Повышение зарплаты сотрудникам старше 45 лет на 5000:");
        Manager.raiseSalary(employees, 45, 5000);
        for (Employee employee : employees) {
            employee.printInfo();
            System.out.println();
        }

        System.out.printf("Средний возраст сотрудников: %.2f\n", Employee.getAverageAge(employees));
        System.out.printf("Средняя зарплата сотрудников: %.2f\n", Employee.getAverageSalary(employees));
    }
}
 
