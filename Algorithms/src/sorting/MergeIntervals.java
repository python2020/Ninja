package sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.Collections;

public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        if (intervals == null | intervals.size() == 0) return result;
        
        Comparator<Interval> comparator = new Comparator<Interval>() {
            @Override
            public int compare(Interval a1, Interval a2) {
                int diff = a1.start - a2.start;    
                return diff == 0? a1.end - a2.end : diff;
            }
        };
        
        Collections.sort(intervals, comparator);
        
        Interval curr = intervals.get(0), next = null;
        for (int i = 1; i < intervals.size(); i++) {
            next = intervals.get(i);
            if (curr.end >= next.start) { // overlap
                curr.end = Math.max(curr.end, next.end); // merge
            } else {
                result.add(curr);
                curr = next;
            }
        }
        
        result.add(curr); // !
        
        return result;    
    }
}
