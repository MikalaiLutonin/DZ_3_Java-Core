// 1.
// – Создать класс ”Сотрудник”с полями: ФИО, должность, телефон, зарплата, возраст;
// – Написать метод выводящую всю доступную информацию об объекте с использованием форматирования строк.
// – Создать массив из 5 сотрудников
// – Создать метод, повышающий зарплату всем сотрудникам старше 45 лет на 5000. Возраст и размер повышения должны быть параметрами метода.
// – Написать тот же метод повышения в качестве статического в классе сотрудника. Метод должен принимать в качестве параметра массив сотрудников.
// – Написать методы (принимающие на вход массив сотрудников), вычисляющие средний возраст и среднюю зарплату сотрудников, вывести результаты работы в консоль.



public class Employee {
    private String name;
    private String position;
    private String phone;
    private double salary;
    private int age;

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
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Иванов Иван Иванович", "Менеджер", "8-800-555-35-35", 50000, 30);
        employees[1] = new Employee("Петров Петр Петрович", "Разработчик", "8-800-555-35-36", 70000, 40);
        employees[2] = new Employee("Сидоров Сидор Сидорович", "Аналитик", "8-800-555-35-37", 60000, 50);
        employees[3] = new Employee("Кузнецова Анна Ивановна", "Дизайнер", "8-800-555-35-38", 40000, 25);
        employees[4] = new Employee("Михайлова Екатерина Александровна", "Тестировщик", "8-800-555-35-39", 45000, 35);

        System.out.println("Информация о сотрудниках:");
        for (Employee employee : employees) {
            employee.printInfo();
            System.out.println();
        }

        System.out.println("Повышение зарплаты сотрудникам старше 45 лет на 5000:");
        Employee.raiseSalary(employees, 45, 5000);
        for (Employee employee : employees) {
            employee.printInfo();
            System.out.println();
        }

        System.out.printf("Средний возраст сотрудников: %.2f\n", Employee.getAverageAge(employees));
        System.out.printf("Средняя зарплата сотрудников: %.2f\n", Employee.getAverageSalary(employees));
    }
}
 
