/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author junki
 */
public class Customer {

    int custID;
    String name;
    String address;
    String phoneNum;
    String deliveryID;

    public Customer(int custID, String name, String address, String phoneNum, String deliveryID) {
        this.custID = custID;
        this.name = name;
        this.address = address;
        this.phoneNum = phoneNum;
        this.deliveryID = deliveryID;
    }

    public Customer() {

    }

    public int getCustID() {
        return custID;
    }

    public void setCustID(int custID) {
        this.custID = custID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getDeliveryID() {
        return deliveryID;
    }

    public void setDeliveryID(String deliveryID) {
        this.deliveryID = deliveryID;
    }

}
