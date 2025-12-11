import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ResultManager {
    private List<MillisecondConvertable> allResults;


    public ResultManager() {
        this.allResults = new ArrayList<>();
    }

    public TrainingResult createTrainingResult(CompetitiveMember member, Disciplines discipline, int distance, int resultMinutes,
                                               int resultSeconds, int resultMilliseconds,
                                               LocalDate date, String resultTime, FileWriter fileWriter) {
        TrainingResult trainingResult = new TrainingResult(member, discipline, distance, resultMinutes, resultSeconds, resultMilliseconds, resultTime, date);
        allResults.add(trainingResult);
        fileWriter.writeResultToCSV(trainingResult, "Results.CSV");
        return trainingResult;
    }

    public void addToAllResults(List<MillisecondConvertable> resultsFromFile) {
        allResults.addAll(resultsFromFile);
    }

    public CompetitiveResult createCompetitiveResult(CompetitiveMember member, Disciplines discipline, int distance
            , int resultMinutes, int resultSeconds, int resultMilliseconds,
                                                     LocalDate date, String resultTime, String competitionName, FileWriter fileWriter) {
        CompetitiveResult competitiveResult = new CompetitiveResult(member, discipline, distance, resultMinutes, resultSeconds, resultMilliseconds, resultTime, date, competitionName);
        allResults.add(competitiveResult);
        fileWriter.writeResultToCSV(competitiveResult, "Results.CSV");
        return competitiveResult;
    }

    public List<MillisecondConvertable> getAllResults() {
        return allResults;
    }

    public void printAllResults() {
        System.out.println("Alle Resultater: ");

        for (MillisecondConvertable results : allResults) {
            System.out.println(results);
        }
    }

    public List<MillisecondConvertable> sortResults(List<MillisecondConvertable> results){
        Collections.sort(results, new ResultChainedComparator(new ResultDisciplineComparator(), new ResultAgeComparator(), new ResultTimeComparator()));
        return results;
    }
    public void printSortedResults(){
        System.out.println(sortResults(allResults).toString());

    }
    public void printTopFive(){
        if()
    }
}
