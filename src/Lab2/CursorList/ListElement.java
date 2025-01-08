package Lab2.CursorList;

import Common.ListElementBase;
/**
 * Класс ListElement для размещения в списке на курсорах
 */

public class ListElement extends ListElementBase {
    /**
     * Копи конструктор
     * @param x ListElement для копирования из
     */
    public ListElement (ListElement x){
        super(x);
        //Устанавливаем индекс следующего элемента на -1
        nextElement = -1;
    }
    public ListElement(String sName, String sAddress){
        super(sName,sAddress);
        //Устанавливаем индекс следующего элемента на -1
        nextElement = -1;
    }

    /**
     * Индекс следующего элемента в последовательности
     */
    protected int nextElement;

}
