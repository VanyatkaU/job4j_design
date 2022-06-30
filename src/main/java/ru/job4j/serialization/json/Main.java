package ru.job4j.serialization.json;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        JSONObject jsonContact = new JSONObject("{\"phone\":\"+7(906)111-111-11-11\"}");

        List<String> list = new ArrayList<>();
        list.add("hemoglobin");
        list.add("red blood cells");
        list.add("platelets");
        list.add("leukocytes");
        JSONArray jsonBloodTests = new JSONArray(list);

        final Patient patient = new Patient(false, 35, "Ivan", new Contact("11-111"),
                "hemoglobin", "red blood cells", "platelets", "leukocytes");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("riskGroup", patient.isRiskGroup());
        jsonObject.put("age", patient.getAge());
        jsonObject.put("name", patient.getName());
        jsonObject.put("contact", jsonContact);
        jsonObject.put("bloodTests", jsonBloodTests);

        System.out.println(jsonObject);

        System.out.println(new JSONObject(patient));
    }
}
