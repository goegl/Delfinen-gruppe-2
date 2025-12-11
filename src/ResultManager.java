import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ResultManager {
    private List<MillisecondConvertable> allResults;
    private List<TrainingResult> trainingResults;
    private List<CompetitiveResult> competitiveResults;

    public ResultManager() {
        this.competitiveResults = new ArrayList<>();
        this.trainingResults = new ArrayList<>();
        this.allResults = new ArrayList<>();
    }

    public TrainingResult createTrainingResult(CompetitiveMember member, Disciplines discipline, int distance, int resultMinutes,
                                               int resultSeconds, int resultMilliseconds,
                                               LocalDate date, String resultTime ,FileWriter fileWriter) {
        TrainingResult trainingResult = new TrainingResult(member, discipline, distance, resultMinutes, resultSeconds, resultMilliseconds, resultTime ,date);
        trainingResults.add(trainingResult);
        allResults.add(trainingResult);
        fileWriter.writeResultToCSV(trainingResult, "Results.CSV");
        return trainingResult;
    }
    public void addToAllResults(List<MillisecondConvertable> resultsFromFile) {
        allResults.addAll(resultsFromFile);
    }

    public CompetitiveResult createCompetitiveResult(CompetitiveMember member, Disciplines discipline, int distance
            , int resultMinutes, int resultSeconds, int resultMilliseconds,
                                                     LocalDate date, String resultTime , String competitionName, FileWriter fileWriter) {
        CompetitiveResult competitiveResult = new CompetitiveResult(member, discipline, distance, resultMinutes, resultSeconds, resultMilliseconds, resultTime ,date, competitionName);
        competitiveResults.add(competitiveResult);
        allResults.add(competitiveResult);
        fileWriter.writeResultToCSV(competitiveResult, "Results.CSV");
        return competitiveResult;
    }

    public List<MillisecondConvertable> getAllResults() {
        return allResults;
    }

    public void printTrainingResults() {
        System.out.println("Trænings Resultater: \n ");

        for (TrainingResult trainingResult : trainingResults) {
            System.out.println(trainingResult);
        }
    }

    public void printCompResults() {
        System.out.println("Konkurrence Resultater: \n");

        for (CompetitiveResult competitiveResult : competitiveResults) {
            System.out.println(competitiveResult);
        }
    }

}
