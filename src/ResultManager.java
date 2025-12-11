import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Comparator.*;
import Member.CompetitiveMember;

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


    public List<MillisecondConvertable> sortResults(List<MillisecondConvertable> results) {
        Collections.sort(results, new ResultChainedComparator(new ResultDisciplineComparator(), new ResultAgeComparator(), new ResultTimeComparator()));
        return results;
    }

    public void printSortedResults() {
        for(MillisecondConvertable result : sortResults(allResults)){
            System.out.println(result);
        }

    }

    public void printTopFive() {
        printJuniorButterflyTopFive();
        printJuniorCrawlTopFive();
        printJuniorBackCrawlTopFive();
        printJuniorBreastStrokeTopFive();
        printSeniorBackCrawlTopFive();
        printSeniorBreastStrokeTopFive();
        printSeniorButterflyTopFive();
        printSeniorCrawlTopFive();

    }

    private void printJuniorButterflyTopFive() {
        ArrayList<MillisecondConvertable> jrButterflyTopFive = new ArrayList<>();

        System.out.println("Junior Butterfly top 5");
        for (MillisecondConvertable result : sortResults(allResults)) {
            if (result.getAgeOfMemberFromResult(result) < 18 && result.getDisciplineFromInterface(result) == Disciplines.BUTTERFLY) {
                jrButterflyTopFive.add(result);
            }
        }
        List<MillisecondConvertable> top5 = sortResults(jrButterflyTopFive).subList(0, Math.min(5, sortResults(jrButterflyTopFive).size()));
        for(MillisecondConvertable result : top5){
            System.out.println(result);
        }


    }

    private void printJuniorCrawlTopFive() {
        ArrayList<MillisecondConvertable> jrCrawlTopFive = new ArrayList<>();

        System.out.println("Junior Crawl top 5");
        for (MillisecondConvertable result : sortResults(allResults)) {
            if (result.getAgeOfMemberFromResult(result) < 18 && result.getDisciplineFromInterface(result) == Disciplines.CRAWL) {
                jrCrawlTopFive.add(result);
            }
        }
        List<MillisecondConvertable> top5 = sortResults(jrCrawlTopFive).subList(0, Math.min(5, sortResults(jrCrawlTopFive).size()));
        for(MillisecondConvertable result : top5){
            System.out.println(result);
        }
    }
    private void printJuniorBackCrawlTopFive() {
        ArrayList<MillisecondConvertable> jrBackCrawlTopFive = new ArrayList<>();

        System.out.println("Junior Backcrawl top 5");
        for (MillisecondConvertable result : sortResults(allResults)) {
            if (result.getAgeOfMemberFromResult(result) < 18 && result.getDisciplineFromInterface(result) == Disciplines.BACKCRAWL) {
                jrBackCrawlTopFive.add(result);
            }
        }
        List<MillisecondConvertable> top5 = sortResults(jrBackCrawlTopFive).subList(0, Math.min(5, sortResults(jrBackCrawlTopFive).size()));
        for(MillisecondConvertable result : top5){
            System.out.println(result);
        }
    }
    private void printJuniorBreastStrokeTopFive() {
        ArrayList<MillisecondConvertable> jrBreastStrokeTopFive = new ArrayList<>();

        System.out.println("Junior Brystsvømning top 5");
        for (MillisecondConvertable result : sortResults(allResults)) {
            if (result.getAgeOfMemberFromResult(result) < 18 && result.getDisciplineFromInterface(result) == Disciplines.BREASTSTROKE) {
                jrBreastStrokeTopFive.add(result);
            }
        }
        List<MillisecondConvertable> top5 = sortResults(jrBreastStrokeTopFive).subList(0, Math.min(5, sortResults(jrBreastStrokeTopFive).size()));
        for(MillisecondConvertable result : top5){
            System.out.println(result);
        }
    }
    private void printSeniorCrawlTopFive() {
        ArrayList<MillisecondConvertable> SeniorCrawlTopFive = new ArrayList<>();

        System.out.println("Senior Crawl top 5");
        for (MillisecondConvertable result : sortResults(allResults)) {
            if (result.getAgeOfMemberFromResult(result) >= 18 && result.getDisciplineFromInterface(result) == Disciplines.CRAWL) {
                SeniorCrawlTopFive.add(result);
            }
        }
        List<MillisecondConvertable> top5 = sortResults(SeniorCrawlTopFive).subList(0, Math.min(5, sortResults(SeniorCrawlTopFive).size()));
        for(MillisecondConvertable result : top5){
            System.out.println(result);
        }
    }
    private void printSeniorButterflyTopFive() {
        ArrayList<MillisecondConvertable> SeniorButterflyTopFive = new ArrayList<>();

        System.out.println("Senior Butterfly top 5");
        for (MillisecondConvertable result : sortResults(allResults)) {
            if (result.getAgeOfMemberFromResult(result) >= 18 && result.getDisciplineFromInterface(result) == Disciplines.BUTTERFLY) {
                SeniorButterflyTopFive.add(result);
            }
        }
        List<MillisecondConvertable> top5 = sortResults(SeniorButterflyTopFive).subList(0, Math.min(5, sortResults(SeniorButterflyTopFive).size()));
        for(MillisecondConvertable result : top5){
            System.out.println(result);
        }
    }
    private void printSeniorBackCrawlTopFive() {
        ArrayList<MillisecondConvertable> SeniorBackCrawlTopFive = new ArrayList<>();

        System.out.println("Senior Rygsvømning top 5");
        for (MillisecondConvertable result : sortResults(allResults)) {
            if (result.getAgeOfMemberFromResult(result) >= 18 && result.getDisciplineFromInterface(result) == Disciplines.BACKCRAWL) {
                SeniorBackCrawlTopFive.add(result);
            }
        }
        List<MillisecondConvertable> top5 = sortResults(SeniorBackCrawlTopFive).subList(0, Math.min(5, sortResults(SeniorBackCrawlTopFive).size()));
        for(MillisecondConvertable result : top5){
            System.out.println(result);
        }
    }
    private void printSeniorBreastStrokeTopFive() {
        ArrayList<MillisecondConvertable> SeniorBreastStrokeTopFive = new ArrayList<>();

        System.out.println("Senior Brystsvømning top 5");
        for (MillisecondConvertable result : sortResults(allResults)) {
            if (result.getAgeOfMemberFromResult(result) >= 18 && result.getDisciplineFromInterface(result) == Disciplines.BREASTSTROKE) {
                SeniorBreastStrokeTopFive.add(result);
            }
        }
        List<MillisecondConvertable> top5 = sortResults(SeniorBreastStrokeTopFive).subList(0, Math.min(5, sortResults(SeniorBreastStrokeTopFive).size()));
        for(MillisecondConvertable result : top5){
            System.out.println(result);
        }
    }




}
