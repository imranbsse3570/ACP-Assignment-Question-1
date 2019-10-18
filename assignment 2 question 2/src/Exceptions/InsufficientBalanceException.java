package Exceptions;

public class InsufficientBalanceException extends TransactionCancelledException {
    private String alert;

    public InsufficientBalanceException() {
        super(null);
        this.alert = null;
    }

    public InsufficientBalanceException(String alert, String alert1) {
        super(alert);
        this.alert = alert1;
    }

    @Override
    public String toString() {
        return super.toString() + "\nInsufficientBalanceException{" +
                "alert='" + alert + '\'' +
                '}';
    }
}
