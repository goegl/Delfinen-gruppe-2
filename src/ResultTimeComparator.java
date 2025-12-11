import java.util.Comparator;

public class ResultTimeComparator implements Comparator<MillisecondConvertable> {

    @Override
    public int compare(MillisecondConvertable o1, MillisecondConvertable o2) {
        return (int) (o1.calculateResultInMilliseconds(o1.calculateResultMinutes(o1.getResultTimeFromResult(o1)),
                        o1.calculateResultSeconds(o1.getResultTimeFromResult(o1)),
                        o1.calculateResultMillis(o1.getResultTimeFromResult(o1))) - o2.calculateResultInMilliseconds(o2.calculateResultMinutes(o2.getResultTimeFromResult(o2)),
                        o1.calculateResultSeconds(o2.getResultTimeFromResult(o2)),
                        o1.calculateResultMillis(o2.getResultTimeFromResult(o2))));
    }
}
