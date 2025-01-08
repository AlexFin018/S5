package Lab3.Map.LinkedList;

public class MyMap {
    private MyList list;
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
    public void assign(String name,String address){
        MyList.ListElement le = list.find(name);
        if(le != null)le.address = address;
        else {
            list.add(name,address);
        }
    }

    /**
     * Если значение для name определено, то оно возвращается, если нет, то возвращается null
     * @param name
     * @return
     */
    public ComputeResult compute(String name){
        MyList.ListElement le = list.find(name);
        if(le == null) {
            return  new ComputeResult(false,null);
        }
        return new ComputeResult(true,le.address.toCharArray());
    }

    public void printMap() {
        list.printList();
    }
}
