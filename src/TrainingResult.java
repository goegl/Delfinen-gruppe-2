import java.time.LocalDate;

public class TrainingResult {
    CompetitiveMember member;
    Disciplines discipline;
    int distance;
    int resultMinutes;
    int resultSeconds;
    int resultMilliseconds;
    LocalDate date;

    public TrainingResult(CompetitiveMember member, Disciplines discipline, int distance ,int resultMinutes, int resultSeconds, int resultMilliseconds, LocalDate date) {
        this.member = member;
        this.discipline = discipline;
        this.distance = distance;
        this.resultMinutes = resultMinutes;
        this.resultSeconds = resultSeconds;
        this.resultMilliseconds = resultMilliseconds;
        this.date = date;
    }

    @Override
    public String toString() {
        return "TrainingResult{" +
                "member=" + member.getName() +
                ", discipline=" + discipline +
                ", distance=" + distance +
                ", resultMinutes=" + resultMinutes +
                ", resultSeconds=" + resultSeconds +
                ", resultMilliseconds=" + resultMilliseconds +
                ", date=" + date +
                '}';
    }
}