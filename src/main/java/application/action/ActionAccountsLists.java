package application.action;

import bank.BankAgency;

public class ActionAccountsLists implements Action<BankAgency> {

    protected String message;
    protected String code;

    public ActionAccountsLists(String message, String code){
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
        ag.print();
    }
}
