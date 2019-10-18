package Exceptions;

public class InvalidAmountException extends TransactionCancelledException {
    private String alert;

    public InvalidAmountException() {
        super(null);
        this.alert = null;
    }

    public InvalidAmountException(String alert, String alert1) {
        super(alert);
        this.alert = alert1;
    }

    @Override
    public String toString() {
        return super.toString()  + "\nInvalidAmountException{" +
                "alert='" + alert + '\'' +
                '}';
    }
}
