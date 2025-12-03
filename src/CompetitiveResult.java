import java.time.LocalDate;

public class CompetitiveResult {
    CompetitiveMember member;
    Disciplines discipline;
    double resultTime;
    LocalDate date;
    String competitionName;

    public CompetitiveResult(CompetitiveMember member, Disciplines discipline, double resultTime, LocalDate date, String competitionName) {
        this.member = member;
        this.discipline = discipline;
        this.resultTime = resultTime;
        this.date = date;
        this.competitionName = competitionName;


    }
}

