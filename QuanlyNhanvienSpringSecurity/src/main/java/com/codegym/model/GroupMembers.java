package com.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "groupMembers")
public class GroupMembers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String groupName;

    @OneToMany(targetEntity = Employee.class)
    private List<Employee> employees;

    public GroupMembers() {
    }

    public GroupMembers(String groupName, List<Employee> employees) {
        this.groupName = groupName;
        this.employees = employees;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
