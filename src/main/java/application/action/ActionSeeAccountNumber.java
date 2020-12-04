package application.action;

import application.ApplicationContextBankAgency;
import bank.Account;
import bank.BankAgency;

import java.util.Scanner;

public class ActionSeeAccountNumber implements Action<BankAgency>{

    protected String message;
    protected String code;

    public ActionSeeAccountNumber(String message, String code){
        this.message = message;
        this.code = code;
    }

    @Override
    public String actionMessage() {
        return message;
    }

    @Override
    public String actionCode() {
        return code;
    }

    @Override
    public void execute(BankAgency ag) throws Exception {
        ApplicationContextBankAgency instance = ApplicationContextBankAgency.getInstance();
        instance.getPrintStream().print("Account Number -> ");
        String number = instance.getScanner().next();
        Account c = ag.getAccount(number);
        if (c==null) {
            instance.getPrintStream().println("Account non existing ...");
        } else {
            c.print();
        }
    }
}
