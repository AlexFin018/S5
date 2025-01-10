package Lab3.Map.LinkedList;

/**
 * Класс реализующий отображение на связном списке
 */
public class MyMap {
    /**
     * Ссылка на связный список
     */
    private final MyList list;

    /**
     * Конструктор по умолчанию для отображения
     */
    public MyMap() {
        //Создаем связный список
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
         * Ссылка, возвращаемая методом compute
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
        list.makeNull();
    }

    /**
     * делает M(name) равным address независимо от того, как M(name) было определено ранее
     * @param name
     * @param address
     */
    public void assign(String name,String address){
        //Получаем из списка элемент с указанным именем
        MyList.Node le = list.find(name);
        //Если получили не null, заменим в элементе адрес
        if(le != null)le.address = address;
        else {
            //Если получили null, занесем новый элемент
            list.add(name,address);
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
        MyList.Node le = list.find(name);
        // Если не нашли, то вернем false, null
        if(le == null) {
            return  new ComputeResult(false,null);
        }
        // Иначе вернем true и ссылку на адрес
        return new ComputeResult(true,le.address.toCharArray());
    }
    /**
     * Метод выводит отображение на печать
     */

    public void printMap() {
        list.printList();
    }
}
