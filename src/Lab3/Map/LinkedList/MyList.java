package Lab3.Map.LinkedList;

/**
 * Класс, реализующий связный список для хранения отображения. Класс содержит только методы,
 * необходимые для работы отображения. Класс и его подклассы не видимы за пределами пакета
 */
class MyList {
    /**
     * Встроенный класс для хранения элемента отображения Имя и адрес. Которые сохраняются
     * как строки
     */
    protected class Node {
        /**
         * Имя
         */
        protected String name;
        /**
         * Адрес
         */
        protected String address;
        /**
         * Следующий элемент в списке
         */
        private Node nextNode;

        /**
         * Конструктор элемента
         * @param name имя
         * @param address адрес
         */
        private Node(String name, String address){
            this.name = name;
            this.address = address;
        }

        /**
         * Переопределяем преобразование объекта в строку
         * @return
         */
        @Override
        public String toString() {
            return name + " " + address;
        }
    }

    /**
     * Ссылка на первый элемент списка
     */
    private Node head;

    /**
     * Метод обнуляет список
     */
    protected void makeNull() {
        head = null;
    }

    /**
     * Метод ищет в списке элемент с указанным именем
     * @param name имя для поиска элемента
     * @return найденный элемент или null, если элемент не найден
     */
    protected Node find(String name){
        //Установим ссылку на текущий элемент на начало списка
        Node current = head;
        //В цикле, пока ссылка на текущий элемент не равна null, или имя из текущего элемент не равено
        // указанному, переходить к следующему элементу
        while(current != null && !name.equals(current.name)){
            current = current.nextNode;
        }
        // Вернуть ссылку на текущий элемент - это или null, или найденный элемент
        return current;
    }

    /**
     * Добавляем к спсику имя и адрес
     * @param name имя
     * @param address адрес
     */
    protected void add(String name, String address){
        // Создаем экземпляр элемента с именем и адресом
        Node le = new Node(name,address);
        // Если списко пустой, то запишем ссылку на новый элемент в head
        if(head == null) {
            head = le;
        }
        // Иначе добавим в конец списка
        else {
            // Найлем последний элемент
            //Установим его next на добавляемый элемент
            findTail().nextNode = le;
        }
    }

    /**
     * Метод ищет последний элемент
     * @return Последний элемент в списке
     */
    private Node findTail(){
        Node l = head;
        while(l.nextNode != null){
            l = l.nextNode;
        }
        return l;
    }

    /**
     * Метод выводит список на консоль
     */
    protected void printList() {
        for (Node le = head; le != null; le = le.nextNode){
            System.out.println(le.toString());
        }
    }
}
