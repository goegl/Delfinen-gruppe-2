import java.time.LocalDate;

public class Member {
    private final String name;
    private final LocalDate dateOfBirth;
    private String phoneNumber;
    private String address;
    private boolean activeStatus;
    private final LocalDate membershipStart;
    protected boolean isPaid;


    public Member(String name, String phoneNumber, String address, LocalDate dateOfBirth, boolean activeStatus, boolean isPaid, LocalDate membershipStart) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.activeStatus = activeStatus;
        this.isPaid = isPaid;
        this.membershipStart = membershipStart;
    }

    public Member(String name, String phoneNumber, String address, LocalDate dateOfBirth, boolean activeStatus) {
        this(name, phoneNumber, address, dateOfBirth, activeStatus, true, LocalDate.now());
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

    public String membershipStartToString(LocalDate membershipStart) {
        return membershipStart.toString();
    }

    public boolean getActiveStatus() {
        return activeStatus;
    }

    public String activeStatusToString(boolean activeStatus) {
        if (activeStatus == true) {
            return "Aktiv";
        } else return "Ikke Aktiv";
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String dateOfBirthToString(LocalDate dateOfBirth) {
        return dateOfBirth.toString();
    }


    public double getMemberFee() {
        MemberFee memberFee1 = new MemberFee();
        return memberFee1.calculateFee(getActiveStatus(), getDateOfBirth());
    }


    public boolean isPaid() {
        return isPaid;
    }


    @Override
    public String toString() {
        return "" + name + "- Aktivitetsstatus:" + activeStatusToString(activeStatus);
    }

    public void setIsPaid(boolean paid) {
        this.isPaid = paid;
    }
}
