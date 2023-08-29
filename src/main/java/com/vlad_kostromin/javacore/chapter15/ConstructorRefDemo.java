package main.java.com.vlad_kostromin.javacore.chapter15;

// Продемострировать применение ссылки на конструктор

// В функциональном интерфейсе MyFunc определяется метод,
// возвращающий ссылку на класс MyClass

interface MyFunc4 {
    MyClass func(int n);
}

class MyClass1 {
    private int val;

    // Этот конструктор принимает один аргуменит
    public MyClass1(int val) {
        this.val = val;
    }

    // Этот конструктор по умолчанию
    public MyClass1() {
        this.val = 0;
    }

    public int getVal() {
        return val;
    }
}

public class ConstructorRefDemo {
    public static void main(String[] args) {
        // Создать ссылку на конструктор класса MyClass.
        // метод func() из интерфейса MyFunc4 принимает аргумент
        // поэтому оператор new обращается к параметризированному
        // конструктору класса MyClass, a не к его конструктору по умолчанию
        MyFunc4 myClassCons = MyClass::new;

        // создать экземпляр класса MyClass по ссылке на его конструктор
        MyClass mc = myClassCons.func(100);

        // использовать только что созданный экземпляр класса MyClass
        System.out.println("Значение val в объекте mc равно " + mc.getVal());
    }
}
