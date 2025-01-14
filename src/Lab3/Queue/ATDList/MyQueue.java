package Lab3.Queue.ATDList;
//import Lab2.DoubleLinkedList.*;
import Lab1.LinkedListPackage.*;
//import Lab2.CursorList.*;
//import Lab1.ArrayPackage.*;

/**
 * Класс реализации очереди на АТД список
 */
public class MyQueue {
    /**
     * Ссылка на АТД список
     */
    private final MyList list;

    /**
     * Конструктор
     */
    public MyQueue() {
        // Создаем экземпляр списка
        list = new MyList();
    }
    /**
     * Очищает очередь, делая ее пустой
     */
    public void makeNull() {
        // Очищаем список
        list.makeNull();
    }
    /**
     * Возвращает первый элемент (копия) очереди
     * @return первый элемент из списка
     */
    public char front() {
        // Если очередь пустая вернем нулевой символ
       if(isEmpty()) return '\0';
       return list.retrieve(list.first()).name[0];
    }
    /**
     * Удаляет первый элемент очереди, и возвращает его в качестве результата
     * @return первый элемент из списка
     */
    public char dequeue() {
        // Если очередь пустая, вернем нулевой символ
       if(isEmpty()) return '\0';
       // Получим первый элементы из списка
       Position p = list.first();
       Node temp = list.retrieve(p);
       //Удалим из списка элемент на первой позиции
       list.delete(p);
        //Элемент находится на 0 позиции массива name
       return temp.name[0];
    }
    /**
     * Вставляет элемент x в конец очереди
     * @param c элемент для вставки
     */
    public void enqueue(char c){
        //Так как у нас в АТД список конструктор узла принимает в качестве параметров строку с именем и
        // строку с адресом, то занесем строку с именем из буквы и пустую строку в качестве адреса
       list.insert(new Node(String.valueOf(c),""),list.end());
    }
    /**
     * Возвращает значение true, если очередь пустая, и значение false в противном случае
     * @return true - если очередь пустая
     */
    public boolean empty() {
        return isEmpty();
    }
    /**
     * Возвращает значение true, если очередь полная, и значение false в противном случае
     * @return всегда false. Очередь на списке безразмерна
     */
    public boolean full() {
        return false;
    }

    /**
     * Метод возвращает true, если очередь пустая
     * @return true, если очередь пустая
     */
    private boolean isEmpty() {
        // Очередь пустая, если позиция первого элемента равна позиции после последнего
        return list.first().equals(list.end());
    }
}
