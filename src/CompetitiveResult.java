import java.time.LocalDate;

public class CompetitiveResult {
    CompetitiveMember member;
    Disciplines discipline;
    int resultMinutes;
    int resultSeconds;
    int resultMilliseconds;
    LocalDate date;
    String competitionName;

    public CompetitiveResult(CompetitiveMember member, Disciplines discipline, int resultMinutes, int resultSeconds, int resultMilliseconds, LocalDate date, String competitionName) {
        this.member = member;
        this.discipline = discipline;
        this.resultMinutes = resultMinutes;
        this.resultSeconds = resultSeconds;
        this.resultMilliseconds = resultMilliseconds;
        this.date = date;
        this.competitionName = competitionName;


    }
}

