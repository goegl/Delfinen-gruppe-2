import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class UserInterface {
    private Scanner inputSC;
    MemberManager memberList;

    public UserInterface() {
        this.inputSC = new Scanner(System.in);
        this.memberList = new MemberManager();
    }

    public void createUI() {

        while (true) {
            System.out.println("1. Opret Medlem\n" +
                    "2. ");


            int number = inputSC.nextInt();
            inputSC.nextLine();
            switch (number) {
                case 1:
                    System.out.println("Indtast Navn");
                    String name = inputSC.nextLine();
                    System.out.println("Intast nummer");
                    String phone = inputSC.nextLine();
                    System.out.println("Intast adresse");
                    String address = inputSC.nextLine();
                    System.out.println("Intast fødselsdag");
                    LocalDate dateOfBirth = inputDateOfBirth(inputSC);
                    System.out.println("Aktivt medlemsskab?");
                    boolean activeStatus = true;
                    int status = inputSC.nextInt();
                    if (status == 1) {
                        activeStatus = true;
                    }
                    if (status == 2) {
                        activeStatus = false;
                    }



                    int iD = 1;


                    memberList.createMember(name, phone, address, dateOfBirth, iD, activeStatus);
                    System.out.println(memberList.toString());

            }
        }
    }

    public LocalDate inputDateOfBirth(Scanner sc) {
        System.out.print("Skriv fødselsdato i følgende format: ÅR-MÅNED-DAG: ");
        LocalDate dateOfBirth = LocalDate.of(sc.nextInt(), sc.nextInt(), sc.nextInt());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        String formattedString = dateOfBirth.format(formatter);
        System.out.println(formattedString);
        return dateOfBirth;

    }

}
