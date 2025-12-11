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
            writer.append(String.valueOf(member.isPaid())).append(",");
            writer.append(member.membershipStartToString(member.getMembershipStart())).append("\n");


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
                writer.append("Navn, Telefonnummer, Adresse, Fødselsdato, Aktiv Status" + "\n");
            }
            writer.append(member.getName()).append(",");
            writer.append(member.getPhoneNumber()).append(",");
            writer.append(member.getAddress()).append(",");
            writer.append((member.dateOfBirthToString(member.getDateOfBirth()))).append(",");
            writer.append(member.activeStatusToString(member.getActiveStatus())).append("\n");
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
                writer.append("Navn, Telefonnummer, Adresse, Fødselsdato, Aktiv Status" + "\n");
            }
            writer.append(member.getName()).append(",");
            writer.append(member.getPhoneNumber()).append(",");
            writer.append(member.getAddress()).append(",");
            writer.append((member.dateOfBirthToString(member.getDateOfBirth()))).append(",");
            writer.append(member.activeStatusToString(member.getActiveStatus())).append("\n");
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

    public void writeResultToCSV(MillisecondConvertable result, String filepath) {
        File file = new File(filepath);
        boolean fileExists = file.exists();

        try (java.io.FileWriter writer = new java.io.FileWriter(filepath, true)) {
            if (!fileExists || file.length() == 0) {
                writer.append("Type, Navn, Telefonnummer, Disciplin, Distance, Tid, Dato, Konkurrencenavn \n");
            }

            if (result instanceof TrainingResult trainingResult) {
                writer.append("Træning,");
                writer.append(trainingResult.member.getName()).append(",");
                writer.append(trainingResult.member.getPhoneNumber()).append(",");
                writer.append(trainingResult.discipline.toString()).append(",");
                writer.append(String.valueOf(trainingResult.distance)).append(",");
                writer.append(String.valueOf(trainingResult.calculateResultInMilliseconds())).append(",");
                writer.append(trainingResult.date.toString()).append(",");
                writer.append("");
                writer.append("\n");

            } else if (result instanceof CompetitiveResult competitiveResult) {
                writer.append("Konkurrence,");
                writer.append(competitiveResult.member.getName()).append(",");
                writer.append(competitiveResult.member.getPhoneNumber()).append(",");
                writer.append(competitiveResult.discipline.toString()).append(",");
                writer.append(String.valueOf(competitiveResult.distance)).append(",");
                writer.append(String.valueOf(competitiveResult.calculateResultInMilliseconds())).append(",");
                writer.append(competitiveResult.date.toString()).append(",");
                writer.append(competitiveResult.competitionName);
                writer.append("\n");
            }

        }   catch (IOException e) {
            e.printStackTrace();
        }
    }
}





