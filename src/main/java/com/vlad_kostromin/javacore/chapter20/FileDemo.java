package main.java.com.vlad_kostromin.javacore.chapter20;

import java.io.File;
import java.io.IOException;

public class FileDemo {
    static void p(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) throws IOException {
        File file = new File("src/main/java/com/vlad_kostromin/javacore/chapter20/files/COPYRIGHT2");
        p("Имя файла: " + file.getName());
        p("Путь: " + file.getPath());
        p("Абсолютный путь: " + file.getAbsolutePath());
        p("Родительский каталог: " + file.getParent());
        p(file.canRead() ? "доступен для чтения" : "не доступен для чтения");
        p(file.isDirectory() ? "является каталогом" : "не является каталогом");
        p(file.isFile() ? "является обычным файлом" : "может быть именованным каналом");
        p(file.isAbsolute() ? "является абсолюьтным" : "не является абсолюьтным");
        p("Последнее изменение в файле: " + file.lastModified());
        p("Размер: " + file.length() + " байт");
    }
}
