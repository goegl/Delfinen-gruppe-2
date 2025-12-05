import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class MemberManager {
    List<Member> members;
    List<CompetitiveMember> juniorCompMembers;
    List<CompetitiveMember> seniorCompMembers;

    private int nextID;

    public MemberManager() {
        this.members = new ArrayList<>();
        this.juniorCompMembers = new ArrayList<>();
        this.seniorCompMembers = new ArrayList<>();
        this.nextID = 1;
    }

    public Member createMember(String name, String phoneNumber, String address, LocalDate dateOfBirth, boolean activeStatus) {
        Member member = new Member(name, phoneNumber, address, dateOfBirth, nextID, activeStatus);
        member.setMemberFee();
        members.add(member);
        setNextID(nextID);
        System.out.println(member);
        return member;
    }

    public Member createCompetitiveMember(String name, String phoneNumber, String address, LocalDate dateOfBirth, boolean activeStatus) {
        CompetitiveMember competitiveMember = new CompetitiveMember(name, phoneNumber, address, dateOfBirth, nextID, activeStatus);
        competitiveMember.setMemberFee();
        setNextID(nextID);
        members.add(competitiveMember);
        addToCompList(competitiveMember);
        return competitiveMember;
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

    public String printJuniorCompLists(){
        for(CompetitiveMember member : juniorCompMembers){
            System.out.println(member);
        }
        return "";
    }
    public String printSeniorCompLists(){
        for(CompetitiveMember member : seniorCompMembers){
            System.out.println(member);
        }
        return "";
    }

    public void addToCompList(CompetitiveMember compMember) {
        Period age = Period.between(compMember.getDateOfBirth(), LocalDate.now());
            if (age.getYears() < 18) {
                juniorCompMembers.add(compMember);
            } else if (age.getYears() <= 18) {
                seniorCompMembers.add(compMember);
            }

    }

    @Override
    public String toString() {
        return printMemberList();
    }
}