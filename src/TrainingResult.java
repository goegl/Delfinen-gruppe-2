import java.time.LocalDate;
import java.time.LocalTime;

public class TrainingResult implements MillisecondConvertable {
    CompetitiveMember member;
    Disciplines discipline;
    int distance;
    LocalDate date;
    LocalTime resultTime;

    public TrainingResult(CompetitiveMember member, Disciplines discipline, int distance, int resultMinutes, int resultSeconds, int resultMilliseconds, LocalTime resultTime ,LocalDate date) {
        this.member = member;
        this.discipline = discipline;
        this.distance = distance;
        this.resultTime = LocalTime.of(0, resultMinutes, resultSeconds, resultMilliseconds);
        this.date = date;
    }

    @Override
    public Long calculateResultInMilliseconds() {
        return resultTime.toNanoOfDay() / 1_000_000;
    }

    public String toString() {
        return  "Trænings Resultat : " +
                "Svømmer: " + member.getName() + "," +
                "Disciplin: " + discipline + "," +
                "Tid: " + resultTime + "," +
                "Distance: " + distance + "," +
                "Dato: " + date;
    }

}