package main.java.com.vlad_kostromin.javacore.chapter21;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ExplicitChannelJDK7Read {
    public static void main(String[] args) {
        FileInputStream fIn = null;
        FileChannel fChan = null;
        ByteBuffer mBuf;
        int count;

        try {
            // сначала открыть файл для ввода
            fIn = new FileInputStream("src/main/java/com/vlad_kostromin/javacore/chapter21/files/test");

            // затем получить канал к этому файлу
            fChan = fIn.getChannel();

            //выделить оперативную память под буфер
            mBuf = ByteBuffer.allocate(128);

            do {
                // читать данные в буфер
                count = fChan.read(mBuf);

                // прекратить чтение по достижении конца файла
                if(count != -1) {
                    // подготовить буфер к чтению из него данных
                    mBuf.rewind();

                    // читать байты данных из буфера и
                    // выводить их на экран как символы
                    for (int i = 0; i < count; i++) {
                        System.out.print((char) mBuf.get());
                    }
                }
            } while (count != -1);
            System.out.println();
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e);
        } finally {
            try {
                if(fChan != null) fChan.close(); // закрываем канал
            } catch (IOException e) {
                System.out.println("Ошибка закрытия канала.");
            }
            try {
                if(fIn != null) fIn.close(); // закрываем фаил
            } catch (IOException e) {
                System.out.println("Ошибка закрытия файла");
            }
        }
    }

}
