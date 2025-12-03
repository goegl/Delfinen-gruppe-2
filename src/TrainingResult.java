import java.time.LocalDate;

public class TrainingResult {
    public class Result {
        CompetitiveMember member;
        Disciplines discipline;
        double resultTime;
        LocalDate date;

        public Result(CompetitiveMember member, Disciplines discipline, double resultTime, LocalDate date) {
            this.member = member;
            this.discipline = discipline;
            this.resultTime = resultTime;
            this.date = date;
        }
    }
}