import MemberFee.MemberFee;

import java.time.LocalDate;

public class CompetitiveResult implements MillisecondConvertable{
    private CompetitiveMember member;
    private Disciplines discipline;
    private int distance;
    private LocalDate date;
    private String resultTime;
    private String competitionName;

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

    public String getCompetitionName() {
        return competitionName;
    }
    @Override
    public String getResultTimeFromResult(MillisecondConvertable result) {
        return getResultTime();
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
    public int getAgeOfMemberFromResult(MillisecondConvertable result) {
        return MemberFee.calculateAge(getMember().getDateOfBirth());
    }

    @Override
    public Disciplines getDisciplineFromInterface(MillisecondConvertable result) {
        return getDiscipline();
    }

    @Override
        public String toString() {
            return "Stævne: " +
                    "Svømmer: " + member.getName() + "," +
                    "Disciplin: " + discipline + "," +
                    "Tid: " + resultTime + "," +
                    "Distance: " + distance + "," +
                    "Dato: " + date + "," +
                    "Konkurrence: " + competitionName;

        }
}

