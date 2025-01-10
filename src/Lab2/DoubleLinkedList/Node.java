package Lab2.DoubleLinkedList;

import Common.ListElement;

/**
 * Класс ListElement для размещения в двусвязном списке, каждый элемент
 * содержит ссылку на следующий и на предыдущий элементы
 */

public class Node extends ListElement {
    /**
     * Копи конструктор
     * @param x Элемент для копирования
     */
    public Node(Node x){
        super(x);
    }

    /**
     * Конструктор принимает два параметра:String sName, String sAddress
     * Строка sName преобразуется в массив символов с помощью метода toCharArray().
     * Символы копируются или до достижения прерывающего символа (0) или не более
     * Размерности принимающего массива
     * @param sName имя персоны
     * @param sAddress адрес персоны
     */
    public Node(String sName, String sAddress){
        super(sName,sAddress);
    }

    /**
     * Ссылка на следующий элемент в списке
     */
    protected Node nextNode;
    /**
     * Ссылка на предыдущий элемент в списке
     */
    protected Node prevNode;
}
