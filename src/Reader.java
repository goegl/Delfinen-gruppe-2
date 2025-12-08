import java.util.List;

public interface Reader {
    List<Member> readMembersFromFile(String filePath);
}
