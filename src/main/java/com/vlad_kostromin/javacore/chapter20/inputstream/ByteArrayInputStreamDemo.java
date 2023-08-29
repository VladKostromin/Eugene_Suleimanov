package main.java.com.vlad_kostromin.javacore.chapter20.inputstream;

import java.io.ByteArrayInputStream;

// продемострировать применение класса ByteArrayInputStream
public class ByteArrayInputStreamDemo {
    public static void main(String[] args) {
        String tmp = "abcdefghijklmnopqrstvwxyz";
        byte[] b = tmp.getBytes();

        ByteArrayInputStream input1 = new ByteArrayInputStream(b);
        ByteArrayInputStream input2 = new ByteArrayInputStream(b, 0, 3);
        // два конструктора принимающие весь алфавит в первом случае, и только 3 буквы во втором
    }
}
