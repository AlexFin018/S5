import Common.ListElement;
import Lab3.Map.LinkedList.MyMap;
import Lab3.Queue.ATDList.MyQueue;
import Lab3.Stack.ATDList.MyStack;

public class TestLab3 {
    public static void main(String[] vars){
        System.out.println("Testing stack and queue...");
        String instring = "Васильевский остров";
        System.out.println(instring);

        MyStack stack = new MyStack();
        MyQueue queue = new MyQueue();
        for(char c:instring.toCharArray()){
            if(!stack.full()) stack.push(c);
            if(!queue.full()) queue.enqueue(c);
        }
        //Вывод стека
        System.out.print("MyStack:");
        while (!stack.empty()){
            System.out.print(stack.pop());
        }
        System.out.println();
        // Вывод очереди
        System.out.print("MyQueue:");
        while (!queue.empty()){
            System.out.print(queue.dequeue());
        }
        System.out.println();

        // Тест отображения
        String name1 = "Иван"; String address1 = "Малая Разночинная 10";
        String name2 = "Вася"; String address2 = "Петроградка";
        String name3 = name1; String address3 = "Васильевский остров";

        MyMap map = new MyMap();
        addToMap(map,name1,address1);
        addToMap(map,name2,address2);
        addToMap(map,name2,address3);

        MyMap.ComputeResult result = map.compute(name1);

        ListElement.PrintArray(result.value);
        System.out.println();
        result = map.compute("Петр");
        ListElement.PrintArray(result.value);
        System.out.println();

    }
    public static void addToMap(MyMap map, String name, String address){
        map.assign(name,address);
        System.out.printf("Добавили %s %s\n",name,address);
        System.out.println("Состав отображения:");
        map.printMap();
    }
}
