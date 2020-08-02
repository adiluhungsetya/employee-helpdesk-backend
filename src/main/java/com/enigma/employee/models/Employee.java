package com.enigma.employee.models;

import com.enigma.employee.enums.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "mst_employee")
public class Employee {
    @Id
    @GeneratedValue(generator = "employee_uuid")
    @GenericGenerator(name = "employee_uuid",strategy = "uuid")
    String id;
    String name;
    @JsonFormat(pattern = "dd-MM-yyyy")
    Date birthDate;
    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties("employees")
    Position position;
    String idNumber;
    @Enumerated(EnumType.ORDINAL)
    Gender gender;
    Integer isDelete;

    public Employee() {
        this.isDelete = 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Integer getDelete() {
        return isDelete;
    }

    public void setDelete(Integer delete) {
        isDelete = delete;
    }
}
