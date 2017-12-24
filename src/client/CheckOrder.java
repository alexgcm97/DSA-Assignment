package client;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import adt.DeliveryADT;
import domain.Staff;
import domain.foodOrdered;
import domain.orderDetails;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author REPUBLIC
 */
public class CheckOrder {

    public static DeliveryADT<orderDetails> od = new DeliveryADT<orderDetails>();
    public static DeliveryADT<foodOrdered> fo = new DeliveryADT<foodOrdered>();
    public static DeliveryADT<foodOrdered> fo1 = new DeliveryADT<foodOrdered>();
    public static DeliveryADT<foodOrdered> fo2 = new DeliveryADT<foodOrdered>();

    private static final DeliveryADT<Staff> staffList = new DeliveryADT<Staff>();

    public static Scanner scan = new Scanner(System.in);
    public static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    public static void checkOrders(int id) {
        Staff staff = null;
        orderDetails orderList = null;

        for (int i = 0; i < staffList.getSize(); i++) {
            Staff s = staffList.get(i);
            if (s.getID() == id) {
                staff = s;
            }
        }
        for (int i = 0; i < od.getSize(); i++) {
            orderDetails o = od.get(i);
            if (o.getStaffID() == id) {
                orderList = o;
            }
            DeliveryADT<foodOrdered> foo = orderList.getFood();

            System.out.println("\n---------------------------------------------------");
            System.out.println("|               Your Order Details                 |");
            System.out.println("---------------------------------------------------");

            System.out.println("Order ID :" + orderList.getOrderID());
            System.out.println("Restaurant ID :" + orderList.getResID());
            System.out.println("Restaurant name :" + orderList.getResName());
            System.out.println("Customer name :" + orderList.getCustomerName());
            System.out.println("Delivery address :" + orderList.getCustomerAdd());
            System.out.println("Customer hp no. :" + orderList.getCustNo());
            System.out.println("\nFood ordered");
            System.out.println("| Food Name  |  Quantity |");
            System.out.println("---------------------------------------------------");
            for (int j = 0; j < foo.getSize(); j++) {
                System.out.println(foo.get(j).getFood() + "       " + foo.get(j).getQuantity());
            }
            System.out.println("-------------------------------------------------------");
        }
    }

    public static void checkIn(int id) {
        Staff staff = null;
        String confirm;
        Date cal = Calendar.getInstance().getTime();
        String date = dateFormat.format(cal);

        for (int i = 0; i < staffList.getSize(); i++) {
            Staff s = staffList.get(i);
            if (s.getID() == id) {
                staff = s;
            }
        }
        if (staff.getAvailability() == "Unavailable") {
            System.out.println("\nCurrent date & time: " + date);
            System.out.println("\nConfirm check in (Y/N)");
            confirm = scan.nextLine().toUpperCase();
            if (confirm.equals("Y") || confirm.equals("YES")) {

                staff.setCheckIn(date);
                staff.setAvailability("Available");
                System.out.println("Successfully checked in.");
            }
        } else {
            System.out.println("You have already clocked in.");
        }
    }

    public static void checkOut(int id) {
        Staff staff = null;
        String confirm;
        Date cal = Calendar.getInstance().getTime();
        String date = dateFormat.format(cal);
        Date date1;
        Date date2;
        String checkIn;
        for (int i = 0; i < staffList.getSize(); i++) {
            Staff s = staffList.get(i);
            if (s.getID() == id) {

                staff = s;
            }
        }
        if (staff.getAvailability() == "Available") {
            System.out.println("\nCurrent date & time: " + date);
            System.out.println("Checked in time: " + staff.getCheckIn());

            System.out.println("\nConfirm check out (Y/N)");

            confirm = scan.nextLine().toUpperCase();
            if (confirm.equals("Y") || confirm.equals("YES")) {

                staff.setCheckOut(date);

                staff.setAvailability("Unavailable");

                checkIn = staff.getCheckIn();
                try {
                    date1 = dateFormat.parse(checkIn);
                    date2 = dateFormat.parse(date);

                    long diff = date2.getTime() - date1.getTime();
                    long diffMinutes = diff / (60 * 1000) % 60;
                    long diffHours = diff / (60 * 60 * 1000) % 24;

                    System.out.println("Successfully checked out.");
                    System.out.println("Duration worked: " + diffHours + " hours " + diffMinutes + " minutes ");
                } catch (ParseException e) {
                    e.printStackTrace();
                };
            }
        } else {
            System.out.println("Please clock in first.");
        }
    }

    public static void updateAvailability(int id) {
        Staff staff = null;
        int select;
        for (int i = 0; i < staffList.getSize(); i++) {
            Staff s = staffList.get(i);
            if (s.getID() == id) {

                staff = s;
                if (!staff.getAvailability().equalsIgnoreCase("Unavailable")) {
                    System.out.println("\nCurrent status:" + staff.getAvailability());
                    System.out.println("Select new status");
                    System.out.println("1.Break");
                    System.out.println("2.Available");
                    System.out.println("0.Exit");

                    select = scan.nextInt();
                    if (select == 1 && staff.getAvailability().equalsIgnoreCase("Available")) {
                        staff.setAvailability("On Break");
                        System.out.println("Status changed to Break");
                    } else if (select == 2 && staff.getAvailability().equalsIgnoreCase("On Break")) {
                        staff.setAvailability("Available");
                        System.out.println("Status changed to Available");
                    } else if (select == 0) {
                        break;
                    } else {
                        System.out.println("\nIncorrect selection");
                        break;
                    }
                } else {
                    System.out.println("Please clock in first.");
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        foodOrdered foodDetail = new foodOrdered(2001, "Nasi lemak", 1, 0.0);
        foodOrdered foodDetail1 = new foodOrdered(2001, "Burger Good", 1, 0.0);
        foodOrdered foodDetail2 = new foodOrdered(2001, "Kopi ice", 1, 0.0);
        foodOrdered foodDetail3 = new foodOrdered(2002, "Roti bakar", 2, 0.0);
        foodOrdered foodDetail4 = new foodOrdered(2002, "Telur Rebus", 2, 0.0);
        foodOrdered foodDetail5 = new foodOrdered(2002, "Milo ais", 2, 0.0);
        foodOrdered foodDetail6 = new foodOrdered(2002, "Roti telur", 3, 0.0);
        foodOrdered foodDetail7 = new foodOrdered(2002, "Telur Good", 3, 0.0);
        foodOrdered foodDetail8 = new foodOrdered(2002, "Limau ais", 3, 0.0);

        fo.add(foodDetail);
        fo.add(foodDetail1);
        fo.add(foodDetail2);
        fo1.add(foodDetail3);
        fo1.add(foodDetail4);
        fo1.add(foodDetail5);
        fo2.add(foodDetail6);
        fo2.add(foodDetail7);
        fo2.add(foodDetail8);

        orderDetails orderDetail = new orderDetails(1001, 2001, 3001, "Kopitiam", "Jordan", "Taman Gembira", "012-3456789", fo);
        orderDetails orderDetail2 = new orderDetails(1001, 2003, 3003, "Kopitiam3", "Jordan3", "Taman Gembira3", "0123456789(3)", fo2);
        orderDetails orderDetail1 = new orderDetails(1002, 2002, 3002, "Kopitiam2", "Jordan2", "Taman Gembira2", "012-3456789(2)", fo1);

        od.add(orderDetail);
        od.add(orderDetail1);
        od.add(orderDetail2);

        Staff Staff1 = new Staff(1001, "Alex", "Unavailable");
        Staff Staff2 = new Staff(1002, "Jordan", "Available");
        staffList.add(Staff1);
        staffList.add(Staff2);
        Staff staff = null;
        int input;
        int select;
        System.out.print("Enter staff ID : ");
        input = scan.nextInt();
        for (int i = 0; i < staffList.getSize(); i++) {
            Staff s = staffList.get(i);
            if (s.getID() == input) {

                staff = s;
            }
        }
        do {
            int id = staff.getID();
            System.out.println("\nStaff name: " + staff.getName());
            System.out.println("Availability: " + staff.getAvailability());
            System.out.println("\n\n-Staff module-");
            System.out.println("1. Clock in");
            System.out.println("2. Clock out");
            System.out.println("3. Orders");
            System.out.println("4. Change availability");

            System.out.println("\n0. Exit");
            System.out.print("Input Selection : ");
            select = scan.nextInt();
            scan.nextLine();
            switch (select) {
                case 0:
                    break;
                case 1:
                    checkIn(id);
                    break;
                case 2:
                    checkOut(id);
                    break;
                case 3:
                    checkOrders(id);
                    break;
                case 4:
                    updateAvailability(id);
                    break;
                default:
                    System.out.println("Invalid Selection");
                    break;
            }
        } while (select != 0);
    }
}
