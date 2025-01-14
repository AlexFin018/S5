package Lab2.CursorList;
import Common.InvalidPositionException;

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
    private final Node[] elements;
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
        // создаем массив для списка индексов пустых ячеек
        elements = new Node[SIZE];
        //Устанавливаем начало списка пустых элементов на первую позицию массива
        headSpace = 0;
        //Инициируем список пустых ячеек
        //Для каждой позиции ставим узел с индексом следующей пустой
        for(int i = 0; i < SIZE-1;i++){
            elements[i] = new Node(i+1);
        }
        //В последнюю пустую ставим -1 - конец списка - нет следующей пустой
        elements[SIZE-1] = new Node(-1);
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
        // Проверим наличие позиции
        findPrevious(p.elementIndex);
        // Вернуть позицию следующего элемента
        return new Position(elements[p.elementIndex].nextNodeIndex);
    }
    /**
     * Метод возвращает позицию предыдущего элемента в списке или end()
     * @param p позиция текущего элемента
     * @return позиция предыдущего элемента
     */
    public Position previous(Position p){
        // Проверим позицию на наличие
        int previous =  findPrevious(p.elementIndex);
        // Если указана первая позиция, то выкидываем ошибку
        if(p.elementIndex == head) throw new InvalidPositionException();
        //Вернуть позицию предыдущего элемента
        return new Position(previous);
    }

    /**
     * Приватный метод поиска индекса предыдущего элемента
     * Для позиции после последнего выкидываем ошибку
     * Для первой позиции возвращаем -1
     * Если позиции не существует, выкидывается ошибка
     * @param p индекс текущего элемента
     * @return индекс предыдущего элемента или -1 для первой позиции
     */
    private int findPrevious(int p){
        // Цикл идет по всем элементам списка начиная с первого до последнего элемента
        int s = head, prev = -1;
        while(s != -1){
            if(s == p) return prev;
            prev = s;
            s = elements[s].nextNodeIndex;
        }
        // Если позиция не найдена, то выкидываем ошибку
        throw new InvalidPositionException();
    }

    /**
     * Метод возвращает элемент в указанной позиции
     * @param p - позиция элемента
     * @return искомый элемент
     */
    public Node retrieve(Position p){
        findPrevious(p.elementIndex);
        // Возвращаем элемент по индексу, который указан в позиции
        return elements[p.elementIndex];
    }

    /**
     * Метод удаляет элемент в указанной позиции
     * @param p позиция для удаления элемента
     */
    public void delete(Position p){
        int prev = findPrevious(p.elementIndex); // Проверим позицию на наличие и найдем предыдущий
        int temp = p.elementIndex;// Запомним удаляемый индекс
        // Если удаляем первый элемент, то
        if(p.elementIndex == head){
            //Запишем в head индекс элемента следующего за удаляемым
            head = elements[p.elementIndex].nextNodeIndex;
            //Запишем в позицию индекс нового первого элемента,
            //Таким образом позиция сохраняется со следующим элементом
            p.elementIndex = head;
            return;
        }
        //Если удаляем не первый элемент

        //Найдем предыдущий элемент
        //nextElement предыдущего элемента устанавливаем на nextElement удаляемого элемента
        int next = elements[p.elementIndex].nextNodeIndex;
        elements[prev].nextNodeIndex = next;
        //Запишем в позицию индекс элемента следующего за удаляемым,
        //Таким образом позиция сохраняется со следующим элементом
        p.elementIndex = next;

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

        elements[index] =new Node(headSpace);
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
            index = elements[index].nextNodeIndex;
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
    public Position locate(Node x){
        //Цикл начинается с первого узла списка (указанного
        // переменной head) и проходит по списку, проверяя каждый узел:
        //переменная p в каждой итерации обновляется ссылкой на следующий узел,
        // используя поле nextNodeIndex у текущего узла.
        //Для каждого узла списка вызывается метод equals(), чтобы проверить,
        // совпадает ли текущий узел с искомым элементом x
        //Если метод equals() возвращает true, то найдено совпадение, и метод
        // возвращает позицию, указывающую на текущий узел current
        //Если после завершения цикла элемент так и не был найден, то метод возвращает позицию
        // после последнего элемента
        int current = head;
        while(current != -1 && !x.equals(elements[current])){
            current = elements[current].nextNodeIndex;
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
        headSpace = elements[headSpace].nextNodeIndex;
        //Возвращаем индекс первой свободной ячейки
        return temp;
    }
    /**
     * Метод вставляет копию элемента на указанную позицию
     * @param le элемент, копию которого нужно вставить
     * @param p позиция, на которую нужно вставить
     */
    public void insert(Node le, Position p ) {
        // Если указана позиция после последней, в качестве previous
        // найдем последнюю позицию
        // Иначе найдем предыдущую и проверим позицию на корректность
        int previous;
        if(p.elementIndex == -1)
            previous = findTailIndex();
        else
            previous = findPrevious(p.elementIndex);

        Node x = new Node(le); // Будем вставлять копию

        //Получим свободную ячейку из списка
        int emptyIndex = captureSpace();

        // Если вставляем на первую позицию
        if(head == p.elementIndex){
            // У заносимого узла ставим head следующим
            x.nextNodeIndex = head;
            // Меняем head на индекс заносимого элемента
            head = emptyIndex;
            // Заносим новый элемент в ячейку массива
            elements[head] = x;
            // Меняем индекс в позиции
            p.elementIndex = emptyIndex;
            return;
        }
        // Иначе цепляем новый элемент к предыдущему
        elements[previous].nextNodeIndex = emptyIndex;
        elements[emptyIndex] = x;
        // Цепляем текущий элемент к новому как следующий
        x.nextNodeIndex = p.elementIndex;
        // Меняем индекс в позиции
        p.elementIndex = emptyIndex;

    }

    /**
     * Метод печатает список элементов
     */
    public void printList() {
        //цикл от первого элемента списка, пока индекс не станет равен -1
        // В каждой итерации index обновляется индексом следующего элемента в списке: nextElement
        //Для каждого элемента списка метод выводит на консоль имя и адрес

        for(int index = head; index != -1;index = elements[index].nextNodeIndex){
            elements[index].PrintElement();
            System.out.println();
        }
    }

    /**
     * Метод ищет и возвращает индекс последнего элемента в списке
     * @return индекс последенего элемента в списке, или -1 если список пустой
     */
    private int findTailIndex(){
        int i = head, tail = -1;
        while(i != -1){
            tail = i;
            i = elements[i].nextNodeIndex;
        }
        return tail;

    }
}
