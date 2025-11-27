import java.time.LocalDate;

public class Result {
    CompetitiveMember member;
    Disciplines discipline;
    double resultTime;
    LocalDate date;
    String competitionName;

    public Result(CompetitiveMember member,Disciplines discipline, double resultTime, LocalDate date){
        this.member = member;
        this.discipline = discipline;
        this.resultTime = resultTime;
        this.date = date;
    }

    public Result(CompetitiveMember member, Disciplines discipline, double resultTime, LocalDate date, String competitionName){
        this.member = member;
        this.discipline = discipline;
        this.resultTime = resultTime;
        this.date = date;
        this.competitionName = competitionName;
    }
}
