package com.techelevator.Menus;

import java.io.*;
import java.util.Scanner;

public class VendingMachine{
    private Scanner scanner;
    private boolean areWeInTheMainMenu = true;

    public VendingMachine(){
        this.scanner = new Scanner(System.in);
    }
    public void run() {
                while (areWeInTheMainMenu) {
                    PurchaseMenu purchaseoption = new PurchaseMenu();
                    int response = mainMenu();

                    if (response == 1) {
                        purchaseoption.displayVending();
                    }

                    if (response == 2) {

                        purchaseoption.purchaseRun();
                    }
                    if (response == 3) {
                        exit();
                    }
                    if (response == 4) {
                        purchaseoption.display();
                    }
                }

    }


    public int mainMenu(){
        int response = 0;
        while(response<1 || response > 4){
            System.out.println("\n"+ "------------Main Menu------------");
            System.out.println("(1) Display Vending Machine Items");
            System.out.println("(2) Purchase");
            System.out.println("(3) Exit");
            String responseString = scanner.nextLine();
            try{
                response = Integer.parseInt(responseString);
            } catch(NumberFormatException e){
                System.out.println("Please enter number of option");
            }

        }
        return response;
    }
    public void exit() {
        System.out.println("Thank you for using Umbrella Corp Vendo-Matic 800!" +
                "\n" + "Have a sunshine day!!!");
        areWeInTheMainMenu = false;
    }
}
