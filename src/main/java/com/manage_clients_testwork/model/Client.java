package com.manage_clients_testwork.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "clients")
@ApiModel(description = "Client's details")
public class Client {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "The unique id of client")
    private long id=0;
    @Column(name = "email")
    @ApiModelProperty(notes = "The email of client")
    private String email;
    @Column(name = "last_name")
    @ApiModelProperty(notes = "The lastname of client")
    private String lastName;
    @Column(name = "first_name")
    @ApiModelProperty(notes = "The firstname of client")
    private String firstName;
    @Column(name = "middle_name")
    @ApiModelProperty(notes = "The middlename of client")
    private String middleName;
    @Column(name = "phone")
    @ApiModelProperty(notes = "The phone of client")
    private String phone;

    public Client() {
    }

    public Client(String email, String lastName, String firstName, String middleName, String phone) {
        this.email = email;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.phone = phone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", FIO='" + lastName +
                " " + firstName +
                " " + middleName + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
