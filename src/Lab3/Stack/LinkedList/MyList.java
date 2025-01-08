package Lab3.Stack.LinkedList;

import Common.InvalidPositionException;

public class MyList {
    private class ListElement{
        private char letter;
        private ListElement next;
        private ListElement(char ch){
            letter = ch;
        }
    }
    private ListElement first;

    /**
     * Метод First возвращает позицию (Position) 1-го элемента в списке
     * Если список пустой --> возвращает позицию после последнего
     * @return
     */
    protected char first(){
        if(first == null) return '\0';
        return first.letter;
    }

    protected void removeFirst(){
        if(isEmpty()) return;
        first = first.next;
    }

    protected void insertFirst(char ch){
        if(isEmpty()) first = new ListElement(ch);
        else {
            ListElement temp = first;
            first = new ListElement(ch);
            first.next = temp;
        }
    }

    protected void makeNull(){
        //Очищает список, делая его пустым.
        //firstelement становится равен нулю
        first = null;
    }

    protected boolean empty() {
        return isEmpty();
    }

    private boolean isEmpty() {
        return first == null;
    }
}
