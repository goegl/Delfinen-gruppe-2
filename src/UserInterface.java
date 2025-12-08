import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class UserInterface {
    private final Scanner inputSC;


    public UserInterface() {
        this.inputSC = new Scanner(System.in);
    }

    public void createUI(MemberManager memberList, FileWriter fileWriter) {

        while (true) {
            System.out.println("1. Opret Medlem\n" +
                    "2. Træner Menu\n" +
                    "3. Kasser Menu \n");


            int createMember = inputSC.nextInt();
            inputSC.nextLine();
            switch (createMember) {
                case 1:
                    System.out.println("Indtast navn");
                    String name = nameInputValidation();
                    System.out.println("Indtast nummer");
                    String phone = numberInputValidation();
                    System.out.println("Indtast adresse");
                    String address = addressInputValidation();
                    System.out.println("Indtast fødselsdag");
                    LocalDate dateOfBirth = inputDateOfBirth(inputSC);
                    System.out.println("Aktivt medlemsskab?");
                    boolean activeStatus = isActiveStatus();
                    System.out.println("Er du konkurrence svømmer?");
                    typeOfMember(memberList, name, phone, address, dateOfBirth, activeStatus, true ,fileWriter);
                    System.out.println(memberList.toString());
                    break;

                //Træner menu
                case 2:
                    System.out.println("1. Vis Junior Hold");
                    System.out.println("2. Vis Senior Hold");
                    System.out.println("3. Vis Top 5");

                    int trainerChoice = inputSC.nextInt();
                    inputSC.nextLine();
                    switch(trainerChoice){
                        case 1:
                            System.out.println("Delfinen's Junior Hold: ");
                            memberList.printCSVFile("JuniorCompetitiveMembers.CSV");
                            break;
                        case 2:
                            System.out.println("Delfinen's Senior Hold: ");
                            memberList.printCSVFile("SeniorCompetitiveMembers.CSV");
                            break;
                        default:
                            System.out.println("Ugyldigt Valg!");


                    }
                    break;
                    //Kasser Menu
                case 3:
                    System.out.println("Vælg funktion \n" +
                            "2. Vælg et medlem der har betalt \n");
                    switch(inputSC.nextInt()){
                        //Case 1: begregn inkomst
                        case 1:
                            System.out.println(" ");

                        break;
                        //Case 2: Mark isPaid
                        case 2:
                            markMemberisPaid(memberList);
                            break;
                        //Case 3: Print medlemmer i restance
                        case 3:
                            System.out.println("Medlemmer i restance");

                            break;
                    }
            }
        }
    }

    private void markMemberisPaid(MemberManager memberList) {
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

    //Method to only take String for name variable
    private String nameInputValidation() {
        while (true) {
            String input = inputSC.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Prøv igen:");
                continue;
            }

            if (!input.matches("^[A-Za-zæøåÆØÅ ]+$")) {
                System.out.println("Kun bogstaver bliver accepteret. Prøv igen:");
                continue;
            }

            return input;
        }
    }

    private String addressInputValidation() {
        while (true) {
            String input = inputSC.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Prøv igen:");
                continue;
            }

            if (!input.matches("^[A-Za-zæøåÆØÅ 0-9]+$")) {
                System.out.println("Kun bogstaver og tal bliver accepteret. Prøv igen:");
                continue;
            }

            return input;
        }
    }

    private String numberInputValidation() {
        while (true) {
            String input = inputSC.nextLine().trim();

            if (!input.matches("\\d{8}")) {

                {
                    System.out.println("Prøv igen: Kun 8 cifre");
                    continue;
                }

            }
            if (!input.matches("^[0-9]+$")) {
                System.out.println("Kun tal bliver accepteret. Prøv igen:");
                continue;
            }

            return input;
        }
    }


    private void typeOfMember(MemberManager memberList, String name, String phone, String address,
                              LocalDate dateOfBirth, boolean activeStatus, boolean isPaid, FileWriter fileWriter) {
        while (true) {
            int status = inputSC.nextInt();
            inputSC.nextLine();
            if (status == 1) {
                fileWriter.writeMemberToCSV(memberList.createCompetitiveMember(name, phone, address, dateOfBirth, activeStatus), "Members.CSV");
                if(memberList.createCompetitiveMember(name, phone, address, dateOfBirth, activeStatus).getAgeInt(dateOfBirth) < 18){
                    fileWriter.writeJuniorCompetitiveMembersToCSV(memberList.createCompetitiveMember(name, phone, address, dateOfBirth, activeStatus), "JuniorCompetitiveMembers.CSV");
                } else if (memberList.createCompetitiveMember(name, phone, address, dateOfBirth, activeStatus).getAgeInt(dateOfBirth) > 18)
                    fileWriter.writeSeniorCompetitiveMembersToCSV(memberList.createCompetitiveMember(name, phone, address, dateOfBirth, activeStatus), "SeniorCompetitiveMembers.CSV");
                break;
            } else if (status == 2) {
                fileWriter.writeMemberToCSV(memberList.createMember(name, phone, address, dateOfBirth, activeStatus), "Members.CSV");
                break;
            } else {
                System.out.println("Ugyldigt input, prøv igen: (Tast 1: Konkurrencesvømmer, 2: Motionist)");
            }
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


