package main.java.com.vlad_kostromin.javacore.chapter10;

public class ChainExcDemo {
    // Демонстрация цепочки исключений
    static void demoproc() {
        // создаем исключение
        NullPointerException e = new NullPointerException("Верхний уровень");

        // добавляем причину исключения
        e.initCause(new ArithmeticException("Причина"));
        throw e;
    }

    public static void main(String[] args) {
        try {
            demoproc();
        } catch (NullPointerException e) {
            // выводим исключение верхнего уровня
            System.out.println("Перехвачено исключение: " + e);
            // выводим исключение, послужившее причиной
            // для исключения верхнего уровня
            System.out.println("Первопричина: " + e.getCause());
        }
    }

}
