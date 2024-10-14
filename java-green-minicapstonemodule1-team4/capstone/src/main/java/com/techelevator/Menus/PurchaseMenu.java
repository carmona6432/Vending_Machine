package com.techelevator.Menus;

import com.techelevator.Items.*;
import com.techelevator.Items.Beverages;
import com.techelevator.Items.Candy;
import com.techelevator.Items.Chips;
import com.techelevator.Items.Gum;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class PurchaseMenu {
    private double moneyProvided;
    private String code;
    private String transactionInformation;
    private double totalSales;
    private boolean isItPurchasing = true;
    private int number0 = 5;
    private int number1 = 5;
    private int number2 = 5;
    private int number3 = 5;
    private int number4 = 5;
    private int number5 = 5;
    private int number6 = 5;
    private int number7 = 5;
    private int number8 = 5;
    private int number9 = 5;
    private int number10 = 5;
    private int number11 = 5;
    private int number12 = 5;
    private int number13 = 5;
    private int number14 = 5;
    private int number15 = 5;
    private int number16 = 5;
    private String salesReport;
    Scanner scanner;
    protected static File inputFile = new File("");

    public PurchaseMenu() {
        scanner = new Scanner(System.in);
        this.moneyProvided = 0;
    }

    public void purchaseRun() {
        while (isItPurchasing) {
            int response = purchase();
            if (response == 1) {
                feedMoney();
            }
            if (response == 2) {
                selectProduct();
            }
            if (response == 3) {
                finishTransaction();
            }
                if (response == 4) {
                    display();
                }}}

    public int purchase() {
        int response = 0;
        while (response < 1 || response > 4) {
            BigDecimal trueTotal = new BigDecimal(moneyProvided).setScale(2, RoundingMode.DOWN);
            System.out.println("\n" + "Current balance: $" + trueTotal);
            System.out.println("  ");
            System.out.println("-----Purchasing Menu-----");
            System.out.println("(1) Feed Money");
            System.out.println("(2) Select Product");
            System.out.println("(3) Finish Transaction");
            String responseString = scanner.nextLine();
            try {
                response = Integer.parseInt(responseString);
            } catch (NumberFormatException e) {
                System.out.println("Please enter number of option");
            }
        }
        return response;
    }

    public double feedMoney() {
        try {
            Double amount = 0.00;
            while (isItPurchasing) {
                System.out.println("How much money would you like to provide?");
                String response = scanner.nextLine();
                amount = Double.parseDouble(response);
                moneyProvided += amount;
                BigDecimal trueTotal = new BigDecimal(moneyProvided).setScale(2, RoundingMode.DOWN);
                transactionInformation = " FEED MONEY: $" + amount + " $" + trueTotal + "\n";
                log();
                additionalMoney();
            }
        } catch (NumberFormatException e) {
            System.out.println("Please put whole dollar amounts");
        }
        return moneyProvided;
    }

    public void additionalMoney() {
        while (true) {
            System.out.println("Would you like to add more money? (Please choose Y for yes or N for no)");
            String additionalMoney = scanner.nextLine().trim().toLowerCase(Locale.ROOT);
            if (additionalMoney.equals("y")) {
                System.out.println("How much money would you like to add?");
                String number = scanner.nextLine();
                moneyProvided += Double.parseDouble(number);
                BigDecimal trueTotal = new BigDecimal(moneyProvided).setScale(2, RoundingMode.DOWN);
                transactionInformation = " FEED MONEY: $" + Double.parseDouble(number) + " $" + trueTotal + "\n";
                log();
            } else if (additionalMoney.equals("n")) {
                purchaseRun();
                break;
            }
        }
    }
    public void displayVending() {
        try {
            List<String> line = Files.readAllLines(Path.of("vendingmachine.txt"));

            System.out.println(line.get(0) + "| " + number0);
            System.out.println(line.get(1) + "| " + number1);
            System.out.println(line.get(2) + "| " + number2);
            System.out.println(line.get(3) + "| " + number3);
            System.out.println(line.get(4) + "| " + number4);
            System.out.println(line.get(5) + "| " + number5);
            System.out.println(line.get(6) + "| " + number6);
            System.out.println(line.get(7) + "| " + number7);
            System.out.println(line.get(8) + "| " + number8);
            System.out.println(line.get(9) + "| " + number9);
            System.out.println(line.get(10) + "| " + number10);
            System.out.println(line.get(11) + "| " + number11);
            System.out.println(line.get(12) + "| " + number12);
            System.out.println(line.get(13) + "| " + number13);
            System.out.println(line.get(14) + "| " + number14);
            System.out.println(line.get(15) + "| " + number15);
            System.out.println(line.get(16) + "| " + number16);
            System.out.println(" ");
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    public void selectProduct() {
        BigDecimal trueTotal = new BigDecimal(moneyProvided).setScale(2, RoundingMode.DOWN);
            displayVending();
            System.out.println("--------------------------------");
            System.out.println("Current balance: $" + trueTotal);
            System.out.println("--------------------------------" + "\n");
            Scanner scanner1 = new Scanner(System.in);

            System.out.print("Please select a slot number: ");
            code = scanner1.nextLine().trim().toLowerCase(Locale.ROOT);
            productRun();
    }
    public double productRun() {
        Chips chips = new Chips();
        Candy candy = new Candy();
        Beverages beverages = new Beverages();
        Gum gum = new Gum();

        String message1 = "Crunch Crunch, Yum!";
        String message2 = "Munch Munch, Yum!";
        String message3 = "Glug Glug, Yum!";
        String message4 = "Chew Chew, Yum!";

        System.out.print("\n" + "Does this complete your order: ");
        Scanner scanner1 = new Scanner(System.in);
        String answer = scanner1.nextLine().trim().toLowerCase(Locale.ROOT);

        int product = 1;
        if (code.equals("a1") && number0 > 0 && moneyProvided >= chips.getPriceList().get(0)) {

            System.out.println("You have selected " + chips.getNameList().get(0)
                    + " for $" + chips.getPriceList().get(0) + "\n" + message1);
            moneyProvided -= chips.getPriceList().get(0);
            number0 -= 1;
            salesReport = "Potato Crisps| " + product;
            salesReport();
            BigDecimal trueTotal = new BigDecimal(moneyProvided).setScale(2, RoundingMode.DOWN);
            transactionInformation = " Potato Crisps A1" + " $" + chips.getPriceList().get(0) + " $" + trueTotal + "\n";
            log();
            if (answer.contains("n")){
            selectProduct();}
            totalSales += chips.getPriceList().get(0);
        }
        else if (code.equals("a1") && number0 == 0) {
            System.out.println("SOLD OUT");
        }
        else if (code.equals("a1") && moneyProvided<chips.getPriceList().get(0)){
            System.out.println("INSUFFICIENT FUNDS");
        }
        if (code.equals("a2") && number1 > 0 && moneyProvided >= chips.getPriceList().get(1)) {

            System.out.println("You have selected " + chips.getNameList().get(1)
                    + " for $" + chips.getPriceList().get(1) + "\n" + message1);
            moneyProvided -= chips.getPriceList().get(1);
            number1 -= 1;
            BigDecimal trueTotal = new BigDecimal(moneyProvided).setScale(2, RoundingMode.DOWN);
            transactionInformation = " Stackers A2" + " $" + chips.getPriceList().get(1) + " $" + trueTotal + "\n";
            log();
            salesReport = "Stackers| " + product;
            salesReport();
            System.out.print("\n" + "Does this complete your order: ");
            if (answer.contains("n")){
                selectProduct();}
            totalSales += chips.getPriceList().get(1);
        }
        else if (code.equals("a2") && number1 == 0){
            System.out.println("SOLD OUT");
        }
        else if (code.equals("a2") && moneyProvided <chips.getPriceList().get(1)){
            System.out.println("INSUFFICIENT FUNDS");
        }
        if (code.equals("a3") && number2 > 0 && moneyProvided >=chips.getPriceList().get(2)) {

            System.out.println("You have selected " + chips.getNameList().get(2)
                    + " for $" + chips.getPriceList().get(2) + "\n" + message1);
            moneyProvided -= chips.getPriceList().get(2);
            number2 -= 1;
            BigDecimal trueTotal = new BigDecimal(moneyProvided).setScale(2, RoundingMode.DOWN);
            transactionInformation = " Grain Waves A3" + " $" + chips.getPriceList().get(2) + " $" + trueTotal + "\n";
            log();
            salesReport = "Grain Waves|" + product;
            salesReport();
            System.out.print("\n" + "Does this complete your order: ");
            if (answer.contains("n")){
                selectProduct();}
            totalSales += chips.getPriceList().get(2);
        }
        else if(code.equals("a3") && number2 == 0){
            System.out.println("SOLD OUT");
        }
        else if (code.equals("a3") && moneyProvided < chips.getPriceList().get(2)){
            System.out.println("INSUFFICIENT FUNDS");
        }
        if (code.equals("a4") && number3 > 0 && moneyProvided >=chips.getPriceList().get(3)) {

            System.out.println("You have selected " + chips.getNameList().get(3)
                    + " for $" + chips.getPriceList().get(3) + "\n" + message1);
            moneyProvided -= chips.getPriceList().get(3);
            number3 -= 1;
            BigDecimal trueTotal = new BigDecimal(moneyProvided).setScale(2, RoundingMode.DOWN);
            transactionInformation = " Cloud Popcorn A4" + " $" + chips.getPriceList().get(3) + " $" + trueTotal + "\n";
            log();
            salesReport = "Cloud Popcorn| " + product;
            salesReport();
            System.out.print("\n" + "Does this complete your order: ");
            if (answer.contains("n")){
                selectProduct();}
            totalSales += chips.getPriceList().get(3);
        }
        else if(code.equals("a4") && number3 == 0){
            System.out.println("SOLD OUT");
        }
        else if(code.equals("a4") && moneyProvided < chips.getPriceList().get(3)){
            System.out.println("INSUFFICIENT FUNDS");
        }
        if (code.equals("b1") && number4 >0 && moneyProvided >= candy.getPriceList().get(0)) {

            System.out.println("You have selected " + candy.getNameList().get(0)
                    + " for $" + candy.getPriceList().get(0) + "\n" + message2);
            moneyProvided -= candy.getPriceList().get(0);
            number4 -= 1;
            BigDecimal trueTotal = new BigDecimal(moneyProvided).setScale(2, RoundingMode.DOWN);
            transactionInformation = " Moonpie B1" + " $" + candy.getPriceList().get(0) + " $" + trueTotal + "\n";
            log();
            salesReport = "Moonpie| " + product;
            salesReport();
            System.out.print("\n" + "Does this complete your order: ");
            if (answer.contains("n")){
                selectProduct();}
            totalSales += candy.getPriceList().get(0);

        }
        else if(code.equals("b1") && number4 == 0){
            System.out.println("SOLD OUT");
        }
        else if(code.equals("b2") && moneyProvided < candy.getPriceList().get(0)){
            System.out.println("INSUFFICIENT FUNDS");
        }
        if (code.equals("b2") && number5 > 0 && moneyProvided >= candy.getPriceList().get(1)) {

            System.out.println("You have selected " + candy.getNameList().get(1)
                    + " for $" + candy.getPriceList().get(1) + "\n" + message2);
            moneyProvided -= candy.getPriceList().get(1);
            number5 -= 1;
            BigDecimal trueTotal = new BigDecimal(moneyProvided).setScale(2, RoundingMode.DOWN);
            transactionInformation = " Cowtales B2" + " $" + candy.getPriceList().get(1) + " $" + trueTotal + "\n";
            log();
            salesReport = "Cowtales |" + product;
            salesReport();
            System.out.print("\n" + "Does this complete your order: ");
            if (answer.contains("n")){
                selectProduct();}
            totalSales += candy.getPriceList().get(1);
        }
        else if(code.equals("b2") && number5 == 0){
            System.out.println("SOLD OUT");
        }
        else if(code.equals("b2") && moneyProvided<candy.getPriceList().get(1)){
            System.out.println("INSUFFICIENT FUNDS");
        }
        if (code.equals("b3") && number6 > 0 && moneyProvided >= candy.getPriceList().get(1)) {

            System.out.println("You have selected " + candy.getNameList().get(2)
                    + " for $" + candy.getPriceList().get(1) + "\n" + message2);
            moneyProvided -= candy.getPriceList().get(1);
            number6 -= 1;
            BigDecimal trueTotal = new BigDecimal(moneyProvided).setScale(2, RoundingMode.DOWN);
            transactionInformation = " Wonka Bar B3" + " $" + candy.getPriceList().get(1) + " $" + trueTotal + "\n";
            log();
            salesReport = "Wonka Bar |" + product;
            salesReport();
            System.out.print("\n" + "Does this complete your order: ");
            if (answer.contains("n")){
                selectProduct();}
            totalSales += candy.getPriceList().get(1);
        }
        else if(code.equals("b3") && number6 == 0){
            System.out.println("SOLD OUT");
        }
        else if ((code.equals("b3") && moneyProvided < candy.getPriceList().get(1))){
            System.out.println("INSUFFICIENT FUNDS");
        }
        if (code.equals("b4") && number7 > 0 && moneyProvided >=candy.getPriceList().get(2)) {

            System.out.println("You have selected " + candy.getNameList().get(3)
                    + " for $" + candy.getPriceList().get(2) + "\n" + message2);
            moneyProvided -= candy.getPriceList().get(2);
            number7 -= 1;
            BigDecimal trueTotal = new BigDecimal(moneyProvided).setScale(2, RoundingMode.DOWN);
            transactionInformation = " Crunchie B4" + " $" + candy.getPriceList().get(2) + " $" + trueTotal + "\n";
            log();
            salesReport = "Crunchie |" + product;
            salesReport();
            System.out.print("\n" + "Does this complete your order: ");
            if (answer.contains("n")){
                selectProduct();}
            totalSales += candy.getPriceList().get(2);
        }
        else if (code.equals("b4") && number7 == 0){
            System.out.println("SOLD OUT");
        }
        else if (code.equals("b4") && moneyProvided<candy.getPriceList().get(2)){
            System.out.println("INSUFFICIENT FUNDS");
        }
        if (code.equals("c1") && number8 > 0 && moneyProvided >=beverages.getPriceList().get(0)) {

            System.out.println("You have selected " + beverages.getNameList().get(0)
                    + " for $" + beverages.getPriceList().get(0) + "\n" + message3);
            moneyProvided -= beverages.getPriceList().get(0);
            number8 -= 1;
            BigDecimal trueTotal = new BigDecimal(moneyProvided).setScale(2, RoundingMode.DOWN);
            transactionInformation = " Cola C1" + " $" + beverages.getPriceList().get(0) + " $" + trueTotal + "\n";
            log();
            salesReport = "Cola |" + product;
            salesReport();
            System.out.print("\n" + "Does this complete your order: ");
            if (answer.contains("n")){
                selectProduct();}
            totalSales += beverages.getPriceList().get(0);
        }
        else if(code.equals("c1") && number8 == 0){
            System.out.println("SOLD OUT");
        }
        else if(code.equals("c1") && moneyProvided < beverages.getPriceList().get(0)){
            System.out.println("INSUFFICIENT FUNDS");
        }
        if (code.equals("c2") && number9 > 0 && moneyProvided >= beverages.getPriceList().get(1)) {

            System.out.println("You have selected " + beverages.getNameList().get(1)
                    + " for $" + beverages.getPriceList().get(1) + "\n" + message3);
            moneyProvided -= beverages.getPriceList().get(1);
            number9 -= 1;
            BigDecimal trueTotal = new BigDecimal(moneyProvided).setScale(2, RoundingMode.DOWN);
            transactionInformation = " Dr. Salt C2" + " $" + beverages.getPriceList().get(1) + " $" + trueTotal + "\n";
            log();
            salesReport = "Dr.Salt |" + product;
            salesReport();
            System.out.print("\n" + "Does this complete your order: ");
            if (answer.contains("n")){
                selectProduct();}
            totalSales += beverages.getPriceList().get(1);
        }
        else if(code.equals("c2") && number9 ==0){
            System.out.println("SOLD OUT");
        }
        else if(code.equals("c2") && moneyProvided < beverages.getPriceList().get(1)){
            System.out.println("INSUFFICIENT FUNDS");
        }
        if (code.equals("c3")&& number10 >0 && moneyProvided>= beverages.getPriceList().get(1)) {

            System.out.println("You have selected " + beverages.getNameList().get(2)
                    + " for $" + beverages.getPriceList().get(1) + "\n" + message3);
            moneyProvided -= beverages.getPriceList().get(1);
            number10 -= 1;
            BigDecimal trueTotal = new BigDecimal(moneyProvided).setScale(2, RoundingMode.DOWN);
            transactionInformation = " Mountain Melter C3" + " $" + beverages.getPriceList().get(1) + " $" + trueTotal + "\n";
            log();
            salesReport = "Mountain Melter |" + product;
            salesReport();
            System.out.print("\n" + "Does this complete your order: ");
            if (answer.contains("n")){
                selectProduct();}
            totalSales += beverages.getPriceList().get(1);
        }
        else if(code.equals("c3") && number10 == 0){
            System.out.println("SOLD OUT");
        }
        else if(code.equals("c3") && moneyProvided < beverages.getPriceList().get(1)){
            System.out.println("INSUFFICIENT FUNDS");
        }
        if (code.equals("c4") && number11 >0 && moneyProvided >= beverages.getPriceList().get(1)) {

            System.out.println("You have selected " + beverages.getNameList().get(3)
                    + " for $" + beverages.getPriceList().get(1) + "\n" + message3);
            moneyProvided -= beverages.getPriceList().get(1);
            number11 -= 1;
            BigDecimal trueTotal = new BigDecimal(moneyProvided).setScale(2, RoundingMode.DOWN);
            transactionInformation = " Heavy C4" + " $" + beverages.getPriceList().get(1) + " $" + trueTotal + "\n";
            log();
            salesReport = "Heavy |" + product;
            salesReport();
            System.out.print("\n" + "Does this complete your order: ");
            if (answer.contains("n")){
                selectProduct();}
            totalSales += beverages.getPriceList().get(1);
        }
        else if(code.equals("c4") && number11 == 0){
            System.out.println("SOLD OUT");
        }
        else if(code.equals("c4") && moneyProvided < beverages.getPriceList().get(1)){
            System.out.println("INSUFFICIENT FUNDS");
        }
        if (code.equals("d1") && number12 > 0 && moneyProvided >= gum.getPriceList().get(0)) {

            System.out.println("You have selected " + gum.getGumList().get(0)
                    + " for $" + gum.getPriceList().get(0) + "\n" + message4);
            moneyProvided -= gum.getPriceList().get(0);
            number12 -= 1;
            BigDecimal trueTotal = new BigDecimal(moneyProvided).setScale(2, RoundingMode.DOWN);
            transactionInformation = " U-Chews D1" + " $" + gum.getPriceList().get(0) + " $" + trueTotal + "\n";
            log();
            salesReport = "U-Chews |" + product;
            salesReport();
            System.out.print("\n" + "Does this complete your order: ");
            if (answer.contains("n")){
                selectProduct();}
            totalSales += gum.getPriceList().get(0);
        }
        else if(code.equals("d1") && number12 == 0){
            System.out.println("SOLD OUT");
        }
        else if(code.equals("d1") && moneyProvided < gum.getPriceList().get(0)){
            System.out.println("INSUFFICIENT FUNDS");
        }
        if (code.equals("d2") && number13 > 0 && moneyProvided >= gum.getPriceList().get(1)) {

            System.out.println("You have selected " + gum.getGumList().get(1)
                    + " for $" + gum.getPriceList().get(1) + "\n" + message4);
            moneyProvided -= gum.getPriceList().get(1);
            number13 -= 1;
            BigDecimal trueTotal = new BigDecimal(moneyProvided).setScale(2, RoundingMode.DOWN);
            transactionInformation = " Little League Chew D2" + " $" + gum.getPriceList().get(1) + " $" + trueTotal + "\n";
            log();
            salesReport = "Little League Chew |" + product;
            salesReport();
            System.out.print("\n" + "Does this complete your order: ");
            if (answer.contains("n")){
                selectProduct();}
            totalSales += gum.getPriceList().get(1);
        }
        else if (code.equals("d2") && number13 == 0){
            System.out.println("SOLD OUT");
        }
        else if (code.equals("d2") && moneyProvided < gum.getPriceList().get(1)){
            System.out.println("INSUFFICIENT FUNDS");
        }
        if (code.equals("d3") && number14 > 0 && moneyProvided >= gum.getPriceList().get(2)) {

            System.out.println("You have selected " + gum.getGumList().get(2)
                    + " for $" + gum.getPriceList().get(2) + "\n" + message4);
            moneyProvided -= gum.getPriceList().get(2);
            number14 -= 1;
            BigDecimal trueTotal = new BigDecimal(moneyProvided).setScale(2, RoundingMode.DOWN);
            transactionInformation = " Chiclets D3" + " $" + gum.getPriceList().get(2) + " $" + trueTotal + "\n";
            log();
            salesReport = "Chiclets |" + product;
            salesReport();
            System.out.print("\n" + "Does this complete your order: ");
            if (answer.contains("n")){
                selectProduct();}
            totalSales += gum.getPriceList().get(2);
        }
       else if (code.equals("d3") && number14 ==0){
            System.out.println("SOLD OUT");
        }
       else if(code.equals("d3") && moneyProvided < gum.getPriceList().get(2)){
            System.out.println("INSUFFICIENT FUNDS");
        }
        if (code.equals("d4") && number15 >0 && moneyProvided >= gum.getPriceList().get(3)) {

            System.out.println("You have selected " + gum.getGumList().get(3)
                    + " for $" + gum.getPriceList().get(3) + "\n" + message4);
            moneyProvided -= gum.getPriceList().get(3);
            number15 -= 1;
            BigDecimal trueTotal = new BigDecimal(moneyProvided).setScale(2, RoundingMode.DOWN);
            transactionInformation = " Triplemint D4" + " $" + gum.getPriceList().get(0) + " $" + trueTotal + "\n";
            log();
            salesReport = "Triplemint |" + product;
            salesReport();
            System.out.print("\n" + "Does this complete your order: ");
            if (answer.contains("n")){
                selectProduct();}
            totalSales += gum.getPriceList().get(3);
        }
        else if (code.equals("d4") && number15 == 0){
            System.out.println("SOLD OUT");
        }
        else if(code.equals("d4") && moneyProvided < gum.getPriceList().get(3)){
            System.out.println("INSUFFICIENT FUNDS");
        }

        return totalSales;
    }

    public void finishTransaction() {
        double dividedBy25 = moneyProvided * 100 / 25;
        double quarters = Math.floor(dividedBy25);
        double changeRemainingAfterQuarters = moneyProvided * 100 % 25;
        double dividedBy10 = changeRemainingAfterQuarters / 10;
        double dimes = Math.floor((dividedBy10));
        double changeRemainingAfterDimes = changeRemainingAfterQuarters % 10;
        double dividedBy5 = changeRemainingAfterDimes / 5;
        double nickels = Math.floor(dividedBy5);
        double endRemainingBalance = changeRemainingAfterDimes % 5;
        BigDecimal trueTotal = new BigDecimal(endRemainingBalance).setScale(2, RoundingMode.DOWN);
        System.out.println("Your change is:");
        System.out.println(quarters + " quarters");
        System.out.println((dimes + " dimes"));
        System.out.println(nickels + " nickels");
        System.out.println("Your remaining balance is " + trueTotal);
        BigDecimal provided = new BigDecimal(moneyProvided).setScale(2, RoundingMode.DOWN);
        transactionInformation = " GIVE CHANGE: $" + provided + " $" + trueTotal + "\n";
        log();
        isItPurchasing = false;

    }
    public void log() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/YYYY");
        String formattedDate = today.format(formatter);
        LocalTime now = LocalTime.now();
        DateTimeFormatter time = DateTimeFormatter.ofPattern("h:mm:ss a");
        String formattedTime = now.format(time);
        try {
            FileWriter writer = new FileWriter("Log.txt", true);
            PrintWriter log = new PrintWriter(writer);
            log.print(formattedDate + " " + formattedTime + transactionInformation);
            log.flush();
            log.close();


        } catch (IOException e) {
            System.out.println("Error");
        }
    }
    public void salesReport() {
        try {
            LocalDate now = LocalDate.now();
            DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("MM_YYYY");
            String formattedMonth = now.format(monthFormatter);
            String directoryName = "Sales Report_" + formattedMonth;
            Path directoryPath = Paths.get(directoryName);
            if (Files.notExists(directoryPath)) {
                Files.createDirectory(directoryPath);
            }
            LocalDateTime today = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH");
            String formattedDate = today.format(formatter);
            inputFile = new File(String.valueOf(directoryPath), "Sales Report_" + formattedDate + ".txt");
            inputFile.createNewFile();
            FileWriter writer = new FileWriter(inputFile, true);
            PrintWriter write = new PrintWriter(writer);
            write.print(salesReport + "\n");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println("error");
        }}

        public void display() {
            try {
                Scanner newScanner = new Scanner(inputFile);
                while (newScanner.hasNextLine()) {
                    System.out.println(newScanner.nextLine());
                }
                System.out.println("**TOTAL SALES** " + "$" + totalSales);
            } catch (IOException e) {
                System.out.println("Error");
            }
        }
            public String getCode () {
                return code;
            }

        }
