/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author junki
 */
public class Restaurant {
    
    int resId;
    String resName;
    ArrayList<Menu> menuList = new ArrayList<Menu>();

    public Restaurant(){
        
    }
    
    public Restaurant(int resId, String resName, ArrayList<Menu> menuList){
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

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(ArrayList<Menu> menuList) {
        this.menuList = menuList;
    }    
}
