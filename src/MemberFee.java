import java.time.LocalDate;
import java.time.Period;

public class MemberFee {
    private static double juniorFee;
    private static double seniorFee;
    private static double retireeFee;
    private static double inactiveFee;

    public MemberFee(){
        this.inactiveFee = 500;
        this.juniorFee = 1000;
        this.seniorFee = 1600;
        this.retireeFee = seniorFee/100*75;
    }

    public static double calculateFee(boolean isActive, LocalDate dateOfBirth){
        Period age = Period.between(dateOfBirth, LocalDate.now());
            if(isActive != true){
                return inactiveFee;
            } else if (age.getYears() < 18){
            return juniorFee;
            } else if (age.getYears() >= 60) {
                return retireeFee;
            } else return seniorFee;
    }
}
