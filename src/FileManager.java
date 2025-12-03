import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileManager {

    public void writeMembersToCSV(List<Member> members, String filepath){
        try(FileWriter writer = new FileWriter(filepath, true)){
            writer.append("Name, PhoneNumber, Address, Aktiv Status, Fødselsdagsdato, MedlemsId, Kontingentsats, Oprettelsesdato"+ "\n");
            for(Member member : members){
                writer.append(member.getName()).append(" ,");
                writer.append(member.getPhoneNumber()).append(" ,");
                writer.append(member.getAddress()).append(" ,");
                writer.append(member.activeStatusToString(member.getActiveStatus())).append(" ,");
            }
            writer.close();
            System.out.println("CSV fil skrevet til" + filepath);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
