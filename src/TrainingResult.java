import java.time.LocalDate;
import java.time.LocalTime;

public class TrainingResult implements MillisecondConvertable {
    CompetitiveMember member;
    Disciplines discipline;
    LocalTime resultTime;
    int distance;
    LocalDate date;

    public TrainingResult(CompetitiveMember member, Disciplines discipline, int distance, LocalTime resultTime, int resultMinutes, int resultSeconds, int resultMilliseconds, LocalDate date) {
        this.member = member;
        this.discipline = discipline;
        this.distance = distance;
        this.resultTime = LocalTime.of(0, resultMinutes, resultSeconds, resultMilliseconds);
        this.date = date;
    }

    @Override
    public String toString() {
        return "TrainingResult{" +
                "member=" + member.getName() +
                ", discipline=" + discipline +
                "Resultat tid" + resultTime.toString() +
                ", date=" + date +
                '}';
    }

    @Override
    public Long calculateResultInMilliseconds(int minutes, int seconds, int milliseconds) {
        return 0L;
    }
}