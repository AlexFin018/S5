package Common;

/**
 * Базовый класс, для реализации ListElement, во всех лабораторных работах. Содержит общую
 * функциональность для всех лабораторных работ
 */
public class ListElementBase {
    /**
     * Конструктор принимает два параметра:String sName, String sAddress
     * Строка sName преобразуется в массив символов с помощью метода toCharArray().
     * Символы копируются или до достижения прерывающего символа (0) или не более
     * Размерности принимающего массива
     * @param sName имя персоны
     * @param sAddress адрес персоны
     */
    public ListElementBase(String sName, String sAddress){

        char[] name = sName.toCharArray();
        ArrayCopy(this.name,name);
        char[] address = sAddress.toCharArray();
        ArrayCopy(this.address,address);
    }

    /**
     * Метод копирует символы из массива src в массив dst. Символы копируются или до достижения
     * границы одного из массивов, или до достижения прерывающего символа \0 во входном массиве
     * @param dst массив, куда копировать
     * @param src массив источник
     */
    public static void ArrayCopy(char[]dst,char[]src) {
        for(int i=0;i<dst.length && i < src.length && src[i] != '\0';i++){
            dst[i]=src[i];
        }
    }

    /**
     * Метод сравнивает два массива посимвольно. Количество, последовательность символов
     * должны совпадать. При этом массивы могут быть различных размеров. Последовательность
     * символов завершается или границей массива, или прерывающим символом '\0'
     * @param x первый массив для сравнения
     * @param y второй массив для сравнения
     * @return true - если последовательности символов в массивах равны. Иначе false
     */
    public static boolean ArraysEquals(char[] x, char[] y){
        if(x == y) return true;
        int i;
        // В цикле сравниваем символы до достижения или границы одного из массивов,
        // либо прерывающего символа в одном из массивов
        for(i = 0; i < x.length && i < y.length && x[i] != '\0' && y[i] != '\0';i++){
            if(x[i] != y[i]) return false;
        }
        // Проверяем условие, по которому вышли из цикла

        //Если дошли до конца обоих массивов, то массивы равны
        if(i == x.length && i == y.length) return true;

        //Если дошли до конца одного из массивов, но во втором след символ 0, т.е. строка тоже
        //закончилась, то массивы равны
        if((i == x.length && y[i+1] == '\0')
                || (i == y.length && x[i+1] == '\0')) return true;

        // Если дошли до символа '\0' в обоих массивах, то true, иначе false
        return x[i] == '\0' && y[i] == '\0';
    }

    /**
     * Копи конструктор. Копирует массивы name и address из параметра
     * @param x - ListElementBase для копирования из
     */
    public ListElementBase(ListElementBase x){
        //конструктор копирует данные из одного объекта типа ListElement
        //в новый объект, создавая его копию с помощью System.arraycopy (не надо!)
        ArrayCopy(name,x.name);
        ArrayCopy(address,x.address);
    }

    /**
     * Переопределенный метод преобразования  в строку
     * @return строку name + пробел + address
     */
    @Override
    public String toString() {
        //метод возвращает строковое представление объекта
        // ListElement. Он выводит имя и адрес в виде строк.
        return String.valueOf(name) + " " + String.valueOf(address);
    }

    /**
     * Свойство имя персоны
     */
    public char[] name = new char[20];
    /**
     * Свойство адрес персоны
     */
    public char[] address = new char[50];

    /**
     * Переопределение метода сравнения двух объектов ListInstanceBase
     * @param obj - объект, с которым сравниваем текущий
     * @return true - если объекты равны, false - иначе
     */
    @Override
    public boolean equals(Object obj){
        //Этот метод проверяет, равен ли текущий объект другому объекту.
        //Если объект obj не является экземпляром класса ListElement, return false

        if(!(obj instanceof ListElementBase)) return false;
        ListElementBase le = (ListElementBase) obj;
        //  сравниваются массивы name и address текущего объекта и объекта obj с помощью
        //  статического метода ArraysEquals().
        //Arrays.equals() проверяет, равны ли два массива символов
        // (т.е. содержат ли они одинаковые элементы в одинаковом порядке).
        //Если оба массива (имя и адрес) совпадают, возвращается true, иначе — false.
        return ArraysEquals(name,le.name) && ArraysEquals(address,le.address);
    }

    /**
     * Метод принимает массив символов (char[] arr) и выводит его элементы по одному,
     * пока не достигнет символа \0.
     * Каждый символ выводится на консоль
     * @param ar - массив для вывода на консоль
     */
    public static void PrintArray(char[] ar){
        if(ar == null) {
            System.out.println("null");
            return;
        }
        for(int i = 0; i < ar.length && ar[i] != '\0'; i++){
            System.out.print(ar[i]);
        }
    }

    /**
     * Метод выводит на консоль имя и адрес, разделенные пробелом
     */
    public void PrintElement() {
        PrintArray(name);
        System.out.print(" ");
        PrintArray(address);
    }
}
