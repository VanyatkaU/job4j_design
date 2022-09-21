package ru.job4j.ood.srp;

import java.util.List;

/**
 * Нарушение SRP - методы добавления и поиска.
 *     Класс CitizenSrp описывает модель данных, поэтому
 *     хранилище можно описать отдельным интерфейсом,
 *     а List<User> и методы добавления и поиска
 *     необходимо перенести в отдельный класс.
 */

public class CitizenSrp {

    private String passport;
    private String username;
    private List<CitizenSrp> list;

    public CitizenSrp(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassport() {
        return passport;
    }

    public String getUsername() {
        return username;
    }

    public void add(CitizenSrp user) {
        if (!findPassport()) {
            list.add(user);
        }
    }

    public boolean findPassport() {
        return true;
    }
}

