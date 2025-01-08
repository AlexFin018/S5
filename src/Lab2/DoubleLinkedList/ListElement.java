package Lab2.DoubleLinkedList;

import Common.ListElementBase;

/**
 * Класс ListElement для размещения в двусвязном списке, каждый элемент
 * содержит ссылку на следующий и на предыдущий элементы
 */

public class ListElement extends ListElementBase {
    /**
     * Копи конструктор
     * @param x Элемент для копирования
     */
    public ListElement (ListElement x){
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
    public ListElement(String sName, String sAddress){
        super(sName,sAddress);
    }

    /**
     * Ссылка на следующий элемент в списке
     */
    protected ListElement nextElement;
    /**
     * Ссылка на предыдущий элемент в списке
     */
    protected ListElement prevElement;
}
