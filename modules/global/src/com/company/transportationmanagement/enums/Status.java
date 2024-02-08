package com.company.transportationmanagement.enums;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;

public enum Status implements EnumClass<Integer> {

    PLANNED(10, "planned"),
    REGISTERED(20, "registered"),
    ON_THE_FORTS(30, "onTheForts"),
    DEPARTURE_ALLOWED(50, "departureAllowed");

    private Integer id;
    private String name;

    Status(Integer id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Nullable
    public static Status fromId(Integer id) {
        for (Status at : Status.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
    @Nullable
    public static Status fromName(String sName) {
        for (Status at : Status.values()) {
            if (at.name.equals(sName)) {
                return at;
            }
        }
        return null;
    }
}
