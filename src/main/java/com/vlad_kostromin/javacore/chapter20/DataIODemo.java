package main.java.com.vlad_kostromin.javacore.chapter20;

import java.io.*;

public class DataIODemo {
    public static void main(String[] args) {
        //сначала вывести данные в файл
        try (DataOutputStream dout = new DataOutputStream(new FileOutputStream("src/main/java/com/vlad_kostromin/javacore/chapter20/files/Test.dat"))) {
            dout.writeDouble(98.6);
            dout.writeInt(1000);
            dout.writeBoolean(true);
        } catch (FileNotFoundException e) {
            System.out.println("Нельзя открыть файл");
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода" + e);
        }

        //а теперь ввести данные из файла
        try (DataInputStream din = new DataInputStream(new FileInputStream("src/main/java/com/vlad_kostromin/javacore/chapter20/files/Test.dat"))) {
            double d = din.readDouble();
            int i = din.readInt();
            boolean b = din.readBoolean();
            System.out.println("Полученные значения: " + d + " " + i + " " + b);
        } catch (FileNotFoundException e) {
            System.out.println("Нельзя открыть файл");
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода" + e);
        }
    }
}
