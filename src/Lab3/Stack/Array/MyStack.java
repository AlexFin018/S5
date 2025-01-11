package Lab3.Stack.Array;

/**
 * Клас реализует стек на массиве.
 */
public class MyStack {
    /**
     * Константа, определяющая размер стека
     */
    private static final int DEFAULT_CAPACITY = 200;
    /**
     * Ссылка на массив для размещения стека
     */
    private final char[] stack;
    /**
     * Первый свободный элемент в массиве
     */
    private int firstEmpty;

    /**
     * Конструктор выделяет память для массива и устанавливает firstEmpty
     */
    public MyStack() {
        stack = new char[DEFAULT_CAPACITY];
        firstEmpty = 0;
    }

    /**
     * Делает стек пустым
     */
    public void makeNull() {
        //Стек пустой, если первым свободным является 0-ой элемент
        firstEmpty = 0;
    }

    /**
     * Возвращает элемент (копия) из вершины стека
     * @return копия элемента из вершины стека или null, если стек пустой
     */
    public char top() {
        // Если стек пустой, то вернем 0
        if(isEmpty()) return '\0';
        //Иначе вернем последний занесенный элемент
        return stack[firstEmpty-1];
    }

    /**
     * Удаляет элемент из вершины стека и возвращает его в качестве результата
     * @return элемента из вершины стека или null, если стек пустой
     */
    public char pop() {
        // Если стек пустой, вернем 0
        if(isEmpty()) return '\0';
        //Запомним последний занесенный элемент и уменьшим на 1 позицию firstEmpty
        return stack[--firstEmpty];
    }

    /**
     * Вставляет элемент x в вершину стека
     * @param x символ для занесения в стек
     */
    public void push(char x) {
        // Если стек полный, то ничего не делаем,
        // Иначе заносим на позицию первого свободного новый символ и увеличиваем на 1
        // позицию после последнего
        if(firstEmpty < stack.length) stack[firstEmpty++] = x;
    }

    /**
     * Возвращает значение true, если стек пустой, и значение false в противном случае
     * @return true, если стек пустой
     */
    public boolean empty() {
        return firstEmpty == 0;
    }

    /**
     * Возвращает значение true, если стек полный, и значение false в противном случае
     * @return true, если стек полный
     */
    public boolean full() {
        // Стек полный, если позиция первого свободного вышла за границы массива и стала равна
        // размерности массива
        return firstEmpty == stack.length;
    }

    /**
     * Приватный метод определения пустоты стека
     * @return true, если стек пустой
     */
    private boolean isEmpty() {
        //Стек пустой, если первым свободным является 0-ой элемент
        return firstEmpty == 0;
    }
}
