package ru.job4j.design.srp;

import java.util.function.Predicate;

public class ReportProgrammersEngine implements Report {

    private Store store;

    public ReportProgrammersEngine(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("<html><head></head><body>")
                .append("<div>Name</div><div>Hired</div><div>Fired</div><div>Salary</div>");
        for (Employee employee : store.findBy(filter)) {
            text.append("<div>").append(employee.getName()).append("</div>")
                    .append("<div>").append(employee.getHired()).append("</div>")
                    .append("<div>").append(employee.getFired()).append("</div>")
                    .append("<div>").append(employee.getSalary()).append("</div>");
        }
        text.append("</body><html>");
        return text.toString();
    }
}
