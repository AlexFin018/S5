package Lab3.Stack.Array;

/**
 * Клас реализует стек на массиве.
 */
public class MyStack {
    private static final int DEFAULT_CAPACITY = 200;
    private final char[] stack;
    /**
     * Первый свободный элемент в массиве
     */
    private int firstEmpty;
    public MyStack() {
        stack = new char[DEFAULT_CAPACITY];
        firstEmpty = 0;
    }

    /**
     * Делает стек пустым
     */
    public void makeNull() {
        if(firstEmpty == 0) return; // Уже пустой
        for(int i = 0; i < firstEmpty; i++) stack[i] = 0;
        firstEmpty = 0;
    }

    /**
     * Возвращает элемент (копия) из вершины стека
     * @return копия элемента из вершины стека или null, если стек пустой
     */
    public char top() {
        if(firstEmpty == 0) return '\0';
        return stack[firstEmpty-1];
    }

    /**
     * Удаляет элемент из вершины стека и возвращает его в качестве результата
     * @return элемента из вершины стека или null, если стек пустой
     */
    public char pop() {
        if(firstEmpty == 0) return '\0';
        char temp = stack[--firstEmpty];
        // Обнуляем позицию в массиве
        stack[firstEmpty] = '\0';
        //Возвращаем элемент
        return temp;
    }

    /**
     * Вставляет элемент x в вершину стека
     * @param x
     */
    public void push(char x) {
        // Если стек полный, то ничего не делаем
        if(firstEmpty < stack.length) stack[firstEmpty++] = x;
    }

    /**
     * Возвращает значение true, если стек пустой, и значение false в противном случае
     * @return
     */
    public boolean empty() {
        return firstEmpty == '\0';
    }

    /**
     * Возвращает значение true, если стек полный, и значение false в противном случае
     * @return
     */
    public boolean full() {
        return firstEmpty == stack.length;
    }
}
