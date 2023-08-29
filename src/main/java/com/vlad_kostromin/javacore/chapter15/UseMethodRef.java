package main.java.com.vlad_kostromin.javacore.chapter15;

// Использовать ссылку на метод, чтобы найти
// максимальное значение в коллекции

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class MyClass {
    private int val;

    public MyClass(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }
}

public class UseMethodRef {
    // Метод compare(), совместимый с аналогичным методом,
    // определенным в интерфейсе Comparator<T>
    static int compareMC(MyClass a, MyClass b) {
        return a.getVal() - b.getVal();
    }

    public static void main(String[] args) {
        ArrayList<MyClass> al = new ArrayList<>();

        al.add(new MyClass(1));
        al.add(new MyClass(4));
        al.add(new MyClass(2));
        al.add(new MyClass(9));
        al.add(new MyClass(3));
        al.add(new MyClass(7));

        // найти максимальное значение, используя метод compareMc()
        MyClass maxValObj = Collections.max(al, UseMethodRef::compareMC);

        System.out.println("Максимальное значение равно: " + maxValObj.getVal());
    }
}
