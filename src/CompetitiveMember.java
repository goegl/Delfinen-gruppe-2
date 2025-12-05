import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class CompetitiveMember extends Member{
    List<Disciplines> disciplines;

    public CompetitiveMember(String name, String phoneNumber, String address, LocalDate dateOfBirth, boolean activeStatus) {
        super(name,phoneNumber, address, dateOfBirth, activeStatus);
        this.disciplines = new ArrayList<>();
    }
    public List<Disciplines> getDisciplines() {
        return disciplines;
    }
    public String disciplinesToString(List<Disciplines> disciplines){
        if (!disciplines.isEmpty()) {
            for (Disciplines discipline : disciplines) {
                String diciplineName = discipline.name();
                return diciplineName;
            }
        }
        return"";
    }

//    public String disciplinesToString(List<Disciplines> disciplines){
//        ArrayList<String> stringDisciplines = new ArrayList<>();
//        for(Disciplines discipline : disciplines){
//            stringDisciplines.add(discipline.toString());
//        }
//        return stringDisciplines.toString();
//    }

    public int getAgeInt(LocalDate dateOfBirth){
        Period age = Period.between(dateOfBirth, LocalDate.now());
        return age.getYears();
    }

    public String getAgeToString(LocalDate dateOfBirth){
        Period age = Period.between(dateOfBirth, LocalDate.now());
        int ageInYears = age.getYears();
        return String.valueOf(ageInYears);
    }

    @Override
    public String toString() {
        return super.toString() + disciplines.toString();
    }

}
