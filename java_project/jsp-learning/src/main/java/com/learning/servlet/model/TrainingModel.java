package com.learning.servlet.model;

import java.sql.Date;

/**
 * Training Model
 *
 * @author Peena
 * @since 3/1/2022
 */
public class TrainingModel {

    private int t_id;
    private String info;
    private Date startdate;
    private Date enddate;
    private String status;
    private String employee_name;
    private int e_id;
    private String issuedByManager;

    public TrainingModel() {
    }

    public TrainingModel(int t_id, String info, Date startdate, Date enddate, String status, String employee_name,
                         String issuedByManager) {
        this.t_id = t_id;
        this.info = info;
        this.startdate = startdate;
        this.enddate = enddate;
        this.status = status;
        this.employee_name = employee_name;
        this.issuedByManager = issuedByManager;
    }

    public TrainingModel(String info, Date startdate, Date enddate, String status, String employee_name,
                         String issuedByManager) {
        this.info = info;
        this.startdate = startdate;
        this.enddate = enddate;
        this.status = status;
        this.employee_name = employee_name;
        this.issuedByManager = issuedByManager;
    }

    public TrainingModel(int t_id, String info, Date startdate, Date enddate, String status, String issuedByManager) {
        this.t_id = t_id;
        this.info = info;
        this.startdate = startdate;
        this.enddate = enddate;
        this.status = status;
        this.issuedByManager = issuedByManager;
    }

    public int getT_id() {
        return t_id;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Date getStartdate() {
        return startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public int getE_id() {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public String getIssuedByManager() {
        return issuedByManager;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public void setIssuedByManager(String issuedByManager) {
        this.issuedByManager = issuedByManager;
    }

}
