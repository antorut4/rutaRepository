import java.util.ArrayList;
import java.util.List;

public class Bank {

    private final List<BankAccount> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public void addAccount(double initialBalance, String customerName) {
        BankAccount nuovoAccount=new BankAccount(initialBalance, customerName);
        this.accounts.add(nuovoAccount);
    }

    public BankAccount find(int accountNumber) {
        for (BankAccount ba : this.accounts) {
            if (ba.getAccountNumber() == accountNumber)
                return ba;
        }
        return null;
    }

    public void deposit(int accountNumber, double amount) {
        BankAccount account=this.find(accountNumber);
        account.deposit(amount);
    }

    public void withdraw(int accountNumber, double amount) {
        BankAccount account= this.find(accountNumber);
        account.withdraw(amount);
    }

    public double getBalance(int accountNumber) {
        BankAccount account= this.find(accountNumber);
        return account.getBalance();
    }

    public void transfer(int fromAccountNumber, int toAccountNumber, double amount) {
        BankAccount accountTrasferitore = this.find(fromAccountNumber);
        BankAccount accountRicevente = this.find(toAccountNumber);
        accountTrasferitore.withdraw(amount);
        accountRicevente.deposit(amount);
    }
}