package main.java.com.vlad_kostromin.javacore.chapter15;

// Реализовать простую фабрику классов, используя ссылку на конструктор

interface MyFunc2<R, T> {
    R func(T n);
}
// Простейший оббобщенный класс
class MyClass2<T> {
    private T val;

    public MyClass2(T val) {
        this.val = val;
    }
    // Конструктор по умолчанию. Этот конструктор в
    // данной программе не используется.
    public MyClass2() {
        val = null;
    }

    public T getVal() {
        return val;
    }
}

// Простейший не обобщенный класс
class MyClass3 {
    String string;

    public MyClass3(String string) {
        this.string = string;
    }

    public MyClass3() {
        string = "";
    }

    public String getString() {
        return string;
    }
}
public class ConstructorRefDemo2 {
    // Фабричный метод для объектов разных классов.
    // У каждого класса должен быть свой конструктор,
    // принимающий один параметр типа Т. А параметр R
    // обозначает тип создаваемого объекта
    static <R, T> R myClassFactory(MyFunc2<R, T> cons, T v) {
        return cons.func(v);
    }

    public static void main(String[] args) {
        // Создать ссылку на конструктор класса MyClass.
        // В данном случае оператор new обращается к конструктору,
        // принимающему аргумент
        MyFunc2<MyClass2<Double>, Double> myClassCons = MyClass2::new;

        // создать экземпляр типа класса MyClass2, используя фабричный метод
        MyClass2<Double> mc = myClassFactory(myClassCons, 100.1);

        // использовать только что созданный экземпляр класса MyClass
        System.out.println("Значение val в объекте mc равно " + mc.getVal());

        // А теперь создать экземпляр другого класса,
        // используя метод myClassFactory
        MyFunc2<MyClass3, String> myClassCon2 = MyClass3::new;

        // создвть экземпляр класса MyClass2, используя фабричный метод
        MyClass3 mc2 = myClassFactory(myClassCon2, "Лямбда");

        // использовать только что созданный экземпляр класса MyClass
        System.out.println("Значение str в объекте mc2 равно " + mc2.getString());
    }
}
