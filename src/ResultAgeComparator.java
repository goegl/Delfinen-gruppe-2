import java.util.Comparator;

public class ResultAgeComparator implements Comparator<MillisecondConvertable> {

    @Override
    public int compare(MillisecondConvertable o1, MillisecondConvertable o2) {
        return o1.getAgeOfMemberFromResult(o1) - o2.getAgeOfMemberFromResult(o2);
    }
}
