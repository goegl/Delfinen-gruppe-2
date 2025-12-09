import java.time.LocalDate;
import java.time.LocalTime;

public class CompetitiveResult implements MillisecondConvertable{
    CompetitiveMember member;
    Disciplines discipline;
    LocalTime resultTime;
    int distance;
    LocalDate date;
    String competitionName;

    public CompetitiveResult(CompetitiveMember member, Disciplines discipline, int distance , LocalTime resultTime, int resultMinutes, int resultSeconds, int resultMilliseconds, LocalDate date, String competitionName) {
        this.member = member;
        this.discipline = discipline;
        this.distance = distance;
        this.resultTime = LocalTime.of(0, resultMinutes, resultSeconds, resultMilliseconds);
        this.date = date;
        this.competitionName = competitionName;


    }

    @Override
    public Long calculateResultInMilliseconds(int minutes, int seconds, int milliseconds) {
        return 0L;
    }
}

