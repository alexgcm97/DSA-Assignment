/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import adt.StaffADT;

/**
 *
 * @author Alex
 */
public class Staff {

    private int ID;
    private String name;
    private String phoneNo;
    private String address;
    private String status;
    private StaffADT<staffOD> deliveryList;
    private String checkIn;
    private String checkOut;
    private String availability;
    private double totalDistance;
    private int noOfDoneDelivery;

    public Staff() {

    }

    public Staff(int ID, String name, String availability) {
        this.ID = ID;
        this.name = name;
        this.availability = availability;
    }

    public Staff(int ID, String name, String phoneNo, String address, String status) {
        this.ID = ID;
        this.name = name;
        this.phoneNo = phoneNo;
        this.address = address;
        this.status = status;
        this.deliveryList = new StaffADT<staffOD>();
    }

    public String getAvailability() {
        return this.availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void addDelivery(staffOD od) {
        deliveryList.add(od);
    }

    public void setDeliveryList(StaffADT<staffOD> deliveryList) {
        this.deliveryList = deliveryList;
    }

    public StaffADT<staffOD> getDeliveryList() {
        return deliveryList;
    }

    public double getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(double totalDistance) {
        this.totalDistance = totalDistance;
    }

    public int getNoOfDoneDelivery() {
        return noOfDoneDelivery;
    }

    public void setNoOfDoneDelivery(int noOfDoneDelivery) {
        this.noOfDoneDelivery = noOfDoneDelivery;
    }

}
