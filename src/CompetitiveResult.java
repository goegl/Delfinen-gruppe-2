import java.time.LocalDate;
import java.time.LocalTime;

public class CompetitiveResult implements MillisecondConvertable{
    CompetitiveMember member;
    Disciplines discipline;
    int distance;
    LocalDate date;
    String resultTime;
    String competitionName;

    public CompetitiveResult(CompetitiveMember member, Disciplines discipline, int distance, int resultMinutes, int resultSeconds, int resultMilliseconds, String resultTime ,LocalDate date, String competitionName) {
        this.member = member;
        this.discipline = discipline;
        this.distance = distance;
        this.resultTime = String.format("%02d:%02d:%03d", resultMinutes, resultSeconds, resultMilliseconds);
        this.date = date;
        this.competitionName = competitionName;
    }

    public String getResultTime() {
        return resultTime;
    }

    @Override
    public Long calculateResultInMilliseconds(int minutes, int seconds, int milliseconds) {
        return minutes * 60_000L + seconds * 1_000L + milliseconds;
    }

    @Override
        public String toString() {
            return "Trænings Resultat : " +
                    "Svømmer: " + member.getName() + "," +
                    "Disciplin: " + discipline + "," +
                    "Tid: " + resultTime + "," +
                    "Distance: " + distance + "," +
                    "Dato: " + date + "," +
                    "Konkurrence: " + competitionName;

        }
}

