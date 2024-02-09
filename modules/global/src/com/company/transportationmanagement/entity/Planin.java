package com.company.transportationmanagement.entity;

import com.company.transportationmanagement.enums.LiftingCapacity;
import com.company.transportationmanagement.enums.Status;
import com.company.transportationmanagement.enums.Condition;
import com.haulmont.cuba.core.entity.StandardEntity;
import org.checkerframework.checker.units.qual.C;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Table(name = "TRANSPORTMANAGEMENT_PLANIN")
@Entity(name = "transportmanagement_Planin")
public class Planin extends StandardEntity {
    private static final long serialVersionUID = 7140312852372513246L;

    @Column(name = "REGISTRATION_NUMBER", length = 10)
    private String registrationNumber;

    @Column(name="ORDER_NUMBER", length = 50)
    private String orderNumber;

//    private  provider;

    @Column(name = "ARRIVAL_DATE")
    private LocalDateTime arrivalDate;

    @Column(name = "NUMBER_TC", length = 20)
    private String numberTC;

    @Column(name="LIFTING_CAPACITY")
    private Integer liftingCapacity;

    @Column(name="FIO", length = 100)
    private String fio;

    @Column(name = "PHONE", length = 20)
    private String phone;

    @Column(name = "STATUS")
    private Integer status;

    @Column(name="CONDITION")
    private Integer condition;

    @Column(name="GATES", length = 5)
    private String gates;

    @Column(name="REGISTRATION_DATE")
    private LocalDateTime registrationDate;

    @Column(name="GATE_SETTING_DATE")
    private LocalDateTime gateSettingDate;

    @Column(name="DEPARTURE_ALLOWED_DATE")
    private LocalDateTime departureAllowedDate;

    @Column(name="DEPARTURE_DATE")
    private LocalDateTime departureDate;

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDateTime arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getNumberTC() {
        return numberTC;
    }

    public void setNumberTC(String numberTC) {
        this.numberTC = numberTC;
    }

    public LiftingCapacity getLiftingCapacity() {
        return liftingCapacity == null ? null : LiftingCapacity.fromId(liftingCapacity);
    }

    public void setLiftingCapacity(LiftingCapacity liftingCapacity) {
        this.liftingCapacity = liftingCapacity == null ? null : liftingCapacity.getId();
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Status getStatus() {
        return status == null ? null : Status.fromId(status);
    }

    public void setStatus(Status status) {
        this.status = status == null ? null : status.getId();
    }

    public Condition getCondition() {
        return condition == null ? null : Condition.fromId(condition);
    }

    public void setCondition(Condition condition) {
        this.condition = condition == null ? null : condition.getId();
    }

    public String getGates() {
        return gates;
    }

    public void setGates(String gates) {
        this.gates = gates;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public LocalDateTime getGateSettingDate() {
        return gateSettingDate;
    }

    public void setGateSettingDate(LocalDateTime gateSettingDate) {
        this.gateSettingDate = gateSettingDate;
    }

    public LocalDateTime getDepartureAllowedDate() {
        return departureAllowedDate;
    }

    public void setDepartureAllowedDate(LocalDateTime departureAllowedDate) {
        this.departureAllowedDate = departureAllowedDate;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDateTime departureDate) {
        this.departureDate = departureDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}