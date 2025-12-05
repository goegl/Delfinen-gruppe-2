import java.io.IOException;
import java.util.List;

public class FileWriter {

    public void writeMembersToCSV(Member member, String filepath) {
        try (java.io.FileWriter writer = new java.io.FileWriter(filepath, true)) {
            if(filepath.isEmpty() || filepath.isBlank()) {
                writer.append("Name, PhoneNumber, Address, Aktiv Status, Fødselsdagsdato, MedlemsId, Kontingentsats, Oprettelsesdato" + "\n");
            }
                writer.append(member.getName()).append(" ,");
                writer.append(member.getPhoneNumber()).append(" ,");
                writer.append(member.getAddress()).append(" ,");
                writer.append(member.activeStatusToString(member.getActiveStatus())).append(" ,");
                writer.append((member.dateOfBirthToString(member.getDateOfBirth()))).append(" ,");
                writer.append(String.valueOf(member.getMemberID())).append(" ,");
                writer.append(String.valueOf(member.getMemberFee())).append(" ,");
                writer.append(member.membershipStartToString(member.getMembershipStart())).append(" , \n");


            writer.close();
            System.out.println("CSV fil skrevet til " + filepath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}





