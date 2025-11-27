import java.time.LocalDate;

public class Result {
    Member member;
    double resultTime;
    LocalDate date;
    String competitionName;

    public Result(Member member, double resultTime, LocalDate date){
        this.member = member;
        this.resultTime = resultTime;
        this.date = date;
    }

    public Result(Member member, double resultTime, LocalDate date, String competitionName){
        this.member = member;
        this.resultTime = resultTime;
        this.date = date;
        this.competitionName = competitionName;
    }
}
