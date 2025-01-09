package Lab3.Queue.Array;

/**
 * Класс реализующий очередь на массиве
 */
public class MyQueue {
    /**
     * Константа, определяющая размерность массива
     */
    private static final int DEFAULT_CAPACITY = 200;
    /**
     * Ссылка на массив для хранения очереди
     */
    private final char[] queue;
    /**
     * Индекс первого свободного элемента в очереди
     */
    private int firstEmpty;
    /**
     * Индекс первого занятого элемента в очереди
     */
    private int firstUsed;

    /**
     * Конструктор по умолчанию
     */
    public MyQueue() {
        // Создаем массив для очереди
        queue = new char[DEFAULT_CAPACITY];
        // Устанавливаем значения для первой пустой и первой занятой ячеек
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
     * Возвращает первый элемент (копия элемента - для char всегда копия) очереди
     * @return возвращает первый элемент в очереди
     */
    public char front() {
        //Если очередь пустая вернем 0
        if(isEmpty()) return 0;
        // Иначе char на позиции firstUsed - начало очереди
        return queue[firstUsed];
    }

    /**
     * Удаляет первый элемент очереди, и возвращает его в качестве результата
     * @return первый элемент в очереди
     */
    public char dequeue() {
        // Если очередь пустая, вернем 0
        if (isEmpty()) return 0;
        // Запомним первый элемент в очереди
        char temp = queue[firstUsed];
        //Установим firstUsed начало очереди на следующий элемент
        firstUsed++;
        //Если очередь опустела, переустановим начало и конец на начало очереди
        if(firstUsed == firstEmpty){
            firstUsed = -1;
            firstEmpty = 0;
        }
        //Вернем первый элемент в очереди
        return temp;
    }

    /**
     * Вставляет элемент x в конец очереди
     * @param x элемент для вставки
     */
    public void enqueue(char x){
        //Если очередь полная, то ничего не делаем
        if(isFull()) return;
        // Если не полная но уперлась в конец массива, то нужно сдвинуть эелементы массива на начало
        if(firstEmpty == queue.length){
            //Сдвигаем элементы к началу массива
            shiftQueue();
        }
        //Заносим элемент в конец очереди и увеличиваем на 1 индекс за последним
        queue[firstEmpty++] = x;
        //Если очередь была постой, установим индекс первого элемента на 0
        if(firstUsed == -1) firstUsed = 0;
    }

    /**
     * Возвращает значение true, если очередь пустая, и значение false в противном случае
     * @return true, если очередь пустая
     */
    public boolean empty() {
        return isEmpty();
    }

    /**
     * Возвращает значение true, если очередь полная, и значение false в противном случае
     * @return true, если очередь полная
     */
    public boolean full() {
        return isFull();
    }

    /**
     * Метод сдвигает все занятые элементы массива к началу
     */
    private void shiftQueue() {
        //Вычисляем, на сколько позиций нужно сдвинуть
        int shift = firstUsed;
        //В цикле от первого элемента до последнего переносим значения в начало массива
        for(int i = firstUsed; i < firstEmpty;i++){
            queue[i - shift] = queue[i];
        }
        //Устанавливаем firstUsed и firstEmpty
        firstEmpty -= shift;
        firstUsed = 0;
    }

    /**
     * Метод проверяет полная ли очередь
     * @return true, если очередь полная
     */
    private boolean isFull() {
        // Очередь полная, если начало очереди установлено в 0, а после последнего равно размерности
        //массива
        return firstEmpty == queue.length && firstUsed == 0;
    }

    /**
     * Метод проверяет очередь на пустоту
     * @return true, если очередь пустая
     */
    private boolean isEmpty() {
        // Если позиция после последнего равна 0, очередь пустая
        // Это так, потому что мы обнуляем firstEmpty при удалении последнего элемента
        // из очереди
        return firstEmpty == 0;
    }
}
