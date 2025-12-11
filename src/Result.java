import java.time.LocalDate;
import java.time.LocalTime;

public class Result {

    CompetitiveMember member;
    Disciplines discipline;
    int distance;
    LocalDate date;
    LocalTime resultTime;

    public Result(CompetitiveMember member, Disciplines disciplines, int distance, LocalTime resultTime, LocalDate date) {
        this.member = member;
        this.discipline = disciplines;
        this.distance = distance;
        this.resultTime = resultTime;
        this.date = date;
    }


}

