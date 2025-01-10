package Lab3.Queue.CircularList;

public class MyList {
    private class Node {
        protected char letter;
        protected Node next;
        public Node(char letter){
            this.letter = letter;
        }
    }
    private Node tail;

    protected char first() {
        if(isEmpty()) return '\0';
        return tail.next.letter;
    }
    protected char last() {
        if(isEmpty()) return '\0';
        return tail.letter;
    }
    protected void add(char letter) {
        if(isEmpty()) {
            tail = new Node(letter);
            tail.next = tail;
        }
        else {
            Node head = tail.next;
            tail.next = new Node(letter);
            tail = tail.next;
            tail.next = head;
        }

    }
    protected void removeHead() {
        if(tail.next == tail) {
            tail = null;
        }
        else {
            tail.next = tail.next.next;
        }
    }
    protected void makeNull() {
        tail = null;
    }
    protected boolean empty() {
        return isEmpty();
    }
    private boolean isEmpty() {
        return tail == null;
    }
}
