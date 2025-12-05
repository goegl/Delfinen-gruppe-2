import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class MemberManager {
    List<Member> members;
    List<CompetitiveMember> juniorCompMembers;
    List<CompetitiveMember> seniorCompMembers;


    public MemberManager() {
        this.members = new ArrayList<>();
        this.juniorCompMembers = new ArrayList<>();
        this.seniorCompMembers = new ArrayList<>();
    }

    public Member createMember(String name, String phoneNumber, String address, LocalDate dateOfBirth, boolean activeStatus, boolean isPaid) {
        Member member = new Member(name, phoneNumber, address, dateOfBirth, activeStatus, isPaid);
        member.setMemberFee();
        members.add(member);
        System.out.println(member);
        return member;
    }

    public CompetitiveMember createCompetitiveMember(String name, String phoneNumber, String address, LocalDate dateOfBirth, boolean activeStatus, boolean isPaid) {
        CompetitiveMember competitiveMember = new CompetitiveMember(name, phoneNumber, address, dateOfBirth, activeStatus, isPaid);
        competitiveMember.setMemberFee();
        members.add(competitiveMember);
        addToCompList(competitiveMember);
        return competitiveMember;
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
    public boolean setIsPaid(Member member){
        if(member.getIsPaid() == true){
            return false;

        }else{
            return true;
        }
    }
    public Member findByPhoneNumber(String phoneNumber) {
        Member memberToFind = null;
        while (memberToFind == null) {
            for (Member member : members) {
                if (member.getPhoneNumber() == phoneNumber) {
                    return memberToFind = member;

                } else if (memberToFind == null) {
                    System.out.println("Kunne ikke finde medlem");

                }
            }
        }
        return memberToFind;
    }


    @Override
    public String toString() {
        return printMemberList();
    }
}