import java.util.Stack;


public class EnqueueFriendlyStackQueue {

    private final Stack<Integer> inStack = new Stack<>();
    private final Stack<Integer> outStack = new Stack<>();

    public void enqueue(int value) {
        inStack.push(value);
    }

    public int dequeue() {
        if (inStack.isEmpty() && outStack.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }

    public int peek() {
        if (inStack.isEmpty() && outStack.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }

    public boolean isEmpty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    public int size() {
        return inStack.size() + outStack.size();
    }

    // Simple demonstration
    public static void main(String[] args) {
        EnqueueFriendlyStackQueue queue = new EnqueueFriendlyStackQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Front: " + queue.peek());   // 10
        System.out.println("Dequeue: " + queue.dequeue()); // 10
        System.out.println("Dequeue: " + queue.dequeue()); // 20
        queue.enqueue(40);
        System.out.println("Dequeue: " + queue.dequeue()); // 30
        System.out.println("Dequeue: " + queue.dequeue()); // 40
        System.out.println("Empty: " + queue.isEmpty());   // true
    }
}
