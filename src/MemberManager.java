import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MemberManager {
    List<Member> members;
    private int nextID;

    public MemberManager() {
        this.members = new ArrayList<>();
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

    @Override
    public String toString() {
        return printMemberList();
    }
}