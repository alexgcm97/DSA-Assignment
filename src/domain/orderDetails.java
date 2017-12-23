/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import adt.DeliveryADT;
import java.util.ArrayList;

/**
 *
 * @author REPUBLIC
 */
public class orderDetails {

    private int staffID;
    private int orderID;
    private int resID;
    private String resName;
    private String customerName;
    private String customerAdd;
    private String custNo;
    private DeliveryADT food;
    private String status;

    public orderDetails() {

    }
    public orderDetails(int staffID, int orderID, int resID, String resName, String customerName, String customerAdd, String custNo,DeliveryADT food) {

        this.staffID = staffID;
        this.orderID = orderID;
        this.resID = resID;
        this.resName = resName;
        this.customerName = customerName;
        this.customerAdd = customerAdd;
        this.custNo = custNo;
        this.food = food;
        this.status = "Pending";
    }

    public orderDetails(int resID, String resName) {
        this.resID = resID;
        this.resName = resName;
    }

    public DeliveryADT getFood() {
        return food;
    }

    public void setFood(DeliveryADT food) {
        this.food = food;
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
}
