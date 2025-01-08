package Lab3.Stack.LinkedList;

public class MyStack {

    private MyList list;
    public  MyStack() {
        list = new MyList();
    }
    /**
     * Делает стек пустым
     */
    public void makeNull() {
        list.makeNull();
    }
    /**
     * Возвращает элемент (копия) из вершины стека
     * @return копия элемента из вершины стека или null, если стек пустой
     */
    public char top() {
        if(list.empty()) return '\0';
        return list.first();
    }
    /**
     * Удаляет элемент из вершины стека и возвращает его в качестве результата
     * @return элемента из вершины стека или null, если стек пустой
     */
    public char pop() {
        if(list.empty()) return '\0';
        char temp = list.first();
        list.removeFirst();
        return temp;
    }

    /**
     * Вставляет элемент x в вершину стека
     * @param x
     */
    public void push(char x){
        list.insertFirst(x);
    }

    /**
     * Возвращает значение true, если стек пустой, и значение false в противном случае
     * @return
     */
    public boolean empty() {
        return list.empty();
    }

    /**
     * Возвращает значение true, если стек полный, и значение false в противном случае
     * @return
     */
    public boolean full() {
        return false;
    }
}
