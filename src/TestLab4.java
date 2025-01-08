import Lab4.PriorityQueue.SimpleArray.MyPriorityQueue;

import java.util.Random;

public class TestLab4 {
    public static void main(String[] args) {
        MyPriorityQueue queue = new MyPriorityQueue();
        Random rand = new Random();
        for(int i = 0; i < 20; i++) {
            int v = rand.nextInt(1,10);
            System.out.println(v);
            queue.insert(v);
        }

        System.out.println("Оригинальная очередь:");
        queue.print();

        for(int i = 0; i < 5; i++) {
            System.out.printf("Extracted %d\n", queue.deleteMin());
            queue.print();
        }
    }
}
