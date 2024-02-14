package com.company.transportationmanagement.audit;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Table(name = "TRANSPORTMANAGEMENT_AUDIT_EVENT")
@Entity(name = "transportmanagement_AuditEvent")
public class AuditEvent extends StandardEntity {
    private static final long serialVersionUID = -3118843325173729033L;


    @Column(name = "REGISTRATION_NUMBER", length = 10)
    private String registrationNumber;

    @Column(name = "NUMBER_TC", length = 20)
    private String numberTC;

    @Column(name = "STATUS")
    private Integer status;

    @Column(name="CONDITION")
    private Integer condition;

    @Column(name="CREATE_DATE")
    private LocalDateTime createDate;

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getNumberTC() {
        return numberTC;
    }

    public void setNumberTC(String numberTC) {
        this.numberTC = numberTC;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCondition() {
        return condition;
    }

    public void setCondition(Integer condition) {
        this.condition = condition;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }
}