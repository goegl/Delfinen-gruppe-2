import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ResultManager {
    private List<TrainingResult> trainingResults;
    private List<CompetitiveResult> competitiveResults;

    public ResultManager() {
        this.competitiveResults = new ArrayList<>();
        this.trainingResults = new ArrayList<>();
    }

    public TrainingResult createTrainingResult(CompetitiveMember member, Disciplines discipline, int distance, LocalTime resultTime , int resultMinutes,
                                               int resultSeconds, int resultMilliseconds,
                                               LocalDate date){
        TrainingResult trainingResult =  new TrainingResult(member, discipline, distance ,resultTime, resultMinutes, resultSeconds, resultMilliseconds, date);
        trainingResults.add(trainingResult);
        System.out.println(trainingResult);
        return trainingResult;
    }
    public CompetitiveResult createCompetitiveResult(CompetitiveMember member, Disciplines discipline, int distance, LocalTime resultTime
                                                     ,int resultMinutes, int resultSeconds, int resultMilliseconds,
                                                     LocalDate date, String competitionName){
        CompetitiveResult competitiveResult = new CompetitiveResult(member, discipline, distance, resultTime ,resultMinutes, resultSeconds, resultMilliseconds, date, competitionName);
        competitiveResults.add(competitiveResult);
        System.out.println(competitiveResult);
        return competitiveResult;
    }


}
