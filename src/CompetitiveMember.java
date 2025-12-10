import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class CompetitiveMember extends Member {


    public CompetitiveMember(String name, String phoneNumber, String address, LocalDate dateOfBirth, boolean activeStatus) {
        super(name, phoneNumber, address, dateOfBirth, activeStatus);
    }

}
