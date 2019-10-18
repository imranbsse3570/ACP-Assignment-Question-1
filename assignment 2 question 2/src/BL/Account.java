package BL;

import Exceptions.InsufficientBalanceException;
import Exceptions.InvalidAmountException;
import Exceptions.TransactionCancelledException;

import java.util.Objects;

public class Account {
    private String accountNumber;
    private String accountHolderName;
    private float balance;
    private String accountOpeningDate;
    private final float profitRate = 5 ;
    private static int noOfAccounts = 0;

    public Account(){
        this(null, null, 0f, null);
    }

    public Account(String accountNumber, String accountHolderName, float balance, String accountOpeningDate) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.accountOpeningDate = accountOpeningDate;
        noOfAccounts++;
    }

    public Account(Account account) {
        this(account.accountNumber, account.accountHolderName, account.balance, account.accountOpeningDate);
    }

    public float getProfitRate() {
        return profitRate;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String getAccountOpeningDate() {
        return accountOpeningDate;
    }

    public void setAccountOpeningDate(String accountOpeningDate) {
        this.accountOpeningDate = accountOpeningDate;
    }

    public static int getNoOfAccounts() {
        return noOfAccounts;
    }

    public void withDraw(float withDrawalAmount) throws InvalidAmountException, InsufficientBalanceException {
        if(withDrawalAmount <= 0)
            throw new InvalidAmountException("Invalid Amount " , "Amount must be greater than 0 to withdrawal");
         else if (withDrawalAmount < this.balance){
            balance -= withDrawalAmount;
            System.out.println("Amount of " + withDrawalAmount + " successfully WithDrawal from account of " + this.accountHolderName);
        } else {
             throw new InsufficientBalanceException("Insufficient Amount " , "Insufficient Balance to withdrawal amount " + withDrawalAmount);
        }
    }

    public float deposit(float amountToDeposit) throws InvalidAmountException{
        if (amountToDeposit > 0) {
            this.balance += amountToDeposit;
            return this.balance;
        } else
            throw new InvalidAmountException("Invalid Amount " , "Amount must be greater than 0 to Deposit");
    }

    public void accountStatement(){
        System.out.println("======================================================\n" +
                "\t\tAccount No. : " + this.accountNumber +
                "\n\t\tAccount Holder Name : " + this.accountHolderName +
                "\n\t\tAccount Balance : " + this.balance +
                "\n\t\tAccount Opening Date : " + this.accountOpeningDate +
                "\n\t\tAccount Interest Rate : " + this.profitRate +
                "\n======================================================");
    }

    public float creditProfit(){
        float profit = (this.profitRate / 100) * this.balance;
        this.balance += profit;
        return profit;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", balance=" + balance +
                ", accountOpeningDate='" + accountOpeningDate + '\'' +
                ", profitRate=" + profitRate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return Float.compare(account.balance, balance) == 0 &&
                Float.compare(account.profitRate, profitRate) == 0 &&
                Objects.equals(accountNumber, account.accountNumber) &&
                Objects.equals(accountHolderName, account.accountHolderName) &&
                Objects.equals(accountOpeningDate, account.accountOpeningDate);
    }
}