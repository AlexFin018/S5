package Lab2.CursorList;

/**
 * Класс определения позиции для списка на курсорах. Содержит индекс элемента для
 * этой позиции
 */
public class Position {
    /**
     * Индекс ячейки элемента для позиции
     */
    protected int elementIndex;

    /**
     * Конструктор позиции с указанием индекса
     * @param index индекс ячейки элемента
     */
    protected Position(int index){
        elementIndex = index;
    }

    /**
     * Копи конструктор, копирует индекс ячейки элемента
     * @param pos Позиция для копирования
     */
    protected Position(Position pos){
        elementIndex = pos.elementIndex;
    }

    /**
     * Переопределение метода сравнения экземпляров Position. Сравнивается индекс элемента для позиции
     * @param obj Объект для сравнения
     * @return true, если объекты эквивалентны
     */
    @Override
    public boolean equals(Object obj) {
        //Сравнивает два объекта Position. Если объект не null и
        // является экземпляром Position, то метод сравнивает ссылки на
        // элементы списка (link). Если ссылки одинаковы, то объекты равны.
        if(! (obj instanceof Position)) return false;
        Position p = (Position) obj;
        return p.elementIndex == elementIndex;
    }
}
