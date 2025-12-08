import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class MemberManager {
    List<Member> members;
    List<CompetitiveMember> juniorCompMembers;
    List<CompetitiveMember> seniorCompMembers;
    private final MemberFee memberFeeCalculator = new MemberFee();


    public MemberManager() {
        this.members = new ArrayList<>();
        this.juniorCompMembers = new ArrayList<>();
        this.seniorCompMembers = new ArrayList<>();
    }

    public Member createMember(String name, String phoneNumber, String address, LocalDate dateOfBirth, boolean activeStatus) {
        Member member = new Member(name, phoneNumber, address, dateOfBirth, activeStatus);
        members.add(member);
        System.out.println(member);
        return member;
    }

    public CompetitiveMember createCompetitiveMember(String name, String phoneNumber, String address, LocalDate dateOfBirth, boolean activeStatus) {
        CompetitiveMember competitiveMember = new CompetitiveMember(name, phoneNumber, address, dateOfBirth, activeStatus);
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
    public void printMembersInRestance() {
        System.out.println("Medlemmer der ikke har betalt:");
        boolean found = false;
        for (Member member : members) {
            if (!member.isPaid()) {
                System.out.println(member);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Alle medlemmer har betalt.");
        }
    }
    public void addMembers(List<Member> membersFromFile) {
        members.addAll(membersFromFile);
    }


    public void printJuniorCompLists(){
        for(CompetitiveMember member : juniorCompMembers){
            System.out.println(member);
        }
    }
    public void printSeniorCompLists(){
        for(CompetitiveMember member : seniorCompMembers){
            System.out.println(member);
        }
    }

    public void addToCompList(CompetitiveMember compMember) {
        Period age = Period.between(compMember.getDateOfBirth(), LocalDate.now());
            if (age.getYears() < 18) {
                juniorCompMembers.add(compMember);
            } else if (age.getYears() <= 18) {
                seniorCompMembers.add(compMember);
            }

    }
    public boolean setIsPaidForMember(String phoneNumber, boolean paid) {
        Member member = getMemberWithPhonenumber(phoneNumber);
        if (member != null) {
            member.setIsPaid(paid);
            return true;
        }
        return false;
    }
    public Member getMemberWithPhonenumber(String phoneNumber) {
        for (Member m : members) {
            if (m.getPhoneNumber().equals(phoneNumber)) {
                return m;
            }
        }
        return null;
    }
    public double getTotalMemberFeeForOneYear() {
        double totalFee = 0.0;

        for (Member member : members) {
            totalFee += memberFeeCalculator.calculateFee(
                    member.getActiveStatus(),
                    member.getDateOfBirth()
            );
        }

        for (CompetitiveMember member : juniorCompMembers) {
            totalFee += memberFeeCalculator.calculateFee(
                    member.getActiveStatus(),
                    member.getDateOfBirth()
            );
        }

        for (CompetitiveMember member : seniorCompMembers) {
            totalFee += memberFeeCalculator.calculateFee(
                    member.getActiveStatus(),
                    member.getDateOfBirth()
            );
        }

        return totalFee;
    }
    public void printMembersWhoHavePaid() {
        for (Member member : members) {
            if (member.isPaid()) {
                System.out.println(member);
            }
        }

        for (CompetitiveMember member : juniorCompMembers) {
            if (member.isPaid()) {
                System.out.println(member);
            }
        }

        for (CompetitiveMember member : seniorCompMembers) {
            if (member.isPaid()) {
                System.out.println(member);
            }
        }
    }



    @Override
    public String toString() {
        return printMemberList();
    }
}