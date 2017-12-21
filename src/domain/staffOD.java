/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import adt.StaffADT;
import java.util.Date;

/**
 *
 * @author REPUBLIC
 */
public class staffOD {

    private int staffID;
    private int orderID;
    private int resID;
    private String resName;
    private String customerName;
    private String customerAdd;
    private String custNo;
    private String status;
    private String date;
    private double distance;

    public staffOD() {

    }

    public staffOD(int staffID, int orderID, int resID, String resName, String customerName, String customerAdd, String custNo, String status, String date, double distance) {
        this.staffID = staffID;
        this.orderID = orderID;
        this.resID = resID;
        this.resName = resName;
        this.customerName = customerName;
        this.customerAdd = customerAdd;
        this.custNo = custNo;
        this.status = status;
        this.date = date;
        this.distance = distance;
    }

    public staffOD(int resID, String resName) {
        this.resID = resID;
        this.resName = resName;
    }

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getResID() {
        return resID;
    }

    public void setResID(int resID) {
        this.resID = resID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAdd() {
        return customerAdd;
    }

    public void setCustomerAdd(String customerAdd) {
        this.customerAdd = customerAdd;
    }

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
