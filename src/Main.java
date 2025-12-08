import java.util.List;

public class Main {
    public static void main(String[] args) {
        MemberManager memberManager = new MemberManager();
        FileWriter fileManager = new FileWriter();
        CSVFileReader csvReader = new CSVFileReader();
//        List<Member> loadedMembers = csvReader.readMembersFromFile("Members.CSV");
//        memberManager.addMembers(loadedMembers);
        //System.out.println("Antal medlemmer indlæst: " + memberManager.members.size());

        //Add members
        //Member andreas = new Member("Andreas", "12345678", "Vejen 1", LocalDate.of(1999, 2,5), 1, true);
        // CompetitiveMember emil = new CompetitiveMember("Emil", "87654321", "Gaden", LocalDate.of(1920, 9, 5), 2, true);

//
//        System.out.println(andreas + "\n" + emil);
//        Result result = new Result(emil, Disciplines.CRAWL, 17.2, LocalDate.now());
//
//        MemberManager mm = new MemberManager();
//        mm.createMember("Anders And", "12345678", "Vejen 1", LocalDate.of(1999, 2,5), true);
        UserInterface userInterface = new UserInterface();
        userInterface.createUI(memberManager, fileManager, csvReader);

    }
}
