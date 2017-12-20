package client;


import domain.Menu;
import domain.Restaurant;
import domain.foodOrdered;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author junkit
 */
public class MakeOrder {
    private static ArrayList<Restaurant> resList = new ArrayList();
    private static ArrayList<Menu> menuList = new ArrayList();
    private static ArrayList<Menu> menuList2 = new ArrayList();
    private static int orderID = 1001;
    private static ArrayList<foodOrdered> foList = new ArrayList();
    private static int ans;
    private static int resId = 0;
    private static final Scanner scan = new Scanner(System.in);
    private static int j;
    private static double totalAmount = 0;
    private static int count = 0;

    public static void initializeMenu() {
        menuList.add(new Menu(9001, 1, "Nasi Lemak    ", 5.00));
        menuList.add(new Menu(9001, 2, "Burger        ", 5.00));
        menuList.add(new Menu(9001, 3, "Roti Telur    ", 5.00));
        menuList.add(new Menu(9001, 4, "Maggie Goreng ", 5.00));
        menuList.add(new Menu(9001, 5, "Kopi Ice      ", 2.00));
        menuList.add(new Menu(9001, 6, "Teh O Ice     ", 2.00));
        resList.add(new Restaurant(9001, "Alibaba Restaurant", menuList));

        menuList2.add(new Menu(9002, 1, "Chicken Chop ", 10.00));
        menuList2.add(new Menu(9002, 2, "Carbonara    ", 8.00));
        menuList2.add(new Menu(9002, 3, "Balognese    ", 8.00));
        menuList2.add(new Menu(9002, 4, "Mushroom Soup", 4.00));
        menuList2.add(new Menu(9002, 5, "Orange Juice ", 3.00));
        menuList2.add(new Menu(9002, 6, "Apple Juice  ", 3.00));
        resList.add(new Restaurant(9002, "Garden Cafe ", menuList2));
    }

    public static void MakeOrder() {

        initializeMenu();
        System.out.println("=============================");
        System.out.println("Please select the restaurant");
        System.out.println("=============================");
        for (int i = 0; i < resList.size(); i++) {
            System.out.println(resList.get(i).getResId() + ". " + resList.get(i).getResName());
        }
        System.out.print("Enter restaurant no. :");
        ans = scan.nextInt();
        scan.nextLine();
        resId = ans;
        viewMenu();
    }

    public static void viewMenu() {

        System.out.println("\n---------------MENU--------------");
        System.out.println("----------------------------------");
        System.out.print("|");
        System.out.println(" No. | Food Name      |  Price  |");
        System.out.println("----------------------------------");
        for (int i = 0; i < resList.size(); i++) {
            if (resId == resList.get(i).getResId()) {
                resId = resList.get(i).getResId();
                for (Menu m : resList.get(i).getMenuList()) {
                    System.out.println("|  " + m.getFoodId() + ". | " + m.getFood() + " |  " + "RM " + m.getPrice() + " |");
                    System.out.println("----------------------------------");
                }
            }
        }
        System.out.print("Please select food: ");
        ans = scan.nextInt();
        foodOrdered fo = new foodOrdered();
        fo.setOrderID(orderID);

        for (int i = 0; i < resList.size(); i++) {
            if (resId == resList.get(i).getResId()) {
                for (Menu m : resList.get(i).getMenuList()) {
                    if (ans == m.getFoodId()) {
                        fo.setFoodID(m.getFoodId());
                        fo.setFood(m.getFood());
                        fo.setPrie(m.getPrice());
                        if (foList.contains(fo)) {
                            fo.setQuantity(fo.getQuantity() + 1);
                        } else {
                            fo.setQuantity(1);
                        }
                    }
                }
            }
        }
        foList.add(fo);
        System.out.println("Any more order? (Y/N)");
        String next = scan.nextLine();
        next = scan.nextLine();
        System.out.println("");

        switch (next) {
            case "Y":
                viewMenu();
                break;

            case "N":
                summary();
                break;

        }

    }

    public static void summary() {

        totalAmount = 0.0;
        System.out.println("---------------------------------------------------");
        System.out.println("|               Your Order Details                |");
        System.out.println("---------------------------------------------------");
        System.out.println("| Food ID |     Food Name    | Quantity |  Price  |");
        System.out.println("---------------------------------------------------");

        for (j = 0; j < foList.size(); j++) {
            System.out.println("|    " + foList.get(j).getFoodID() + "         " + foList.get(j).getFood() + "     " + foList.get(j).getQuantity() + "        RM " +( foList.get(j).getPrice()* foList.get(j).getQuantity())+" |");
            totalAmount += (foList.get(j).getPrice()) * (foList.get(j).getQuantity());
        }

        System.out.println("---------------------------------------------------");
        System.out.printf("|                                  Total:  RM %.1f |\n", totalAmount);
        System.out.println("---------------------------------------------------");

        System.out.println();
          
        changeQuantity();

    }
    

    public static void confirmOrder() {
        System.out.println("Please Confirm your order (Y/N)");
        String co = scan.nextLine();
        co = scan.nextLine();

        switch (co) {

            case "Y":
                System.out.println("Thank you for ordering from us! Please come again.");
        
                 totalAmount = 0.0;
        System.out.println("---------------------------------------------------");
        System.out.println("|               Order Confirmed                   |");
        System.out.println("---------------------------------------------------");
        System.out.println("| Food ID |     Food Name    | Quantity |  Price  |");
        System.out.println("---------------------------------------------------");

        for (j = 0; j < foList.size(); j++) {
            System.out.println("|    " + foList.get(j).getFoodID() + "         " + foList.get(j).getFood() + "     " + foList.get(j).getQuantity() + "        RM " + ( foList.get(j).getPrice()* foList.get(j).getQuantity())+" |");
            totalAmount += (foList.get(j).getPrice()) * (foList.get(j).getQuantity());
        }

        System.out.println("---------------------------------------------------");
        System.out.printf("|                                   Total: RM %.1f |\n", totalAmount);
        System.out.println("---------------------------------------------------");

        System.out.println();
          
                
                

                break;

            case "N":
                System.out.println("Continue your order~");
                viewMenu();
                break;

            default:
               
                confirmOrder();
                break;
        }

    }

    public static void changeQuantity() {
        System.out.println("Do you wish to change the quantity or the food ? (Y/N)");
        
String change = scan.next();

        switch (change) {
            case "Y":
                System.out.println("------Change Quantity-------");
                System.out.print("Enter the food ID to change quantity :");
                int id = scan.nextInt();
                for (int a = 0; a < foList.size(); a++) {
                    if (id == foList.get(a).getFoodID()) {
                        System.out.print("Quantity: ");
                        int quant = scan.nextInt();
                        foList.get(a).setQuantity(quant);
                        summary();

                    }
                }
                break;

            case "N":
                confirmOrder();
                break;
                
 
        }

    }
    

    public static void main(String[] args) {
        MakeOrder();
    }
}
