package client;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import domain.Staff;
import domain.foodOrdered;
import domain.orderDetails;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author REPUBLIC
 */
public class CheckOrder {
        public static List<orderDetails> od = new ArrayList<orderDetails>();
        public static ArrayList<foodOrdered> fo = new ArrayList<foodOrdered>();
        public static ArrayList<foodOrdered> fo1 = new ArrayList<foodOrdered>();
        public static ArrayList<foodOrdered> fo2 = new ArrayList<foodOrdered>();
        public static ArrayList<Staff> staff = new ArrayList<Staff>();
        public static Scanner scan = new Scanner(System.in);
        public static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    
           public static void checkOrders(int id) {
               
            for (int i = 0; i < od.size(); i++) {
                    if (id == (od.get(i).getStaffID())) {
               
                System.out.println("-------------------------------------------------------");
                System.out.println("Order ID :" + od.get(i).getOrderID());
                System.out.println("Restaurant ID :" + od.get(i).getResID());
                System.out.println("Restaurant name :" + od.get(i).getResName());
                System.out.println("Customer name :" + od.get(i).getCustomerName());
                System.out.println("Delivery address :" + od.get(i).getCustomerAdd());
                System.out.println("Customer hp no. :" + od.get(i).getCustNo());
                System.out.println("\nFood ordered");

                List<foodOrdered> foo = od.get(i).getFood();
                for (int j = 0; j < foo.size(); j++) {
                    System.out.println(foo.get(j).getFood() + " x" + foo.get(j).getQuantity());
                }
                System.out.println("-------------------------------------------------------");
            }
            }
           }
    
    
    public static void checkIn(int id) {
        String confirm;
        Date cal= Calendar.getInstance().getTime();
        String date=dateFormat.format(cal);
        
        for (int i=0;i<staff.size();i++){
            if(id==staff.get(i).getID()){
        System.out.println("\nCurrent date & time: "+date);
        System.out.println("\nConfirm check in (Y/N)");
        confirm=scan.nextLine().toUpperCase();
        if(confirm.equals("Y") || confirm.equals("YES")){
            staff.get(i).setCheckIn(date);
            staff.get(i).setAvailability("Available");
            System.out.println("Successfully checked in.");
            
        }
        }
             
        }
   
    }
    public static void checkOut(int id) {
        String confirm;
        Date cal= Calendar.getInstance().getTime();
        String date=dateFormat.format(cal);
        Date date1;
        Date date2;
        String checkIn;
        for (int i=0;i<staff.size();i++){
        if(id==staff.get(i).getID()){
        System.out.println("\nCurrent date & time: "+date);
        System.out.println("Checked in time: "+staff.get(i).getCheckIn());
        
        System.out.println("\nConfirm check out (Y/N)");
        
        confirm=scan.nextLine().toUpperCase();
        if(confirm.equals("Y") || confirm.equals("YES")){
            staff.get(i).setCheckOut(date);
            staff.get(i).setAvailability("Unavailable");
            checkIn=staff.get(i).getCheckIn();
            try{
            date1=dateFormat.parse(checkIn);
            date2=dateFormat.parse(date);
            
            long diff=date2.getTime()- date1.getTime();
            long diffMinutes = diff / (60 * 1000) % 60;
	    long diffHours = diff / (60 * 60 * 1000) % 24;
	   
            System.out.println("Successfully checked out.");
            System.out.println("Duration worked: "+diffHours+" hours "+diffMinutes+" minutes ");
            }catch(ParseException e){
                e.printStackTrace();
            }
            
;
        }
        }
              
        }
    }
    
    public static void updateAvailability(int id) {
        int select;
         for (int i=0;i<staff.size();i++){
        if(id==staff.get(i).getID()){
            System.out.println("\nCurrent status:"+staff.get(i).getAvailability());
            System.out.println("Select new status");
            System.out.println("1.Break");
            System.out.println("2.Available");
            System.out.println("0.Exit");
            select=scan.nextInt();
            if(select ==1){
                staff.get(i).setAvailability("On Break");
            }else if (select==2){
                staff.get(i).setAvailability("Available");
            }else if (select==0){
                break;
            }else{
                System.out.println("\nIncorrect selection");
                break;
            }
            
        }
        }
    }
           
           
    public static void main(String[] args) throws IOException {

        foodOrdered foodDetail = new foodOrdered(2001, "Nasi lemak", 1,0.0);
        foodOrdered foodDetail1 = new foodOrdered(2001, "Burger", 1,0.0);
        foodOrdered foodDetail2 = new foodOrdered(2001, "Kopi ice", 1,0.0);
        foodOrdered foodDetail3 = new foodOrdered(2002, "Roti bakar", 2,0.0);
        foodOrdered foodDetail4 = new foodOrdered(2002, "Telur", 2,0.0);
        foodOrdered foodDetail5 = new foodOrdered(2002, "Milo ais", 2,0.0);
        foodOrdered foodDetail6 = new foodOrdered(2002, "Roti telur", 3,0.0);
        foodOrdered foodDetail7 = new foodOrdered(2002, "Telur", 3,0.0);
        foodOrdered foodDetail8 = new foodOrdered(2002, "Limau ais", 3,0.0);

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
        
        Staff Staff1= new Staff(1001,"Alex","Unavailable");
        Staff Staff2= new Staff(1002,"Jordan","Available");
        staff.add(Staff1);
        staff.add(Staff2);
        
        int input;

        System.out.print("Enter staff ID : ");
        input = scan.nextInt();
        for (int i = 0; i < staff.size(); i++) {
            if (input == (staff.get(i).getID())) {
                int select;
                int id=staff.get(i).getID();
        do {
            System.out.println("\nStaff name: "+staff.get(i).getName());
            System.out.println("Availability: "+staff.get(i).getAvailability());
            System.out.println("\n\n-Staff module-");
            System.out.println("1. Check in");
            System.out.println("2. Check out");
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
 
}
}