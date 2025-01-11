package Lab3.Queue.CircularList;

/**
 * Класс, реализующий круговой список. Только методы, необходимые для реализации очереди.
 * Класс protected, видим только внутри пакета
 */
class MyList {
    /**
     * Класс реализующий узел кругового списка
     */
    private class Node {
        /**
         * Элемент, хранящийся в узле
         */
        protected final char letter;
        /**
         * Ссылка на следующий узел списка
         */
        protected Node next;

        /**
         * Конструктор для узла
         * @param letter символ, хранящийся в узле
         */
        public Node(char letter){
            this.letter = letter;
        }
    }

    /**
     * Ссылка на последний узел в списке
     */
    private Node tail;

    /**
     * Возвращает первый элемент списка
     * @return первый символ, хранящийся в списке
     */
    protected char first() {
        // Если список пустой, вернем нулевой символ
        if(isEmpty()) return '\0';
        //tail.next указывает на head - первый узел списка, вернем символ из него
        return tail.next.letter;
    }

    /**
     * Добавляет элемент в конец очереди
     * @param letter символ для добавления
     */
    protected void add(char letter) {

        Node newNode = new Node(letter);
        // Если очередь пустая, то и tail и tail.next (head) устанавливаем
        // на новый добавляемый узел
        if(isEmpty()) {
            // И tail и head (tail.next) устанавливаем на новый элемент
            tail = newNode.next = newNode;
        }
        else {
            //Устанавливаем head (tail.next) в next заносимого элемента
            newNode.next = tail.next;
            // вставляем новый элемент в цепочку последним
            tail.next = newNode;
            // Устанавливаем tail на новый элемент
            tail = newNode;
        }
    }

    /**
     * Метод удаляем первый
     * элемент
     */
    protected void removeHead() {
        // Если один элемент, то очищаем список
        if(tail.next == tail) {
            tail = null;
        }
        else {
            //Иначе ссылку на следующий элемент в хвосте устанавливаем на элемент после первого
            tail.next = tail.next.next;
        }
    }

    /**
     * Метод обнуляет очередь
     */
    protected void makeNull() {
        tail = null;
    }

    /**
     * Метод проверяет очередь на пустоту
     * @return true - если очередь пустая
     */
    protected boolean empty() {
        return isEmpty();
    }

    /**
     * Проверка очереди на пустоту
     * @return true - очередь пустая
     */
    private boolean isEmpty() {
        return tail == null;
    }
}
