import java.util.*;
class RecentCallCounter {
    private static Queue<Integer> counts;
    public static void RecentCounter() {
        counts = new LinkedList<>();
    }
    
    public static int ping(int t) {
        counts.add(t);
        while(counts.peek() < t - 3000){
            counts.poll();
        }
        return counts.size();
    }
    public static void main(String[] args) {
        RecentCallCounter.RecentCounter();
    }
}