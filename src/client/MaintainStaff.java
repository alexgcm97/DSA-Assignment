package client;

import adt.StaffADT;
import adt.StaffSortedList;
import domain.Staff;
import domain.staffOD;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    private static final StaffADT<Staff> staffList = new StaffADT<Staff>();
    private static int ID = 1005;
    private static staffOD staffOD;
    private static final StaffADT<staffOD> orderList = new StaffADT<staffOD>();
    private static int reportNo = 0001;

    public static void initializeData() {
        //Initialize data into staffList
        staffList.add(new Staff(1001, "Alex", "012-3456789", "123, Jalan ABC", "Active"));
        staffList.add(new Staff(1002, "Jonathan", "013-44455566", "12, Jalan DEF", "Active"));
        staffList.add(new Staff(1003, "Lily", "014-7894512", "35, Jalan Ros", "Active"));
        staffList.add(new Staff(1004, "Crystal", "018-3357849", "12, Jalan IDK", "Active"));

        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();

        //Intialize deliveries data into staff object in staffList
        staffList.get(0).addDelivery(new staffOD(2001, 3001, "Kopitiam", "Jordan", "Taman Gembira", "012-3456789", "Completed", "18-12-2017", 6));
        staffList.get(0).addDelivery(new staffOD(2008, 3001, "Kopitiam", "Jordan", "Taman Gembira", "012-3456789", "Pending", dateFormat.format(date), 6));

        staffList.get(1).addDelivery(new staffOD(2002, 3001, "Kopitiam", "Steve", "Taman Bunga", "013-4567789", "Completed", "18-12-2017", 3));
        staffList.get(1).addDelivery(new staffOD(2003, 3001, "Kopitiam", "John", "Taman ABC", "012-333444555", "Completed", "18-12-2017", 3.5));
        staffList.get(1).addDelivery(new staffOD(2004, 3002, "Garden Cafe", "Chelsea", "Taman Bahagia", "012-4331547", "Completed", "18-12-2017", 8));

        staffList.get(2).addDelivery(new staffOD(2005, 3002, "Garden Cafe", "Chelsea", "Taman Def", "012-4331547", "Completed", "18-12-2017", 5));
        staffList.get(2).addDelivery(new staffOD(2006, 3001, "Kopitiam", "Steve", "Desa Park City", "013-4567789", "Completed", "18-12-2017", 7));
        staffList.get(3).addDelivery(new staffOD(2007, 3001, "Garden Cafe", "Robin", "Taman Bahagia", "012-9871234", "Completed", "18-12-2017", 8));

        //Initialize pending deliveries
        orderList.add(new staffOD(2009, 3002, "Garden Cafe", "John", "Taman ABC", "0123456789(3)", "Pending", dateFormat.format(date), 0));
        orderList.add(new staffOD(2010, 3002, "Garden Cafe", "Dennis", "Taman DEF", "012-333444999", "Pending", dateFormat.format(date), 0));
    }

    public static int compareInput(String input) {
        //Method use to compare input for yes/no/exit
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

    public static boolean comparePhoneNo(String phoneNo) {
        //Method use to compare phone number format
        Pattern pattern = Pattern.compile("\\d{3}-\\d{7,8}");
        Matcher matcher = pattern.matcher(phoneNo);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }

    private static void exitMenu() {
        //Method use to print exit menu
        String strInput;
        do {
            System.out.print("Return to HR Executive Module Menu or Exit (Y = Return / N = Exit) ? ");
            strInput = scanner.nextLine();
            if (compareInput(strInput) == 0) {
                System.exit(0);
            } else if (compareInput(strInput) == -1) {
                System.out.println("Invalid Input");
            }
        } while (compareInput(strInput) != 1);
    }

    private static int getIntInput() {
        //Method use to validate integer input & print error if invalid
        int input;
        while (!scanner.hasNextInt()) {
            System.out.println("Please input a valid digit!");
            System.out.print("Input Selection: ");
            scanner.next();
        }
        input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }

    public static void addStaff() {
        //Method use to add new staff/delivery man into staffList
        boolean doMore;
        String input;

        OUTER:
        do {
            doMore = false;
            Staff newStaff = new Staff();
            newStaff.setID(ID);

            //Print form for inputting data for new staff/delivery man
            System.out.println("\n\n\n***Staff Registration***\n");
            System.out.println("===Input Details===");
            System.out.println("Staff ID : " + newStaff.getID());
            System.out.print("Name : ");
            newStaff.setName(scanner.nextLine());
            do {
                System.out.print("Phone Number(xxx-xxxxxxx) : ");
                input = scanner.nextLine();
                if (!comparePhoneNo(input)) {
                    System.out.println("Invalid Phone Number Format!");
                }
            } while (!comparePhoneNo(input));
            newStaff.setPhoneNo(input);
            System.out.print("Address : ");
            newStaff.setAddress(scanner.nextLine());
            newStaff.setStatus("Active");
            newStaff.setDeliveryList(new StaffADT<staffOD>());

            do {
                //Prompt HR executive if want to verify the above input data
                System.out.print("Verify Input Details (Y/N/Exit) ?  ");
                input = scanner.nextLine();
                //If yes, print the details
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
                //Prompt confirmation to add into system
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
                //Prompt to add more staff or not
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

        exitMenu();
    }

    public static void retrieveDeliveries() {
        Staff staff = null;
        int input = 0, count = 0;
        boolean found = false;

        System.out.println("\n\n\n\n**Retrieve Pending Deliveries**");
        OUTER:
        do {
            do {
                System.out.print("Input Staff ID (-1 to exit): ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Please input Staff ID in digit!");
                    System.out.print("Input Staff ID (-1 to exit): ");
                    scanner.next();
                }
                input = scanner.nextInt();
                scanner.nextLine();
                if (input == -1) {
                    break OUTER;
                }

                for (int i = 0; i < staffList.getSize(); i++) {
                    Staff s = staffList.get(i);
                    if (s.getID() == input) {
                        staff = s;
                    }
                }
                if (staff == null) {
                    System.out.println("Staff ID Not Found.");
                }
                if (!staff.getStatus().equals("Active")) {
                    System.out.println("Staff is not active.");
                    break OUTER;
                }
            } while (staff == null);

            do {
                StaffADT<staffOD> deliveryList = new StaffADT<>();
                if (!staff.getDeliveryList().isEmpty()) {
                    deliveryList = staff.getDeliveryList();
                }

                System.out.println("\n\n\n\n==Pending Deliveries==");
                System.out.println("Staff Name(ID): " + staff.getName() + "(" + staff.getID() + ")");
                System.out.print("Order IDs: ");

                if (deliveryList.isEmpty()) {
                    System.out.println("No pending deliveries.");
                } else {
                    for (int i = 0; i < deliveryList.getSize(); i++) {
                        staffOD od = deliveryList.get(i);
                        if (od.getStatus().equals("Pending")) {
                            System.out.print(od.getOrderID() + " ");
                            count++;
                        }
                    }
                    if (count == 0) {
                        System.out.println("No pending deliveries.");
                    }
                }
                System.out.println("");

                System.out.println("==List of Action==");
                System.out.println("1. Assign New Order");
                if (!deliveryList.isEmpty() && count > 0) {
                    System.out.println("2. Check Order Details");
                }
                System.out.println("0. Exit");
                System.out.print("Input Selection: ");
                input = getIntInput();
                switch (input) {
                    case 0:
                        break OUTER;
                    case 1: {
                        if (!orderList.isEmpty()) {
                            System.out.print("Current Available Order IDs: ");

                            for (int i = 0; i < orderList.getSize(); i++) {
                                staffOD od = orderList.get(i);
                                System.out.print(od.getOrderID() + " ");
                            }
                            System.out.println("");
                            System.out.print("Input New Order ID: ");
                            while (!scanner.hasNextInt()) {
                                System.out.println("Please input Order ID in digit!");
                                System.out.print("Input Order ID: ");
                                scanner.next();
                            }
                            input = scanner.nextInt();
                            scanner.nextLine();

                            for (int i = 0; i < orderList.getSize(); i++) {
                                staffOD od = orderList.get(i);
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
                            while (!scanner.hasNextInt()) {
                                System.out.println("Please input Order ID in digit!");
                                System.out.print("Input Order ID: ");
                                scanner.next();
                            }
                            input = scanner.nextInt();
                            scanner.nextLine();
                            StaffADT<staffOD> odList = staff.getDeliveryList();
                            Loop:
                            for (int i = 0; i < odList.getSize(); i++) {
                                staffOD od = odList.get(i);
                                if (input == od.getOrderID()) {
                                    if (od.getStatus().equals("Pending")) {
                                        System.out.println("\n\n==Order Details==");
                                        System.out.println("Order ID: " + od.getOrderID());
                                        System.out.println("Restaurant Name(ID): " + od.getResName() + "(" + od.getResID() + ")");
                                        System.out.println("Customer Name: " + od.getCustomerName());
                                        System.out.println("Customer Address: " + od.getCustomerAdd());
                                        System.out.println("Customer Phone Number: " + od.getCustNo());
                                        System.out.println("Date: " + od.getDate());
                                        found = true;
                                        break;
                                    }
                                }
                            }
                            if (found == false) {
                                System.out.println("Invalid Order ID.");
                            }
                            break;
                        }
                    }
                    default:
                        System.out.println("Invalid Selection");
                }
            } while (input != 0);
        } while (input != -1);
        exitMenu();
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
                while (!scanner.hasNextInt()) {
                    System.out.println("Please input Staff ID in digit!");
                    System.out.print("Input Staff ID (-1 to exit): ");
                    scanner.next();
                }
                input = scanner.nextInt();
                scanner.nextLine();
                if (input == -1) {
                    break OUTER;
                }

                for (int i = 0; i < staffList.getSize(); i++) {
                    Staff s = staffList.get(i);
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
                System.out.print("Select field to be updated (1-3 or 0 to Exit): ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Please input a valid digit!");
                    System.out.print("Select field to be updated (1-3 or 0 to Exit): ");
                    scanner.next();
                }
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
                        do {
                            System.out.print("Input New Phone Number: ");
                            temp = scanner.nextLine();
                            if (!temp.equals("")) {
                                if (!comparePhoneNo(temp)) {
                                    System.out.println("Invalid Phone Number Format (xxx-xxxxxxx).");
                                }
                            } else {
                                System.out.println("Phone number cannot be empty.");
                            }
                        } while (!comparePhoneNo(temp));
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
        } while (input != -1);
        exitMenu();
    }

    public static void updateStatus() {
        Staff staff = null;
        int input = 0;
        String strInput = null;

        StaffADT<String> statusList = new StaffADT<>();
        statusList.add("Active");
        statusList.add("Inactive");
        statusList.add("Resigned");
        statusList.add("Retired");

        System.out.println("\n\n\n\n**Update Staff Status**");
        OUTER:
        do {
            do {
                System.out.print("Input Staff ID (-1 to exit): ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Please input Staff ID in digit!");
                    System.out.print("Input Staff ID (-1 to exit): ");
                    scanner.next();
                }
                input = scanner.nextInt();
                scanner.nextLine();
                if (input == -1) {
                    break OUTER;
                }

                for (int i = 0; i < staffList.getSize(); i++) {
                    Staff s = staffList.get(i);
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
                for (int i = 0; i < statusList.getSize(); i++) {
                    if (!staff.getStatus().equalsIgnoreCase(statusList.get(i))) {
                        System.out.println(numb + ". " + statusList.get(i));
                        numb++;
                    }
                }
                System.out.println("0. Exit");
                do {
                    System.out.print("Input Selection: ");
                    input = getIntInput();
                    if (input == 0) {
                        break OUTER;
                    } else if (input < 1 || input > 3) {
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

        exitMenu();
    }

    public static void dailyReport() throws ParseException {
        int input = 0;
        String dateStr = null;
        Date date = null;
        boolean validDate;
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        StaffSortedList sortedList = new StaffSortedList();
        boolean isEmpty = true;

        System.out.println("\n\n\n\n==Daily Report on Delivery Men==");
        do {
            System.out.print("Input Date(DD-MM-YYYY) [-1 to Exit]: ");
            dateStr = scanner.nextLine();
            if (dateStr.equals("-1")) {
                break;
            }
            try {
                df.setLenient(false);
                date = df.parse(dateStr);
                validDate = true;
            } catch (ParseException e) {
                System.out.println(dateStr + " is not a valid date. Please try again.");
                validDate = false;
            }
        } while (validDate == false);

        for (int i = 0; i < staffList.getSize(); i++) {
            int tempCount = 0;
            double tempDistance = 0;
            Staff s = staffList.get(i);
            StaffADT<staffOD> ODList = s.getDeliveryList();
            for (int n = 0; n < ODList.getSize(); n++) {
                staffOD OD = ODList.get(n);
                if (OD.getDate().equals(dateStr)) {
                    if (OD.getStatus().equalsIgnoreCase("Completed")) {
                        tempCount++;
                        tempDistance += OD.getDistance();
                        isEmpty = false;
                    }
                }
            }
            s.setNoOfDoneDelivery(tempCount);
            s.setTotalDistance(tempDistance);
        }

        if (!isEmpty) {
            OUTER:
            do {
                System.out.println("\nReport Type:");
                System.out.println("1. Total Deliveries Completed");
                System.out.println("2. Total Distance Travelled");
                System.out.println("0. Exit");
                System.out.print("Input Selection: ");
                input = getIntInput();
                switch (input) {
                    case 0:
                        break;
                    case 1: {
                        int sum = 0;
                        sortedList.bubble_srt(staffList, "Delivery");
                        System.out.println("\n----Daily Report on Delivery Men's Total Deliveries Completed----");
                        System.out.println("==================================================================");
                        System.out.printf("|Report Date: %10s %20s Report No: %8d|\n", dateStr, "", reportNo);
                        System.out.println("------------------------------------------------------------------");
                        System.out.print("|");
                        System.out.println(" No. | Delivery Man's Name (ID)   |  Total Deliveries Completed |");
                        System.out.println("------------------------------------------------------------------");
                        for (int i = 0; i < staffList.getSize(); i++) {
                            Staff s = staffList.get(i);
                            if (staffList.get(i).getNoOfDoneDelivery() > 0) {
                                System.out.printf("| %3d | %25s  | %28d|\n", i + 1, (s.getName() + "(" + s.getID() + ")"), s.getNoOfDoneDelivery());
                                sum += staffList.get(i).getNoOfDoneDelivery();
                            }
                        }
                        if (sum == 0) {
                            System.out.printf("| %62s |\n", "No Records.");
                        }
                        System.out.println("==================================================================");
                        if (sum > 0) {
                            System.out.printf("%61s %3d\n", "Grand Total:", sum);
                        }
                        System.out.printf("Report Generated on: %s\n\n", df.format(new Date()));
                        reportNo++;
                        break OUTER;
                    }
                    case 2: {
                        double sum = 0;
                        sortedList.bubble_srt(staffList, "Distance");
                        System.out.println("\n----Daily Report on Delivery Men's Total Distance Travelled----");
                        System.out.println("==================================================================");
                        System.out.printf("|Report Date: %10s %20s Report No: %8d|\n", dateStr, "", reportNo);
                        System.out.println("------------------------------------------------------------------");
                        System.out.print("|");
                        System.out.println(" No. | Delivery Man's Name (ID)   | Total Distance Travelled(m) |");
                        System.out.println("------------------------------------------------------------------");
                        for (int i = 0; i < staffList.getSize(); i++) {
                            Staff s = staffList.get(i);
                            if (staffList.get(i).getTotalDistance() > 0) {
                                System.out.printf("| %3d | %25s  | %28.2f|\n", i + 1, (s.getName() + "(" + s.getID() + ")"), s.getTotalDistance());
                                sum += staffList.get(i).getTotalDistance();
                            }
                        }
                        if (sum == 0) {
                            System.out.printf("| %62s |\n", "No Records.");
                        }
                        System.out.println("==================================================================");
                        if (sum > 0) {
                            System.out.printf("%57s %7.2fm\n", "Grand Total:", sum);
                        }
                        System.out.printf("Report Generated on: %s\n\n", df.format(new Date()));
                        reportNo++;
                        break OUTER;
                    }
                    default:
                        System.out.println("Invalid Selection");
                        break;
                }
            } while (input != 0);
        } else {
            System.out.println("No Records on Date " + dateStr + ".");
        }
        exitMenu();
    }

    public static void main(String[] args) throws IOException, ParseException {
        //Intialize StaffLists
        initializeData();

        int input = 0;
        do {
            System.out.println("\n\n\n***HR Executive Module***");
            System.out.println("1. Add Staff");
            System.out.println("2. Retrieve Pending Deliveries");
            System.out.println("3. Update Staff Details");
            System.out.println("4. Update Staff Status");
            System.out.println("5. Daily Report on Delivery Men");
            System.out.println("0. Exit");
            System.out.print("Input Selection : ");
            input = getIntInput();

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
                case 5:
                    dailyReport();
                    break;
                default:
                    System.out.println("Invalid Selection");
                    break;
            }
        } while (input != 0);
    }
}
