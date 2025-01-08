package Lab1.ArrayPackage;
import Common.ListElementBase;

/**
 * Класс ListElement для размещения в массиве.
 */
public class ListElement extends ListElementBase {
    /**
     * Копи конструктор
     * @param x ListElement для копирования из
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
}
