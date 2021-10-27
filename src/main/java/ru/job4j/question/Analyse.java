package ru.job4j.question;

import java.util.Set;
import java.util.stream.Collectors;

public class Analyse {
    public static Info diff(Set<User> previous, Set<User> current) {
        Info info = new Info();
        Set<Integer> idSet = current.stream().map(User::getId).collect(Collectors.toSet());
        for (User left : previous) {
            if (idSet.contains(left.getId())) {
                if (!current.contains(left)) {
                    info.setChanged(info.getChanged() + 1);
                }
            } else {
                info.setDeleted(info.getDeleted() + 1);
            }
        }
        info.setAdded(current.size() - (previous.size() - info.getDeleted()));
        return info;
    }
}