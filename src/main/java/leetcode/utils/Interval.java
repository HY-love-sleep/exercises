package leetcode.utils;

import lombok.Data;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Interval {
    int start;
    int end;
    public Interval() {
        start = 0;
        end = 0;
    }
    public Interval(int s, int e) {
        start = s;
        end = e;
    }

    public int getStart() {
        return this.start;
    }

    public int getEnd() {
        return this.end;
    }

    public String toString() {
        return "[" + String.valueOf(this.getStart()) + "," + String.valueOf(this.getEnd()) + "]";
    }
}
