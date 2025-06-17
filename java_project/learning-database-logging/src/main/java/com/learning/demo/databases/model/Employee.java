package com.learning.demo.databases.model;

public class Employee {
    private int eid;
    private String e_name;
    private String branch;
    private int percentage;
    private int e_phone;
    private String e_email;

    public Employee(String e_name, String branch, int percentage, int e_phone, String e_email) {
        super();
        this.e_name = e_name;
        this.branch = branch;
        this.percentage = percentage;
        this.e_phone = e_phone;
        this.e_email = e_email;
    }

    public Employee() {
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public int getE_phone() {
        return e_phone;
    }

    public void setE_phone(int e_phone) {
        this.e_phone = e_phone;
    }

    public String getE_email() {
        return e_email;
    }

    public void setE_email(String e_email) {
        this.e_email = e_email;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("ID: " + eid + "\tName: " + e_name + "\tBranch: " + branch + "\tPercentage: " + percentage
                + "\tPhone: " + e_phone + "\tEmail: " + e_email);

        return sb.toString();
    }
}
