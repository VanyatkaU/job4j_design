package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        short id = 12355;
        byte age = 37;
        char gender = 'M';
        float growth = 1.73f;
        long tel = 84954544456L;
        int weight = 80;
        boolean parent = true;
        double plt = 2.33e+11;

        LOG.debug("User info id : {}, age : {}, gender : {}, "
                  + "growth : {}, tel : {}, weigh : {}, "
                  + "parent : {}, plt : {}", id, age, gender,
                growth, tel, weight, true, plt);
    }
}