package client;

import adt.CustomerADT;
import domain.Customer;
import domain.Menu;
import domain.Restaurant;
import domain.foodOrdered;
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

    private static CustomerADT<Restaurant> resList = new CustomerADT();
    private static CustomerADT<Menu> menuList = new CustomerADT();
    private static CustomerADT<Menu> menuList2 = new CustomerADT();
    private static CustomerADT<Customer> cList = new CustomerADT();
    private static int orderID = 1001;
    private static CustomerADT<foodOrdered> foList = new CustomerADT();
    private static int ans;
    private static int resId = 0;
    private static final Scanner scan = new Scanner(System.in);
    private static int j;
    private static double totalAmount = 0;
    private static int count = 0;
    private static String next;
    private static int quant;
    private static boolean foundId = false;

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

        cList.add(new Customer(1001, "Derek", "TBR", "012-3456789"));

        MakeOrder();
    }

    public static void login() {
        int id;
        String psw;

        do {
            System.out.print("Enter ID Number: ");
            id = scan.nextInt();
            System.out.print("Enter Password: ");
            psw = scan.next();
            if (id != 2001 || !psw.equals("AAA111")) {
                System.out.println("Invalid username and password\n");
            }
        } while (id != 2001 || !psw.equals("AAA111"));

        initializeMenu();
    }

    public static void MakeOrder() {
        do {
            System.out.println("\n=============================");
            System.out.println("Please select the restaurant");
            System.out.println("=============================");
            for (int i = 0; i < resList.getSize(); i++) {
                System.out.println(resList.getData(i).getResId() + ". " + resList.getData(i).getResName());

            }
            System.out.print("Enter restaurant no. :");
            ans = scan.nextInt();
            scan.nextLine();
            if (ans == 9001 || ans == 9002) {
                resId = ans;
            } else if (ans < 9001 || ans > 9002) {
                System.out.println("Invalid restaurant ID! Please try again.");
            }
        } while (ans < 9001 || ans > 9002);
        viewMenu();

    }

    public static void viewMenu() {

        do {

            System.out.println("\n---------------MENU--------------");
            System.out.println("----------------------------------");
            System.out.print("|");
            System.out.println(" No. | Food Name      |  Price  |");
            System.out.println("----------------------------------");
            for (int i = 0; i < resList.getSize(); i++) {
                if (resId == resList.getData(i).getResId()) {
                    resId = resList.getData(i).getResId();
                    for (int index = 0; index < resList.getData(i).getMenuList().getSize(); index++) {
                        Menu m = resList.getData(i).getMenuList().getData(index);
                        System.out.println("|  " + m.getFoodId() + ". | " + m.getFood() + " |  " + "RM " + m.getPrice() + " |");
                        System.out.println("----------------------------------");
                    }
                }
            }

            System.out.print("Please select food: ");
            ans = scan.nextInt();
            if (ans >= 1 && ans < 7) {

                foodOrdered fo = new foodOrdered();
                fo.setOrderID(orderID);

                for (int i = 0; i < resList.getSize(); i++) {
                    if (resId == resList.getData(i).getResId()) {
                        for (int index = 0; index < resList.getData(i).getMenuList().getSize(); index++) {
                            Menu m = resList.getData(i).getMenuList().getData(index);
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

            } else {
                System.out.println("Invalid food ID.");
                System.out.println("Please enter again.");
            }

        } while (ans < 1 || ans > 6);
        do {
            System.out.println("Any more order? (Y/N)");
            next = scan.next();
            if (next.equalsIgnoreCase("y") || next.equalsIgnoreCase("n")) {
                if (next.equalsIgnoreCase("y")) {
                    viewMenu();
                } else if (next.equalsIgnoreCase("n")) {
                    summary();
                }

            } else if (!next.equals("Y") && !next.equals("N")) {
                System.out.println("Invalid input! Please try again.");
            }
        } while (next != "Y" && next != "N");

    }

    public static void summary() {

        totalAmount = 0.0;
        System.out.println("---------------------------------------------------");
        System.out.println("|               Your Order Details                 |");
        System.out.println("---------------------------------------------------");
        System.out.println("| Food ID |     Food Name    | Quantity |  Price   |");
        System.out.println("---------------------------------------------------");

        for (j = 0; j < foList.getSize(); j++) {
            System.out.println("|    " + foList.getData(j).getFoodID() + "         " + foList.getData(j).getFood() + "    " + foList.getData(j).getQuantity() + "        RM " + (foList.getData(j).getPrice() * foList.getData(j).getQuantity()));
            totalAmount += (foList.getData(j).getPrice()) * (foList.getData(j).getQuantity());
        }

        System.out.println("---------------------------------------------------");
        System.out.printf("|                                  Total:  RM %.1f \n", totalAmount);
        System.out.println("---------------------------------------------------");

        changeQuantity();

    }

    public static void confirmOrder() {
        System.out.println("Please Confirm your order (Y/N)");
        String co = scan.next();

        if (co.equalsIgnoreCase("y")) {

            System.out.println("\n\nThank you for ordering from us! Please come again.");

            totalAmount = 0.0;
            System.out.println("------------------------------------------------------");
            System.out.println("|               Order Confirmed                      |");
            System.out.println("------------------------------------------------------");
            System.out.println("| Food ID |     Food Name    | Quantity |  Price     |");
            System.out.println("------------------------------------------------------");

            for (j = 0; j < foList.getSize(); j++) {
                System.out.println("|    " + foList.getData(j).getFoodID() + "         " + foList.getData(j).getFood() + "     " + foList.getData(j).getQuantity() + "        RM " + (foList.getData(j).getPrice() * foList.getData(j).getQuantity()) + "  |");
                totalAmount += (foList.getData(j).getPrice()) * (foList.getData(j).getQuantity());
            }

            System.out.println("------------------------------------------------------");
            System.out.printf("|                                   Total: RM %.1f   |\n", totalAmount);
            System.out.println("------------------------------------------------------");

            System.out.println();
            MakeOrder();
        } else if (co.equalsIgnoreCase("n")) {
            System.out.println("Continue your order~");
            viewMenu();
        } else {
            System.out.println("Invalid Input. (Y = Yes/N = No )");
            confirmOrder();
        }

    }

    public static void changeQuantity() {

        System.out.println("Do you wish to change the quantity of the food ? (Y/N)");
        String change = scan.next();
        if (change.equalsIgnoreCase("y")) {
            System.out.print("Enter food Id : ");
            int id = scan.nextInt();
            for (int j = 0; j < foList.getSize(); j++) {
                if (id == foList.getData(j).getFoodID()) {
                    foundId = true;

                    do {
                        System.out.print("Quantity : ");
                        quant = scan.nextInt();
                        if (quant <= 20) {
                            foList.getData(j).setQuantity(quant);
                            summary();

                        } else if (quant > 20) {
                            System.out.println("Quantity should be less than 20");
                            changeQuantity();
                        }

                    } while (quant < 20);
                } else {
                    System.out.println("Invalid food Id. Please try again");
                    changeQuantity();
                }
            }
        } else if (change.equalsIgnoreCase("n")) {
            confirmOrder();
        } else {
            System.out.println("Invalid input! Please try again.");
            changeQuantity();

        }

    }

    public static void retrieveCus() {
        boolean check = false;

        do {
            System.out.print("Enter Phone Number: ");
            String num = scan.next();

            for (int i = 0; i < cList.getSize(); i++) {
                if (num.equals(cList.getData(i).getPhoneNum())) {
                    System.out.println("ID: " + cList.getData(i).getCustID());
                    System.out.println("Name: " + cList.getData(i).getName());
                    System.out.println("Address: " + cList.getData(i).getAddress());
                    check = true;
                }
            }

            if (check == false) {
                System.out.print("Invalid Phone Number!");
            }

        } while (check == false);
    }

    public static void cont() {
        System.out.print("Continue? ");
        String c = scan.nextLine();
        switch (c) {
            case "Y":
                retrieveCus();
                break;

            case "N":
                //MainMenu.main(args);
                break;

            default:
                System.out.println("Invalid Input!");
                cont();
                break;
        }
    }

    public static void main(String[] args) {
        login();
    }
}
