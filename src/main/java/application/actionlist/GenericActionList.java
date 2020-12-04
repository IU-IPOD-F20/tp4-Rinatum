package application.actionlist;

import application.ApplicationContextBankAgency;
import application.action.Action;
import application.action.ActionList;
import bank.BankAgency;

import java.io.PrintStream;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class GenericActionList implements ActionList<BankAgency> {
    protected String message;
    protected String code;
    protected String title;
    protected List<Action<BankAgency>> actionList;

    public GenericActionList(String message, String code, List<Action<BankAgency>> actionList){
        this.message = message;
        this.code = code;
        this.actionList = actionList;
        this.title = "0 : quit\n";
        for (int i = 1; i < actionList.size() + 1; i++){
            this.title = this.title.concat(i + " : " + actionList.get(i - 1).actionMessage() + "\n");
        }
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
    public String listTitle() {
        return title;
    }

    @Override
    public int size() {
        return this.actionList.size();
    }

    @Override
    public boolean addAction(Action<BankAgency> ac) {
        boolean success = this.actionList.add(ac);
        if (success){
            int i = this.actionList.size();
            this.title = this.title.concat(i + " : " + actionList.get(i - 1).actionMessage() + "\n");
        }
        return this.actionList.add(ac);
    }

    @Override
    public void execute(BankAgency ag) throws Exception {
        int choice;

        Scanner lect = ApplicationContextBankAgency.getInstance().getScanner();
        PrintStream printStream = ApplicationContextBankAgency.getInstance().getPrintStream();

        boolean proceed = true;

        while (proceed) {
            printStream.println(listTitle());
            choice = lect.nextInt();
            if (choice == 0){
                printStream.println("KEK");
                return;
            }
            this.actionList.get(choice - 1).execute(ag);

        }
    }
}
