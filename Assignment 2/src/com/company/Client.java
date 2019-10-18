package com.company;

import java.util.Scanner;

public class Client {
    static Scanner input = new Scanner(System.in);
    public static void main(String args[]){
        boolean coffee = true;
        VirtualPerson customer = null;
        CoffeeCup acup = null;
        TeaCup teaCup = null;
        boolean quit = false;
        boolean isPerson = false;
        boolean isReadyToServe = false;
        while(!quit) {
            int choice = getChoice();
            switch (choice) {
                case 1:
                    customer = new VirtualPerson();
                    isPerson = true;
                    break;
                case 2:
                    if(isPerson) {
                        acup = new CoffeeCup(getTemperature());
                        isReadyToServe = true;
                        coffee = true;
                    } else
                        System.out.println("Firstly a person is required");
                    break;
                case 3:
                    if (isPerson) {
                        teaCup = new TeaCup(getTemperature());
                        isReadyToServe = true;
                        coffee = false;
                    } else
                        System.out.println("Firstly a person is required");
                    break;
                case 4:
                    if (isPerson && isReadyToServe) {
                        if (coffee) {
                            VirtualCafe.serveCustomer(customer, acup);
                        } else {
                            VirtualCafe.serveCustomer(customer, teaCup);
                        }
                    }  else
                        System.out.println("Firstly a person is required\n" +
                                "Secondly Tea or Coffee is Prepared then it is served to client");
                    break;
                default:
                    quit = true;
            }
        }
    }

    private static double getTemperature(){
        System.out.println("Enter Temperature");
        return input.nextDouble();
    }

    private static int getChoice(){
        while (true) {
            System.out.println("===============================================\n" +
                    "\t\tWelcome to the Main-Menu\n" +
                    "1. Create new Virtual Customer\n" +
                    "2. Set Temperature of Coffee Cup\n" +
                    "3. Set Temperature of Tea Cup\n" +
                    "4. Serving a Customer with a cup of Or Tea as ordered\n" +
                    "5. Terminate the program\n" +
                    "===============================================");
            int choice = input.nextInt();
            if (choice > 0 && choice <= 5) {
                return choice;
            }
            System.out.println("Enter Valid choice");
        }
    }
}