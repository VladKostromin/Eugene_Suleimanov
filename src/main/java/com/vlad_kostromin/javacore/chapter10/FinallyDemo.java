package main.java.com.vlad_kostromin.javacore.chapter10;

public class FinallyDemo {
    //сгенерировать исключение в методе
    static void procA() {
        try {
            System.out.println("В теле метода procA()");
            throw new RuntimeException("демонстрация");
        } finally {
            System.out.println("Блок оператора finally в методе procA()");
        }
    }
    // возвратить управление из блока оператора try
    static void procB() {
        try {
            System.out.println("В теле метода procB()");
            return;
        } finally {
            System.out.println("Блок оператора finally в методе procB()");
        }
    }
    // выполнить блок try, как обычно

    static void procС() {
        try {
            System.out.println("В теле метода procB()");
        } finally {
            System.out.println("Блок оператора finally в методе procB()");
        }
    }

    public static void main(String[] args) {
        try {
            procA();
        } catch (Exception e) {
            System.out.println("Исключение перехвачено");
        }

        procB();
        procС();
    }
    /*
    В данном примере выполнение метода procA ( ) преждевременно прерывается
в блоке оператора try, где генерируется исключение, но блок оператора finally

все равно выполняется. Выход из блока оператора try в методе procB ( ) проис-
ходит через оператор return, а блок оператора finally выполняется перед воз-
вратом из метода procB ( ) . В методе procC ( ) блок оператора try выполняется

обычным образом, когда ошибки отсутствуют, но блок оператора finally выпол-
няется все равно.
     */

}
