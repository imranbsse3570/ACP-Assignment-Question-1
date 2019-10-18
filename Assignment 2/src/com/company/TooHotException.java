package com.company;

public class TooHotException extends TemperatureException {
    private String alert;

    public TooHotException() {
        super();
        this.alert = null;
    }

    public TooHotException(String tAlert, String alert) {
        super(tAlert);
        this.alert = alert;
    }

    @Override
    public String toString() {
        return super.toString() + "TooHotException{" +
                "alert='" + alert + '\'' +
                '}';
    }
}
