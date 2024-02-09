package com.company.transportationmanagement.entity;

import com.haulmont.cuba.core.entity.StandardEntity;
import org.checkerframework.common.aliasing.qual.Unique;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Table(name = "TRANSPORTMANAGEMENT_CLIENT")
@Entity(name = "transportmanagement_Client")
public class Client extends StandardEntity {
    private static final long serialVersionUID = -3634413783893890613L;

    @Column(name ="CODE_CLIENT", unique = true)
    private Integer codeClient;

    @Column(name = "NAME", length = 200)
    private String name;

    @Column(name = "ADDRESS", length = 200)
    private String address;

    @Column(name="PERSON", length = 100)
    private String person;

    public Integer getCodeClient() {
        return codeClient;
    }

    public void setCodeClient(Integer codeClient) {
        this.codeClient = codeClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }
}