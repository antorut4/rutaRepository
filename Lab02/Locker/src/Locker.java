public class Locker {

    private boolean isOpen;
    private String code;

    public Locker() {
        isOpen = true;
        code = "";
    }

    public void unlock(String code) {
        if(code.equalsIgnoreCase(this.code))isOpen=true;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void lock() {
        isOpen=false;
    }

    public void newComb(String newCode) {
        code=newCode;
    }

}