package ru.job4j.design.srp;

import java.util.function.Predicate;

public record ReportProgrammersEngine(Store store) implements Report {

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("<html><head></head><body>");
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
