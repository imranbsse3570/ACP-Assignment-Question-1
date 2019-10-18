package com.company;

public class VirtualPerson {
    public void drinkCoffee(CoffeeCup acup) throws TooColdException, TooHotException{
        if(acup.getTemperature() <= 65)
            throw new TooColdException("Issue in Temperature","Coffee is too Cold to serve");
        else if(acup.getTemperature() >= 85)
            throw new TooHotException("Issue in Temperature","Coffee is too Hot to serve");
        else
            System.out.println("Coffee is perfect to serve");
    }

    public void drinkTea(TeaCup acup) throws TooColdException, TooHotException{
        if(acup.getTemperature() <= 60)
            throw new TooColdException("Issue in Temperature","Tea is too cold to serve");
        else if(acup.getTemperature() >= 80)
            throw new TooHotException("Issue in Temperature","Tea is too hot to serve");
        else
            System.out.println("Tea is perfect to serve");
    }
}
