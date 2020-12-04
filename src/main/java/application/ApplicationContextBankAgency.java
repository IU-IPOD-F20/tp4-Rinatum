package application;


import bank.BankAgency;

import java.io.PrintStream;
import java.util.Locale;
import java.util.Scanner;

public class ApplicationContextBankAgency {
    private Scanner scanner;
    private PrintStream printStream;

    private static ApplicationContextBankAgency instance;

    private ApplicationContextBankAgency(){}

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public void setPrintStream(PrintStream printStream) {
        this.printStream = printStream;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public PrintStream getPrintStream() {
        return printStream;
    }

    public static ApplicationContextBankAgency getInstance() {
        ApplicationContextBankAgency instance = ApplicationContextBankAgency.instance;
        if (instance != null){
            return instance;
        }
        synchronized(ApplicationContextBankAgency.class) {
            if (ApplicationContextBankAgency.instance == null) {
                ApplicationContextBankAgency.instance = new ApplicationContextBankAgency();
                Scanner scanner = new Scanner(System.in);
                scanner.useLocale(Locale.US);
                ApplicationContextBankAgency.instance.setScanner(scanner);
                ApplicationContextBankAgency.instance.setPrintStream(new PrintStream(System.out));
            }
            return ApplicationContextBankAgency.instance;
        }
    }
}