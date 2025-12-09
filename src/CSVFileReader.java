import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;

public class CSVFileReader implements Reader {
    public List<Member> readMembersFromFile(String filepath) {
        List<Member> memberList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;
            reader.lines().skip(1);
            if ((line = reader.readLine()) != null) {
            }
            while ((line = reader.readLine()) != null) {
                Member member = parseMember(line);
                memberList.add(member);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return memberList;
    }

    @NotNull
    private static Member parseMember(String line) {
        String[] fields = line.split(",");

        for (int i = 0; i < fields.length; i++) {
            fields[i] = fields[i].trim();
        }

        String name = fields[0];
        String phoneNumber = fields[1];
        String address = fields[2];
        boolean activeStatus = Boolean.parseBoolean(fields[3]);
        LocalDate birthDate = LocalDate.parse(fields[4], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        boolean isPaid = Boolean.parseBoolean(fields[5]);
        LocalDate membershipStart = LocalDate.parse(fields[6], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return new Member(
                name,
                phoneNumber,
                address,
                birthDate,
                activeStatus,
                isPaid,
                membershipStart
        );
    }

    public void printCSVFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Kunne ikke læse filen: " + e.getMessage());
        }
    }
    public List<CompetitiveMember> readCompMemberFromCSV(String filepath){
        List<CompetitiveMember> memberList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;
            reader.lines().skip(1);
            if ((line = reader.readLine()) != null) {
            }
            while ((line = reader.readLine()) != null) {
                CompetitiveMember member = parseCompetitiveMember(line);
                memberList.add(member);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return memberList;
    }
    @NotNull
    private static CompetitiveMember parseCompetitiveMember(String line){
        String[] fields = line.split(",");

        for (int i = 0; i < fields.length; i++) {
            fields[i] = fields[i].trim();
        }

        String name = fields[0];
        String phoneNumber = fields[1];
        String address = fields[2];
        boolean activeStatus = Boolean.parseBoolean(fields[3]);
        LocalDate birthDate = LocalDate.parse(fields[4], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return new CompetitiveMember(
                name,
                phoneNumber,
                address,
                birthDate,
                activeStatus
        );
    }
}