package main.java.com.vlad_kostromin.javacore.chapter15;

// Применит обобщенный функциональныйинтерфейс
// с разнотипными лямбда-выражениями

// Обобщенный функциональный интерфейс
interface SomeFunc<T> {
    T func(T t);
}

public class GenericFunctionalInterfaceDemo {
    public static void main(String[] args) {

        // использовать строковый вариант интерфейса SomeFunc
        SomeFunc<String> reverse = (str) -> {
            String result = "";
            for (int i = str.length() - 1; i >= 0; i--) {
                result += str.charAt(i);
            }
            return result;
        };
        System.out.println("Лямбда обращается на " + reverse.func("Лябмда"));
        System.out.println("Выражение обращается на " + reverse.func("Выражение"));

        // а теперь используем целочисленный варианта интерфейса SomeFunc

        SomeFunc<Integer> factorial = (n) -> {
            int result = 1;
            for (int i = 1; i <= n; i++) {
                result = i * result;
            }
            return result;
        };
        System.out.println("Факториал числа 3 равен " + factorial.func(3));
        System.out.println("Факториал числа 5 равен " + factorial.func(5));
    }
}
