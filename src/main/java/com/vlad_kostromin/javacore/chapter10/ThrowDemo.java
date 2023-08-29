package main.java.com.vlad_kostromin.javacore.chapter10;

public class ThrowDemo {
    //демонстрация применения оператора throw
    static void demoproc() {
        try {
            throw new NullPointerException("Demonstration");
        } catch (NullPointerException e) {
            System.out.println("Исключение перехвачено в теле метода demoproc().");
            throw e; //повторно сгенерировать исключение
        }
    }

    public static void main(String[] args) {
        try {
            demoproc();
        } catch (NullPointerException e) {
            System.out.println("Повторный перехват: " + e);
        }
    }
}
