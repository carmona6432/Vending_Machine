package com.techelevator.Application;

import com.techelevator.Menus.VendingMachine;

import java.io.IOException;
import java.util.Scanner;

public class UmbrellaCorpVendingMachine {
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.run();
    }

}
