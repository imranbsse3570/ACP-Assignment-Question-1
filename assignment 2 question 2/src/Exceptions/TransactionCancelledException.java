package Exceptions;

public class TransactionCancelledException extends Exception{
    private String alert;

    public TransactionCancelledException() {
        this.alert = null;
    }

    public TransactionCancelledException(String alert){
        this.alert = alert;
    }

    @Override
    public String toString() {
        return "TransactionCancelledException{" +
                "alert='" + alert + '\'' +
                '}';
    }
}
