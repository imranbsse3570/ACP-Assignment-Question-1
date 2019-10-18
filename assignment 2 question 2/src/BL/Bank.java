package BL;

import Exceptions.InsufficientBalanceException;
import Exceptions.InvalidAmountException;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Bank {
    static Scanner input = new Scanner(System.in);
    private static String accountNumber;
    private static String accountName;
    private static float balance;
    private static String openingDate;
    private static String temp;
    private static Account[] accounts;

    public static void main(String args[]) {
        int totalAccounts;
        System.out.println("======================================\n" +
                "\tEnter Total number of Accounts");
        totalAccounts = isNextInt();
        System.out.println("======================================");
        accounts = new Account[totalAccounts];
        boolean repeat = true;
        while (repeat) {
            int choice = mainMenu();
            switch (choice){
                case 1 :
                    System.out.println("===========================================");
                    openNewAccount();
                    System.out.println("===========================================");
                    break;
                case 2 :
                    if(Account.getNoOfAccounts() == 0)
                        System.out.println("No Record Exists");
                    else
                        withdrawalAnAmount();
                    break;
                case 3 :
                    if(Account.getNoOfAccounts() == 0)
                        System.out.println("No Record Exists");
                    else
                        depositAnAmount();
                    break;
                case 4 :
                    if(Account.getNoOfAccounts() == 0)
                        System.out.println("No Record Exists");
                    else
                        accountStatement();
                    break;
                case 5 :
                    if(Account.getNoOfAccounts() == 0)
                        System.out.println("No Record Exists");
                    else
                        creditProfit();
                    break;
                case 6 :
                    if(Account.getNoOfAccounts() == 0)
                        System.out.println("No Record Exists");
                    else
                        System.out.println("===========================================\n" +
                                "Total No. of Accounts : " + Account.getNoOfAccounts() +
                                "\n===========================================");
                    break;
                default:
                    repeat = false;
            }
        }
    }

    private static int mainMenu() {
        while (true) {
            System.out.println("===========================================\n" +
                    "\t\t\t\tMain-Menu\n" +
                    "......Select your Choice......\n" +
                    "\t1. Open an Account\n" +
                    "\t2. Withdraw an Amount\n" +
                    "\t3. Deposit an Amount\n" +
                    "\t4. Account Statement\n" +
                    "\t5. Credit Profit\n" +
                    "\t6. Total Number of Accounts Opened\n" +
                    "\t7. Exit Program\n" +
                    "===========================================");
            int choice = isNextInt();
            if (choice > 0 && choice <= 7)
                return choice;
            System.out.println("\t\t\t\t:(\n" +
                    "Sorry Your Choice was inValid\n" +
                    "Please Re-Enter..........");
        }
    }

    private static int isNextInt(){
        while (true){
            boolean test = input.hasNextInt();
            if (test)
                return input.nextInt();
            else {
                System.out.println("\t\t\t\t:(\n" +
                        "Please Enter an Integer Value");
                input.nextLine();
            }
        }
    }

    private static String setAName(){
        while(true){
            System.out.println("Enter the Name of the Account");
            temp = input.nextLine();
            boolean test = temp.matches("^[a-zA-Z ]{3,20}$");
            if(test)
                return temp;
            System.out.println(":( Name doesn't seem to be correct\n" +
                    "Kindly re-enter......");
        }
    }

    private static String setANumber(){
        while(true){
            System.out.println("Enter the Number of the Account\n" +
                    "Follow Format : A00\n" +
                    "Disclaimer : Account Number is also Case Sensitive");
            temp = input.nextLine();
            boolean test = temp.matches("^[a-zA-Z][0-9]{2,10}$");
            if(test)
                return temp;
            System.out.println(":( Account Number doesn't seem to be correct\n" +
                    "Kindly re-enter......\n\n");
        }
    }

    private static String setDate(){
        while(true){
            System.out.println("Enter the Date of Opening Account\n" +
                    "Proper Format : yyyy-mm-dd");
            temp = input.nextLine();
            boolean test = temp.matches("([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))");
            if(test)
                return temp;
            System.out.println(":( Account Number doesn't seem to be correct\n" +
                    "Kindly re-enter......");
        }
    }

    private static float balance(){
        while (true){
            System.out.println("Enter balance in the respective Account");
            balance = input.nextFloat();
            if (balance > 0)
                break;
            System.out.println("Balance must be greater than 0");
        }
        return balance;
    }

    public static boolean isUnique(String aNum){
        for (int i = 0 ; i < Account.getNoOfAccounts(); i++){
            if(aNum.equals(accounts[i].getAccountNumber()))
                return false;
        }
        return true;
    }
    private static void openNewAccount(){
        input.nextLine();
        while (true) {
            temp = setANumber();
            if(isUnique(temp)) {
                accountNumber = temp;
                break;
            }
            System.out.println("Account Number must be Unique");
        }
        accountName = setAName();
        balance = balance();
        input.nextLine();
        openingDate = setDate();
        accounts[Account.getNoOfAccounts()] = new Account(accountNumber, accountName, balance, openingDate);
    }

    private static int indexOf(String number) {
        for (int i = 0; i <= Account.getNoOfAccounts(); i++) {
            if (number.equals(accounts[i].getAccountNumber()))
                return i;
        }
        return 0;
    }

    private static String  isPresent(){
        while (true) {
            System.out.println("\t\t......search......");
            input.nextLine();
            temp = setANumber();
            if (!isUnique(temp))
                return temp;
            System.out.println("Account Number does not Exists :(");
        }
    }

    public static void withdrawalAnAmount(){
        accountNumber = isPresent();
        System.out.println("Enter the amount you want to WithDrawl");
        balance = input.nextFloat();
        input.nextLine();
        int index = indexOf(accountNumber);
        try {
            accounts[index].withDraw(balance);
        } catch (InvalidAmountException | InsufficientBalanceException err){
            System.out.println(err);
        }
    }

    public static void depositAnAmount(){
        accountNumber = isPresent();
        int index = indexOf(accountNumber);
        System.out.println("Enter Amount to Deposit");
        balance = input.nextFloat();
        input.nextLine();
        try {
            System.out.println("===========================================\n" +
                    "New Balance : " + accounts[index].deposit(balance) +
                    "\n===========================================");
        } catch (InvalidAmountException err){
            System.out.println(err);
        }
    }

    public static void accountStatement(){
        accountNumber = isPresent();
        int index = indexOf(accountNumber);
        accounts[index].accountStatement();
    }

    public static void creditProfit(){
        isPresent();
        int index = indexOf(accountNumber);
        System.out.println("===========================================\n" +
                "Profit : " + accounts[index].creditProfit() +
                "\n===========================================");
    }
}
