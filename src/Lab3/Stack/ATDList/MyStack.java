package Lab3.Stack.ATDList;

import Lab2.DoubleLinkedList.*;

public class MyStack {

    private MyList list;

    public MyStack() {
        list = new MyList();
    }
    public void makeNull() {
        list.makeNull();
    }
    public char top() {
        if(isEmpty()) return '\0';
        return list.retrieve(list.first()).name[0];
    }
    public char pop() {
        if(isEmpty()) return '\0';
        Position pos = list.first();
        ListElement temp = list.retrieve(pos);
        list.delete(pos);
        return temp.name[0];
    }
    public void push(char c){
        list.insert(new ListElement(String.valueOf(c),""),list.first());
    }
    public boolean empty() {
        return isEmpty();
    }
    private boolean isEmpty(){
        return list.first().equals(list.end());
    }
    public boolean full() {
        return false;
    }
}
