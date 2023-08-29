package main.java.com.vlad_kostromin.javacore.chapter21;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ExplicitChannelWrite {
    public static void main(String[] args) {
        // получить канал к файлу в блоке оператора try с ресурсами
        try(FileChannel fChan = (FileChannel) Files.newByteChannel(
                Paths.get("src/main/java/com/vlad_kostromin/javacore/chapter21/files/test"),
                StandardOpenOption.WRITE,
                StandardOpenOption.CREATE)) {
            // создать буфер
            ByteBuffer mBuf = ByteBuffer.allocate(26);

            // записать некоторое количество байтов в буфер
            for (int i = 0; i < mBuf.capacity(); i++) {
                mBuf.put((byte) ('A' + i));
            }

            // подготовка буфера к записи данных
            mBuf.rewind();

            // записать данные из буфера в выходной фаил
            fChan.write(mBuf);
        } catch (InvalidPathException e) {
            System.out.println("Ошибка указания пути " + e);
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода " + e);
            System.exit(1);
        }
    }
}
