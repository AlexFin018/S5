package Lab3.Map.ATDList;
//import Lab2.CursorList.*;
import Lab2.DoubleLinkedList.*;
//import Lab1.ArrayPackage.*;
//import Lab1.LinkedListPackage.*;

/**
 * Класс реализации отображения на АТД Список
 */
public class MyMap {
    /**
     * Ссылка на список для хранения элементов отображения
     */
    private final MyList list;

    /**
     * Конструктор по умолчанию, создает экземпляр списка
     */
    public MyMap() {
        list = new MyList();
    }

    /**
     * Внутренний класс для возврата результата работы метода compute. По условиям задачи
     * метод compute должен вернуть два значения - результат успешности и адрес. Поскольку
     * в java нельзя вернуть два параметра, то этот класс предназначен для хранения этих двух параметров
     * и используется для возврата значения из compute
     */
    public class ComputeResult{
        /**
         * Результат работы метода compute
         */
        public final boolean  result;
        /**
         * ссылка, возвращаемая методом compute
         */
        public final char[] value;

        /**
         * Конструктор
         * @param boolResult результат работы compute
         * @param str ссылка, возвращаемая методом compute
         */
        public ComputeResult(boolean boolResult,char[] str){
            result = boolResult;
            value  = str;
        }
    }
    /**
     * Делает отображение пустым
     */
    public void makeNull() {
        // вызываем метод makeNull нашего списка
       list.makeNull();
    }
    /**
     * делает M(name) равным address независимо от того, как M(name) было определено ранее
     * @param name значение из области определений
     * @param address - значение из области значений
     */
    public void assign(String name, String address){
        //Проверяем, если ли значение для ключа name в списке
        Node le = locate(name);
        // Если значения нет, то запишем его в список
        if(le == null){
            le = new Node(name,address);
            list.insert(le,list.end());
        }
        else {
            //Если нашли, то меняем адрес в найденном элементе
            Node.ArrayCopy(le.address,address.toCharArray());
        }
    }

    /**
     * Если значение для указанного ключа определено, то возвращается true и ссылка на массив с адресом,
     * иначе возвращается false и null
     * @param name ключ для поиска
     * @return экземпляр ComputeResult с результатом
     */
    public ComputeResult compute(String name){
        // Пробуем найти значение по ключу
        Node le = locate(name);
        // Если не нашли, то вернем false, null
        if(le == null){
            return new ComputeResult(false,null);
        }
        // Иначе вернем true и ссылку на адрес
        return new ComputeResult(true,le.address);
    }

    /**
     * Метод ищет в  АТД списке ListElement только по совпадению имени
     * @param name Имя для поиска
     * @return элемент из списка с указанным именем, или nul
     */
    private Node locate(String name){
        // Так как имя хранится в массиве, то преобразуем строку в массив char
        char[] nameAsArray = name.toCharArray();
        // В цикле перебираем позиции, ищем нужное имя в списке.
        for(Position p = list.first(); ! p.equals(list.end());p = list.next(p)){
            // Получаем элемент по позиции
            Node le = list.retrieve(p);
            // Сравниваем имя
            if(Node.ArraysEquals(le.name,nameAsArray)) {
                //Если равно, то возвращаем элемент
                return le;
            }
        }
        // Если не нашли, возвращаем null
        return  null;
    }

    /**
     * Метод выводит отображение на печать
     */
    public  void printMap() {
        //Выводим на печать список
        list.printList();
    }
}
