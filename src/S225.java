import java.util.LinkedList;

public class S225 {

    private static class MyStack {
        private LinkedList<Integer> queue0 = new LinkedList<>();
        private LinkedList<Integer> queue1 = new LinkedList<>();

        /** Initialize your data structure here. */
        public MyStack() {

        }

        /** Push element x onto stack. */
        public void push(int x) {
            LinkedList<Integer> emptyQueue;
            LinkedList<Integer> contentQueue;

            if (queue0.isEmpty()) {
                emptyQueue = queue0;
                contentQueue = queue1;
            } else {
                emptyQueue = queue1;
                contentQueue = queue0;
            }

            emptyQueue.add(x);

            //rearrange
            int size = contentQueue.size();
            for (int i = 0; i < size; i++) {
                emptyQueue.add(contentQueue.pop());
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            if (empty()) {
                throw new NullPointerException("empty stack");
            }
            LinkedList<Integer> contentQueue = queue0.isEmpty() ? queue1 : queue0;
            return contentQueue.pop();
        }

        /** Get the top element. */
        public int top() {
            if (empty()) {
                throw new NullPointerException("empty stack");
            }
            LinkedList<Integer> contentQueue = queue0.isEmpty() ? queue1 : queue0;
            return contentQueue.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue0.isEmpty() && queue1.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.top());
    }
}
