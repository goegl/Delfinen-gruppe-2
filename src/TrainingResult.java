import java.time.LocalDate;
import java.time.LocalTime;

public class TrainingResult extends Result implements MillisecondConvertable {

    public TrainingResult(CompetitiveMember member, Disciplines discipline, int distance, int resultMinutes, int resultSeconds, int resultMilliseconds, LocalTime resultTime ,LocalDate date) {
        super(member,discipline,distance, resultTime, date);
        this.resultTime = LocalTime.of(0, resultMinutes, resultSeconds, resultMilliseconds);
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