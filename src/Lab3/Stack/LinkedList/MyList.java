package Lab3.Stack.LinkedList;

public class MyList {
    private class Node {
        private char letter;
        private Node next;
        private Node(char ch){
            letter = ch;
        }
    }
    private Node first;

    /**
     * Метод First возвращает позицию (Position) 1-го элемента в списке
     * Если список пустой --> возвращает позицию после последнего
     * @return
     */
    protected char first(){
        if(first == null) return '\0';
        return first.letter;
    }

    protected void removeFirst(){
        if(isEmpty()) return;
        first = first.next;
    }

    protected void insertFirst(char ch){
        if(isEmpty()) first = new Node(ch);
        else {
            Node temp = first;
            first = new Node(ch);
            first.next = temp;
        }
    }

    protected void makeNull(){
        //Очищает список, делая его пустым.
        //firstelement становится равен нулю
        first = null;
    }

    protected boolean empty() {
        return isEmpty();
    }

    private boolean isEmpty() {
        return first == null;
    }
}
