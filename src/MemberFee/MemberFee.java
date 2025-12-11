package MemberFee;

import java.time.LocalDate;
import java.time.Period;

public class MemberFee {
    private double juniorFee;
    private double seniorFee;
    private double retireeFee;
    private double inactiveFee;

    public MemberFee(){
        this.inactiveFee = 500;
        this.juniorFee = 1000;
        this.seniorFee = 1600;
        this.retireeFee = seniorFee/100*75;
    }
//Calculate members fees for different age groups
    public double calculateFee(boolean isActive, LocalDate dateOfBirth){
            if(isActive != true){
                return inactiveFee;
            } else if (isJunior(dateOfBirth)){
            return juniorFee;
            } else if (isRetiree(dateOfBirth)) {
                return retireeFee;
            } else return seniorFee;
    }

    public static boolean isRetiree(LocalDate dateOfBirth) {
        return calculateAge(dateOfBirth) >= 60;
    }

    public static boolean isJunior(LocalDate dateOfBirth) {
        return calculateAge(dateOfBirth) < 18;
    }

    public static int calculateAge(LocalDate dateOfBirth) {
        Period age = Period.between(dateOfBirth, LocalDate.now());
        return age.getYears();
    }


}
