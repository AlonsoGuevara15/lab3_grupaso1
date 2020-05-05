package com.example.laboratorio3.entity;

import javax.persistence.*;

@Entity
@Table(name="job_history")
public class History {

    @Id
    @Column(name="job_history_id",nullable = false)
    private int jobhistoryid;
    @Column(name="start_date",nullable = false)
    private String startdate;
    @ManyToOne
    @JoinColumn(name="employee_id",nullable = false)
    private Employees employee;

    public int getJobhistoryid() {
        return jobhistoryid;
    }

    public void setJobhistoryid(int jobhistoryid) {
        this.jobhistoryid = jobhistoryid;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public Employees getEmployee() {
        return employee;
    }

    public void setEmployee(Employees employee) {
        this.employee = employee;
    }
}
