package Lab3.Queue.ATDList;
import Lab2.DoubleLinkedList.*;

public class MyQueue {
    private MyList list;
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
       if(isEmpty()) return '\0';
       return list.retrieve(list.first()).name[0];
    }
    /**
     * Удаляет первый элемент очереди, и возвращает его в качестве результата
     * @return
     */
    public char dequeue() {
       if(isEmpty()) return '\0';
       Position p = list.first();
       ListElement temp = list.retrieve(p);
       list.delete(p);
       return temp.name['\0'];
    }
    /**
     * Вставляет элемент x в конец очереди
     * @param c
     */
    public void enqueue(char c){
       list.insert(new ListElement(String.valueOf(c),""),list.end());
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
        return false;
    }

    private boolean isEmpty() {
        return list.first().equals(list.end());
    }
}
