import java.util.List;

public class Main {
    public static void main(String[] args) {
        MemberManager memberManager = new MemberManager();
        FileWriter fileManager = new FileWriter();
        CSVFileReader csvReader = new CSVFileReader();
        List<Member> loadedMembers = csvReader.readMembersFromFile("Members.CSV");
        memberManager.addMembers(loadedMembers);

        UserInterface userInterface = new UserInterface();
        userInterface.createUI(memberManager, fileManager, csvReader);

    }
}
