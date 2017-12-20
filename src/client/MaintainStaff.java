package client;


import domain.Staff;
import domain.foodOrdered;
import domain.orderDetails;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Alex
 */
public class MaintainStaff {

    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Staff> staffList = new ArrayList<Staff>();
    private static int ID = 1002;
    private static orderDetails orderDetail;
    private static final ArrayList<orderDetails> orderList = new ArrayList<orderDetails>();

    public static int compareInput(String input) {
        if (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("ye") || input.equalsIgnoreCase("yes")) {
            return 1; //Represent Yes
        } else if (input.equalsIgnoreCase("n") || input.equalsIgnoreCase("no")) {
            return 0; //Represent No
        } else if (input.equalsIgnoreCase("exit")) {
            return -999; //Represent Exit
        } else {
            return -1; //Represent Invalid
        }
    }

    public static void addStaff() {
        boolean doMore;
        String input;

        OUTER:
        do {
            doMore = false;
            Staff newStaff = new Staff();
            newStaff.setID(ID);

            System.out.println("\n\n\n***Staff Registration***\n");
            System.out.println("===Input Details===");
            System.out.println("Staff ID : " + newStaff.getID());
            System.out.print("Name : ");
            newStaff.setName(scanner.nextLine());
            System.out.print("Phone Number : ");
            newStaff.setPhoneNo(scanner.nextLine());
            System.out.print("Address : ");
            newStaff.setAddress(scanner.nextLine());
            newStaff.setStatus("Active");
            newStaff.setDeliveryList(new ArrayList<orderDetails>());

            do {
                System.out.print("Verify Input Details (Y/N/Exit) ?  ");
                input = scanner.nextLine();
                if (compareInput(input) == 1) {
                    System.out.println("\n===Verify Staff Details===");
                    System.out.println("Staff ID : " + newStaff.getID());
                    System.out.println("Name : " + newStaff.getName());
                    System.out.println("Phone Number : " + newStaff.getPhoneNo());
                    System.out.println("Address : " + newStaff.getAddress());
                    break;
                } else if (compareInput(input) == -1) {
                    System.out.println("Invalid Input");
                } else if (compareInput(input) == -999) {
                    break OUTER;
                }
            } while (compareInput(input) != 0);

            do {
                System.out.print("Confirm add into system (Y/N/Exit) ? ");
                input = scanner.nextLine();
                if (compareInput(input) == 1) {
                    staffList.add(newStaff);
                    ID++;
                    break;
                } else if (compareInput(input) == -1) {
                    System.out.println("Invalid Input");
                } else if (compareInput(input) == -999) {
                    break OUTER;
                }
            } while (compareInput(input) != 0);

            do {
                System.out.print("Add more staff (Y/N) ? ");
                input = scanner.nextLine();
                if (compareInput(input) == 1) {
                    doMore = true;
                    break;
                } else if (compareInput(input) == -1) {
                    System.out.println("Invalid Input");
                }
            } while (compareInput(input) != 0);
        } while (doMore == true);

        do {
            System.out.print("Return to Main Menu or Exit (Y = Return / N = Exit) ? ");
            input = scanner.nextLine();
            if (compareInput(input) == 0) {
                System.exit(0);
            } else if (compareInput(input) == -1) {
                System.out.println("Invalid Input");
            }
        } while (compareInput(input) != 1);
    }

    public static void retrieveDeliveries() {
        Staff staff = null;
        int input = 0;
        String strInput = null;

        System.out.println("\n\n\n\n**Retrieve Pending Deliveries**");
        OUTER:
        do {
            do {
                System.out.print("Input Staff ID (-1 to exit): ");
                input = scanner.nextInt();
                scanner.nextLine();
                if (input == -1) {
                    break OUTER;
                }

                for (Staff s : staffList) {
                    if (s.getID() == input) {
                        staff = s;
                    }
                }
                if (staff == null) {
                    System.out.println("Staff ID Not Found.");
                }
            } while (staff == null);

            do {
                ArrayList<orderDetails> deliveryList = new ArrayList<>();
                if (!staff.getDeliveryList().isEmpty()) {
                    deliveryList = staff.getDeliveryList();
                }

                System.out.println("\n\n\n\n==Pending Deliveries==");
                System.out.println("Staff Name(ID): " + staff.getName() + "(" + staff.getID() + ")");
                System.out.print("Order IDs: ");

                if (deliveryList.isEmpty()) {
                    System.out.println("Delivery list is empty.");
                } else {
                    for (orderDetails od : deliveryList) {
                        System.out.print(od.getOrderID() + " ");
                    }
                }
                System.out.println("");

                System.out.println("==List of Action==");
                System.out.println("1. Assign New Order");
                if (!deliveryList.isEmpty()) {
                    System.out.println("2. Check Order Details");
                }
                System.out.println("0. Exit");
                System.out.print("Input Selection: ");
                input = scanner.nextInt();
                scanner.nextLine();
                switch (input) {
                    case 0:
                        break OUTER;
                    case 1: {
                        if (!orderList.isEmpty()) {
                            System.out.print("Current Available Order IDs: ");
                            for (orderDetails od : orderList) {
                                System.out.print(od.getOrderID() + " ");
                            }
                            System.out.println("");
                            System.out.print("Input New Order ID: ");
                            input = scanner.nextInt();
                            scanner.nextLine();

                            for (orderDetails od : orderList) {
                                if (input == od.getOrderID()) {
                                    if (!staff.getDeliveryList().contains(od)) {
                                        staff.addDelivery(od);
                                        orderList.remove(od);
                                    } else {
                                        System.out.println("Order already assigned.");
                                    }
                                    break;
                                } else {
                                    System.out.println("Invalid Order ID");
                                    break;
                                }
                            }
                            break;
                        } else {
                            System.out.println("Order list is empty.");
                            break;
                        }
                    }
                    case 2: {
                        if (!deliveryList.isEmpty()) {
                            System.out.print("Input Order ID: ");
                            input = scanner.nextInt();
                            scanner.nextLine();
                            for (orderDetails od : staff.getDeliveryList()) {
                                if (input == od.getOrderID()) {
                                    System.out.println("\n\n==Order Details==");
                                    System.out.println("Order ID: " + od.getOrderID());
                                    System.out.println("Restaurant Name(ID): " + od.getResName() + "(" + od.getResID() + ")");
                                    System.out.println("Customer Name: " + od.getCustomerName());
                                    System.out.println("Customer Address: " + od.getCustomerAdd());
                                    break;
                                } else {
                                    System.out.println("Invalid Order ID");
                                }
                            }
                            break;
                        }
                    }
                    default:
                        System.out.println("Invalid Selection");
                }
            } while (input != 0);
        } while (input != -1);

        do {
            System.out.print("Return to Main Menu or Exit (Y = Return / N = Exit) ? ");
            strInput = scanner.nextLine();
            if (compareInput(strInput) == 0) {
                System.exit(0);
            } else if (compareInput(strInput) == -1) {
                System.out.println("Invalid Input");
            }
        } while (compareInput(strInput) != 1);
    }

    public static void updateStaff() {
        Staff staff = null;
        int input = 0;
        String strInput = null;
        String temp = null;

        System.out.println("\n\n\n\n**Update Staff Information**");
        OUTER:
        do {
            do {
                System.out.print("Input Staff ID (-1 to exit): ");
                input = scanner.nextInt();
                scanner.nextLine();
                if (input == -1) {
                    break OUTER;
                }

                for (Staff s : staffList) {
                    if (s.getID() == input) {
                        staff = s;
                    }
                }
                if (staff == null) {
                    System.out.println("Staff ID Not Found.");
                }
            } while (staff == null);

            do {
                System.out.println("\n\n\n==Current Stored Information==");
                System.out.println("Staff ID : " + staff.getID());
                System.out.println("1. Name : " + staff.getName());
                System.out.println("2. Phone Number : " + staff.getPhoneNo());
                System.out.println("3. Address : " + staff.getAddress());
                System.out.println("0. Exit");
                System.out.print("Select field to be updated (1-3):");
                input = scanner.nextInt();
                scanner.nextLine();
                switch (input) {
                    case 0:
                        break OUTER;
                    case 1: {
                        System.out.println("Current Name: " + staff.getName());
                        System.out.print("Input New Name: ");
                        temp = scanner.nextLine();
                        if (!temp.equals("")) {
                            do {
                                System.out.print("Confirm update (Y/N) ? ");
                                strInput = scanner.nextLine();
                                if (compareInput(strInput) == 1) {
                                    staff.setName(temp);
                                    break;
                                } else {
                                    System.out.println("Invalid Input");
                                }
                            } while (compareInput(strInput) != 0);
                        } else {
                            System.out.println("Name cannot be empty.");
                        }
                        break;
                    }
                    case 2: {
                        System.out.println("Current Phone Number: " + staff.getPhoneNo());
                        System.out.print("Input New Phone Number: ");
                        temp = scanner.nextLine();
                        if (!temp.equals("")) {
                            do {
                                System.out.print("Confirm update (Y/N) ? ");
                                strInput = scanner.nextLine();
                                if (compareInput(strInput) == 1) {
                                    staff.setPhoneNo(temp);
                                    break;
                                } else {
                                    System.out.println("Invalid Input");
                                }
                            } while (compareInput(strInput) != 0);
                        } else {
                            System.out.println("Phone number cannot be empty.");
                        }
                        break;
                    }
                    case 3: {
                        System.out.println("Current Address: " + staff.getAddress());
                        System.out.print("Input New Address: ");
                        temp = scanner.nextLine();
                        if (!temp.equals("")) {
                            do {
                                System.out.print("Confirm update (Y/N) ? ");
                                strInput = scanner.nextLine();
                                if (compareInput(strInput) == 1) {
                                    staff.setAddress(temp);
                                    break;
                                } else {
                                    System.out.println("Invalid Input");
                                }
                            } while (compareInput(strInput) != 0);
                        } else {
                            System.out.println("Phone number cannot be empty.");
                        }
                        break;
                    }
                    default: {
                        System.out.println("Invalid Selection");
                    }
                }

            } while (input != 0);
        } while (input
                != -1);

        do {
            System.out.print("Return to Main Menu or Exit (Y = Return / N = Exit) ? ");
            strInput = scanner.nextLine();
            if (compareInput(strInput) == 0) {
                System.exit(0);
            } else if (compareInput(strInput) == -1) {
                System.out.println("Invalid Input");
            }
        } while (compareInput(strInput)
                != 1);
    }

    public static void updateStatus() {
        Staff staff = null;
        int input = 0;
        String strInput = null;

        ArrayList<String> statusList = new ArrayList<>();
        statusList.add("Active");
        statusList.add("Inactive");
        statusList.add("Resigned");
        statusList.add("Retired");

        System.out.println("\n\n\n\n**Update Staff Status**");
        OUTER:
        do {
            do {
                System.out.print("Input Staff ID (-1 to exit): ");
                input = scanner.nextInt();
                scanner.nextLine();
                if (input == -1) {
                    break OUTER;
                }

                for (Staff s : staffList) {
                    if (s.getID() == input) {
                        staff = s;
                    }
                }
                if (staff == null) {
                    System.out.println("Staff ID Not Found.");
                }
            } while (staff == null);

            do {
                int numb = 1;
                System.out.println("\n\n\n==Staff Information==");
                System.out.println("Staff Name(ID) : " + staff.getName() + "(" + staff.getID() + ")");
                System.out.println("Current Status : " + staff.getStatus());
                System.out.println("\nSet New Status:");
                for (int i = 0; i < statusList.size(); i++) {
                    if (!staff.getStatus().equalsIgnoreCase(statusList.get(i))) {
                        System.out.println(numb + ". " + statusList.get(i));
                        numb++;
                    }
                }
                System.out.println("0. Exit");
                do {
                    System.out.print("Input Selection: ");
                    input = scanner.nextInt();
                    scanner.nextLine();
                    if (input == 0) {
                        break OUTER;
                    } else if(input <1 || input > 3){
                        System.out.println("Invalid Selection");
                    }
                } while (input < 1 || input > 3);
                switch (staff.getStatus()) {
                    case "Active": {
                        do {
                            System.out.print("Confirm update (Y/N) ? ");
                            strInput = scanner.nextLine();
                            if (compareInput(strInput) == 1) {
                                if (input == 1) {
                                    staff.setStatus("Inactive");
                                } else if (input == 2) {
                                    staff.setStatus("Resigned");
                                } else if (input == 3) {
                                    staff.setStatus("Retired");
                                }
                                break;
                            } else {
                                System.out.println("Invalid Input");
                            }
                        } while (compareInput(strInput) != 0);
                        break;
                    }
                    case "Inactive": {
                        do {
                            System.out.print("Confirm update (Y/N) ? ");
                            strInput = scanner.nextLine();
                            if (compareInput(strInput) == 1) {
                                if (input == 1) {
                                    staff.setStatus("Active");
                                } else if (input == 2) {
                                    staff.setStatus("Resigned");
                                } else if (input == 3) {
                                    staff.setStatus("Retired");
                                }
                                break;
                            } else {
                                System.out.println("Invalid Input");
                            }
                        } while (compareInput(strInput) != 0);
                        break;
                    }
                    case "Resigned": {
                        do {
                            System.out.print("Confirm update (Y/N) ? ");
                            strInput = scanner.nextLine();
                            if (compareInput(strInput) == 1) {
                                if (input == 1) {
                                    staff.setStatus("Active");
                                } else if (input == 2) {
                                    staff.setStatus("Inactive");
                                } else if (input == 3) {
                                    staff.setStatus("Retired");
                                }
                                break;
                            } else {
                                System.out.println("Invalid Input");
                            }
                        } while (compareInput(strInput) != 0);
                        break;
                    }
                    case "Retired": {
                        do {
                            System.out.print("Confirm update (Y/N) ? ");
                            strInput = scanner.nextLine();
                            if (compareInput(strInput) == 1) {
                                if (input == 1) {
                                    staff.setStatus("Active");
                                } else if (input == 2) {
                                    staff.setStatus("Inactive");
                                } else if (input == 3) {
                                    staff.setStatus("Resigned");
                                }
                                break;
                            } else {
                                System.out.println("Invalid Input");
                            }
                        } while (compareInput(strInput) != 0);
                        break;
                    }
                }
            } while (input != 0);
        } while (input != -1);

        do {
            System.out.print("Return to Main Menu or Exit (Y = Return / N = Exit) ? ");
            strInput = scanner.nextLine();
            if (compareInput(strInput) == 0) {
                System.exit(0);
            } else if (compareInput(strInput) == -1) {
                System.out.println("Invalid Input");
            }
        } while (compareInput(strInput) != 1);
    }

    public static void main(String[] args) throws IOException {
        //Intialize ArrayLists
        staffList.add(new Staff(1001, "Alex", "012-3456789", "123, Jalan ABC", "Active"));

        ArrayList<foodOrdered> fo = new ArrayList<foodOrdered>();
        fo.add(new foodOrdered(2001, "Nasi lemak", 1, 5.00));
        fo.add(new foodOrdered(2001, "Burger", 1, 5.00));
        fo.add(new foodOrdered(2001, "Kopi ice", 1, 2.00));
        orderDetail = new orderDetails(1001, 2001, 3001, "Kopitiam", "Jordan", "Taman Gembira", "012-3456789", fo);
        staffList.get(0).addDelivery(orderDetail);

        fo = new ArrayList<>();
        fo.add(new foodOrdered(2002, "Roti bakar", 2, 5.00));
        fo.add(new foodOrdered(2002, "Telur", 2, 4.0));
        fo.add(new foodOrdered(2002, "Milo Ais", 2, 2.50));
        orderList.add(new orderDetails(1001, 2002, 3002, "Garden Cafe", "John", "Taman ABC", "0123456789(3)", fo));
        fo = new ArrayList<>();
        fo.add(new foodOrdered(2003, "Mee Rebus", 2, 5.0));
        fo.add(new foodOrdered(2003, "Teh Ais", 1, 2.0));
        orderList.add(new orderDetails(1002, 2003, 3002, "Garden Cafe", "Dennis", "Taman DEF", "012-333444999", fo));

        int input;
        do {
            System.out.println("\n\n\n***HR Module***");
            System.out.println("1. Add Staff");
            System.out.println("2. Retrieve Pending Deliveries");
            System.out.println("3. Update Staff Details");
            System.out.println("4. Update Staff Status");
            System.out.println("0. Exit");
            System.out.print("Input Selection : ");
            input = scanner.nextInt();
            scanner.nextLine();
            switch (input) {
                case 0:
                    break;
                case 1:
                    addStaff();
                    break;
                case 2:
                    retrieveDeliveries();
                    break;
                case 3:
                    updateStaff();
                    break;
                case 4:
                    updateStatus();
                    break;
                default:
                    System.out.println("Invalid Selection");
                    break;
            }
        } while (input != 0);
    }
}
