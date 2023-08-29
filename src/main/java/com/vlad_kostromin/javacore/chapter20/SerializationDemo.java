package main.java.com.vlad_kostromin.javacore.chapter20;

import java.io.*;

public class SerializationDemo {
    public static void main(String[] args) {
        // произвести сериализацию объекта

        try (ObjectOutputStream objOStream = new ObjectOutputStream(new FileOutputStream("src/main/java/com/vlad_kostromin/javacore/chapter20/files/serial"))) {
            MyClass object1 = new MyClass("Hello", -7, 2.7e10);
            System.out.println("object1: " + object1);

            objOStream.writeObject(object1);
        } catch (IOException e) {
            System.out.println("Исключение при сериализации: " + e);
        }

        // произвести десериализацию объекта
        try (ObjectInputStream objIStream = new ObjectInputStream(new FileInputStream("src/main/java/com/vlad_kostromin/javacore/chapter20/files/serial"))) {
            MyClass object2 = (MyClass) objIStream.readObject();
            System.out.println("object2: " + object2);
        } catch (Exception e) {
            System.out.println("Исключение при десериализации: " + e);
            System.exit(0);
        }
    }
}

class MyClass implements Serializable {
    String s;
    int i;
    double d;

    public MyClass(String s, int i, double d) {
        this.s = s;
        this.i = i;
        this.d = d;
    }

    @Override
    public String toString() {
        return "s=" + s + "; i=" + i + "; d=" + d;
    }
}
