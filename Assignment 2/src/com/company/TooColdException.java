package com.company;

public class TooColdException extends TemperatureException {
    public String alert;

    public TooColdException() {
        super();
        this.alert = null;
    }

    public TooColdException(String tAlret, String alert) {
        super(tAlret);
        this.alert = alert;
    }


    @Override
    public String toString() {
        return super.toString() + "TooColdException{" +
                "alert='" + alert + '\'' +
                '}';
    }
}
