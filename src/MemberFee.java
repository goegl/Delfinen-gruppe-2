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


}
