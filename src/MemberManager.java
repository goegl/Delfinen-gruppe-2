import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MemberManager {
    List<Member> members;
    List<Member> juniorCompMembers;
    List<Member> seniorCompMembers;

    private int nextID;

    public MemberManager() {
        this.members = new ArrayList<>();
        this.juniorCompMembers = new ArrayList<>();
        this.seniorCompMembers = new ArrayList<>();
        this.nextID = 1;
    }

    public void createMember(String name, String phoneNumber, String address, LocalDate dateOfBirth, boolean activeStatus) {
        Member member = new Member(name, phoneNumber, address, dateOfBirth, nextID, activeStatus);
        member.setMemberFee();
        members.add(member);
        setNextID(nextID);
        System.out.println(member);
    }

    public void createCompetitiveMember(String name, String phoneNumber, String address, LocalDate dateOfBirth, boolean activeStatus) {
        CompetitiveMember competitiveMember = new CompetitiveMember(name, phoneNumber, address, dateOfBirth, nextID, activeStatus);
        competitiveMember.setMemberFee();
        setNextID(nextID);
        members.add(competitiveMember);

    }

    public void setNextID(int nextID) {
        this.nextID = nextID + 1;
    }


    public String printMemberList() {
        for (Member member : members) {
            System.out.println(member);
        }
        return "";
    }

    public void printJuniorCompList(LocalDate dateBirth) {
        Period age = Period.between(dateBirth, LocalDate.now());
        for (Member member : members) {
            if (age.getYears() < 18 && member instanceof CompetitiveMember) {
                juniorCompMembers.add(member);
            }

        }
    }

    @Override
    public String toString() {
        return printMemberList();
    }
}