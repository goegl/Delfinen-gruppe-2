package Comparator;

import java.util.Comparator;

public class ResultDisciplineComparator  implements Comparator<MillisecondConvertable> {

    @Override
    public int compare(MillisecondConvertable o1, MillisecondConvertable o2) {
        return o1.getDisciplineFromInterface(o1).compareTo(o2.getDisciplineFromInterface(o2));
    }
}
