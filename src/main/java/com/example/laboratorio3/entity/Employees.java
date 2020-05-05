package com.example.laboratorio3.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

//COMPLETAR
@Entity
@Table(name = "employees")
public class Employees {

    //COMPLETAR
    @Id
    @Column(name = "employee_id")
    private String employeeid;
    private String first_name;
    @Column(nullable = false)
    private String last_name;
    @Column(nullable = false)
    private String email;
    private String phone_number;

    @Column(nullable = false)
    private LocalDate hire_date;

    @ManyToOne
    @JoinColumn(name = "job_id")
    @Column(nullable = false)
    private Job job;
    private BigDecimal salary;
    private BigDecimal commission_pct;
    private String manager_id;
    @ManyToOne
    @JoinColumn(name = "department_id")
    @Column(nullable = false)
    private Departments department;
    private int enabled;



    public String getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public LocalDate getHire_date() {
        return hire_date;
    }

    public void setHire_date(LocalDate hire_date) {
        this.hire_date = hire_date;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job_id) {
        this.job = job_id;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public BigDecimal getCommission_pct() {
        return commission_pct;
    }

    public void setCommission_pct(BigDecimal commission_pct) {
        this.commission_pct = commission_pct;
    }

    public String getManager_id() {
        return manager_id;
    }

    public void setManager_id(String manager_id) {
        this.manager_id = manager_id;
    }

    public Departments getDepartment() {
        return department;
    }

    public void setDepartment(Departments department_id) {
        this.department = department_id;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }
}
