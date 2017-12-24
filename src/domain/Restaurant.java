/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import adt.CustomerADT;

/**
 *
 * @author junki
 */
public class Restaurant {

    int resId;
    String resName;
    CustomerADT<Menu> menuList = new CustomerADT<Menu>();

    public Restaurant() {

    }

    public Restaurant(int resId, String resName, CustomerADT<Menu> menuList) {
        this.resId = resId;
        this.resName = resName;
        this.menuList = menuList;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public CustomerADT<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(CustomerADT<Menu> menuList) {
        this.menuList = menuList;
    }
}
