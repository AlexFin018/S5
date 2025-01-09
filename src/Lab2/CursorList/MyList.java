package Lab2.CursorList;
import Common.InvalidPositionException;

import java.util.List;

/**
 * Реализация списка на курсорах
 */
public class MyList {
    /**
     * Константа - размерность массива
     */
    private static final  int SIZE = 200;
    /**
     * Массив для хранения элементов списка
     */
    private final ListElement[] elements;
    /**
     * Начало списка пустых ячеек для элементов. Содержит индекс ячейки в массиве spaces, в которой хранится
     * индекс следующе свободной ячейки. Если в ячейке по этому индексу хранится -1,
     * значит headSpace содержит индекс последней свободной ячейки.
     * Если headSpace равен -1, значит свободных ячеек больше нет.
     * Индекс в headSpace - индекс первой свободной ячейки в массиве элементов
     */
    private  int headSpace;

    /**
     * Индекс ячейки первого элемента в списке
     */
    private int head;

    /**
     * Конструктор класса
     */
    public MyList() {
        head = -1; // начало списка отсутствует
        // Создаем два массива, один для элементов,
        // второй для списка индексов пустых ячеек
        elements = new ListElement[SIZE];
        //Устанавливаем начало списка пустых элементов на первую позицию массива
        headSpace = 0;
        //Инициируем список пустых ячеек
        //Для каждой позиции ставим индекс следующей пустой
        for(int i = 0; i < SIZE-1;i++){
            elements[i] = new ListElement(i+1);
        }
        //В последнюю пустую ставим -1 - конец списка - нет следующей пустой
        elements[SIZE-1] = new ListElement(-1);
    }

    /**
     * Метод возвращает позицию первого элемента или end() если список пустой
     * @return позиция первого элемента, или end
     */
    public Position first() {
        return new Position(head);
    }

    /**
     * Метод возвращает позицию после последнего элемента
     * @return позиция после последнего элемента
     */
    public Position end() {
        return new Position(-1);
    }

    /**
     * Возвращает позицию следующего элемента в списке или end(), если нет следующего элемента
     * @param p позиция текущего элемента
     * @return позиция следующего элемента
     */
    public Position next(Position p){
        checkPosition(p);
        //Иначе вернуть позицию следующего элемента
        return new Position(elements[p.elementIndex].nextElement);
    }
    /**
     * Метод возвращает позицию предыдущего элемента в списке или end()
     * @param p позиция текущего элемента
     * @return позиция предыдущего элемента
     */
    public Position previous(Position p){
        checkPosition(p);
        //Вернуть позицию предыдущего элемента
        return new Position(findPrevious(p.elementIndex));
    }

    /**
     * Приватный метод поиска индекса предыдущего элемента
     * @param p индекс текущего элемента
     * @return индекс предыдущего элемента или -1, если такого нет
     */
    private int findPrevious(int p){
        // Цикл идет по всем элементам списка начиная с первого до последнего элемента
        int s = head;
        while(elements[s].nextElement != p){
            s = elements[s].nextElement;
        }
        return  s;
    }

    /**
     * Метод возвращает элемент в указанной позиции
     * @param p - позиция элемента
     * @return искомый элемент
     */
    public ListElement retrieve(Position p){
        checkPosition(p);
        // Возвращаем элемент по индексу, который указан в позиции
        return elements[p.elementIndex];
    }

    /**
     * Проверяет позицию на наличие
     * @param p позиция для проверки
     */
    private void checkPosition(Position p){
        if(head == -1 //Если список пустой
                || p.elementIndex == -1 // Если это позиция после последней
                // Или по указанному индексу нет значения выкидываем ошибку
                || elements[p.elementIndex] == null) throw new InvalidPositionException();
    }
    /**
     * Метод удаляет элемент в указанной позиции
     * @param p позиция для удаления элемента
     */
    public void delete(Position p){
        checkPosition(p); // Проверим позицию на наличие
        int temp = p.elementIndex;// Запомним удаляемый индекс
        // Если удаляем первый элемент, то
        if(p.elementIndex == head){
            //Запишем в head индекс элемента следующего за удаляемым
            head = elements[p.elementIndex].nextElement;
            //Запишем в позицию индекс нового первого элемента,
            //Таким образом позиция сохраняется со следующим элементом
            p.elementIndex = head;
        }
        //Если удаляем не первый элемент
        else {
            //Найдем предыдущий элемент
            int prev = findPrevious(p.elementIndex); // prev != -1, так как тогда удаляется head
            //nextElement предыдущего элемента устанавливаем на nextElement удаляемого элемента
            int next = elements[p.elementIndex].nextElement;
            elements[prev].nextElement = next;
            //Запишем в позицию индекс элемента следующего за удаляемым,
            //Таким образом позиция сохраняется со следующим элементом
            p.elementIndex = next;
        }
        saveSpaceIndex(temp);
    }

    /**
     * Метод сохраняет индекс в списке индексов свободных ячеек
     * @param index освободившийся индекс
     */
    private void saveSpaceIndex(int index){
        //Запишем в список свободных ячеек индекс освободившейся ячейки. headSpace - индекс первой свободной
        // ячейки элементов, в массиве spaces по этому индексу указана следующая свободная ячейка. Соответственно,
        // после удаления headSpace станет равен индексу удаленной ячейки, а в массиве spaces по индексу index, будет
        // находиться предыдущее значение headSpace. Освободившаяся ячейка станет первой в списке свободных ячеек.

        elements[index] =new ListElement(headSpace);
        headSpace = index;
    }

    /**
     * Очищает список элементов и возвращает end()
     * @return позицию после последнего
     */
    public Position makeNull() {
        // Перебираем все занятые ячейки, их обнуляем и записываем их индекс в список свободных ячеек
        for(int index = head; index != -1;){
            int current = index;
            index = elements[index].nextElement;
            saveSpaceIndex(current);
        }
        // Устанавливаем начало списка в -1
        head = -1;
        // Возвращаем позицию после последнего
        return new Position(-1);
    }

    /**
     * Метод находит в списке позицию первого элемента равного указанному
     * @param x элемент для поиска
     * @return позиция найденного элемента, или позиция после последнего, если она не найдена
     */
    public Position locate(ListElement x){
        //цикл начинается с первого элемента списка (указанного
        // переменной head) и проходит по списку, проверяя каждый элемент:
        //переменная index в каждой итерации обновляется индексом следующего элемента,
        // используя поле nextElement у текущего элемента.
        //Для каждого элемента списка вызывается метод equals(), чтобы проверить,
        // совпадает ли текущий элемент с искомым элементом x
        //Если метод equals() возвращает true, то найдено совпадение, и метод
        // возвращает позицию, указывающую на текущий элемент l
        //Если после завершения цикла элемент так и не был найден, то метод возвращает позицию
        // после последнего элемента
        int current = head;
        while(!x.equals(elements[current])){
            current = elements[current].nextElement;
        }
        return new Position(current);
    }

    /**
     * Метод возвращает индекс свободной ячейки и удаляет ее из списка свободных ячеек
     * @return индекс свободной ячейки, или -1 если свободных больше нет
     */
    private int captureSpace() {
        //Запоминаем значение первой свободной ячейки
        int temp = headSpace;
        //Устанавливаем первой свободной следующую ячейку из списка свободных ячеек
        headSpace = elements[headSpace].nextElement;
        //Возвращаем индекс первой свободной ячейки
        return temp;
    }
    /**
     * Метод вставляет копию элемента на указанную позицию
     * @param le элемент, копию которого нужно вставить
     * @param p позиция, на которую нужно вставить
     */
    public void insert(ListElement le, Position p ) {
        if(p == null) throw new InvalidPositionException();
        // Если указана существующая позиция, но список пуст - выкинуть ошибку
        if(p.elementIndex != -1 && head == -1) throw new InvalidPositionException();

        ListElement x = new ListElement(le); // Будем вставлять копию
        //Получим свободную ячейку из списка
        int emptyIndex = captureSpace();
        // если вставляем на позицию после последней
        if(p.elementIndex == -1){
            // Если список пуст
            if(head == -1) {
                //Запишем новый индекс в head
                head = emptyIndex;
                elements[head] = x; // Занесем туда элемент
                p.elementIndex = head; //Установим в позиции индекс этого элемента
            }
            else {
                //Добавляем после последней
                int tail = findTailIndex(); //Находим индекс последней позиции
                elements[emptyIndex] = x; //Запишем туда элемент
                elements[tail].nextElement = emptyIndex; //Подсоединим его к последнему элементу
                p.elementIndex = emptyIndex;//Установим в позиции индекс добавленного элемента
            }
        }
        //Если вставляем не на после последней
        else {
            // Получим индекс предыдущей ячейки
            int prev = findPrevious(p.elementIndex);
            //Запишем в пустую ячейку элемент
            elements[emptyIndex] = x;
            if(prev == -1){ //Значит меняем head
                x.nextElement = head; //Установим старый head, как индекс следующего элемент
                head = emptyIndex; //Поменяем head на индекс вставляемого элемента
            }
            //Если меняем не head
            else {
                // Устанавливаем prev.next - на индекс нового элемента,
                // а next нового элемента, на то что было в prev.next
                x.nextElement = elements[prev].nextElement;
                elements[prev].nextElement = emptyIndex;
            }
            // Занесем индекс вставленного элемента в текущую позицию.
            p.elementIndex = emptyIndex;
        }
    }

    /**
     * Метод печатает список элементов
     */
    public void printList() {
        //цикл от первого элемента списка, пока индекс не станет равен -1
        // В каждой итерации index обновляется индексом следующего элемента в списке: nextElement
        //Для каждого элемента списка метод выводит на консоль имя и адрес

        for(int index = head; index != -1;index = elements[index].nextElement){
            elements[index].PrintElement();
            System.out.println();
        }
    }

    /**
     * Метод ищет и возвращает индекс последнего элемента в списке
     * @return
     */
    private int findTailIndex(){
        int i = head;
        while(i != -1 && elements[i].nextElement != -1){
            i = elements[i].nextElement;
        }
        return i;

    }
}
