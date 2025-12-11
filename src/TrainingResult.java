import java.time.LocalDate;
import java.time.LocalTime;

public class TrainingResult implements MillisecondConvertable {
    CompetitiveMember member;
    Disciplines discipline;
    int distance;
    LocalDate date;
    String resultTime;

    public TrainingResult(CompetitiveMember member, Disciplines discipline, int distance, int resultMinutes, int resultSeconds, int resultMilliseconds, String resultTime ,LocalDate date) {
        this.member = member;
        this.discipline = discipline;
        this.distance = distance;
        this.resultTime = String.format("%02d:%02d:%03d", resultMinutes, resultSeconds, resultMilliseconds);
        this.date = date;
    }

    public String getResultTime() {
        return resultTime;
    }

    @Override
    public Long calculateResultInMilliseconds(int minutes, int seconds, int milliseconds) {
        return minutes * 60_000L + seconds * 1_000L + milliseconds;
    }

    public int calculateResultMinutes(String resultTime){
        String[] timeParts = resultTime.split("[:.]");
        return Integer.parseInt(timeParts[0]);
    }
    public int calculateResultSeconds(String resultTime){
        String[] timeParts = resultTime.split("[:.]");
        return Integer.parseInt(timeParts[1]);
    }
    public int calculateResultMillis(String resultTime){
        String[] timeParts = resultTime.split("[:.]");
        return Integer.parseInt(timeParts[2]);
    }

    @Override
    public String getResultTimeFromResult(MillisecondConvertable result) {
        return getResultTime();
    }

    @Override
    public Disciplines getDisciplineFromInterface(MillisecondConvertable result) {
        return getDiscipline();
    }

    @Override
    public int getAgeOfMemberFromResult(MillisecondConvertable result) {
        return MemberFee.calculateAge(getMember().getDateOfBirth());
    }

    public CompetitiveMember getMember() {
        return member;
    }

    public Disciplines getDiscipline() {
        return discipline;
    }

    public int getDistance() {
        return distance;
    }

    public LocalDate getDate() {
        return date;
    }

    public String toString() {
        return  "Træning: " +
                "Svømmer: " + member.getName() + "," +
                "Disciplin: " + discipline + "," +
                "Tid: " + resultTime + "," +
                "Distance: " + distance + "," +
                "Dato: " + date;
    }

}