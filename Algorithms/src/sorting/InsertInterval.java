package sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> res = new ArrayList<Interval>();
        
        Iterator<Interval> it = intervals.iterator();
        Interval curr = null;
        
        while (it.hasNext()) {
            curr = it.next();
            if (newInterval.end < curr.start) { // before
                res.add(newInterval);
                res.add(new Interval(curr.start, curr.end));
                while (it.hasNext()) { // add the rest
                    curr = it.next(); 
                    res.add(new Interval(curr.start, curr.end)); 
                }
                return res; // !
            } else if (newInterval.start > curr.end) { // after
                res.add(new Interval(curr.start, curr.end));
            } else { // overlap
                newInterval.start = Math.min(newInterval.start, curr.start);
                newInterval.end = Math.max(newInterval.end, curr.end);
            }
        }
        
        res.add(newInterval);
        
        return res;
    }
}
