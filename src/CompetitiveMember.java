import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CompetitiveMember extends Member{
    List<Disciplines> disciplines;

    public CompetitiveMember(String name, String phoneNumber, String address, LocalDate dateOfBirth, int memberID, boolean activeStatus) {
        super(name,phoneNumber, address, dateOfBirth, memberID, activeStatus);
        this.disciplines = new ArrayList<>();
    }

    @Override
    public String toString() {
        return super.toString() + disciplines.toString();
    }
}
