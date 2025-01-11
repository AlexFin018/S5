package Lab3.Stack.LinkedList;

/**
 * Класс для реализации связного списка для стека. Реализован в protected классе,
 * видимом только в рамках пакета
 */
class MyList {
    /**
     * Класс, представляющий элемент узла списка с символом
     */
    private class Node {
        /**
         * Символ, который хранится в узле списка
         */
        private final char letter;
        /**
         * Ссылка на следующий элемент списка
         */
        private Node next;

        /**
         * Конструктор узла списка
         * @param ch символ, сохраняемый в узле
         */
        private Node(char ch){
            letter = ch;
        }
    }

    /**
     * Ссылка на первый узел списка
     */
    private Node first;

    /**
     * Метод возвращаем первый символ в списке
     * @return первый символ в списке, или '\0', если лист пустой
     */
    protected char first(){
        if(isEmpty()) return '\0';
        return first.letter;
    }

    /**
     * Метод удаляем первый символ из списка
     */
    protected void removeFirst(){
        // Если список пустой, то ничего не делаем
        if(isEmpty()) return;
        // Устанавливаем первым в списке следующий за первым элемент
        first = first.next;
    }

    /**
     * Заносит символ на первую позицию списка
     * @param ch заносимый символ
     */
    protected void insertFirst(char ch){
        // Создаем заносимый элемент
        Node node = new Node(ch);
        // Заносим его в цепочку первым
        node.next = first;
        //Устанавливаем на него первый элемент
        first = node;
    }

    /**
     * Метод очищаем список
     */
    protected void makeNull(){
        //Очищает список, делая его пустым.
        //first становится равен нулю
        first = null;
    }

    /**
     * Метод возвращает true, если список пустой
     * @return true, если список пуст
     */
    protected boolean empty() {
        //Переадресуем вызов приватному методу
        return isEmpty();
    }

    /**
     * Метод определяет пустоту списка
     * @return true, если список пустой
     */
    private boolean isEmpty() {
        //Список пуст если ссылка на первый элемент списка равна null
        return first == null;
    }
}
