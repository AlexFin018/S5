package Lab3.Map.LinkedList;

public class MyList {
    protected class ListElement{
        protected String name;
        protected String address;
        private ListElement next;
        private ListElement(String name, String address){
            this.name = name;
            this.address = address;
        }

        @Override
        public String toString() {
            return name + " " + address;
        }
    }
    private ListElement first;

    protected void makeNull() {
        first = null;
    }

    protected ListElement find(String name){
        for(ListElement le = first; le != null;le = le.next){
            if(le.name == name) return le;
        }
        return null;
    }

    protected void add(String name, String address){
        ListElement le = new ListElement(name,address);
        if(first == null) {
            first = le;
        }
        else {
            ListElement l = first;
            while(l.next != null){
                l = l.next;
            }
            l.next = le;
        }
    }
    protected void printList() {
        for (ListElement le = first; le != null;le = le.next){
            System.out.println(le.toString());
        }
    }
}
