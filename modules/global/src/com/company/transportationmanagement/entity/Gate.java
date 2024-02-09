package com.company.transportationmanagement.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalTime;

@Table(name = "TRANSPORTMANAGEMENT_GATE")
@Entity(name = "transportmanagement_Gate")
public class Gate extends StandardEntity {
    private static final long serialVersionUID = -786591186068973090L;

    @Column(name = "NUMBER_GATE", length = 5, unique = true)
    private String numberGate;

    @Column(name = "TIME_FROM")
    private LocalTime timeFrom;

    @Column(name = "TIME_BY")
    private LocalTime timeBy;

    public String getNumberGate() {
        return numberGate;
    }

    public void setNumberGate(String numberGate) {
        this.numberGate = numberGate;
    }

    public LocalTime getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(LocalTime timeFrom) {
        this.timeFrom = timeFrom;
    }

    public LocalTime getTimeBy() {
        return timeBy;
    }

    public void setTimeBy(LocalTime timeBy) {
        this.timeBy = timeBy;
    }
}