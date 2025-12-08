import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;

public class CSVFileReader{
    public List<Member> readMembersFromCSV(String filepath) {
        List<Member> memberList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new java.io.FileReader(filepath));
            String line;

            while((line = reader.readLine()) != null){
                Member member = parseMember(line);
                memberList.add(member);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return memberList;
    }

//    Navn, Telefonnummer, Addresse, Aktiv Status, Fødselsdato, Kontingentsats, Oprettelsesdato
    @NotNull
    private static Member parseMember(String line) {
        String[] fields = line.split(",");
        String name = fields[0];
        String phoneNumber = fields[1];
        String adress = fields[2];
        boolean activeStatus = Boolean.parseBoolean(fields[3]);
        LocalDate birthDate = LocalDate.parse(fields[4], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        double memberFee = Double.parseDouble(fields[5]);
        LocalDate membershipStart = LocalDate.parse(fields[6], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return new Member(
               name,
                phoneNumber,
                adress,
                birthDate,
                activeStatus,
                false
                );
    }
}
