package main.java.com.vlad_kostromin.javacore.chapter15;

import java.util.function.Function;

// Использовать встроенный функциональный интерфейс Function
public class UseFunctionInterfaceDemo {
    // Это блочное лябмда-выражение вычисляет факториал
    // целочисленного значения. Для этой цели на сей раз
    // используется функциональный интерфейс Function
    public static void main(String[] args) {
        Function<Integer, Integer> factorial = (integer -> {
            int result = 1;
            for (int i = 1; i <= integer; i++) {
                result = i * result;
            }
            return result;
        });

        System.out.println("Факториал числа 3 равено " + factorial.apply(3));
        System.out.println("Факториал числа 5 равено " + factorial.apply(5));
    }


}
