package com.school.model.example;

import java.util.HashSet;
import java.util.Set;

public class Promotion {
    private Set<String> groups = new HashSet<>();

    public void addGroup(String group) {
        groups.add(group);
    }

    public Set<String> getGroups() {
        return groups;
    }
}