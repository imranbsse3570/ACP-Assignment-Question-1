package com.company;

public class VirtualCafe {
    public static void serveCustomer(VirtualPerson customer, CoffeeCup acup){
        try {
            customer.drinkCoffee(acup);
        } catch (TooHotException err) {
            System.out.println(err);
        }
        catch (TooColdException err) {
            System.out.println(err);
        }
    }

    public static void serveCustomer(VirtualPerson customer, TeaCup acup){
        try {
            customer.drinkTea(acup);
        } catch (TooColdException err) {
            System.out.println(err);
        } catch (TooHotException err) {
            System.out.println(err);
        }
    }
}
