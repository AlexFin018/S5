package Lab3.Queue.CircularList;

public class MyQueue {
    private final MyList list;
    public MyQueue() {
        list = new MyList();
    }
    /**
     * Очищает очередь, делая ее пустой
     */
    public void makeNull() {
        list.makeNull();
    }
    /**
     * Возвращает первый элемент (копия) очереди
     * @return
     */
    public char front() {
        return list.first();
    }
    /**
     * Удаляет первый элемент очереди, и возвращает его в качестве результатата
     * @return
     */
    public char dequeue() {
        if(list.empty()) return '\0';
        char c = list.first();
        list.removeHead();
        return c;
    }
    /**
     * Вставляет элемент x в конец очереди
     * @param c
     */
    public void enqueue(char c) {
        list.add(c);
    }
    /**
     * Возвращает значение true, если очередь пустая, и значение false в противном случае
     * @return
     */
    public boolean empty() {
        return list.empty();
    }
    /**
     * Возвращает значение true, если очередь полная, и значение false в противном случае
     * @return
     */
    public boolean full() {
        return false;
    }
}
