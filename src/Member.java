import java.time.LocalDate;

public class Member{
    private final String name;
    private final LocalDate dateOfBirth;
    private String phoneNumber;
    private String address;
    private boolean activeStatus;
    double memberFee;
    private final LocalDate membershipStart;
    private boolean isPaid;

    public Member(String name, String phoneNumber, String address, LocalDate dateOfBirth, boolean activeStatus, boolean isPaid){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.activeStatus = activeStatus;
        this.memberFee = 0;
        this.membershipStart = LocalDate.now();
        this.isPaid = true;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public LocalDate getMembershipStart() {
        return membershipStart;
    }
    public String membershipStartToString(LocalDate membershipStart){
        return membershipStart.toString();
    }

    public boolean getActiveStatus() {
        return activeStatus;
    }

    public String activeStatusToString(boolean activeStatus){
        if (activeStatus == true){
            return "Er Aktiv";
        } else return "Er Inaktiv";
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String dateOfBirthToString(LocalDate dateOfBirth){
        return dateOfBirth.toString();
    }

    public void setMemberFee() {
        MemberFee memberFee1 = new MemberFee();
        this.memberFee = memberFee1.calculateFee(getActiveStatus(), getDateOfBirth());
    }

    public double getMemberFee() {
        return memberFee;
    }


    public boolean getIsPaid() {
        return isPaid;
    }

    @Override
    public String toString() {
        return String.valueOf(getMemberFee()) + "KR " + " " + name + " " + activeStatus;
    }
}
