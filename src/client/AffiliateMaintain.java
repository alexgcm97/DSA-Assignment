package client;


import domain.Affiliate;
import domain.Menu;
import static java.lang.Integer.parseInt;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import adt.AffiliateADT;
import adt.AffiliateInterface;
import adt.MenuSortingADT;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
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
 * @author Julian
 */
public class AffiliateMaintain<T extends Comparable<? super T>> {
    
    public static String currentDate ;
    public static Scanner scan = new Scanner(System.in);
    private static  AffiliateInterface<Menu> menuList = new AffiliateADT<Menu>();
    private final static Menu Menus = new Menu();
    public static AffiliateInterface<Affiliate> Affialiates = new AffiliateADT<Affiliate>();
    
    
    private static int getIntInput() {
        //Method use to validate integer input & print error if invalid
        int input;
        while (!scan.hasNextInt()) {
            System.out.println("Error input. Please input a valid digit.");
            System.out.print("Enter a valid Value: ");
            scan.next();
        }
        input = scan.nextInt();
        scan.nextLine();
        return input;
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
    
    
    public static void showMenu(){
        
        System.out.println("--Food Menu--");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("|No.|  Food Name  |         Description             | Price |Availability|");
        System.out.println("--------------------------------------------------------------------------");
        for(int i=0; i<menuList.getSize();i++){
            System.out.printf("|%-3d|%-13s|%-33s|RM%-5.2f|    %-8s|\n",(i+1),menuList.getPositionData(i).getFood()
                    ,menuList.getPositionData(i).getFoodDesc()
                    ,menuList.getPositionData(i).getPrice()
                    ,menuList.getPositionData(i).getStock());
        }
        
        System.out.println("---------------------------");
        
        
    }
    
    public static boolean isValidICNo(String icNo){
        Pattern pattern = Pattern.compile("([0-9]{2})((0[1-9])|(1[0-2]))((0[1-9])|([1-2][0-9])|(3[0-1]))\\-([0-9][0-9])\\-([0-9][0-9][0-9][0-9])");
        Matcher matcher = pattern.matcher(icNo);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
        
    }
    
    public static void getDate(){
        
        GregorianCalendar date = new GregorianCalendar();
        int month = date.get(Calendar.MONTH);
        month = month+1;
        switch (month){
            case 1:
                currentDate = ""+date.get(Calendar.DATE)+"-JAN-"+date.get(Calendar.YEAR);
                break;
            case 2:
                currentDate = ""+date.get(Calendar.DATE)+"-FEB-"+date.get(Calendar.YEAR);
                break;
            case 3:
                currentDate = ""+date.get(Calendar.DATE)+"-MAR-"+date.get(Calendar.YEAR);
                break;
            case 4:
                currentDate = ""+date.get(Calendar.DATE)+"-APR-"+date.get(Calendar.YEAR);
                break;
            case 5:
                currentDate = ""+date.get(Calendar.DATE)+"-MAY-"+date.get(Calendar.YEAR);
                break;
            case 6:
                currentDate = ""+date.get(Calendar.DATE)+"-JUN-"+date.get(Calendar.YEAR);
                break;
            case 7:
                currentDate = ""+date.get(Calendar.DATE)+"-JUL-"+date.get(Calendar.YEAR);
                break;
            case 8:
                currentDate = ""+date.get(Calendar.DATE)+"-AUG-"+date.get(Calendar.YEAR);
                break;
            case 9:
                currentDate = ""+date.get(Calendar.DATE)+"-SEP-"+date.get(Calendar.YEAR);
                break;
            case 10:
                currentDate = ""+date.get(Calendar.DATE)+"-OCT-"+date.get(Calendar.YEAR);
                break;
            case 11:
                currentDate = ""+date.get(Calendar.DATE)+"-NOV-"+date.get(Calendar.YEAR);
                break;
            case 12:
                currentDate = ""+date.get(Calendar.DATE)+"-DEC-"+date.get(Calendar.YEAR);
                break;
        };
        
        
        
    }
    
    public static void loginAffialiate(){
        String id;
        String pass;
        boolean ToF = false;
        do
        {
            ToF = false;
            System.out.println("--Login--");
            System.out.println("-----------");
            System.out.printf("Login ID :");
            id = scan.nextLine();
            System.out.printf("Password :");
            pass = scan.nextLine();
            
            Affiliate temp = Affialiates.getData();
            int i = 0;
            while(temp.getUserName().compareTo(id) != 0 && i < Affialiates.getSize())
            {
                temp = Affialiates.getPositionData(i);
                i++;
            }
            
            if(temp.getPassword().compareTo(pass) != 0)
            {
                
                System.out.println("Invalid ID or Password");
                ToF =true ;
            }
            System.out.println("Successful logged in");
        }while(ToF);
        
    }
    
    
    
    
    public static void registerAffialiate(){
        boolean ToF;
        String tryAgain = "" ;
        String input;
        
        Affiliate temp = new Affiliate();
        
        getDate();
        
        temp.setJoinDate(currentDate);
        
        do{
            System.out.println("\n --Register As Affiliates--");
            System.out.println("-----------------------------");
            System.out.println("--Company Information--");
            System.out.print("Company Name :");
            
            temp.setCompanyName(scan.nextLine());
            
            System.out.print("Business License Number:");
            temp.setLicenseNumber(getIntInput());
            
            
            
            System.out.print("Company Address :");
            temp.setAddress(scan.nextLine());
            
            System.out.print("Business Type :");
            temp.setCompanyType(scan.nextLine());
            
            
            System.out.println("\n\n--Owner Information--");
            System.out.println("-----------------------------");
            System.out.print("Full Name :");
            temp.setOwnerName(scan.nextLine());
            
            do{
                ToF = true;
                
                
                System.out.print("I/C No.(971231-XX-XXXX) :");
                temp.setOwnerICNumb(scan.nextLine());
                
                if(!isValidICNo(temp.getOwnerICNumb())){
                    ToF = false;
                    System.out.println("Invalid IC format.(971231-XX-XXXX)");
                }
                
            }while(ToF == false);
            
            do{
                ToF = false;
                System.out.print("Gender (M/F) :");
                input = scan.nextLine();
                if(input.equalsIgnoreCase("M") || input.equalsIgnoreCase("F")){
                    temp.setOwnerGender(input);
                }
                else{
                    ToF = true;
                    System.out.println("Error input. Please enter your gender again.");
                }
            }while(ToF == true);
            
            System.out.print("Owner Address :");
            temp.setOwnerAddress(scan.nextLine());
            
            do {
                System.out.print("Phone No.(xxx-xxxxxxx) : ");
                input = scan.nextLine();
                if (!comparePhoneNo(input)) {
                    System.out.println("Invalid Phone Number Format!");
                }else{
                    temp.setOwnerPhoneNumber(input);
                }
            } while (!comparePhoneNo(input));
            
            
            System.out.println("\n\n\n");
            System.out.println("--Verify Information Entered--");
            System.out.println("Company Name :"+temp.getCompanyName());
            System.out.println("Business License Number:"+temp.getLicenseNumber());
            System.out.println("Company Address :"+temp.getCompanyaddress());
            System.out.println("Business Type :"+temp.getCompanyType());
            System.out.println("Owner Name :"+temp.getOwnerName());
            System.out.println("I/C No. :"+temp.getOwnerICNumb());
            System.out.println("Gender :"+temp.getOwnerGender());
            System.out.println("Ownder Address :"+temp.getOwnerAddress());
            System.out.println("Phone No. :"+temp.getOwnerPhoneNumber());
            System.out.println("------------------------------------------------");
            
            tryAgain = "n";
            
            do{
                if(!tryAgain.equalsIgnoreCase("n") && !tryAgain.equalsIgnoreCase("y")){
                    System.out.println("Error Input. Please enter Y or N only.");
                }
                System.out.printf("Are all information entered correctly? Y/N :");
                tryAgain = scan.nextLine();
                
            }while(!tryAgain.equalsIgnoreCase("n") && !tryAgain.equalsIgnoreCase("y"));
            
            if(tryAgain.equalsIgnoreCase("y")){
                System.out.println("\n\n\n --Information for Login--");
                System.out.println("--------------------");
                ToF = false;
                do
                {
                    if(ToF)
                    {
                        System.out.println("User ID already exist.Please Re-enter.");
                    }
                    ToF = false;
                    System.out.print("User ID :");
                    temp.setUserName(scan.nextLine());
                    
                    Affiliate tempCheck = Affialiates.getData();
                    int i = 0;
                    while(i < Affialiates.getSize())
                    {
                        if(tempCheck.getUserName().compareTo(temp.getUserName()) == 0){
                            ToF = true;
                            break;
                        }
                        tempCheck = Affialiates.getPositionData(i);
                        i++;
                    }
                    
                }while(ToF);
                
                ToF = false;
                do{
                    if(ToF == true){
                        System.out.println("Password not match. Please re-enter");
                    }
                    System.out.print("Password :");
                    temp.setPassword(scan.nextLine());
                    
                    System.out.print("Re-Enter Password :");
                    ToF = !scan.nextLine().equals(temp.getPassword());
                    
                }while(ToF);
                break;
            } else if (tryAgain.equalsIgnoreCase("n")){
                break;
            }
            
            
        }while(tryAgain.equalsIgnoreCase("n"));
        Affialiates.add(temp);
        
    }
    public static void addNewMenuItem(){
        String again;
        boolean ToF ;
        String newFoodName;
        String foodPrice;
        String YoN;
        
        showMenu();
        do{
            System.out.println("***Insert New Menu Item****");
            System.out.println("---------------------------");
            
            System.out.println("Food ID  : "+(menuList.getSize()+1));
            Menus.setFoodId(menuList.getSize()+1);
            
            do{
                System.out.print("Food Name: ");
                ToF = false;
                newFoodName = scan.nextLine();
                if(newFoodName.matches(".*\\d.*")){
                    System.out.println("Input contains Integer or Symbol.Please Re-enter.");
                }
                else{
                    Menus.setFood(newFoodName);
                    break;
                }
            }while(ToF == false);
            
            System.out.print("Food Description: ");
            Menus.setFoodDesc(scan.nextLine());
            
            do{
                System.out.print("Price: ");
                ToF = false;
                foodPrice = scan.nextLine();
                if(foodPrice.matches("[0-9]{1,}") || foodPrice.matches("[0-9]{1,}.[0-9][05]")){
                    Menus.setPrice(Double.parseDouble(foodPrice));
                    break;
                }
                else{
                    System.out.println("Error input price. Please enter a valid price (eg. 1.50 or 1)");
                    
                }
                
            }while(ToF == false);
            
            do{
                System.out.printf("Set Availability? Y/N :");
                YoN = scan.next();
                if(YoN.equalsIgnoreCase("Y")){
                    Menus.setStock("Yes");
                    scan.nextLine();
                    break;
                    
                }else if(YoN.equalsIgnoreCase("N")){
                    Menus.setStock("No");
                    scan.nextLine();
                    break;
                }else{
                    System.out.println("Error Input, Please Enter Y or N only");
                    ToF = false;
                }
            }while(ToF == false);
            
            
            menuList.add(new Menu(Menus.getFood(),Menus.getFoodDesc(),Menus.getPrice(),Menus.getStock()));
            
            System.out.println("\n\n***Updated Menu****");
            showMenu();
            
            do{
                System.out.printf("Do you wish to add more new item? Y/N :");
                again = scan.nextLine();
                if(again.equalsIgnoreCase("y")){
                    ToF = true;
                    break;
                }else if(again.equalsIgnoreCase("n")){
                    ToF = false;
                    break;
                }else
                    System.out.println("Error input. Please Re-enter.");
                ToF = false;
            }while(ToF == false);
        }while(ToF == true);
        
    }
    
    
    public static void updateMenuItem(){
        int selection;
        boolean ToF;
        String foodPrice;
        String YoN;
        String input;
        
        
        do{
            showMenu();
            System.out.println("\n\n***Update Menu Item****");
            System.out.println("---------------------------");
            do{
                ToF = false;
                System.out.printf("Item Number want to update :");
                selection = scan.nextInt();
                if(selection > menuList.getSize()){
                    System.out.println("\n\n------------------------------------------------");
                    System.out.println("Invalid Selection. Please re-enter.");
                    ToF = false;
                }
                else
                    ToF = true;
            }while(ToF == false);
            
            selection--;
            scan.nextLine();
            do{
                System.out.println("------------------------------------------------");
                System.out.println("Food ID :"+menuList.getPositionData(selection).getFoodId());
                System.out.println("Food Name :"+menuList.getPositionData(selection).getFood());
                System.out.println("1.Food Description :"+menuList.getPositionData(selection).getFoodDesc());
                System.out.println("2.Price :"+menuList.getPositionData(selection).getPrice());
                System.out.println("3.Availability :"+menuList.getPositionData(selection).getStock());
                System.out.println("------------------------------------------------\n");
                System.out.println("*** Food ID and Food Name can't be changed!! ***");
                // System.out.println("Description From: "+menuList.get(selection).getFoodDesc());
                //System.out.printf("To :");
                //Menus.setFoodDesc(scan.nextLine());
                
                System.out.printf("Enter number you wish to update :");
                input=scan.nextLine();
                switch(input){
                    case "1":
                        System.out.println("Description From: "+menuList.getPositionData(selection).getFoodDesc());
                        System.out.printf("To :");
                        menuList.getPositionData(selection).setFoodDesc(scan.nextLine());
                        break;
                    case "2":
                        do{
                            System.out.println("Price From: RM"+menuList.getPositionData(selection).getPrice());
                            System.out.printf("To : RM");
                            ToF = false;
                            foodPrice = scan.nextLine();
                            if(foodPrice.matches("[0-9]{1,}") || foodPrice.matches("[0-9]{1,}.[0-9][05]")){
                                menuList.getPositionData(selection).setPrice(Double.parseDouble(foodPrice));
                                break;
                            }
                            else{
                                System.out.println("Error input price. Please enter a valid price (eg. 1.50 or 1)");
                                
                            }
                            
                        }while(ToF == false);
                        break;
                    case "3":
                        do{
                            
                            System.out.println("Availability :"+menuList.getPositionData(selection).getStock());
                            System.out.println("Set Availability? Y/N");
                            YoN = scan.next();
                            if(YoN.equalsIgnoreCase("Y")){
                                menuList.getPositionData(selection).setStock("Yes");
                                break;
                            }else if(YoN.equalsIgnoreCase("N")){
                                menuList.getPositionData(selection).setStock("No");
                                break;
                            }else{
                                System.out.println("Error Input, Please Enter Y or N only");
                                ToF = false;
                            }
                        }while(ToF == false);
                        break;
                    default:
                        System.out.println("Invalid Input, Please enter 1 , 2 or 3 only.");
                }
                System.out.printf("Do you wish to update another data field for "+menuList.getPositionData(selection).getFood()+"? Y/N :");
                YoN = scan.nextLine();
            }while(YoN.equalsIgnoreCase("y"));
            
            showMenu();
            System.out.println("Do you wish to update other food? Y/N :");
            YoN = scan.nextLine();
        }while(YoN.equalsIgnoreCase("y"));
        
        
    }
    
    public static void removeMenuItem(){
        boolean ToF ;
        int selection = 0;
        String again;
        String YoN;
        do{
            showMenu();
            System.out.println("\n\n***Remove Menu Item****");
            System.out.println("---------------------------");
            
            do{
                ToF = false;
                do{
                    if(ToF == true){
                        showMenu();
                        System.out.println("***Error Input Selection****");
                        System.out.print("Please re-enter Food ID want to Remove :");
                        selection = scan.nextInt()-1;
                    }
                    else{
                        System.out.printf("Food ID want to Remove :");
                        selection = scan.nextInt()-1;
                    }
                    
                    ToF = (selection >= menuList.getSize() || selection < 0);
                }while(ToF);
                
                System.out.println("------------------------------------------------");
                System.out.print("Are you sure you want to remove "+menuList.getPositionData(selection).getFood()
                        +" from the list? (Y/N) :");
                scan.nextLine();
                YoN = scan.nextLine();
                do{
                    if(YoN.equalsIgnoreCase("y")){
                        menuList.remove(selection);
                        showMenu();
                        ToF = true;
                        break;
                    }
                    else if(YoN.equalsIgnoreCase("n")){
                        do{
                            showMenu();
                            System.out.print("Please Re-enter Food ID want to remove :");
                            selection = scan.nextInt()-1;
                            while(selection >= menuList.getSize() || selection < 0){
                                showMenu();
                                System.out.println("***Error Input Selection****");
                                System.out.print("Please re-enter Food ID want to Remove :");
                                selection = scan.nextInt()-1;
                            }
                            scan.nextLine();
                            System.out.println("------------------------------------------------");
                            System.out.print("Are you sure you want to remove "+menuList.getPositionData(selection).getFood()
                                    +" from the list? (Y/N) :");
                            YoN=scan.nextLine();
                        }while(!YoN.equals("y"));
                        menuList.remove(selection);
                        showMenu();
                        ToF = true;
                        break;
                    }
                    System.out.println("------------------------------------------------");
                    System.out.println("Are you sure you want to remove "+menuList.getPositionData(selection).getFood()
                            +" from the list?");
                    System.out.print("Error Input Please Re-enter (Y/N) :");
                    YoN = scan.nextLine();
                }while(ToF == false);
            }while(ToF == false);
            System.out.println("Successfully Remove Item from Menu");
            System.out.print("Do you wish to remove another item? Y/N :");
            again = scan.nextLine();
        }while(again.equalsIgnoreCase("y"));
    }
    
    public static void sortMenuItem(){
        MenuSortingADT list = new MenuSortingADT();
        boolean ToF = false;
        do{
            
            showMenu();
            System.out.println("\n\n***Sort Menu Item****");
            System.out.println("---------------------------");
            System.out.println("1.Sort by Price");
            System.out.println("2.Sort by Availability");
            System.out.println("---------------------------");
            if(ToF){
                System.out.println("Error Input selection. Please re-enter");
            }
            System.out.printf("Enter sorting choice :");
            switch(scan.nextLine()){
                case "1":
                    list.bubble_sortPrice((AffiliateADT<Menu>) menuList);
                    System.out.println("--Food Menu Sorted By Price(High to Low)--");
                    System.out.println("--------------------------------------------------------------------------");
                    System.out.println("|No.|  Food Name  |         Description             | Price |Availability|");
                    System.out.println("--------------------------------------------------------------------------");
                    for(int i=0; i<menuList.getSize();i++){
                        System.out.printf("|%-3d|%-13s|%-33s|RM%-5.2f|    %-8s|\n",(i+1),menuList.getPositionData(i).getFood()
                                ,menuList.getPositionData(i).getFoodDesc()
                                ,menuList.getPositionData(i).getPrice()
                                ,menuList.getPositionData(i).getStock());
                    }
                    
                    System.out.println("---------------------------");
                    ToF = false;
                    break;
                    
                case "2":
                    list.bubble_sortAvailability((AffiliateADT<Menu>) menuList);
                    System.out.println("--Food Menu Sorted By Availability (Yes, then only No)--");
                    System.out.println("--------------------------------------------------------------------------");
                    System.out.println("|No.|  Food Name  |         Description             | Price |Availability|");
                    System.out.println("--------------------------------------------------------------------------");
                    for(int i=0; i<menuList.getSize();i++){
                        System.out.printf("|%-3d|%-13s|%-33s|RM%-5.2f|    %-8s|\n",(i+1),menuList.getPositionData(i).getFood()
                                ,menuList.getPositionData(i).getFoodDesc()
                                ,menuList.getPositionData(i).getPrice()
                                ,menuList.getPositionData(i).getStock());
                    }
                    
                    System.out.println("---------------------------");
                    ToF = false;
                    break;
                default :
                    
                    ToF = true;
                    break;
            }
        }while(ToF);
    }
    
    
    public static void main(String[] args) {
        
        menuList.add(new Menu("Roti Canai","Plain Paratha Bread",1.00,"Yes"));
        menuList.add(new Menu("Roti A Telur","Paratha Bread cooked with egg",1.70,"Yes"));
        
        menuList.add(new Menu("Roti Cheese","Paratha Bread cooked with cheese",2.50,"Yes"));
        menuList.add(new Menu("Roti Bawang","Paratha Bread cooked with onion",1.50,"No"));
        menuList.add(new Menu("Roti Planta","Paratha Bread cooked with planta",3.00,"No"));
        
        Affialiates.add(new Affiliate(1001,"Moi Restaurant","1, Jalan Duta 2, 55100 KL"
                ,"Restaurant","25-DEC-2016","MoMoi","M","970503-35-1234","2, Jalan Bunga 3, 55100 KL","012-3322132","Moi","1234"));
        
        int selection;
        boolean YoN = false;
        String Again;
        String start;
        boolean login = false;
        /*
        do{
        //login
        //register
        }while();
        */
        //if(login==true){
        do{
            System.out.println("--Restaurant Owner Module--");
            System.out.println("----------------------------");
            System.out.println("1.Affiliate login.");
            System.out.println("2.Register as an affiliate.");
            System.out.println("0.Exit");
            System.out.println("----------------------------");
            System.out.printf("Enter Selection :");
            start = scan.nextLine();
            switch(start){
                case "1":
                    if(!Affialiates.isEmpty()){
                        loginAffialiate();
                        login = true;
                        YoN = false;
                    }
                    break;
                case "2":
                    registerAffialiate();
                    YoN = true;
                    break;
                case "0":
                    YoN = false;
                    break;
                default:
                    YoN = true;
            }
        }while(YoN);
        
        if(login){
            do{
                
                do{
                    System.out.println("--List of Function--");
                    System.out.println("----------------------------");
                    System.out.println("1.Add New Menu Items");
                    System.out.println("2.Update Menu Items");
                    System.out.println("3.Remove Menu Items");
                    System.out.println("4.Sort Menu Items");
                    System.out.println("0.Exit");
                    System.out.println("---------------------------");
                    System.out.print("Enter your Selection :");
                    selection = getIntInput();
                    YoN =true;
                    switch(selection){
                        case 1:
                            addNewMenuItem();
                            break;
                        case 2:
                            updateMenuItem();
                            break;
                        case 3:
                            removeMenuItem();
                            break;
                        case 4:
                            sortMenuItem();
                            break;
                        case 0:
                            break;
                        default:
                            YoN = false;
                            System.out.println("Error Input, Please enter 1 , 2 , 3 or 0 only.");
                    }
                    
                }while(YoN == false);
                
                YoN = false;
                do{
                    if(YoN){
                        System.out.println("Error input. Please enter Y/N only.");
                    }
                    System.out.printf("Do you want to do another transaction? Y/N :");
                    Again = scan.nextLine();
                    YoN = (!Again.equalsIgnoreCase("y")&&!Again.equalsIgnoreCase("n"));
                    
                    
                }while(YoN);
            }while(Again.equalsIgnoreCase("y"));
            // }
        }
        
        System.out.println("Thanks for using our system.");
        
    }
    
}
