import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MemberManager {
    List<Member> members;

    public MemberManager() {
        this.members = new ArrayList<>();
    }
    public void createMember(String name, String phoneNumber, String address, LocalDate dateOfBirth, int memberID, boolean activeStatus){
        Member member = new Member(name, phoneNumber, address, dateOfBirth, memberID, activeStatus);
        member.setMemberFee();
        members.add(member);
        System.out.println(member);
    }
    public String printMemberList(){
        for(Member member : members){
            System.out.println(member);
        }
        return "";
    }

    @Override
    public String toString() {
        return printMemberList();
    }
}