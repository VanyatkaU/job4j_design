package ru.job4j.serialization.json;

import javax.xml.bind.annotation.*;
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

    @XmlElementWrapper(name = "bloodTests")
    @XmlElement(name = "bloodTest")
    private String[] bloodTests;

    public Patient() { }

    public Patient(boolean riskGroup, int age, String name, Contact contact, String[] bloodTests) {
        this.riskGroup = riskGroup;
        this.age = age;
        this.name = name;
        this.contact = contact;
        this.bloodTests = bloodTests;
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

}
