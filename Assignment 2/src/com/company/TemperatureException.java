package com.company;

public class TemperatureException extends Exception {
    private String alert;

    public TemperatureException(){
        alert = null;
    }

    public TemperatureException(String alert) {
        this.alert = alert;
    }

    @Override
    public String toString() {
        return "TemperatureException{" +
                "alert='" + alert + '\'' +
                '}';
    }
}
