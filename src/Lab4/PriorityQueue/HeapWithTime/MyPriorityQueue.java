package Lab4.PriorityQueue.HeapWithTime;
import Lab4.PriorityQueueException;


public class MyPriorityQueue {
    private class Item {
        private int priority;
        private int time;
        private Item(int priority,int time){
            this.priority = priority;
            this.time = time;
        }
        private boolean isLessThan(Item item) {
            if(priority < item.priority) return true;
            if(priority > item.priority) return false;
            if(time < item.time) return true;
            return false;
        }
        private boolean isGreaterThan(Item item) {
            if(priority > item.priority) return true;
            if(priority < item.priority) return false;
            if(time > item.time) return true;
            return false;
        }
    }
    private static final int DEFAULT_CAPACITY = 100;
    private final Item[] items;
    private int size;
    private int currentTime = Integer.MIN_VALUE;
    public MyPriorityQueue() {
        items = new Item[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Помещает значение в очередь
     * @param value
     */
    public void insert(int value){
        insert(new Item(value,currentTime++));
    }

    /**
     * Возвращает значение с минимальным приоритетом, при этом удаляя его из очереди
     * @return
     */
    public int deleteMin() {
        Item item = extractFirst();
        if(item == null) throw new PriorityQueueException("Очередь пустая!");
        return item.priority;
    }

    /**
     * Делает очередь пустой
     */
    public void makeNull() {
        // Обнулим ссылки для ускорения работы сборщика мусора, хотя это и не обязательно
        for(int i = 0; i < size; i++){
            items[i] = null;
        }
        size = 0;
    }

    /**
     * Выводит очередь на экран в порядке правильной очереди, а не в порядке следования
     * элементов в массиве
     * @return
     */
    public void print() {
        // Создадим временную копию кучи
        Item[] temp = new Item[size];
        for(int i = 0; i < size; i++){
            temp[i] = items[i];
        }
        int tmpSize = size;
        // Печатаем очередь
        System.out.println("Очередь: ");
        for(Item item = extractFirst(); item != null; item = extractFirst()){
            System.out.printf("%d %d; ", item.priority, item.time);
        }
        System.out.println();

        // Восстановим из копии
        size = tmpSize;
        for(int i = 0; i < size; i++){
            items[i] = temp[i];
        }
    }
    //Методы для работы с heap

    /**
     * Вставляем элемент в кучу
     * @param item
     */
    private void insert(Item item) {
        if(size == items.length) throw new PriorityQueueException("Очередь полная!");
        items[size] = item;
        if(size > 0)  {
            heapifyUp(size);
        }
        size++;
    }

    private Item extractFirst() {
        if(size == 0) return null;
        Item temp = items[0];
        items[0] = items[size-1];
        items[--size] = null;
        heapifyDown(0);
        return temp;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }
    private int leftChild(int i) {
        return 2 * i + 1;
    }
    private int rightChild(int i) {
        return 2 * i + 2;
    }
    private void swap(int i, int j) {
        Item temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }
    private void heapifyUp(int i) {
        while (i > 0 && items[i].isLessThan(items[parent(i)])) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    private void heapifyDown(int pos) {
        while ((rightChild(pos) < size)) {
            int left = leftChild(pos);
            int right = rightChild(pos);
            //Проверяем, что значение (когда-то последнее, а сейчас первое) больше его сыновей
            if ((items[pos].isGreaterThan(items[left]))
                    || (items[pos].isGreaterThan(items[right]))) {
                //В случае если первый сын меньше второго, то меняем значение с первым сыном
                if (items[left].isLessThan(items[right])) {
                    swap(left, pos);
                    pos = left;
                }
                //Иначе меняем со вторым сыном
                else {
                    swap(right, pos);
                    pos = right;
                }
                //Если значение меньше сыновей, то выходим из цикла
            } else {
                break;
            }
        }
    }
}
