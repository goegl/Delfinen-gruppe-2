import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ResultChainedComparator implements Comparator<MillisecondConvertable> {
    private List<Comparator<MillisecondConvertable>> listComparators;

    public ResultChainedComparator(Comparator<MillisecondConvertable>... comparators){
        this.listComparators = Arrays.asList(comparators);
    }

    public int compare(MillisecondConvertable result1, MillisecondConvertable result2){
        for (Comparator<MillisecondConvertable> comparator : listComparators){
            int result = comparator.compare(result1, result2);
            if (result != 0){
                return result;
            }
        }
        return 0;
    }
}
