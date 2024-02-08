package com.company.transportationmanagement.enums;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;

public enum LiftingCapacity implements EnumClass<Integer> {

    GAZEL(1, "gazel"),
    TRUCK(2, "truck");

    private Integer id;
    private String name;

    LiftingCapacity(Integer id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Nullable
    public static LiftingCapacity fromId(Integer id) {
        for (LiftingCapacity at : LiftingCapacity.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
    @Nullable
    public static LiftingCapacity fromName(String sName) {
        for (LiftingCapacity at : LiftingCapacity.values()) {
            if (at.name.equals(sName)) {
                return at;
            }
        }
        return null;
    }

}
