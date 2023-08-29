package main.java.com.vlad_kostromin.javacore.chapter15;

// Продемострировать применение ссылки на обобщенный метод,
// объявленный в необобщенном классе

// функциональный интерфейс для обработки массива значенией
// и возврата целочисленного результата
interface MyFunc3<T> {
    int func(T[] vals, T v);
}

// В этом классе определяется метод countMatching(), возвращающий
// количество элементов в массиве, равных указанному значению.
// Обратите внимание на то, что метод countMatching() является
// обобщенным, тогда как класс MyArrayOps - не обобщенным
class MyArrayOps {
    static <T> int countMatching(T[] vals, T v) {
        int count = 0;

        for (int i = 0; i < vals.length; i++) {
            if(vals[i] == v) count++;
        }
        return count;
    }
}
public class GenericMethodRefDemo {
    // В качетсве первого параметра этого метода указывается
    // функциональный интерфейс MyFunc, а в качестве двух других
    // параметров - массив и значение, причем оба типа Т
    static <T> int myOp (MyFunc3 f, T[] vals, T v) {
        return f.func(vals, v);
    }

    public static void main(String[] args) {
        Integer[] vals = { 1, 2, 3, 4, 2, 3, 4, 4, 5 };
        String[] strings = { "Один", "Два", "Три", "Два"};
        int count;

        count = myOp(MyArrayOps::countMatching, vals, 4);
        System.out.println("массив vals содержит " + count + " числа 4");

        count = myOp(MyArrayOps::countMatching, strings, "Два");
        System.out.println("массив vals содержит " + count + " числа два");
    }
}
