import Comparator.MillisecondConvertable;
import Member.Member;
import java.io.File;
import java.io.IOException;
import Member.CompetitiveMember;


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
            writer.append(String.valueOf(member.getActiveStatus())).append(",");
            writer.append((String.valueOf((member.getDateOfBirth())))).append(",");
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
            writer.append((String.valueOf((member.getDateOfBirth())))).append(",");
            writer.append(String.valueOf(member.getActiveStatus())).append("\n");
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
            writer.append((String.valueOf(member.getDateOfBirth()))).append(",");
            writer.append(String.valueOf(member.getActiveStatus())).append("\n");
            writer.close();
            System.out.println("CSV fil skrevet til " + filepath);
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
                writer.append("Træning").append(",");
                writer.append(trainingResult.getMember().getName()).append(",");
                writer.append(trainingResult.getMember().getPhoneNumber()).append(",");
                writer.append(trainingResult.getDiscipline().toString()).append(",");
                writer.append(String.valueOf(trainingResult.getDistance())).append(",");
                writer.append(trainingResult.getResultTime()).append(",");
                writer.append(trainingResult.getDate().toString()).append(",");
                writer.append("Træning").append("\n");


            } else if (result instanceof CompetitiveResult competitiveResult) {
                writer.append("Konkurrence").append(",");
                writer.append(competitiveResult.getMember().getName()).append(",");
                writer.append(competitiveResult.getMember().getPhoneNumber()).append(",");
                writer.append(competitiveResult.getDiscipline().toString()).append(",");
                writer.append(String.valueOf(competitiveResult.getDistance())).append(",");
                writer.append(competitiveResult.getResultTime()).append(",");
                writer.append(competitiveResult.getDate().toString()).append(",");
                writer.append(competitiveResult.getCompetitionName()).append("\n");

            }

        }   catch (IOException e) {
            e.printStackTrace();
        }
    }
}





