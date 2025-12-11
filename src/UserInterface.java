import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class UserInterface {
    private final Scanner inputSC;


    public UserInterface() {
        this.inputSC = new Scanner(System.in);
    }

    public void createUI(MemberManager memberList, FileWriter fileWriter, CSVFileReader fileReader, ResultManager resultManager) {

        while (true) {
            System.out.println("1. Opret Medlem\n" +
                    "2. Medlems Oversigt\n" +
                    "3. Træner Menu\n" +
                    "4. Kasser Menu \n");


            int createMember = inputSC.nextInt();
            inputSC.nextLine();
            switch (createMember) {
                case 1:
                    System.out.println("Indtast navn");
                    String name = nameInputValidation();
                    System.out.println("Indtast nummer");
                    String phone = phoneNumberInputValidation(inputSC);
                    System.out.println("Indtast adresse");
                    String address = lettersAndNumbersInputValidation();
                    System.out.println("Indtast fødselsdag");
                    LocalDate dateOfBirth = inputDateOfBirth(inputSC);
                    System.out.println("Aktivt medlemsskab?");
                    boolean activeStatus = isActiveStatus();
                    System.out.println("Er du konkurrence svømmer?");
                    typeOfMember(memberList, name, phone, address, dateOfBirth, activeStatus, true, fileWriter);
                    System.out.println(memberList.toString());
                    break;

                //Oversigt over alle medlemmer i Svømmeklubben
                case 2:
                    System.out.println("Svømmeklubben Delfinen's Medlemmer: ");
                    fileReader.printCSVFile("Members.CSV");
                    break;

                //Træner menu
                case 3:
                    System.out.println("1. Vis Junior Hold");
                    System.out.println("2. Vis Senior Hold \n");
                    System.out.println("3. Indtast Træningsresultat for Junior");
                    System.out.println("4. Indtast Træningsresultat for Senior");
                    System.out.println("5. Indtast StævneResultat for Junior");
                    System.out.println("6. Indtast StævneResultat for Senior \n");
                    System.out.println("7. Vis alle resultater sorteret\n");
                    System.out.println("8. Vis Top 5");

                    int trainerChoice = inputSC.nextInt();
                    inputSC.nextLine();
                    switch (trainerChoice) {
                        case 1:
                            System.out.println("Delfinen's Junior Hold: ");
                            fileReader.printCSVFile("JuniorCompetitiveMembers.CSV");
                            break;
                        case 2:
                            System.out.println("Delfinen's Senior Hold: ");
                            fileReader.printCSVFile("SeniorCompetitiveMembers.CSV");
                            break;
                        case 3:
                            createJuniorTrainingResult(memberList, resultManager, fileWriter);
                            break;
                        case 4:
                            createSeniorTrainingResult(memberList, resultManager, fileWriter);
                            break;
                        case 5:
                            createJuniorCompResult(memberList, resultManager, fileWriter);
                            break;
                        case 6:
                            createSeniorCompResult(memberList, resultManager, fileWriter);
                            break;
                        case 7:
                           resultManager.printSortedResults();
                        break;
                        case 8:
                             resultManager.printTopFive();
                        default:
                            System.out.println("Ugyldigt Valg!");


                    }
                    break;


                //Kasser Menu
                case 4:
                    System.out.println("Vælg funktion \n" +
                            "1. Se årlig inkomst \n" +
                            "2. Vælg et medlem der har betalt \n" +
                            "3. Se medlemmer i restance \n");
                    switch (inputSC.nextInt()) {
                        //Case 1: begregn inkomst
                        case 1:
                            double total = memberList.getTotalMemberFeeForOneYear();
                            System.out.println("Samlet indkomst for ét år: " + total + " kr.");
                            System.out.println("\nMedlemmer der har betalt:");
                            memberList.printMembersWhoHavePaid();
                            break;

                        //Case 2: Mark isPaid
                        case 2:
                            memberList.markMemberisPaid(memberList, inputSC);
                            break;
                        //Case 3: Print medlemmer i restance
                        case 3:
                            memberList.printMembersInRestance();

                            break;
                    }
            }
        }
    }

    private void createSeniorCompResult(MemberManager memberList, ResultManager resultManager, FileWriter fileWriter) {
        System.out.println("Træningsresultat for Seniorsvømmer");
        System.out.println("Indtast telefonnummer på svømmeren");
        CompetitiveMember member = memberList.getCompMemberWithPhonenumber(phoneNumberInputValidation(inputSC), memberList.getSeniorCompMembers());
        System.out.println("Vælg disciplin: \n 1. Crawl, 2.Rygcrawl, 3.Brystsvømning, 4.Butterfly");
        Disciplines discipline = typeOfDiscipline();
        System.out.println("Indtast Distance");
        int distance = inputSC.nextInt();
        System.out.println("Indtast Minutter");
        int minutes = inputSC.nextInt();
        System.out.println("Indtast Sekunder");
        int seconds = inputSC.nextInt();
        System.out.println("Indtast Millisekunder");
        int millis = inputSC.nextInt();
        String resultTime = String.format("%02d:%02d:%03d", minutes, seconds, millis);
        inputSC.nextLine();
        System.out.println("Indtast Stævnenavn");
        String compettitionName = lettersAndNumbersInputValidation();
        resultManager.createCompetitiveResult(member, discipline, distance, minutes, seconds, millis, LocalDate.now(), resultTime, compettitionName, fileWriter);
    }

    private void createJuniorCompResult(MemberManager memberList, ResultManager resultManager, FileWriter fileWriter) {
        System.out.println("Stævneresultat for Juniorsvømmer");
        System.out.println("Indtast telefonnummer på svømmeren");
        CompetitiveMember member = memberList.getCompMemberWithPhonenumber(phoneNumberInputValidation(inputSC), memberList.getJuniorCompMembers());
        System.out.println("Vælg disciplin: \n 1. Crawl, 2.Rygcrawl, 3.Brystsvømning, 4.Butterfly");
        Disciplines discipline = typeOfDiscipline();
        System.out.println("Indtast Distance");
        int distance = inputSC.nextInt();
        System.out.println("Indtast Minutter");
        int minutes = inputSC.nextInt();
        System.out.println("Indtast Sekunder");
        int seconds = inputSC.nextInt();
        System.out.println("Indtast Millisekunder");
        int millis = inputSC.nextInt();
        String resultTime = String.format("%02d:%02d:%03d", minutes, seconds, millis);
        inputSC.nextLine();
        System.out.println("Indtast Stævnenavn");
        String competitionName = lettersAndNumbersInputValidation();
        resultManager.createCompetitiveResult(member, discipline, distance, minutes, seconds, millis ,LocalDate.now(), resultTime ,competitionName, fileWriter);
    }

    private void createSeniorTrainingResult(MemberManager memberList, ResultManager resultManager, FileWriter fileWriter) {
        System.out.println("Træningsresultat for Seniorsvømmer");
        System.out.println("Indtast telefonnummer på svømmeren");
        CompetitiveMember member = memberList.getCompMemberWithPhonenumber(phoneNumberInputValidation(inputSC), memberList.getSeniorCompMembers());
        System.out.println("Vælg disciplin: \n 1. Crawl, 2.Rygcrawl, 3.Brystsvømning, 4.Butterfly");
        Disciplines discipline = typeOfDiscipline();
        System.out.println("Indtast Distance");
        int distance = inputSC.nextInt();
        System.out.println("Indtast Minutter");
        int minutes = inputSC.nextInt();
        System.out.println("Indtast Sekunder");
        int seconds = inputSC.nextInt();
        System.out.println("Indtast Millisekunder");
        int millis = inputSC.nextInt();
        String resultTime = String.format("%02d:%02d:%03d", minutes, seconds, millis);
        resultManager.createTrainingResult(member, discipline, distance, minutes, seconds, millis, LocalDate.now(), resultTime ,fileWriter);
    }

    private void createJuniorTrainingResult(MemberManager memberList, ResultManager resultManager, FileWriter fileWriter) {
        System.out.println("Træningsresultat for Juniorsvømmer");
        System.out.println("Indtast telefonnummer på svømmeren");
        CompetitiveMember member = memberList.getCompMemberWithPhonenumber(phoneNumberInputValidation(inputSC), memberList.getJuniorCompMembers());
        System.out.println("Vælg disciplin: \n 1. Crawl, 2.Rygcrawl, 3.Brystsvømning, 4.Butterfly");
        Disciplines discipline = typeOfDiscipline();
        System.out.println("Indtast Distance");
        int distance = inputSC.nextInt();
        System.out.println("Indtast Minutter");
        int minutes = inputSC.nextInt();
        System.out.println("Indtast Sekunder");
        int seconds = inputSC.nextInt();
        System.out.println("Indtast Millisekunder");
        int millis = inputSC.nextInt();
        String resultTime = String.format("%02d:%02d:%03d", minutes, seconds, millis);
        resultManager.createTrainingResult(member, discipline, distance, minutes, seconds, millis, LocalDate.now(), resultTime, fileWriter);

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

    //Method to choose Discipline
    public Disciplines typeOfDiscipline()   {
        while (true) {
            int input = inputSC.nextInt();
            if (input == 1) {
                return Disciplines.CRAWL;
            } else if (input == 2) {
                return Disciplines.BACKCRAWL;
            } else if (input == 3) {
                return Disciplines.BREASTSTROKE;
            } else if (input == 4) {
                return Disciplines.BUTTERFLY;
            } else
                System.out.println("Der skal indtastes et tal 1-4");
            continue;
        }
    }

    private String lettersAndNumbersInputValidation() {
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

    private static String phoneNumberInputValidation(Scanner inputSC) {
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
                CompetitiveMember competitiveMember = memberList.createCompetitiveMember(name, phone, address, dateOfBirth, activeStatus);
                fileWriter.writeMemberToCSV(competitiveMember, "Members.CSV");
                if (MemberFee.isJunior(dateOfBirth)) {
                    fileWriter.writeJuniorCompetitiveMembersToCSV(competitiveMember, "JuniorCompetitiveMembers.CSV");
                } else
                    fileWriter.writeSeniorCompetitiveMembersToCSV(competitiveMember, "SeniorCompetitiveMembers.CSV");
                break;

            } else if (status == 2) {

                Member member =
                        memberList.createMember(name, phone, address, dateOfBirth, activeStatus);

                fileWriter.writeMemberToCSV(member, "Members.CSV");
                break;

            } else {
                System.out.println("Ugyldigt input, prøv igen: (Tast 1: Konkurrencesvømmer, 2: Motionist)");
            }
        }
    }


    //Added method to chose activeStatus with input validation
    private boolean isActiveStatus() {
        boolean activeStatus;
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


