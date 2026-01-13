import java.util.Stack;

class MyQueue {
    private Stack<Integer> stackIn;
    private Stack<Integer> stackOut;

    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }
    
    // Push element x to the back of queue
    public void push(int x) {
        stackIn.push(x);
    }
    
    // Removes the element from the front of queue and returns it
    public int pop() {
        moveIfNeeded();
        return stackOut.pop();
    }
    
    // Get the front element
    public int peek() {
        moveIfNeeded();
        return stackOut.peek();
    }
    
    // Returns whether the queue is empty
    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }
    
    // Helper method: move elements from stackIn to stackOut if stackOut is empty
    private void moveIfNeeded() {
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
    }
}
