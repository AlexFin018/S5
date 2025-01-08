import Lab1.ArrayPackage.*;
//import Lab1.LinkedListPackage.*;
//import Lab2.CursorList.*;
//import Lab2.DoubleLinkedList.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class TestLab1Lab2 {
    public static void main(String[] args) {
        MyList L = new MyList();
        ListElement x = new ListElement("Иван", "Малая Разночинная 10");
        L.insert(x, L.end());
        x = new ListElement("Иван", "Малая Разночинная 10");
        L.insert(x, L.end());
        x = new ListElement("Вася", "Петроградка");
        L.insert(x, L.end());
        x = new ListElement("Елена", "Васильевский остров");
        L.insert(x, L.end());
        x = new ListElement("Елена", "Васильевский остров");
        L.insert(x, L.end());
        deleteDublicates( L);
        L.printList();

    }

    /**
     * Удаление дубликатов
     * @param L
     */
    public static void deleteDublicates(MyList L){
        Position p, q; // = int num1, num2
        p = L.first();

        while (!p.equals(L.end())) {
            q = L.next(p);
            while (!q.equals(L.end())) {
                if (L.retrieve(p).equals( L.retrieve(q))){
                    L.delete(q);
                }
                else{
                    q = L.next(q);
                }
            }
            p = L.next(p);
        }
    }
}