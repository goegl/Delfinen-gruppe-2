import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileManager {

    public void writeMembersToCSV(List<Member> members, String filepath){
        try(FileWriter writer = new FileWriter(filepath)){
            writer.append("Name, PhoneNumber, Adress"+ "\n");
            for(Member member : members){
                writer.append(member.getName()).append(",");
                writer.append(member.getPhoneNumber()).append(",");
            }
            writer.close();
            System.out.println("CVS fil skrevet til" + filepath);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
