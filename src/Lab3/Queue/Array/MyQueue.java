package Lab3.Queue.Array;

public class MyQueue {
    private static final int DEFAULT_CAPACITY = 200;
    private final char[] queue;
    private int firstEmpty;
    private int firstUsed;
    public MyQueue() {
        queue = new char[DEFAULT_CAPACITY];
        firstEmpty = 0;
        firstUsed = -1;
    }

    /**
     * Очищает очередь, делая ее пустой
     */
    public void makeNull() {
        firstEmpty = 0;
        firstUsed = -1;
    }

    /**
     * Возвращает первый элемент (копия) очереди
     * @return
     */
    public char front() {
        if(isEmpty()) return 0;
        return queue[firstUsed];
    }

    /**
     * Удаляет первый элемент очереди, и возвращает его в качестве результатата
     * @return
     */
    public char dequeue() {
        if (isEmpty()) return 0;
        char temp = queue[firstUsed];
        firstUsed++;
        if(firstUsed == firstEmpty){
            firstUsed = -1;
            firstEmpty = 0;
        }
        return temp;
    }

    /**
     * Вставляет элемент x в конец очереди
     * @param x
     */
    public void enqueue(char x){
        if(isFull()) return;
        // Если не полная но уперлась в конец массива, то нужно сдвинуть эелементы массива на начало
        if(firstEmpty == queue.length){
            shiftQueue();
        }
        queue[firstEmpty++] = x;
        if(firstUsed == -1) firstUsed = 0;
    }

    /**
     * Возвращает значение true, если очередь пустая, и значение false в противном случае
     * @return
     */
    public boolean empty() {
        return isEmpty();
    }

    /**
     * Возвращает значение true, если очередь полная, и значение false в противном случае
     * @return
     */
    public boolean full() {
        return isFull();
    }

    private void shiftQueue() {
        int shift = firstUsed;
        for(int i = firstUsed; i < firstEmpty;i++){
            queue[i - shift] = queue[i];
        }
        firstEmpty -= shift;
        firstUsed = 0;
    }
    private boolean isFull() {
        return firstEmpty == queue.length && firstUsed == 0;
    }
    private boolean isEmpty() {
        return firstEmpty == 0;
    }
}
