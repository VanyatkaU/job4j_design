package ru.job4j.serialization.json;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class Main {
    public static void main(String[] args) throws JAXBException, IOException {
        final Patient patient = new Patient(false, 35, "Ivan", new Contact("11-111"),
                "hemoglobin", "red blood cells", "platelets", "leukocytes");

        JAXBContext context = JAXBContext.newInstance(Patient.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml;
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(patient, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }

        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            Patient result = (Patient) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }
    }
}
