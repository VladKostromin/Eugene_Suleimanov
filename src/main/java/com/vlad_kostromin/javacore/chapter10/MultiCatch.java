package main.java.com.vlad_kostromin.javacore.chapter10;

public class MultiCatch {
    public static void main(String[] args) {
        int a = 10, b = 0;
        int vals[] = {1, 2, 3};

        try {
            int result = a / b; // сгенерировать исключение типа ArithmeticException
            // vals[10] = 19;       // сгенерировать исключение типа ArrayIndexOutOfBoundException
            // в операторе catch перехватываются оба исключения
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Исключение перехвачено: " + e);
        }
        System.out.println("После многократного перехвата.");
    }
}
