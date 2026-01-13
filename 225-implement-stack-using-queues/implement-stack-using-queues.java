import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    // Push element x onto stack
    public void push(int x) {
        queue1.offer(x);
    }

    // Removes the element on top of the stack and returns it
    public int pop() {
        // Move all but last element from queue1 to queue2
        while (queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }
        // Last element is the "top" of the stack
        int top = queue1.poll();

        // Swap references to maintain queue1 as main queue
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return top;
    }

    // Get the top element without removing it
    public int top() {
        // Move all but last element from queue1 to queue2
        while (queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }
        // Peek last element
        int top = queue1.poll();
        queue2.offer(top);

        // Swap queues
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return top;
    }

    // Returns true if stack is empty
    public boolean empty() {
        return queue1.isEmpty();
    }
}
