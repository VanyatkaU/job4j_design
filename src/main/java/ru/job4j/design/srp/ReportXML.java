package ru.job4j.design.srp;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.function.Predicate;

public class ReportXML implements Report {

    private final Store store;
    private JAXBContext context;
    private Marshaller marshaller;

    public ReportXML(Store store) {
        this.store = store;
        try {
            context = JAXBContext.newInstance(Employees.class);
            marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String generate(Predicate<Employee> filter) throws RuntimeException {
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(new Employees(store.findBy(filter)), writer);
            xml = writer.getBuffer().toString();
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
        return xml;
    }

    @XmlRootElement(name = "employees")
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Employees {

        @XmlElement(name = "employee")
        private List<Employee> employees;

        public Employees() {
        }

        public Employees(List<Employee> employees) {
            this.employees = employees;
        }
    }
}
