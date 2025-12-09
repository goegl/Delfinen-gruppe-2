import java.util.List;

public class Main {
    public static void main(String[] args) {
        MemberManager memberManager = new MemberManager();
        ResultManager resultManager = new ResultManager();
        FileWriter fileManager = new FileWriter();
        CSVFileReader csvReader = new CSVFileReader();
        List<Member> loadedMembers = csvReader.readMembersFromFile("Members.CSV");
        memberManager.addMembers(loadedMembers);
        List<CompetitiveMember> loadedJuniorCompMembers = csvReader.readCompMemberFromCSV("JuniorCompetitiveMembers.CSV");
        memberManager.addJuniorCompetitiveMembers(loadedJuniorCompMembers);
        List<CompetitiveMember> loadedSeniorCompMembers = csvReader.readCompMemberFromCSV("SeniorCompetitiveMembers.CSV");
        memberManager.addSeniorCompetitiveMembers(loadedSeniorCompMembers);
        UserInterface userInterface = new UserInterface();
        userInterface.createUI(memberManager, fileManager, csvReader, resultManager);

    }
}
