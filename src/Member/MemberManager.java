package Member;

import MemberFee.MemberFee;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberManager {
    private List<Member> members;
    private List<CompetitiveMember> juniorCompMembers;
    private List<CompetitiveMember> seniorCompMembers;
    private final MemberFee memberFeeCalculator = new MemberFee();


    public MemberManager() {
        this.members = new ArrayList<>();
        this.juniorCompMembers = new ArrayList<>();
        this.seniorCompMembers = new ArrayList<>();
    }

    public Member createMember(String name, String phoneNumber, String address, LocalDate dateOfBirth, boolean activeStatus) {
        Member member = new Member(name, phoneNumber, address, dateOfBirth, activeStatus);
        members.add(member);
        System.out.println("Medlem: " + member + " er oprettet");
        return member;
    }

    public CompetitiveMember createCompetitiveMember(String name, String phoneNumber, String address, LocalDate dateOfBirth, boolean activeStatus) {
        CompetitiveMember competitiveMember = new CompetitiveMember(name, phoneNumber, address, dateOfBirth, activeStatus);
        members.add(competitiveMember);
        addToCompList(competitiveMember);
        System.out.println("Medlem: " + competitiveMember + "er oprettet");
        return competitiveMember;
    }

     //Vi kan printe medlemslisten med printCSVFile i CSVFileReader klassen
    public String printMemberList() {
        for (Member member : members) {
            System.out.println(member);
        }
        return " \n";
    }

    public void printMembersInRestance() {
        System.out.println("Medlemmer der ikke har betalt:");
        boolean found = false;
        for (Member member : members) {
            if (!member.isPaid()) {
                System.out.println(""+member.getName() + ": " +  "Kontingentsats: " + member.getMemberFee() + " Kr.");
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
    public void  addJuniorCompetitiveMembers(List<CompetitiveMember> juniorMembersFromFile){
        juniorCompMembers.addAll(juniorMembersFromFile);
    }
    public void addSeniorCompetitiveMembers(List<CompetitiveMember> seniorMembersFromFile){
        seniorCompMembers.addAll(seniorMembersFromFile);
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

        if (age.getYears() < 18) {
            juniorCompMembers.add(compMember);
        } else {
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

    public List<Member> getMembers() {
        return members;
    }

    public List<CompetitiveMember> getJuniorCompMembers() {
        return juniorCompMembers;
    }

    public List<CompetitiveMember> getSeniorCompMembers() {
        return seniorCompMembers;
    }

    public CompetitiveMember getCompMemberWithPhonenumber(String phoneNumber, List<CompetitiveMember> compMemberList) {
        for (CompetitiveMember m : compMemberList) {
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

        return totalFee;
    }

    public void printMembersWhoHavePaid() {
        for (Member member : members)
            if (member.isPaid() == true) {
                System.out.println(member);
            }
    }

    public void markMemberisPaid(MemberManager memberList, Scanner inputSC) {
        System.out.println("Indtast telefonnummer på medlem:");
        inputSC.nextLine();
        String phoneNumber = inputSC.nextLine();
        Member m = memberList.getMemberWithPhonenumber(phoneNumber);
        if (m != null) {
            m.setIsPaid(true);
            System.out.println("Medlem med nummer " + phoneNumber + " er nu markeret som betalt.");
        } else {
            System.out.println("Intet medlem med det telefonnummer blev fundet.");
        }
    }


    @Override
    public String toString() {
        return "" + printMemberList();
    }
}