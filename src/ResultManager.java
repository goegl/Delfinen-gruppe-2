import java.util.ArrayList;
import java.util.List;

public class ResultManager {
    private List<TrainingResult> trainingResults;
    private List<CompetitiveResult> competitiveResults;

    public ResultManager() {
        this.competitiveResults = new ArrayList<>();
        this.trainingResults = new ArrayList<>();
    }
}
