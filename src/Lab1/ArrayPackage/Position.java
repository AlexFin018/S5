package Lab1.ArrayPackage;

/**
 * Класс, определяющий позицию элемента в списке на массиве
 */
public class Position {
    // поле index, которое указывает на положение в массиве
    protected int index;

    //конструктор
    public Position(int index){
        this.index = index;
    }

    /**
     * Переопределение метода сравнения двух экземпляров класса
     * @param obj объект для сравнения
     * @return true - объекты содержат одинаковые данные, иначе false
     */
    @Override
    public boolean equals(Object obj) {
        //Метод сравнивает текущую позицию
        // с другой позицией (obj). Если объект переданный в метод equals — это
        // объект класса Position, и его индекс совпадает с текущим, то метод
        // вернет true, иначе — false
        if(!(obj instanceof Position))return false;
        Position p = (Position)obj;
        return this.index == p.index;
    }
}
