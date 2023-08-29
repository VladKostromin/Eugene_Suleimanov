package main.java.com.vlad_kostromin.javacore.chapter10;

public class ThrowsDemo {
    //демонстрация применения оператора throws
    static void throwOne() throws IllegalArgumentException {
        System.out.println("В теле метода throw().");
        throw new IllegalArgumentException("демонстрация");
    }
    public static void main(String[] args) {
        try {
            throwOne();
        } catch (IllegalArgumentException e) {
            System.out.println("Перехвачено исключение: " + e);
        }
    }
}
