package ru.job4j.serialization.json;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "patient")
@XmlAccessorType(XmlAccessType.FIELD)
public class Patient {

    @XmlAttribute
    private boolean riskGroup;

    @XmlAttribute
    private int age;

    @XmlAttribute
    private String name;
    private Contact contact;

    @XmlElementWrapper(name = "bloodTest")
    @XmlElement(name = "bloodTest")
    private String[] bloodTests;

    public Patient() {

    }

    public Patient(boolean riskGroup, int age, String name, Contact contact, String... bloodTests) {
        this.riskGroup = riskGroup;
        this.age = age;
        this.name = name;
        this.contact = contact;
        this.bloodTests = bloodTests;
    }

    public boolean isRiskGroup() {
        return riskGroup;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Contact getContact() {
        return contact;
    }

    public String[] getBloodTests() {
        return bloodTests;
    }

    @Override
    public String toString() {
        return "Patient{"
               + "riskGroup=" + riskGroup
               + ", age=" + age
               + ", name='" + name + '\''
               + ", contact=" + contact
               + ", bloodTests=" + Arrays.toString(bloodTests)
               + '}';
    }

    public static void main(String[] args) throws JAXBException {

        final Patient patient = new Patient(false, 35, "Ivan", new Contact("11-111"),
                "hemoglobin", "red blood cells", "platelets", "leukocytes");

        JAXBContext context = JAXBContext.newInstance(Patient.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(patient, writer);
            String result = writer.getBuffer().toString();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}