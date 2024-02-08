package com.company.transportationmanagement.enums;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;

public enum Condition implements EnumClass<Integer> {
    AWAITS(5, "awaits"),
    AT_THE_GATE(20, "atTheGate"),
    DEPARTURE_ALLOWED(50, "departureAllowed");

    private Integer id;
    private String name;

    Condition(Integer id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Nullable
    public static Condition fromId(Integer id) {
        for (Condition at : Condition.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
    @Nullable
    public static Condition fromName(String name) {
        for (Condition at : Condition.values()) {
            if (at.name.equals(name)) {
                return at;
            }
        }
        return null;
    }
}
