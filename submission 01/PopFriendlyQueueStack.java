import java.util.LinkedList;
import java.util.Queue;


public class PopFriendlyQueueStack {


    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();


    public void push(int value) {
        q2.add(value);
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public int pop() {
        if (q1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return q1.remove();
    }

    public int peek() {
        if (q1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return q1.peek();
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }

    public int size() {
        return q1.size();
    }

    // Simple demonstration
    public static void main(String[] args) {
        PopFriendlyQueueStack stack = new PopFriendlyQueueStack();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top: " + stack.peek()); // 30
        System.out.println("Pop: " + stack.pop());   // 30
        System.out.println("Pop: " + stack.pop());   // 20
        stack.push(40);
        System.out.println("Pop: " + stack.pop());   // 40
        System.out.println("Pop: " + stack.pop());   // 10
        System.out.println("Empty: " + stack.isEmpty()); // true
    }
}
