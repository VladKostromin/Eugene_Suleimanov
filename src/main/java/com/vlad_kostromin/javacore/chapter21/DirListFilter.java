package main.java.com.vlad_kostromin.javacore.chapter21;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class DirListFilter {
    public static void main(String[] args) {
        String dirname = "src/main/java/com/vlad_kostromin/javacore/chapter13";

        // создать фильтр, возвращающий логическое зхначение true
        // только в отношении доступных для записи файлов

        DirectoryStream.Filter<Path> how = new DirectoryStream.Filter<Path>() {
            @Override
            public boolean accept(Path filename) throws IOException {
                if(Files.isWritable(filename)) return true;
                return false;
            }
        };
        // получить и использовать поток ввода из каталога
        // только доступных для записи файлов
        try(DirectoryStream<Path> dirstrm = Files.newDirectoryStream(Paths.get(dirname), how)) {

            System.out.println("Каталог " + dirname);

            // Класс DirectoryStream реализует интерфейс Iterable,
            // поэтому для вывода содержимого каталога можно
            // организовать цикл for в стиле for each

            for (Path entry : dirstrm) {
                BasicFileAttributes attributes = Files.readAttributes(entry, BasicFileAttributes.class);

                if(attributes.isDirectory())
                    System.out.print("<DIR> ");
                else
                    System.out.print("      ");

                System.out.println(entry.getFileName());
            }
        } catch (InvalidPathException e) {
            System.out.println("Ошибка указания пути " + e);
        } catch (NotDirectoryException e) {
            System.out.println(dirname + " не является каталогом");
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода " + e);
        }
    }
}
