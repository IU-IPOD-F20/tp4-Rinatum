import application.AccesBankAgency;
import application.action.Action;
import application.action.ActionAccountsLists;
import application.action.ActionList;
import application.action.ActionSeeAccountNumber;
import application.actionlist.GenericActionList;
import bank.BankAgency;

import java.util.LinkedList;
import java.util.List;

public class MyBankAgencyApp {
    public static void main(String[] args) {
        Action<BankAgency> accountsLists = new ActionAccountsLists("List Accounts", "l");
        Action<BankAgency> accountNumber = new ActionSeeAccountNumber("Account number", "n");

        List<Action<BankAgency>> actions = new LinkedList<>();
        actions.add(accountsLists);
        actions.add(accountNumber);

        ActionList<BankAgency> actionList = new GenericActionList("Action list", "al", actions);

        BankAgency bankAgency = AccesBankAgency.getBankAgency();
        try {
            actionList.execute(bankAgency);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
