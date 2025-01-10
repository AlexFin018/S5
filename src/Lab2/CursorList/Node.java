package Lab2.CursorList;

import Common.ListElement;
/**
 * Класс ListElement для размещения в списке на курсорах
 */

public class Node extends ListElement {
    /**
     * Копи конструктор
     * @param x ListElement для копирования из
     */
    public Node(Node x){
        super(x);
        //Устанавливаем индекс следующего элемента на -1
        nextNode = -1;
    }
    public Node(String sName, String sAddress){
        super(sName,sAddress);
        //Устанавливаем индекс следующего элемента на -1
        nextNode = -1;
    }

    public Node(int index){
        super("","");
        nextNode = index;
    }

    /**
     * Индекс следующего элемента в последовательности
     */
    protected int nextNode;

}
