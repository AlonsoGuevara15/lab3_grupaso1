package com.example.laboratorio3.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
