package com.ddlab.rnd.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name="Emp") @Table(name = "emp")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Emp {

    @Id @GeneratedValue
    private long id;

    private String name;

    private String firstName;
    private String lastName;
    private String designation;
    private String location;
    private int salary;
    private String gender;
    private String maritalStatus;
    private String panNo;

}
