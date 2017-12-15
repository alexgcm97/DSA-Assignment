/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author REPUBLIC
 */
public class foodOrdered {
    private int orderID;
    private int foodID;
    private String food;
    private int quantity;
    private double price;

    public foodOrdered(){
        
    }
        
    public foodOrdered(int orderID, int foodID, String food, int quantity, double price) {
        this.orderID = orderID;
        this.foodID = foodID;
        this.food = food;
        this.quantity = quantity;
        this.price = price;
    }
    
    public foodOrdered(int orderID, String food, int quantity, double price) {
        this.orderID = orderID;
        this.food = food;
        this.quantity = quantity;
        this.price = price;
    }
   
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getFoodID() {
        return foodID;
    }

    public void setFoodID(int foodID) {
        this.foodID = foodID;
    }
    
    public void setFood(String food) {
        this.food = food;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getOrderID() {
        return orderID;
    }

    public String getFood() {
        return food;
    }

    public int getQuantity() {
        return quantity;
    }
    
    public void setPrie(double price){
        this.price = price;
    }
    
    public double getPrice(){
        return price;
    }
   
    
}
