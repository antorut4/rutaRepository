import java.util.Random;
import java.util.Scanner;

public class Dice {

    public static void main(String[] args) {
        BankAccount playerAccount = new BankAccount(1000);
        BankAccount casinoAccount = new BankAccount(100000);
        int predictedValue, actualValue;
        double bet;
        String choice = "no";
        Scanner in = new Scanner(System.in);

        do{
            choice = "no"; //inizializzo per la domanda di continuare
            System.out.println("Scommetti la faccia del dado 1 a 6: ");

            actualValue = in.nextInt();

            do {
                System.out.println("Quanto vuoi scommettere? ");
                bet = in.nextDouble();
                if (playerAccount.getBalance() < bet) {
                    System.out.println("Errore non hai abbastanza soldi.");
                }
            } while(playerAccount.getBalance() < bet && casinoAccount.getBalance() < 5*bet);

            Random lancio = new Random();
            predictedValue = lancio.nextInt(5) + 1;
            if( actualValue == predictedValue ){ //vincita
                System.out.println("Hai vinto!");
                casinoAccount.withdraw(5*bet);
                playerAccount.deposit(5*bet);
            }
            else { //perso
                System.out.println("Hai perso!");
                playerAccount.withdraw(bet);
                casinoAccount.deposit(bet);
            }

            System.out.println("Il tuo saldo è " + playerAccount.getBalance());
            System.out.println("Il saldo del casinò è " + casinoAccount.getBalance());

            if( choice.equalsIgnoreCase("no")) {
                System.out.println("Vuoi ancora giocare? (sì per continuare)");
                String temp = in.next();
                if( temp.equalsIgnoreCase("si") )
                    choice = "si";

            }
        }while( playerAccount.getBalance() > 0 && choice.equalsIgnoreCase("si"));
        System.out.println("Il tuo saldo è " + playerAccount.getBalance());
    }
}
