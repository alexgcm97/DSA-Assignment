/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class MainMenu {

    public static void main(String[] args) throws IOException, ParseException {
        Scanner scan = new Scanner(System.in);
        int input = 0;
        do {
            System.out.println("\n\n\n\n=====Main Menu=====");
            System.out.println("1. Restaurant Owner Module");
            System.out.println("2. HR Executive Module ");
            System.out.println("3. Customer Module");
            System.out.println("4. DeliveryMan Module");
            System.out.println("0. Exit");
            System.out.print("Input Selection: ");
            input = scan.nextInt();
            scan.nextLine();
            switch (input) {
                case 0:
                    break;
                case 1:
                    AffiliateMaintain.main(args);
                    break;
                case 2:
                    MaintainStaff.main(args);
                    break;
                case 3:
                    MakeOrder.main(args);
                    break;
                case 4:
                    CheckOrder.main(args);
                    break;
                default:
                    System.out.println("Invalid Selection");
            }
        } while (input != 0);

    }
}
