public class VendingMachine {
    private int numberOfCans;
    private int numberOfTokens;

    public VendingMachine() {
    }

    public VendingMachine(int initialNumberOfCans) {
        numberOfCans = initialNumberOfCans;
        numberOfTokens = 0;
    }

    public void addCans(int numberOfNewCans) {
        numberOfCans+=numberOfNewCans;
    }

    public void takeCan() {
        numberOfCans--;
        numberOfTokens++;
    }

    public void takeTokens() {
        numberOfTokens--;
    }

    public int getNumberOfCans() {
        return numberOfCans;
    }

    public int getNumberOfTokens() {
        return numberOfTokens;
    }
}