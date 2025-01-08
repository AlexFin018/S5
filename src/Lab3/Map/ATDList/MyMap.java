package Lab3.Map.ATDList;
import Lab2.CursorList.*;

public class MyMap {
    private final MyList list;
    public MyMap() {
        list = new MyList();
    }
    public class ComputeResult{
        public final boolean  result;
        public final char[] value;
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
    public void assign(String name, String address){

        ListElement le = locate(name);
        if(le == null){
            le = new ListElement(name,address);
            list.insert(le,list.end());
        }
        else {
            //Если нашли, то меняем адрес
            ListElement.ArrayCopy(le.address,address.toCharArray());
        }
    }

    /**
     * Если значение для name определено, то оно возвращается, если нет, то возвращается null
     * @param name
     * @return
     */
    public ComputeResult compute(String name){
        ListElement le = locate(name);
        if(le == null){
            return new ComputeResult(false,null);
        }
        return new ComputeResult(true,le.address);
    }
    private ListElement locate(String name){
        // Так как имя хранится в массиве, то преобразуем строку в массив char
        char[] nameAsArray = name.toCharArray();
        // В цикле перебираем позиции, ищем нужное имя в списке.
        for(Position p = list.first(); ! p.equals(list.end());p = list.next(p)){
            // Получаем элемент по позиции
            ListElement le = list.retrieve(p);
            // Сравниваем имя
            if(ListElement.ArraysEquals(le.name,nameAsArray)) {
                //Если равно, то меняем адрес
                return le;
            }
        }
        return  null;
    }

    public  void printMap() {
        list.printList();
    }
}
