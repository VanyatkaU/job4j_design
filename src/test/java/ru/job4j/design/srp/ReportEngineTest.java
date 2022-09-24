package ru.job4j.design.srp;

import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.job4j.design.srp.ReportEngine.DATE_FORMAT;

class ReportEngineTest {

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(DATE_FORMAT.format(worker.getHired().getTime())).append(";")
                .append(DATE_FORMAT.format(worker.getFired().getTime())).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());
    }

    @Test
    public void whenAccountantGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
                Report accountantEngine = new ReportAccountantEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(DATE_FORMAT.format(worker.getHired().getTime())).append(";")
                .append(DATE_FORMAT.format(worker.getFired().getTime())).append(";")
                .append(worker.getSalary() * ReportAccountantEngine.TAX).append(";")
                .append(System.lineSeparator());
        assertThat(accountantEngine.generate(em -> true)).isEqualTo(expect.toString());
    }

    @Test
    public void whenProgrammersGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report programmersEngine = new ReportProgrammersEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("<html><head></head><body>")
                .append("<div>Name</div><div>Hired</div><div>Fired</div><div>Salary</div>")
                .append("<div>").append(worker.getName()).append("</div>")
                .append("<div>").append(worker.getHired()).append("</div>")
                .append("<div>").append(worker.getFired()).append("</div>")
                .append("<div>").append(worker.getSalary()).append("</div>")
                .append("</body><html>");
        assertThat(programmersEngine.generate(em -> true)).isEqualTo(expect.toString());
    }

    @Test
    public void whenHRGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Stepan", now, now, 110);
        store.add(worker1);
        store.add(worker2);
        Report hrEngine = new ReportHREngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker2.getName()).append(";")
                .append(worker2.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker1.getName()).append(";")
                .append(worker1.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(hrEngine.generate(em -> true)).isEqualTo(expect.toString());
    }

    /**@Test
    public void whenXMLGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report xmlEngine = new ReportXML(store);
        StringBuilder expect = new StringBuilder()
                .append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n")
                .append("<employees>\n")
                .append("    <employee>\n")
                .append("        <hired>").append(DATE_FORMAT.format(worker.getHired()
                        .getTime())).append("</hired>\n")
                .append("        <fired>").append(DATE_FORMAT.format(worker.getFired()
                        .getTime())).append("</fired>\n")
                .append("        <name>").append(worker.getName()).append("</name>\n")
                .append("        <salary>").append(worker.getSalary()).append("</salary>\n")
                .append("    </employee>\n")
                .append("</employees>\n");
        assertThat(xmlEngine.generate(em -> true)).isEqualTo(expect.toString());
    }*/

    @Test
    public void whenJSONGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report jsonEngine = new ReportJSON(store);
        StringBuilder expect = new StringBuilder()
                .append("[{").append("\"name\":\"Ivan\",")
                .append("\"hired\":").append("{")
                .append("\"year\":").append(worker.getHired().get(Calendar.YEAR)).append(",")
                .append("\"month\":").append(worker.getHired().get(Calendar.MONTH)).append(",")
                .append("\"dayOfMonth\":").append(worker.getHired().get(Calendar.DAY_OF_MONTH))
                .append(",")
                .append("\"hourOfDay\":").append(worker.getHired().get(Calendar.HOUR_OF_DAY))
                .append(",")
                .append("\"minute\":").append(worker.getHired().get(Calendar.MINUTE)).append(",")
                .append("\"second\":").append(worker.getHired().get(Calendar.SECOND)).append("},")
                .append("\"fired\":").append("{")
                .append("\"year\":").append(worker.getHired().get(Calendar.YEAR)).append(",")
                .append("\"month\":").append(worker.getHired().get(Calendar.MONTH)).append(",")
                .append("\"dayOfMonth\":").append(worker.getHired().get(Calendar.DAY_OF_MONTH))
                .append(",")
                .append("\"hourOfDay\":").append(worker.getHired().get(Calendar.HOUR_OF_DAY))
                .append(",")
                .append("\"minute\":").append(worker.getHired().get(Calendar.MINUTE)).append(",")
                .append("\"second\":").append(worker.getHired().get(Calendar.SECOND)).append("},")
                .append("\"salary\":").append(100.0).append("}]");
        assertThat(jsonEngine.generate(em -> true)).isEqualTo(expect.toString());
    }
}