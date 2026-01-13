import java.util.LinkedList;
import java.util.Queue;

class RecentCounter {
    private Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        // Add new request
        queue.offer(t);

        // Remove requests older than t - 3000
        while (queue.peek() < t - 3000) {
            queue.poll();
        }

        // Number of requests in [t-3000, t] inclusive
        return queue.size();
    }
}
