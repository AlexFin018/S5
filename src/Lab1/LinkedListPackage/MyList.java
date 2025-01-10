package Lab1.LinkedListPackage;
import Common.InvalidPositionException;

/**
 * Класс реализации списка на связном списке
 *
 */
public class MyList {
    // Ссылка на первый элемент списка. Изначально
    // список пустой, поэтому first равен null
    private Node first = null;

    /**
     * Метод First возвращает позицию (Position) 1-го элемента в списке
     * Если список пустой --> возвращает позицию после последнего
     * @return первую позицию в списке
     */
    public Position first(){
        //Если first == null т.е. список пустой, то вернется позиция после последнего
        return new Position(first);
    }

    /**
     * Метод End возвращает позицию после последнего элемента в списке
     * @return позиция после последней
     */
    public Position end(){
        return new Position(null);
    }

    /**
     * Метод Next возвращает позицию следующего элемента в списке
     * @param p - текущая позиция в списке
     * @return позиция следующего элемента
     */
    public Position next(Position p){
        //Проверяется, не является ли текущая позиция пустой
        // (если link равен null, выбрасывается исключение).
        if(p == null || p.link == null) throw new InvalidPositionException();
        // Если следующий равен null, значит p - это последний элемент в списке.
        // Вернем позицию за последним
        return new Position(p.link.nextNode);
    }

    /**
     * Метод возвращает позицию предыдущего элемента
     * @param p - позиция, для которой надо найти предыдущий элемент
     * @return позиция предыдущего элемента
     */
    public Position previous(Position p){
        //Возвращает позицию предыдущего элемента.
        //Если позиция пуста или она указывает на первый элемент, выбрасывается исключение.
        if(p.link == null || p.link == first) throw new InvalidPositionException();
        //Если все ок - вызывается findPrevious.
        return findPrevious(p);
    }

    /**
     * Приватный метод, находит предыдущую позицию
     * @param p текущая позиция
     * @return предыдущая позиция
     */
    private Position findPrevious(Position p){
        // Устанавливаем current на начало списка
        Node current = first;
        // Пока следующий для текущего элемента не равен искомой ссылке
        //переходим к следующему элементу
        while (current != null && current.nextNode != p.link) {
            current = current.nextNode;
        }
        return new Position(current);
    }


    /**
     * Метод Retrieve возвращает элемент списка по позиции
     * @param p позиция элемента
     * @return элемент в указанной позиции
     */
    public Node retrieve(Position p){
        //Возвращает элемент списка по заданной позиции.
        //Если позиция пуста (null), выбрасывается исключение.
        if(p == null || p.link == null) throw new InvalidPositionException();
        return p.link;
    }

    /**
     * Метод Delete удаляет элемент из позиции списка
     * @param p позиция, в которой нужно удалить элемент
     */
    public void delete(Position p){
        if(p == null || p.link == null) throw new InvalidPositionException();
        //Если список пустой, ничего не удаляем
        if(first == null) return;
        //Удаляет элемент списка на позиции p.
        //Если удаляемый элемент — первый, то firstElement переходит
        //на следующий элемент.
        if(p.link == first) first = p.link.nextNode;
        //Если удаляемый элемент не является первым, нужно найти предыдущий
        // элемент. Для этого вызывается метод findPrevious(p).
        else {
            Position previous = findPrevious(p);
            //После того как найден предыдущий элемент, его поле nextElement переназначается
            // так, чтобы оно указывало на элемент, следующий за удаляемым.
            previous.link.nextNode = p.link.nextNode;
        }

        // Переустанавливаем позицию на элемент, следующий за удаленным
        if(p.link.nextNode != null){
            p.link = p.link.nextNode;
        }
        else {
            p.link = null;
        }

    }

    /**
     * Очищает список
     * @return позицию после последней
     */
    public Position makeNull(){
        //Очищает список, делая его пустым.
        //First становится равен нулю
        first = null;
        return new Position(null);
    }

    /**
     * Возвращает позицию в списке объекта x. Если объекта в списке нет, то возвращается позиция end().
     * Если несколько значений, совпадает со значением x, то возвращается первая позиция от начала
     * @param x объект для поиска
     * @return позиция первого найденного объекта в списке
     */
    public Position locate(Node x){
        //Цикл начинается с первого элемента списка (указанного
        // переменной firstElement) и проходит по списку, проверяя каждый элемент:
        //переменная l в каждой итерации обновляется ссылкой на следующий элемент,
        // используя поле nextElement у текущего элемента.
        //Для каждого элемента списка вызывается метод equals(), чтобы проверить,
        // совпадает ли текущий элемент с искомым элементом x
        //Если метод equals() возвращает true, то найдено совпадение, и метод
        // возвращает позицию, указывающую на текущий элемент l
        //Если после завершения цикла элемент так и не был найден, то метод возвращает позицию
        // после последнего элемента

        Node current = first;
        while(current != null && !current.equals(x)){
            current = current.nextNode;
        }
        return new Position(current);
    }

    /**
     * Метод вставляет элемент x на позицию p, элемент на позиции p становится следующим
     * @param le элемент, копию которого нужно вставить
     * @param p позиция для вставки
     */
    public void insert(Node le, Position p ){
        if(p == null) throw new InvalidPositionException();
        //Если позиция p равна позиции после последнего элемента
        // (p == End()), элемент вставляется в конец списка
            //Сначала проверяется, пустой ли список (firstElement == null):
            //Если список пустой, вставляемый элемент становится первым элементом списка
            //Если список не пуст, цикл проходит по списку до последнего элемента
            //После нахождения последнего элемента его поле nextElement обновляется, указывая на новый элемент
            //Новый элемент не ссылается ни на какие следующие элементы, поэтому его nextElement устанавливается в null.
        // Будем вставлять копию
        Node x = new Node(le);
        if(p.link == null){
            p.link = x;
            if(first == null) {
                first = x;
            }
            else {
                findTail().nextNode = x;
            }
        }
        //Если позиция p равна первой позиции в списке (p.link == firstElement), новый элемент
        // вставляется в начало. Он будет ссылаться на текущий первый элемент, а сам станет новым
        // первым элементом списка
        else if(p.link == first){
            p.link = x;
            x.nextNode = first;
            first = x;
        }

        //Если позиция для вставки находится не в начале и не в конце, элемент вставляется в середину списка
        //сначала находится предыдущий элемент по отношению к позиции p с помощью метода findPrevious(p)
        //Новый элемент x теперь ссылается на элемент, находящийся в позиции p
        //После вставки позиция p обновляется, чтобы она указывала на только что вставленный элемент x
        else {
            Position s = findPrevious(p);
            s.link.nextNode = x;
            x.nextNode = p.link;
            p.link = x;
        }
    }

    /**
     * Метод возвращает последний элемент в списке
     * @return последний элемент или null
     */
    private Node findTail() {
        Node s = first; // В общем случае first может быть равен null, но мы вызываем этот метод
        //только тогда, когда first != null, но оставляем эту проверку
        if(s == null) return null;
        while (s.nextNode != null){
            s = s.nextNode;
        }
        return s;
    }

    /**
     * Выводит список на консоль
     */
    public void printList(){
        //цикл от первого элемента списка, пока l не станет равен null
        // В каждой итерации l обновляется ссылкой на следующий элемент в списке: l.nextElement
        //Для каждого элемента списка метод выводит на консоль имя и адрес
        for(Node p = first; p!=null; p = p.nextNode){
            p.PrintElement();
            System.out.println();
        }
    }
}
