import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileWriter {

    public void writeMemberToCSV(Member member, String filepath) {
        File file = new File(filepath);
        boolean fileExists = file.exists();
        try (java.io.FileWriter writer = new java.io.FileWriter(filepath, true)) {
            if (!fileExists || file.length() == 0) {

                writer.append("Navn, Telefonnummer, Addresse, Aktiv Status, Fødselsdato, Har betalt, Oprettelsesdato" + "\n");
            }
            writer.append(member.getName()).append(",");
            writer.append(member.getPhoneNumber()).append(",");
            writer.append(member.getAddress()).append(",");
            writer.append(member.activeStatusToString(member.getActiveStatus())).append(",");
            writer.append((member.dateOfBirthToString(member.getDateOfBirth()))).append(",");
            writer.append(String.valueOf(member.getIsPaid())).append(",");
            writer.append(member.membershipStartToString(member.getMembershipStart())).append(",\n");


            writer.close();
            System.out.println("CSV fil skrevet til " + filepath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeJuniorCompetitiveMembersToCSV(CompetitiveMember member, String filepath) {
        File file = new File(filepath);
        boolean fileExists = file.exists();
        try (java.io.FileWriter writer = new java.io.FileWriter(filepath, true)) {
            if (!fileExists || file.length() == 0) {
                writer.append("Navn, Alder, Telefonnummer, Discipliner, Aktiv Status" + "\n");
            }
            writer.append(member.getName()).append(",");
            writer.append(member.getAgeToString(member.getDateOfBirth())).append(",");
            writer.append(member.getPhoneNumber()).append(",");
            writer.append(member.activeStatusToString(member.getActiveStatus())).append(",");

            writer.close();
            System.out.println("CSV fil skrevet til " + filepath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeSeniorCompetitiveMembersToCSV(CompetitiveMember member, String filepath) {
        File file = new File(filepath);
        boolean fileExists = file.exists();
        try (java.io.FileWriter writer = new java.io.FileWriter(filepath, true)) {
            if (!fileExists || file.length() == 0) {
                writer.append("Navn, Alder, Telefonnummer, Discipliner, Aktiv Status" + "\n");
            }
            writer.append(member.getName()).append(" ,");
            writer.append(member.getAgeToString(member.getDateOfBirth())).append(" ,");
            writer.append(member.getPhoneNumber()).append(" ,");
            writer.append(member.activeStatusToString(member.getActiveStatus())).append(" ,");

            writer.close();
            System.out.println("CSV fil skrevet til " + filepath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeMemberFeeInfoToCSV(List<Member> members, String filepath) {
        File file = new File(filepath);
        boolean fileExists = file.exists();
        try (java.io.FileWriter writer = new java.io.FileWriter(filepath, true)) {
            if (!fileExists || file.length() == 0) {
                writer.append("Navn, Telefonnummer, Kontingentsats, Betalingsstatus" + "\n");
            }
            for (Member member : members) {
                writer.append(member.getName()).append(" ,");
                writer.append(member.getPhoneNumber()).append(" ,");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}





