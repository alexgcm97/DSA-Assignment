package client;


import domain.Affiliate;
import domain.Menu;
import static java.lang.Integer.parseInt;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Julian
 */
public class AffiliateRegisteration {

    public static String currentDate ;
    public static Scanner scan = new Scanner(System.in);
    private static  List<Menu> menuList = new ArrayList<Menu>();
    private final static Menu Menus = new Menu();
    
    
    
    
     public static void showMenu(){
     
         System.out.println("--Food Menu--");
         System.out.println("--------------------------------------------------------------------------");
         System.out.println("|No.|  Food Name  |         Description             |Price |Availability|");
         System.out.println("--------------------------------------------------------------------------");
         for(int i=0; i<menuList.size();i++){
             System.out.println("|"+ (i+1) +". |"+menuList.get(i).getFood()+
                     "|"+menuList.get(i).getFoodDesc()+
                     "|RM"+menuList.get(i).getPrice()+
                     " | "+menuList.get(i).getStock()+" |");
             
         }
         
         System.out.println("---------------------------");
         
         
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
    
    
  
    
    public static void registerAffialiate(){
         List<Affiliate> Affialiates = new ArrayList<Affiliate>();
        boolean ToF; 
        String tryAgain ;
       
        Affiliate regAffiliate = new Affiliate();
        getDate();
        
        regAffiliate.setJoinDate(currentDate);
        
        do{
            System.out.println("\n --Register As Affiliates--");
            System.out.println("-----------------------------");
            System.out.println("--Company Information--");
            System.out.print("Company Name :");
            regAffiliate.setCompanyName(scan.nextLine());
            
            do{
                ToF = true;
                try{

                System.out.print("Business License Number:");
                regAffiliate.setLicenseNumber(scan.nextInt());
                break;

                }catch(Exception  e){
                    System.out.println("Please enter Number only.");
                    scan.nextLine();
                    ToF = false;
                }
            }while(!ToF);
            
            scan.nextLine();
            System.out.print("Company Address :");
            regAffiliate.setAddress(scan.nextLine());
            
            System.out.print("Business Type :");
            regAffiliate.setCompanyType(scan.nextLine());
            
           
            System.out.println("\n\n--Owner Information--");
            System.out.println("-----------------------------");
            System.out.print("Full Name :");
            regAffiliate.setOwnerName(scan.nextLine());
          
            do{
                ToF = true;
                try{

                System.out.print("I/C No. :");
                regAffiliate.setOwnerICNumb(scan.nextInt());

                }catch(Exception  e){
                    System.out.println("Please enter Number only!.");
                    scan.nextLine();
                    ToF = false;
                }
            }while(ToF = false);
            
            scan.nextLine();
            System.out.print("Gender :");
            regAffiliate.setOwnerGender(scan.nextLine());
            
            System.out.print("Owner Address :");
            regAffiliate.setOwnerAddress(scan.nextLine());
            
            System.out.print("Phone No. :");
            regAffiliate.setOwnerPhoneNumber(scan.nextLine());
            
            do{
                System.out.println("\n\n\n");
                System.out.println("--Verify Information Entered--");
                System.out.println("Company Name :"+regAffiliate.getCompanyName());
                System.out.println("Business License Number:"+regAffiliate.getLicenseNumber());
                System.out.println("Company Address :"+regAffiliate.getCompanyaddress());
                System.out.println("Business Type :"+regAffiliate.getCompanyType());
                System.out.println("Owner Name :"+regAffiliate.getOwnerName());
                System.out.println("I/C No. :"+regAffiliate.getOwnerICNumb());
                System.out.println("Gender :"+regAffiliate.getOwnerGender());
                System.out.println("Ownder Address :"+regAffiliate.getOwnerAddress());
                System.out.println("Phone No. :"+regAffiliate.getOwnerPhoneNumber());
                System.out.println("------------------------------------------------");
                System.out.println("Are all information entered correctly? Y/N");
                tryAgain = scan.nextLine();
                
                if(tryAgain.equalsIgnoreCase("y")){
                    System.out.println("\n\n\n --For Login--");
                    System.out.println("--------------------");
                    System.out.print("User ID :");
                    regAffiliate.setUserName(scan.next());
                    scan.nextLine();
                    do{
                        System.out.print("Password :");
                        regAffiliate.setPassword(scan.nextLine());
                        
                        System.out.print("Re-Enter Password :");
                    }while(!scan.nextLine().equals(regAffiliate.getPassword()));
                    break;
                } else if (tryAgain.equalsIgnoreCase("n")){
                    break;
                }
                
            }while(!tryAgain.equalsIgnoreCase("n") && !tryAgain.equalsIgnoreCase("y"));
        }while(tryAgain.equalsIgnoreCase("n"));
        Affialiates.add(regAffiliate);
        
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

            System.out.println("Food ID  : "+(menuList.size()+1));
            Menus.setFoodId(menuList.size()+1);
            scan.nextLine();
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
                if(!foodPrice.matches(".*\\d.*")){
                    System.out.println("Input contains Character or Symbol. Please Re-enter.");
                }
                else{
                    Menus.setPrice(Double.parseDouble(foodPrice));
                    break;
                }

            }while(ToF == false);
            
            do{
                 System.out.println("Set Availability? Y/N");
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
           
      
            menuList.add(new Menu(Menus.getFoodId(),Menus.getFood(),Menus.getFoodDesc(),Menus.getPrice(),Menus.getStock()));

            System.out.println("\n\n***Updated Menu****");
            showMenu();
           
            do{
                System.out.println("Do you wish to add more new item? Y/N");
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
        String updateMenu;
        
        
       
        showMenu();
        System.out.println("\n\n***Update Menu Item****");
        System.out.println("---------------------------");
        do{
            ToF = false;
            System.out.printf("Item Number want to update :");
            selection = scan.nextInt();
            if(selection > menuList.size()){
                System.out.println("\n\n------------------------------------------------");
               System.out.println("Invalid Selection. Please re-enter.");
               ToF = false;
            }
            else
                ToF = true;
        }while(ToF == false);
       
        selection--;
        scan.nextLine();
        System.out.println("------------------------------------------------");
        System.out.println("Food ID : "+menuList.get(selection).getFoodId());
        System.out.println("Food Name: "+menuList.get(selection).getFood());
        System.out.println("*** Food ID and Food Name can't be changed!! ***");
        
        System.out.println("\n\n------------------------------------------------");
        System.out.println("Description From: "+menuList.get(selection).getFoodDesc());
        System.out.printf("To :");
        Menus.setFoodDesc(scan.nextLine());
        
        
        do{
            
            ToF = false;
            System.out.println("\n\n------------------------------------------------");
            System.out.println("Price From: RM"+menuList.get(selection).getPrice());
            System.out.printf("To : RM");
            foodPrice = scan.nextLine();
            if(!foodPrice.matches(".*\\d.*")){
                
                System.out.println("Input contains Character or Symbol. Please Re-enter.");
            }
            else{
                Menus.setPrice(Double.parseDouble(foodPrice));
                break;
            }
        }while(ToF == false);
        
        do{
            System.out.println("\n\n------------------------------------------------");
            System.out.println("Availability :"+menuList.get(selection).getStock());
            System.out.println("Set Availability? Y/N");
            YoN = scan.next();
                if(YoN.equalsIgnoreCase("Y")){
                    Menus.setStock("Yes");
                    break;
                }else if(YoN.equalsIgnoreCase("N")){
                    Menus.setStock("No");
                    break;
                }else{
                    System.out.println("Error Input, Please Enter Y or N only");
                    ToF = false;
                }
        }while(ToF == false);
        
        Menus.setFoodId(menuList.get(selection).getFoodId());
        Menus.setFood(menuList.get(selection).getFood());
        updateMenu = Menus.getFoodId()+Menus.getFood()+Menus.getFoodDesc()+Menus.getPrice()+Menus.getStock();
        
        
        
        menuList.remove(selection);
        menuList.add(selection, Menus);
        
        showMenu();
            
    }
    
    public static void removeMenuItem(){
        boolean ToF ;
        int selection;
        String again;
        String YoN;
        do{
            showMenu();
            System.out.println("\n\n***Remove Menu Item****");
            System.out.println("---------------------------");

            do{
                ToF = false;
                System.out.printf("Food ID want to Remove :");
                selection = scan.nextInt()-1;
                while(selection >= menuList.size() || selection < 0){
                    showMenu();
                    System.out.println("***Error Input Selection****");
                    System.out.print("Please re-enter Food ID want to Remove :");
                    selection = scan.nextInt()-1;
                }
                System.out.println("------------------------------------------------");
                System.out.print("Are you sure you want to remove "+menuList.get(selection).getFood()
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
                            while(selection >= menuList.size() || selection < 0){
                                showMenu();
                                System.out.println("***Error Input Selection****");
                                System.out.print("Please re-enter Food ID want to Remove :");
                                selection = scan.nextInt()-1;
                            }
                            scan.nextLine();
                            System.out.println("------------------------------------------------");
                            System.out.print("Are you sure you want to remove "+menuList.get(selection).getFood()
                                +" from the list? (Y/N) :");
                            YoN=scan.nextLine();
                        }while(!YoN.equals("y"));
                        menuList.remove(selection);
                        showMenu();
                        ToF = true;
                        break;
                    }
                    System.out.println("------------------------------------------------");
                    System.out.println("Are you sure you want to remove "+menuList.get(selection).getFood()
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
   
  
    public static void main(String[] args) {
        menuList.add(new Menu(1,"Roti Canai.  ","Plain Paratha Bread              ",1.00,"Yes       "));
         menuList.add(new Menu(2,"Roti Bawang. ","Paratha Bread cooked with onion  ",1.50,"No        "));
         menuList.add(new Menu(3,"Roti Telur.  ","Paratha Bread cooked with egg    ",1.70,"No        "));
         menuList.add(new Menu(4,"Roti Planta. ","Paratha Bread cooked with planta ",2.00,"Yes       "));
         
         int selection;
         boolean YoN = false;
         
   
      
       
        do{
            System.out.println("--List of Function--");
            System.out.println("----------------------------");
            System.out.println("1.Register As An Affiliates");
            System.out.println("2.Add New Menu Items");
            System.out.println("3.Update Menu Items");
            System.out.println("4.Remove Menu Items");
            System.out.println("0.Exit");
            System.out.println("---------------------------");
            System.out.print("Enter your Selection :");
            selection = scan.nextInt();
            if(selection>-1 && selection<5){
                switch(selection){
                    case 1: 
                        registerAffialiate();
                        break;
                    case 2:
                        addNewMenuItem();
                        break;
                    case 3:
                        updateMenuItem();
                        break;
                    case 4:
                        removeMenuItem();
                        break; 
                    case 0:
                        break;
                }
                YoN =true;
            }else{
                YoN = false;
                System.out.println("Error Input, Please enter 1 , 2 ,3 or 0 only.");
            }
            
        }while(YoN == false);
       
    }
    
}
