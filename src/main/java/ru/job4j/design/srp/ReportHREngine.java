package ru.job4j.design.srp;

import java.util.List;
import java.util.function.Predicate;

public class ReportHREngine implements Report {

    private Store store;

    public ReportHREngine(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        List<Employee> employees = store.findBy(filter);
        employees.sort((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()));
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : employees) {
            text.append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}