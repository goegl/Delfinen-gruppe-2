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

    @NotNull
    private static Member parseMember(String line) {
        String[] fields = line.split(",");
        String name = fields[0];
        LocalDate birthDate = LocalDate.parse(fields[1], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        boolean activeStatus = Boolean.parseBoolean(fields[2]);
        return new Member(
               name,
                "1234567",
                "Meinungsgade 8",
                birthDate,
                activeStatus,
                false
                );
    }
}
