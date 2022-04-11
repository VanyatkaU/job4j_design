package ru.job4j.question;

import java.util.*;
import java.util.stream.Collectors;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        int deleted = 0;
        int changed = 0;
        Map<Integer, String> userMap = current.stream()
                .collect(Collectors.toMap(User::getId, User::getName));
        for (User user : previous) {
            if (userMap.get(user.getId()) == null) {
                deleted++;
            }
            boolean rsl = userMap.get(user.getId()) != null
                    && !Objects.equals(userMap.get(user.getId()), user.getName());
            if (rsl) {
                userMap.remove(user.getId());
                changed++;
            }
        }
        int added = current.size() - previous.size() + deleted;
        return new Info(added, changed, deleted);
    }
}
