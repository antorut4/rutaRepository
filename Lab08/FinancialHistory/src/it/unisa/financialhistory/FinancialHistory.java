package it.unisa.financialhistory;

import java.util.ArrayList;
import java.util.List;

public class FinancialHistory {
    final private Person person;
    private double balance;
    final private List<Movement> movements;

    public FinancialHistory(Person person, double balance) {
        if(balance < 0)
            throw new IllegalArgumentException("Non puoi creare un conto con saldo negativo");
        this.balance=balance;
        this.person=person;
        this.movements=new ArrayList<>();
    }

    public void receiveFrom(int amount, String source) {
        this.movements.add(new Movement(source,amount));
        balance+=amount;
    }

    public void spendFor(int amount, String reason) {

        if(amount>balance)
            throw new IllegalArgumentException("Non hai abbastanza denaro");
        this.movements.add(new Movement(reason,amount));
        balance-=amount;
    }

    public double cashOnHand() {
        return balance;
    }

    public double totalReceivedFrom(String source) {
        double total=0;
        for(Movement m: movements){
            if(m.getDescription().equals(source))
                total+=m.getAmount();
        }
        return total;
    }

    public double totalSpentFor(String reason) {
        double total=0;
        for(Movement m: movements){
            if(m.getDescription().equals(reason))
                total+=m.getAmount();
        }
        return total;
    }

    public void printMovements() {
        for(Movement m: movements){
            System.out.println(m.getDescription() +","+ m.getAmount() +";");
        }
    }

}
