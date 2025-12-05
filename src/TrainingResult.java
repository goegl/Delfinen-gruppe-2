import java.time.LocalDate;

public class TrainingResult {
    CompetitiveMember member;
    Disciplines discipline;
    double resultTime;
    LocalDate date;

    public TrainingResult(CompetitiveMember member, Disciplines discipline, double resultTime, LocalDate date) {
        this.member = member;
        this.discipline = discipline;
        this.resultTime = resultTime;
        this.date = date;
    }

}