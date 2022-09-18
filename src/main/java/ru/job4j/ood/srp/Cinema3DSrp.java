package ru.job4j.ood.srp;

import ru.job4j.tdd.Account;
import ru.job4j.tdd.Session;
import ru.job4j.tdd.Ticket;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

public class Cinema3DSrp {

    public List<Session> find(Predicate<Session> filter) {
        return new ArrayList<>();
    }

    public Ticket buy(Account account, int row, int column, Calendar date) {
        return null;
    }

    public void add(Session session) {
        List<Session> list = new ArrayList<>();
    }

    public void print(List<Session> session) {
        session.forEach(System.out::println);
    }
}
/**
 * Класс не реализует абстракцию (интерфейс).
 * Класс реализует несколько функций (находит сеанс, покупка билета, добавление сеанса в список).
 * Класс создает и инициализирует объект.
 */