/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        // Sort meeting based on incr starting time
        // pairwise comparison to see if meetings are conflicted

        if (intervals.size() <= 1) {
            return true;
        }
        

        Collections.sort(intervals, (a,b)->{
            return Integer.compare(a.start,b.start);
        });

        for (int i=1; i<intervals.size(); i++) {
            Interval prev = intervals.get(i-1);
            Interval curr = intervals.get(i);

            if (curr.start < prev.end) {
                return false;
            }
        }
        return true;
    }
}   
