package Lab1.LinkedListPackage;

/**
 * Класс определения позиции элемента в списке на связном списке
 */
public class Position {
    //ссылка на элемент списка (ListElement),
    // который находится на этой позиции.
    protected Node link;

    /**
     * Конструктор класса
     * @param p элемент на этой позиции
     */
    public Position(Node p){
        link = p;
    }

    /**
     * Переопределение метода сравнения двух экземпляров класса
     * @param obj объект для сравнения
     * @return true - объекты содержат одинаковые данные, иначе false
     */
    @Override
    public boolean equals(Object obj) {
        //Сравнивает два объекта Position. Если объект не null и
        // является экземпляром Position, то метод сравнивает ссылки на
        // элементы списка (link). Если ссылки одинаковы, то объекты равны.
        if(! (obj instanceof Position)) return false;
        Position p = (Position) obj;
        return p.link == link;
    }
}
