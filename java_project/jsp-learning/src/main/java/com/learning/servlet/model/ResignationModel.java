package com.learning.servlet.model;

import java.sql.Date;

/**
 * Resignation Model
 *
 * @author Peena
 * @since 3/1/2022
 */
public class ResignationModel {

    private int r_id;
    private String reasons;
    private Date enddate;
    private String employee_name;
    private String issuedByManager;

    public ResignationModel() {
    }

    public ResignationModel(int r_id, String reasons, Date enddate, String employee_name, String issuedByManager) {
        this.r_id = r_id;
        this.reasons = reasons;
        this.enddate = enddate;
        this.employee_name = employee_name;
        this.issuedByManager = issuedByManager;
    }

    public ResignationModel(String reasons, Date enddate, String employee_name, String issuedByManager) {
        this.reasons = reasons;
        this.enddate = enddate;
        this.employee_name = employee_name;
        this.issuedByManager = issuedByManager;
    }

    public int getR_id() {
        return r_id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }

    public String getReasons() {
        return reasons;
    }

    public void setReasons(String reasons) {
        this.reasons = reasons;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getEmployee_name() {
        return employee_name;
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
