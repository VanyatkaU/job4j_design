package ru.job4j.design.srp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

public class Employees {

    public Employees(List<ru.job4j.design.srp.Employee> by) {

    }

    @XmlRootElement(name = "report")
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Employee {

        private List<Employee> employees;

        public Employee() {
        }

        public Employee(List<Employee> employees) {
            this.employees = employees;
        }

        public List<Employee> getEmployees() {
            return employees;
        }

        public void setEmployees(List<Employee> employees) {
            this.employees = employees;
        }
    }
}
