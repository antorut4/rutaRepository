import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneCompany {
    List<User> users;

    private final double minutePrice;
    private final double smsPrice;
    private final double gbPrice;

    public PhoneCompany(double minutePrice, double smsPrice, double gbPrice){
        this.users = new ArrayList<>();
        this.minutePrice = minutePrice;
        this.smsPrice = smsPrice;
        this.gbPrice = gbPrice;
    }

    public void readUserDataFromFile(File file) throws FileNotFoundException{
        Scanner in= new Scanner(file);
        while(in.hasNextLine()){
            int codUser=Integer.parseInt(in.nextLine());
            String nome=in.nextLine();
            String cognome=in.nextLine();
            User user = new User(codUser, nome, cognome);
            user.setUsedMinutes(Integer.parseInt(in.nextLine()));
            user.setUsedSMS(Integer.parseInt(in.nextLine()));
            user.setUsedMB(Double.parseDouble(in.nextLine()));
            this.users.add(user);
        }
    }

    public User findUserByCode(int cod){
        for(User u: users) {
            if (u.getCode() == cod) return u;
        }
        return null;
    }

    public void computeUserCost(User user) {
        int nmin = user.getUsedMinutes();
        int nsms = user.getUsedSMS();
        double nmb = user.getUsedMB();
        user.setTotalCost(nmin * minutePrice + nsms * smsPrice + nmb * gbPrice / 1000);
    }
}