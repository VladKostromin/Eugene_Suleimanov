package main.java.com.vlad_kostromin.javacore.chapter21;

import java.io.IOException;
import java.nio.channels.Selector;
import java.nio.file.*;

public class NIOCopy {
    public static void main(String[] args) {
        if(args.length != 2) {
            System.out.println("Применени: откуда и куда копировать");
            return;
        }

        try {
            Path source = Paths.get(args[0]);
            Path target = Paths.get(args[1]);

            // скопировать фаил
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
        } catch (InvalidPathException e) {
            System.out.println("Ошибка указания пути " + e);
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода " + e);
        }
    }
}
