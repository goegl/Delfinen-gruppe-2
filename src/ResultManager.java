import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ResultManager {
    private List<TrainingResult> trainingResults;
    private List<CompetitiveResult> competitiveResults;

    public ResultManager() {
        this.competitiveResults = new ArrayList<>();
        this.trainingResults = new ArrayList<>();
    }

    public TrainingResult createTrainingResult(CompetitiveMember member, Disciplines discipline, double resultTime,
                                               LocalDate date){
        return new TrainingResult(member, discipline, resultTime, date);
    }
    public CompetitiveResult createCompetitiveResult(CompetitiveMember member, Disciplines discipline,
                                                          double resultTime, LocalDate date, String competitionName){
        return new CompetitiveResult(member, discipline, resultTime, date, competitionName);
    }
}
