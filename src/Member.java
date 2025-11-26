import java.time.LocalDate;

public class Member {
    private final String name;
    private final LocalDate dateOfBirth;
    private String phoneNumber;
    private final int memberID;
    private String address;
    private boolean activeStatus;
    double memberFee;
    private final LocalDate membershipStart;

    public Member(String name, String phoneNumber, String address, LocalDate dateOfBirth, int memberID, boolean activeStatus, double memberFee){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.memberID = memberID;
        this.address = address;
        this.activeStatus = activeStatus;
        this.memberFee = MemberFee.getFee(dateOfBirth);
        this.membershipStart = LocalDate.now();
    }


}
