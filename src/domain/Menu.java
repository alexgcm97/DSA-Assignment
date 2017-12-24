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
public class Menu {

    int resId;
    int foodId;
    String food;
    double price;
    String foodDesc;
    String stock;

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getFoodDesc() {
        return foodDesc;
    }

    public void setFoodDesc(String foodDesc) {
        this.foodDesc = foodDesc;
    }

    public Menu() {

    }

    public Menu(int resId, int foodId, String food, double price) {
        this.resId = resId;
        this.foodId = foodId;
        this.food = food;
        this.price = price;
    }

    public Menu(int foodId, String food, String foodDesc, double price, String stock) {
        this.foodId = foodId;
        this.food = food;
        this.foodDesc = foodDesc;
        this.price = price;
        this.stock = stock;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getFood() {
        return food;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }
}
