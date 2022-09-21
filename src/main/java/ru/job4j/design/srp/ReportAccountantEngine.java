package ru.job4j.design.srp;

import java.text.SimpleDateFormat;
import java.util.function.Predicate;

public class ReportAccountantEngine implements Report {

    private static final double TAX = 0.13d;
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(
            "dd:MM:yyyy HH:mm");

    private Store store;

    public ReportAccountantEngine(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            Employee emp = new Employee();
            emp.setSalary(employee.getSalary() * (1 - TAX));
            text.append(employee.getName()).append(";")
                    .append(DATE_FORMAT.format(employee.getHired().getTime())).append(";")
                    .append(DATE_FORMAT.format(employee.getFired().getTime())).append(";")
                    .append(emp.setSalary(employee.getSalary())).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}