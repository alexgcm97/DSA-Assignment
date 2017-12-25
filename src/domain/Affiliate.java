/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Julian
 */
public class Affiliate implements Comparable<Affiliate> {

    private int licenseNumber;
    private String companyName;
    private String companyAddress;
    private String companyType;
    private String joinDate;
    private String ownerName;
    private String ownerGender;
    private String ownerICNumb;
    private String ownerAddress;
    private String ownerPhoneNumber;
    private String userName;
    private String password;

    public Affiliate(int licenseNumber, String companyName, String companyAddress, String companyType, String joinDate, String ownerName, String ownerGender, String ownerICNumb, String ownerAddress, String ownerPhoneNumber, String userName, String password) {
        this.licenseNumber = licenseNumber;         //1001
        this.companyName = companyName;             //Moi Restaurant
        this.companyAddress = companyAddress;       //1, Jalan Duta 2, 55100 KL
        this.companyType = companyType;             //Restaurant
        this.joinDate = joinDate;                   //25-DEC-2016
        this.ownerName = ownerName;                 //MoMoi
        this.ownerGender = ownerGender;             //M
        this.ownerICNumb = ownerICNumb;             //970503-35-1234
        this.ownerAddress = ownerAddress;           //2, Jalan Bunga 3, 55100 KL
        this.ownerPhoneNumber = ownerPhoneNumber;   //012-3322132
        this.userName = userName;                   //Moi
        this.password = password;                   //1234
    }

    public Affiliate() {

    }

    public int getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(int licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return companyAddress;
    }

    public void setAddress(String address) {
        this.companyAddress = address;
    }

    public String getType() {
        return companyType;
    }

    public void setType(String type) {
        this.companyType = type;
    }

    public String getCompanyaddress() {
        return companyAddress;
    }

    public void setCompanyaddress(String companyaddress) {
        this.companyAddress = companyaddress;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerGender() {
        return ownerGender;
    }

    public void setOwnerGender(String ownerGender) {
        this.ownerGender = ownerGender;
    }

    public String getOwnerICNumb() {
        return ownerICNumb;
    }

    public void setOwnerICNumb(String ownerICNumb) {
        this.ownerICNumb = ownerICNumb;
    }

    public String getOwnerAddress() {
        return ownerAddress;
    }

    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

    public String getOwnerPhoneNumber() {
        return ownerPhoneNumber;
    }

    public void setOwnerPhoneNumber(String ownerPhoneNumber) {
        this.ownerPhoneNumber = ownerPhoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int compareTo(Affiliate o) {
        return this.getCompanyName().compareTo(o.getCompanyName());
    }

}
