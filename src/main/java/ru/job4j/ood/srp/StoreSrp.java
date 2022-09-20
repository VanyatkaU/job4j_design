package ru.job4j.ood.srp;

import ru.job4j.design.srp.Employee;

import java.util.List;
import java.util.function.Predicate;

/**
 * Интерфейс имеет различный функционал,
 * умеет находить и добавлять.
 */

public interface StoreSrp {

    void add(Employee em);

    List<Employee> findBy(Predicate<Employee> filter);
}
