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
    protected class ListElement{
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
        private ListElement nextElement;

        /**
         * Конструктор элемента
         * @param name имя
         * @param address адрес
         */
        private ListElement(String name, String address){
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
    private ListElement head;

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
    protected ListElement find(String name){
        //Установим ссылку на текущий элемент на начало списка
        ListElement current = head;
        //В цикле, пока ссылка на текущий элемент не равна null, или имя из текущего элемент не равено
        // указанному, переходить к следующему элементу
        while(current != null && !name.equals(current.name)){
            current = current.nextElement;
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
        ListElement le = new ListElement(name,address);
        // Если списко пустой, то запишем ссылку на новый элемент в head
        if(head == null) {
            head = le;
        }
        // Иначе добавим в конец списка
        else {
            // Найлем последний элемент
            ListElement l = head;
            while(l.nextElement != null){
                l = l.nextElement;
            }
            //Установим его next на добавляемый элемент
            l.nextElement = le;
        }
    }

    /**
     * Метод выводит список на консоль
     */
    protected void printList() {
        for (ListElement le = head; le != null; le = le.nextElement){
            System.out.println(le.toString());
        }
    }
}
