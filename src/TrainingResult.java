import java.time.LocalDate;

public class TrainingResult {
    CompetitiveMember member;
    Disciplines discipline;
    int resultMinutes;
    int resultSeconds;
    int resultMilliseconds;
    LocalDate date;

    public TrainingResult(CompetitiveMember member, Disciplines discipline, int resultMinutes, int resultSeconds, int resultMilliseconds, LocalDate date) {
        this.member = member;
        this.discipline = discipline;
        this.resultMinutes = resultMinutes;
        this.resultSeconds = resultSeconds;
        this.resultMilliseconds = resultMilliseconds;
        this.date = date;
    }

}