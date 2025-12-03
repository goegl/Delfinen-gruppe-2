import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class UserInterface {
    private Scanner inputSC;


    public UserInterface() {
        this.inputSC = new Scanner(System.in);
    }

    public void createUI(MemberManager memberList, FileManager fileManager) {

        while (true) {
            System.out.println("1. Opret Medlem\n" +
                    "2. ");


            int number = inputSC.nextInt();
            inputSC.nextLine();
            switch (number) {
                case 1:
                    System.out.println("Indtast navn");
                    nameInputValidation(inputSC.nextLine());
                    System.out.println("Indtast nummer");
                    String phone = inputSC.nextLine();
                    System.out.println("Indtast adresse");
                    String address = inputSC.nextLine();
                    System.out.println("Indtast fødselsdag");
                    LocalDate dateOfBirth = inputDateOfBirth(inputSC);
                    System.out.println("Aktivt medlemsskab?");
                    boolean activeStatus = isActiveStatus();
                    System.out.println("Er du konkurrence svømmer?");
                    typeOfMember(memberList, nameInputValidation(inputSC.nextLine()), phone, address, dateOfBirth, activeStatus, fileManager);
                    System.out.println(memberList.toString());
            }
        }
    }

    private String nameInputValidation(String input) {
        while(true) {

            if (input == null || input.trim().isEmpty()) {
                throw new IllegalArgumentException("Indtast dit navn.");
            }
            if (!input.matches("^[A-Åa-å]")) {
                throw new IllegalArgumentException("Et navn kan kun indeholde bogstaver");
            }


            return input;

        }
    }

    private void typeOfMember(MemberManager memberList, String phone, String address, String s, LocalDate
            dateOfBirth, boolean activeStatus, FileManager fileManager) {
        while (true) {
            int status = inputSC.nextInt();
            if (status == 1) {
                memberList.createCompetitiveMember(nameInputValidation(inputSC.nextLine()), phone, address, dateOfBirth, activeStatus);
                //fileManager.writeCompetitiveMembersToCSV(memberList.members, "Members.CSV");
                break;
            } else if (status == 2) {
                memberList.createMember(nameInputValidation(inputSC.nextLine()), phone, address, dateOfBirth, activeStatus);
                fileManager.writeMembersToCSV(memberList.members, "Members.CSV");
                break;
            } else {
                System.out.println("Ugyldigt input, prøv igen: (Tast 1: Konkurrencesvømmer, 2: Motionist");
            }
            inputSC.nextLine();
        }
    }

    //Added method to chose activeStatus with input validation
    private boolean isActiveStatus() {
        boolean activeStatus = false;
        while (true) {
            int status = inputSC.nextInt();

            if (status == 1) {
                activeStatus = true;
                break;
            } else if (status == 2) {
                activeStatus = false;
                break;
            } else {
                System.out.println("Ugyldigt valg. Prøv igen: (1 = Aktiv, 2 = Passiv)");
            }
        }
        inputSC.nextLine();
        return activeStatus;
    }

    //Method to input date of birth of new members, and format it to "ÅR-MÅNED-DAG"
    public LocalDate inputDateOfBirth(Scanner sc) {
        System.out.print("Skriv fødselsdato i følgende format: ÅR-MÅNED-DAG: ");
        LocalDate dateOfBirth = LocalDate.of(sc.nextInt(), sc.nextInt(), sc.nextInt());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        String formattedString = dateOfBirth.format(formatter);
        System.out.println(formattedString);
        return dateOfBirth;

    }
}
