package com.example.laboratorio3.entity;

import javax.persistence.*;

@Entity
@Table(name="departments")
public class Departments {

    @Id
    @Column(name = "department_id")
    private int departmentid;
    @Column(nullable = false, name = "department_name")
    private String departmentname;
    @Column(name = "manager_id")
    private String managerid;
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Locations location;


    public Locations getLocation() {
        return location;
    }

    public void setLocation(Locations location) {
        this.location = location;
    }

    public int getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(int departmentid) {
        this.departmentid = departmentid;
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }

    public String getManagerid() {
        return managerid;
    }

    public void setManagerid(String managerid) {
        this.managerid = managerid;
    }
}
