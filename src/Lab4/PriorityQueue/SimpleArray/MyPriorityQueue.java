package Lab4.PriorityQueue.SimpleArray;

import Lab4.PriorityQueueException;

/**
 * Очередь формируется в массиве уже в правильном порядке, на нулевой позиции
 * всегда первый элемент очереди
 */
public class MyPriorityQueue {
    private final int[] items;
    private static final int DEFAULT_CAPACITY = 100;
    private int firstEmpty;
    private int firstUsed;
    public MyPriorityQueue() {
        items = new int[DEFAULT_CAPACITY];
        firstEmpty = 0;
        firstUsed = -1;
    }

    /**
     * Помещает значение в очередь
     * @param value
     */
    public void insert(int value){
        if(firstEmpty == items.length){
            if(firstUsed == 0) {
                throw new PriorityQueueException("Очередь уже полная!");
            }
            else {
                shiftItems();
            }
        }
        if(firstUsed == -1) firstUsed = 0;
        // Ищем позицию, на которую поставить новое число
        for(int i = firstUsed; i < firstEmpty; i++){
            if(items[i] > value) {
                //Вставляем на позицию первого большего,
                //хвост сдвигаем на 1 позицию влево
                for(int j = firstEmpty;j > i; j--){
                    items[j] = items[j-1];
                }
                items[i] = value;
                firstEmpty++;
                return;
            }
        }
        // Если не нашли, то ставим в коней
        items[firstEmpty++] = value;
    }
    /**
     * Возвращает значение с минимальным приоритетом, при этом удаляя его из очереди
     * @return
     */
    public int deleteMin() {
        if(firstUsed == firstEmpty) throw new PriorityQueueException("Очередь пустая!");
        return items[firstUsed++];
    }

    /**
     * Делает очередь пустой
     */
    public void makeNull() {
        firstUsed = -1;
        firstEmpty = 0;
    }

    /**
     * Выводит очередь на экран в порядке правильной очереди
     */
    public void print() {
        System.out.println("Очередь: ");
        for(int i = firstUsed; i < firstEmpty; i++){
            System.out.printf("%d ",items[i]);
        }
        System.out.println();
    }

    private void shiftItems() {
        int shift = firstUsed;
        for(int i = firstUsed; i < firstEmpty;i++){
            items[i-shift] = items[i];
        }
    }
}
